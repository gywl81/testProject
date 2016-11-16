<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form>
	<input name="target" type="radio" checked="" value="post"> 지번 우편번호<br> <br> 
	<input name="target" type="radio" value="postRoad"> 도로명 우편번호<br> <br> 
	<strong>검색할 도로명과 건물번호를 정확히 입력하십시오!<br> 찾고자 하는 주소 : 서울특별시 종로구 세종로 17 세종문화회관 검색(입력)방법 예시 : 도로명 + 건물번호 => 세종로 17
	</strong><br> <br> 
	<input name="target" type="radio" value="postNew"> 지번 우편번호(2015년 8월 1일 시행되는 5자리 구역번호)<br> 
	<input name="target" type="radio" value="postNewRoad"> 도로명 우편번호(2015년 8월 1일 시행되는 5자리 구역번호) <br> <br> 
	<input name="query" id="query" type="text"> 
	<input id="searchBtn" type="button" value="검색">
	<input id="searchBtn1" type="button" value="계산">
	<marquee width='150'>"-가나다라마바사ㅁㅁㅁㅁㅁㄴㄴㄴㄴㄴㅇㅇㅇㅇㅇ"</marquee>
</form>

<p></p>
<div>
	<table border="1">
		<thead>
			<tr>
				<th style="width: 150px;">우편번호</th>
				<th style="width: 600px;">내용</th>
			</tr>
		</thead>
		<tbody id="zipcodeList"></tbody>
	</table>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	$(function() {
	    $('#searchBtn').click(function(e){
	        e.preventDefault();
	         
	        $.ajax({
	            url: '<c:url value="/zipcode/list"/>',
	            data: $('form').serialize(),
	            type: 'POST',
	            dataType: 'json',
	            success: function(result) {
	                 
	                $("#zipcodeList").empty();
	                 
	                var html = '';
	                 
	                if (result.errorCode != null && result.errorCode != '') {
	                    html += '<tr>';
	                    html += '   <td colspan="2">';
	                    html +=         result.errorMessage;
	                    html += '   <td>';
	                    html += '</tr>';
	                     
	                } else {
	                    var list = result.list;
	                     
	                    for(var i = 0; i < list.length ; i++) {
	                        html += '<tr>';
	                        html += '   <td>';
	                         
	                        var zipcode = list[i].zipcode;
	                         
	                        if (zipcode != null && zipcode.length > 5) {
	                            var preZipcode = zipcode.substring(0, 3);
	                            var afterZipcode = zipcode.substring(3, 6);
	                             
	                            zipcode = preZipcode + '-' + afterZipcode;
	                        }
	                         
	                        html +=         zipcode;
	                        html += '   </td>';
	                        html += '   <td>';
	
	                        if (list[i].lnmAddress != null && list[i].lnmAddress != '') {
	                            html +=     list[i].lnmAddress;
	                            html += '   <br/>';
	                        }
	                         
	                        html +=         list[i].address;
	                        html += '   </td>';
	                        html += '</tr>';
	                    }
	                }
	                 
	                $("#zipcodeList").append(html);
	            }
	        });
	    });
	    $('#searchBtn1').click(function(e){
	        alert(4570764 / 36000);
	        alert(1349074 / 36000);
	        var test1 = 4570764 / 36000;
	        var test2 = 1349074 / 36000;
	        
	        alert(test1 * 36000);
	        alert(test2 * 36000);
	    });
	});
</script>
