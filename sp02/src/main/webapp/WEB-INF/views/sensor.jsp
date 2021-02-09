<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sensor Page</title>
</head>
<body>
	<h1>sensor</h1>
	<table>
     <tr>
        <td>Sensor ID</td>
        <td>온도</td>
        <td>습도</td>
        <td>미세먼지</td>
        <td>초미세먼지</td>
        <td>극초미세먼지</td>
        <td>이산화탄소</td>
        <td>TVOC</td>
        <td>Date</td>
    </tr>
	<c:forEach items="${sensorList}" var="sensorList" varStatus="vs">
    <tr>
        <td>${sensorList.sensorId}</td>
        <td>${sensorList.temp}</td>
        <td>${sensorList.humidity}</td>
        <td>${sensorList.tm1}</td>
        <td>${sensorList.tm2_5}</td>
        <td>${sensorList.tm10}</td>
        <td>${sensorList.co2}</td>
        <td>${sensorList.tvoc}</td>
        <td>${sensorList.date}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>