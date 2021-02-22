<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>API 데이터 호출</title>
</head>
<body>
	<table border = "1">
	<tr>
		<th>SO2</th>
		<th>NO2</th>
		<th>CO</th>
		<th>PM10</th>
		<th>PM2.5</th>
		<th>발표시간</th>
	</tr>
	
	<c:forEach  var="result" items="${list}" varStatus="status">
		<tr>
			<td>${result.soValue }</td>		
			<td>${result.no2Value }</td>		
			<td>${result.coValue }</td>		
			<td>${result.pm10Value }</td>		
			<td>${result.pm25Value }</td>		
			<td>${result.dataTime }</td>		
		</tr>
	</c:forEach>
	</table>
</body>
</html>