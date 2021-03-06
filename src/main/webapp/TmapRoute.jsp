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
	function initTmap() {
		centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
		map = new Tmap.Map({
			div : 'map_div',
			width : '100%',
			height : '400px',
			transitionEffect : "resize",
			animation : true
		});
		searchRoute();
	};
	//경로 정보 로드
	function searchRoute() {
		var routeFormat = new Tmap.Format.KML({
			extractStyles : true,
			extractAttributes : true
		});
		var startX = 14129105.461214;
		var startY = 4517042.1926406;
		var endX = 14136027.789587;
		var endY = 4517572.4745242;
		var urlStr = "https://apis.skplanetx.com/tmap/routes?version=1&format=xml";
		urlStr += "&startX=" + startX;
		urlStr += "&startY=" + startY;
		urlStr += "&endX=" + endX;
		urlStr += "&endY=" + endY;
		urlStr += "&appKey=c50d5304-b445-3c35-8953-d9279928cc66";
		var prtcl = new Tmap.Protocol.HTTP({
			url : urlStr,
			format : routeFormat
		});
		console.log("test1 === : " + prtcl.read(true));
		alert("1 === :: " + prtcl.read(true));
		
		var routeLayer = new Tmap.Layer.Vector("route", {
			protocol : prtcl,
			strategies : [ new Tmap.Strategy.Fixed() ]
		});
		routeLayer.events.register("featuresadded", routeLayer, onDrawnFeatures);
		map.addLayer(routeLayer);
	}
	//경로 그리기 후 해당영역으로 줌
	function onDrawnFeatures(e) {
		map.zoomToExtent(this.getDataExtent());
	}
	function initTest(){
		alert($('form').serialize());
		$.ajax({
            url: '<c:url value="/tmap/list"/>',
            data: $('form').serialize(),
            type: 'POST',
            contentType : 'application/json; charset=UTF-8',
            dataType: 'json',
            beforeSend : function(xhr){
                xhr.setRequestHeader("x-skpop-userId", "hyun@sptek.co.kr"); 
                xhr.setRequestHeader("appKey", "c50d5304-b445-3c35-8953-d9279928cc66"); 
            },
            success: function(result) {
                 
                alert(result);
            }
        });
	}
</script>
</head>
<body onload="initTmap()">
	//지도 div 정의
	<form>
		<input type='hidden' name='endX'       value='14133518.0344372'>
		<input type='hidden' name='endY'       value='4505815.2222688'>
		<input type='hidden' name='startX'       value='14129748.9535116'>
		<input type='hidden' name='startY'       value='4506820.3521510'>
		<input type='hidden' name='roadType'       value='8'>
		<input type='hidden' name='tollgateFareOption'       value='32'>
		<div id="map_div"></div>
	</form>
</body>
</html>
