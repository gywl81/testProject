<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=c50d5304-b445-3c35-8953-d9279928cc66"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">


	var map, markerLayer;
	var tdata;
	//초기화

	function initTmap() {
		var param = {};
		var _lng = new Number('4583280'); 
		var _lat = new Number('1344994'); 
		
		param.lat = _lat / 36000;
		param.lng = _lng / 36000;
		

		
		centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
	};

	tdata = new Tmap.TData();

	tdata.events.register("onComplete", tdata, onComplete);
	var options ={};
	options.count = "99";
	tdata.getPOIDataFromSearch(encodeURIComponent("낙성대"), options);

	function onComplete(e) {
		if (jQuery(this.responseXML).find("searchPoiInfo pois poi").text() != '') {
			jQuery(this.responseXML).find("searchPoiInfo pois poi").each(
					function() {
						var name = jQuery(this).find("name").text();
						var id = jQuery(this).find("id").text();
						var lon = jQuery(this).find("frontLon").text();
						var lat = jQuery(this).find("frontLat").text();
						console.log("name : " + name);
						console.log("id : " + id);
						console.log("lon : " + lon);
						console.log("lat : " + lat);
					});
		} else {
			alert('검색결과가 없습니다.');
		}
	}
</script>
</head>
<body onload="initTmap()">
	//지도 div 정의
	<div id="map_div"></div>
</body>
</html>
