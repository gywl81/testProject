<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=c50d5304-b445-3c35-8953-d9279928cc66"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">

	//초기화 함수
	function initTest() {
		
		var time = 3455 ;
		
		var pad = function(x) { return (x < 10) ? "0"+x : x; }
		  var test =  pad(parseInt(time / (60*60))) + ":" +
		         pad(parseInt(time / 60 % 60)) + ":" +
		         pad(time % 60);
		console.log("test >>>>>>>>>>>" + test);
		//console.log ("222" +humanReadable(time));
		
		
		var tData = new Tmap.TData();
		 
		var pr_3857 = new Tmap.Projection("EPSG:3857");
		var pr_4326 = new Tmap.Projection("EPSG:4326");
		
		var endX = "14133518.0344372";
		var endY = "4505815.2222688";
		var startX = "14129748.9535116";
		var startY = "4506820.3521510";
		
		////////////////////////위도경도 변환///////////////////////////
		var pr_1113858 = new Tmap.LonLat(endX, endY).transform(pr_3857, pr_4326);
		console.log("pr_1113858.lon >>> :: " + pr_1113858.lon);
		console.log("pr_1113858.lat >>> :: " + pr_1113858.lat);
		var pr_1113857 = new Tmap.LonLat(pr_1113858.lon, pr_1113858.lat).transform(pr_4326, pr_3857);
		console.log("pr_1113857.lon >>> :: " + pr_1113857.lon);
		console.log("pr_1113857.lat >>> :: " + pr_1113857.lat);
		////////////////////////////////////////////////////////////////
		
		var s_lonLat = new Tmap.LonLat(startX, startY);    
		var e_lonLat = new Tmap.LonLat(endX, endY);
		 
		 
		tData.getRoutePlan(s_lonLat, e_lonLat);
		 
		tData.events.register("onComplete", tData, onComplete);
		tData.events.register("onProgress", tData, onProgress);
		tData.events.register("onError", tData, onError);
		 
		function onComplete(e) {
			console.log('Tmap 성공가 발생했습니다.');
//			console.log("tests >>>> " + jQuery(this.responseXML).find("searchPoiInfo pois poi").text());
			if (jQuery(this.responseXML).find("kml totalTime").text() != '') {
				console.log("in >>> :: " + jQuery(this.responseXML).find("kml totalTime").text());
			} else {
				console.log("out >>> :: " + jQuery(this.responseXML).find("kml totalTime").text());
//				alert('검색결과가 없습니다.');
			}
		}
		function onError(){
			console.log('Tmap 오류가 발생했습니다.');
		}
		function onProgress(e){
			console.log('Tmap 진행가 발생했습니다.');
		}
	};
	
	function humanReadable(seconds) {
		  var pad = function(x) { return (x < 10) ? "0"+x : x; }
		  return pad(parseInt(seconds / (60*60))) + ":" +
		         pad(parseInt(seconds / 60 % 60)) + ":" +
		         pad(seconds % 60)
		}
	
</script>
</head>
<body onload="initTest()">
	//지도 div 정의
	<form>
		<div id="map_div"></div>
	</form>
</body>
</html>
