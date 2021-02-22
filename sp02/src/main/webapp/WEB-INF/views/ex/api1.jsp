<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>API 호출</title>
</head>

<script>
	function init(){
		var szStr = '{"name":"강아지", "age":10}';
		var jsonStr = JSON.parse(szStr);
		console.log('--- jsonStr : '+ typeof jsonStr+", "+ jsonStr);
		
		var str = JSON.stringify(jsonStr);
		console.log("--- str : "+ typeof str+ ", "+ str);
	}

</script>
<body onload="init();">
	API 호출
	
	
	
</body>
</html>