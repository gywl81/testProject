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
    decallowed = 2; // �Ҽ������ϼ����� ���� 

    if (isNaN(fieldValue) || fieldValue == "") { 
            alert("���ڸ� �Է��ϼ���"); 
            fieldName.select(); 
            fieldName.focus(); 
    } 
    else { 
            if (fieldValue.indexOf('.') == -1) fieldValue += "."; 
            dectext = fieldValue.substring(fieldValue.indexOf('.')+1, fieldValue.length); 

            if (dectext.length > decallowed) 
            { 
                    alert ("�Ҽ��� " + decallowed + " �ڸ������� �Է��� �� �ֽ��ϴ�"); 
                    fieldName.select(); 
                    fieldName.focus(); 
            } 
            else { 
                    alert ("�ٸ��� �Է� �ϼ̳׿�"); 
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
	    fncDelay(1000); // 1�ʾ� �������ֱ�
	    console.log('���� i �� : '+i); // �����̸� Ȯ�� �ϱ� ���� �����ٿ� �� ����ϱ�
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
�Ҽ��� 2�ڸ� ������ ���ڸ� �Է� �� �ּ��� : <br> 
<input type=text name=numbox> 
<input type=button name=ok value="Ȯ��" onClick="checkDecimals(this.form.numbox, this.form.numbox.value)"> 
<input type=button name=forMun1 value="����"  onClick="forMun()"> 
</form> 
</center> 
</body>
</html>
