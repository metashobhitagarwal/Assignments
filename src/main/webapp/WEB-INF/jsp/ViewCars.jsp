<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<%@page import="factory.FacadeFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.CarVO"%>
<%@page import="model.CarFacade"%>
<%@page import="factory.FacadeFactory"%>
<%@page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cars</title>
</head>
<body>
	<table>
		<tr>
			<th>Company Name</th>
			<th>Model Number</th>
			<th>Car Name</th>
			<th>Fuel Capacity (in Litres)</th>
			<th>Milage</th>
			<th>Price</th>
			<th>Road Tax</th>
			<th>AC</th>
			<th>Power Steering</th>
			<th>Accessory Kit</th>
		</tr>
		<c:forEach var="car" items="${lists}" varStatus="status">
		<tr>
			<td>${car.getCompanyName()}</td>
			<td>${car.getModelNumber()}</td>
			<td>${car.getName()}</td>
			<td>${car.getFuelCapacity()}</td>
			<td>${car.getMilege()}</td>
			<td>${car.getPrice()}</td>
			<td>${car.getRoadTax()}</td>
			<td>${car.getIsACPresent()}</td>
			<td>${car.getIsPowerSteeringPresent()}</td>
			<td>${car.getIsAccessoryKitPresent()}</td>
			<td><a href="<c:url value='/update/UpdateCar/${lists[status.index].getModelNumber()}' />" > Update </a> </td>
			<td><a href="<c:url value='/detailedView/getDetailedView/${lists[status.index].getModelNumber()}' />" > Detailed View </a> </td>
		</c:forEach>
	</table>
	<div>
		<a href="/CarBechoSpringCore/index.jsp"> Home </a>
	</div>
</body>
</html>