<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Detailed Car View </title>
		<link rel='stylesheet' type='text/css' href='site.index.css'>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel='stylesheet' href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	</head>
	
	<body>
		<div id='contact'>
			<h2> Detailed Car Information </h2>
		</div>
		<div>
			<div>
				<label> Company Name : </label>
				<span> ${car.getCompanyName()} </span>
			</div>
			<div>
				<label> Model Number :  </label>
				<span> ${car.getModelNumber()} </span>
			</div>
			<div>
				<label> Car Name : </label>
				<span> ${car.getName()} </span>
			</div>
			<div>
				<label> Fuel Capacity (in Litres) : </label>
				<span> ${car.getFuelCapacity()} </span>
			</div>
			<div>
				<label> Milage : </label>
				<span> ${car.getMilege()} </span>
			</div>
			<div>
				<label> Price : </label>
				<span> ${car.getPrice()} </span>
			</div>
			<div>
				<label> Road Tax : </label>
				<span> ${car.getRoadTax()} </span>
			</div>
			<div>
				<label> Does car have AC ? : </label>
				<span> ${car.getIsACPresent()} </span>
			</div>
			<div>
				<label> Does car have power steering ? : </label>
				<span> ${car.getIsPowerSteeringPresent()} </span>
			</div> 
			<div>
				<label> Does car have accessory kit ? : </label>
				<span> ${car.getIsAccessoryKitPresent()} </span>
			</div>
			<div>
				<a href="/carBechoSpringMVCHibernate/index.jsp"> Home </a>
			</div>
		</div>
	</body>
</html>