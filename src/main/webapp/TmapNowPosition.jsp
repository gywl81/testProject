<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="map_div" ></div>

<p><p id="demo2">Click the button to get your coordinates:</p>
<button onclick="getLocation2()">좌표 구하기!!</button>

<script language="javascript" src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=c50d5304-b445-3c35-8953-d9279928cc66"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">


	function initialize(lat, lon) {
		var favoriteOffice = {};
		
			console.log("favoriteOffice >>>>>>>>>>>>>>>>>>> " + Object.keys(favoriteOffice).length) ;
		if (Object.keys(favoriteOffice).length > 0) {
			console.log("1111111111111");
		} else {
			console.log("222222222222222");
			
		}
		
		var pr_3857 = new Tmap.Projection("EPSG:3857");
		var pr_4326 = new Tmap.Projection("EPSG:4326");
		var coordY = lat;
		var coordX = lon;

		var map = new Tmap.Map({
			div : "map_div",
			width : '500px',
			height : '500px'
		});
		var pr_1113857 = new Tmap.LonLat(coordX, coordY).transform(pr_4326, pr_3857);
		var pr_1113858 = new Tmap.LonLat(pr_1113857.lon, pr_1113857.lat).transform(pr_3857, pr_4326);

		alert(coordY); //위도 lat 37
		alert(coordX); // 경도 lon 120
		alert(pr_1113857.lon);
		alert(pr_1113857.lat);
		alert(pr_1113858.lon);
		alert(pr_1113858.lat);
		//14133518.0344372, 4505815.2222688 낙성대역 2호선
		//14129748.9535116, 4506820.3521510 신림역 2호선
		map.setCenter(new Tmap.LonLat(pr_1113857.lon, pr_1113857.lat), 14);
	}

	var x2 = document.getElementById("demo2");
	function getLocation2() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition2, showError);
		} else {
			x2.innerHTML = "Geolocation is not supported by this browser.";
		}
	}
	function showPosition2(position) {
		x2.innerHTML = "Latitude: " + position.coords.latitude
				+ "<br />Longitude: " + position.coords.longitude;
		initialize(position.coords.latitude, position.coords.longitude);
	}
	function showError(error) {
		switch (error.code) {
		case error.PERMISSION_DENIED:
			x2.innerHTML = "User denied the request for Geolocation."
			break;
		case error.POSITION_UNAVAILABLE:
			x2.innerHTML = "Location information is unavailable."
			break;
		case error.TIMEOUT:
			x2.innerHTML = "The request to get user location timed out."
			break;
		case error.UNKNOWN_ERROR:
			x2.innerHTML = "An unknown error occurred."
			break;
		}
	}
</script>

</p>    

    