<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE HTML>
<html>
	<head>
		<title> Welcome to Car Becho </title>
		<link rel='stylesheet' type='text/css' href='site.index.css'>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
		<link rel='stylesheet' href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	</head>
	
	<body>
		<div id='addCar'>
			<h2> Add Car </h2>
		</div>
		<div>
			<form:form action="addCar" method="POST" modelAttribute="car">
				<div>
					<label> Company Name </label>
					<form:input path="companyName" type="text" name="car_company_name" value="" placeholder="Company Name" required="required"/>
				</div>
				<div>
					<label> Model Number  </label>
					<form:input path="modelNumber" type="text" name="car_model_number" value="" placeholder="Model Number" required="required"/>
				</div>
				<div>
					<label> Name </label>
					<form:input path="name" type="text" name="car_name" value="" placeholder="Name" required="required"/>
				</div>
				<div>
					<label> Fuel Capacity (in Litres) </label>
					<form:input path="fuelCapacity" type="number" name="car_fuel_capacity" value="" placeholder="Fuel Capacity" required="required"/>
				</div>
				<div>
					<label> Milage  </label>
					<form:input path="milege" type="number"  name="car_milage" value="" placeholder="Milage" required="required"/>
				</div>
				<div>
					<label> Price </label>
					<form:input path="price" type="text" name="car_price" value="" placeholder="Price" required="required"/>
				</div>
				<div>
					<label> Road Tax </label>
					<form:input path="roadTax" type="text" name="car_road_tax" value="" placeholder="Road Tax"  required="required"/>
				</div>
				<div>
					<label> Does car have AC ? </label>
					<form:radiobutton path="isACPresent" name="AC" value="Yes" required="required"/> <span id='radiotext'> Yes </span> &nbsp; &nbsp;
					<form:radiobutton path="isACPresent"  name="AC" value="No"/> <span id='radiotext'> No </span>
				</div>
				<div>
					<label> Does car have power steering ? </label>
					<form:radiobutton path="isPowerSteeringPresent" name="PowerSteering" value="Yes" required="required"/> <span id='radiotext'> Yes </span> &nbsp; &nbsp;
					<form:radiobutton path="isPowerSteeringPresent" name="PowerSteering" value="No"/> <span id='radiotext'> No </span>
				</div>
				<div>
					<label> Does car have accessory kit ? </label>
					<form:radiobutton path="isAccessoryKitPresent" name='accessoryKit' value="Yes" required="required"/> <span id='radiotext' > Yes </span> &nbsp; &nbsp;
					<form:radiobutton path="isAccessoryKitPresent" name='accessoryKit' value="No"/> <span id='radiotext'> No </span>
				</div>
				<div>
					<button type='submit'> <h4 id='buttontext'>  Send  <i class="fa fa-paper-plane" aria-hidden="true"></i> </h4>  </button>
				</div>
			</form:form>
			<div>
				<a href="/CarBechoSpringCore/index.jsp"> Home </a>
			</div>
		</div>
	</body>
</html>