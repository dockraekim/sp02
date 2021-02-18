<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CallAPI2</title>
<script type="text/javascript">

	document.addEventListener("DOMContentLoaded", function(){
		getJsonType();
		getJson1();
		getJson2();		

	});
	
	function getJsonType(){
		var json = '{"result":true, "count":42}';
		console.log("json : " + typeof(json));
		var jsonobj = JSON.parse(json);
		console.log("jsonobj : "+typeof(jsonobj));
		
		
		var jsonstr = JSON.string
		console.log("jsonobj : "+typeof(jsonobj));
		
	}
	
	function getJson1(){

		var json = '{"result":true, "count":42}';
		var obj = JSON.parse(json);

		console.log(obj.count);
	}
	function getJson2(){
		//console.log('param json : '+ JSON.stringify(${apiData}));

		
		var jsonstr = JSON.stringify(${apiData});
		var json = JSON.parse(jsonstr);
		console.log('-- '+ json.list.length);
		document.getElementById("pm25").innerHTML = json.list[0].pm25Grade;
		document.getElementById("pm10").innerHTML = json.list[0].pm10Grade;
		document.getElementById("co").innerHTML = json.list[0].coValue;
		document.getElementById("no2").innerHTML = json.list[0].no2Value;
		document.getElementById("so2").innerHTML = json.list[0].so2Value;
		document.getElementById("o3").innerHTML = json.list[0].o3Value;
		document.getElementById("dataTime").innerHTML = json.list[0].dataTime;
		
		for (var i = 0; i < json.list.length; i++) {
			console.log('--- dataTime : ['+i+'] : '+ json.list[i].dataTime);
		}
	}


</script>

</head>
<body>

	<div>pm2.5 : <span id="pm25"></span></div> 
	<div>pm10 : <span id="pm10"></span></div> 
	<div>co : <span id="co"></span></div> 
	<div>no2 : <span id="no2"></span></div>  
	<div>so2 : <span id="so2"></span></div>  
	<div>o3 : <span id="o3"></span></div>  
	<div>발표시간 : <span id="dataTime"></span></div> 
</body>
</html>