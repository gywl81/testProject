<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=c50d5304-b445-3c35-8953-d9279928cc66"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">


function checkDecimals(fieldName, fieldValue) { 
    decallowed = 2; // 소숫점이하숫자의 갯수 

    if (isNaN(fieldValue) || fieldValue == "") { 
            alert("숫자를 입력하세요"); 
            fieldName.select(); 
            fieldName.focus(); 
    } 
    else { 
            if (fieldValue.indexOf('.') == -1) fieldValue += "."; 
            dectext = fieldValue.substring(fieldValue.indexOf('.')+1, fieldValue.length); 

            if (dectext.length > decallowed) 
            { 
                    alert ("소수점 " + decallowed + " 자리까지만 입력할 수 있습니다"); 
                    fieldName.select(); 
                    fieldName.focus(); 
            } 
            else { 
                    alert ("바르게 입력 하셨네요"); 
            } 
    } 
};

function forMun() { 
	var cnt = 0;
	var tid = "";
	alert($("#testfor").length);
	/* alert("test");
	for(var i=0; i<100; i++)
	{
	    fncDelay(1000); // 1초씩 딜레이주기
	    console.log('현재 i 값 : '+i); // 딜레이를 확인 하기 위한 상태줄에 값 출력하기
	}; */
	/* function a(){
		if(cnt<10){
			cnt++;
			console.log(cnt);
			tid = setTimeout(a, 10000);
		} else {
			clearTimeout(tid);
		}
	} */
};

function fncDelay(millis)
{
    var date = new Date();
    var curDate = null;

    do { curDate = new Date();}
    while(curDate-date < millis);
};


</script>
</head>
<body>
<center> 
<form> 
소수점 2자리 까지의 숫자만 입력 해 주세요 : <br> 
<input type=text name=numbox> 
<input type=button name=ok value="확인" onClick="checkDecimals(this.form.numbox, this.form.numbox.value)"> 
<input type=button name=forMun1 value="포문"  onClick="forMun()"> 
</form> 
</center> 
</body>
</html>
