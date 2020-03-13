<%@page import="java.util.List"%>

<%@page import="com.project.model.AdminBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>

<style>
#wrapper {
	width: 450px;
}

#wrapper .container {
	max-width: 100%;
	display: block;
}

.notification {
	background-color: black;
	color: white;
	text-decoration: none;
	padding: 10px 18px;
	position: relative;
	display: inline-block;
	border-radius: 2px;
	width: 150px;
	font-size: 15px;
}

.notification:hover {
	background: green;
}

.notification .badge {
	position: absolute;
	top: -10px;
	right: -10px;
	padding: 5px 10px;
	border-radius: 50%;
	background-color: RED;
	color: white;
}
</style>

<!-- Required meta tags -->

<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/styles.css" />

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>





</head>

<body>

	<nav class="navbar navbar-expand-lg fixed-top bg-dark">



		<button class="navbar-toggler " type="button" data-toggle="collapse"
			data-target="#navigation-bar" aria-controls="navbarTogglerDemo03"
			aria-expanded="false" aria-label="Toggle navigation">

			<span class="navbar-toggler-icon text-light">&#9776;</span>

		</button>

		<img src="logo2.png" alt="logo" style="height: 5%; width: 5%" /> <a
			class="navbar-brand text-light" href="/adminhomepage">GetMed</a>





		<div class="collapse navbar-collapse" id="navigation-bar">

			<ul class="navbar-nav ml-auto ">

				<li><c:if test="${ notic==0 && noti!=0}">

						<a href="/notification" class="nav-link  text-light notification">

							<span>NOTIFICATION</span> <span class="badge">${noti}</span>

						</a>
					</c:if> <c:if test="${notic==0 && noti==0}">

						<a href="/notification" class="nav-link  text-light notification">

							<span>NOTIFICATION</span>

						</a>
					</c:if></li>&nbsp;&nbsp;



				<li class="nav-item"><a class="nav-link  text-light"
					href="/logout">LOGOUT</a></li>



			</ul>

		</div>

	</nav>

	<br />

	<br />

	<br />

	<br />



	<%
		AdminBean ab = (AdminBean) session.getAttribute("id");

		String role = "";

		String name = ab.getFirstName() + " " + ab.getLastName();

		if (ab.getRole() == 1)

			role = "ADMIN";

		else

			role = "USER";

		Integer i = (Integer) session.getAttribute("addm");

		String msg = "";

		if (i == 1)

			msg = "Your Details are Added successfully";

		else if (i == 2)

			msg = "Medicine Details Edited Successfully";

		else if (i == 3)

			msg = "Stock Updated Successfully";

		else

			msg = "";
	%>

	<br>

	<p
		style="font-size: 24px; text-align: center; font-weight: bold; font-family: Verdana; text-decoration: underline;"><%="Welcome " + name + " (" + role + ")"%>

	</p>

	<br />

	<br />

	<p style="text-align: center; color: green;"><%=msg%></p>
<p style="text-align: center;color:green;">${pdf}</p> 










	<div class="row" style="margin-left: 10px">

		<div class="col-sm-4">

			<div class="card text-center" style="width: 300px !important">

				<div class="card-body bg-dark text-white">

					<h5 class="card-title">Medicine Information</h5>

					<p class="card-text">Information about the Medicine</p>

					<a href="adhome" class="btn btn-primary">Medicine Information</a>

				</div>

			</div>

		</div>



		<div class="col-sm-4">

			<div class="card text-center" style="width: 300px !important">

				<div class="card-body bg-dark text-white">

					<h5 class="card-title">Add Medicine</h5>

					<p class="card-text">Click to add a new Medicine</p>

					<a href="/addm" class="btn btn-primary">Add Medicine</a>

				</div>

			</div>

		</div>



		<div class="col-sm-4">

			<div class="card text-center" style="width: 300px !important">

				<div class="card-body bg-dark text-white">

					<h5 class="card-title">View Stock</h5>

					<p class="card-text">Click to view the available Stock</p>

					<a href="viewstock" class="btn btn-primary">View Stock</a>

				</div>

			</div>

		</div>

	</div>



	<br>


	<div class="row" style="margin-left: 10px">





		<div class="col-sm-4">

			<div class="card text-center" style="width: 300px !important">

				<div class="card-body bg-dark text-white">

					<h5 class="card-title">Update Stocks</h5>

					<p class="card-text">Click to update the existing stocks</p>

					<a href="viewupdate" class="btn btn-primary">Update Stocks</a>

				</div>

			</div>

		</div>



		<div class="col-sm-4">

			<div class="card text-center" style="width: 300px !important">

				<div class="card-body bg-dark text-white">

					<h5 class="card-title">View Orders</h5>

					<p class="card-text">Click to view the orders received</p>

					<a href="viewordersadmin" class="btn btn-primary">View Orders</a>

				</div>

			</div>

		</div>



		<div class="col-sm-4">

			<div class="card text-center" style="width: 300px !important">

				<div class="card-body bg-dark text-white">

					<h5 class="card-title">Generate Report</h5>

					<p class="card-text">Click to Generate Report</p>

					<a href="pdf" class="btn btn-primary">Generate Report</a>

				</div>

			</div>

		</div>

	</div>









	<!--  <p style="text-align: center;"><a href="/adhome"  class="btn btn-outline-dark btn-lg">Medicine Information</a>

      

      

</p>

<br/>

<p style="text-align: center;"><a href="/addm" style="text-align: center;" class="btn btn-outline-dark btn-lg">Add Medicine</a>

  </p>

 

<br/>

<p style="text-align: center;"><a href="/viewstock" style="text-align: center;" class="btn btn-outline-dark btn-lg">View Stock</a>

</p>

 

<br/>

       <p style="text-align: center;"><a href="/viewupdate" class="btn btn-outline-dark btn-lg">Update Stocks</a></p>

  

 

<br/>

       <p style="text-align: center;"><a href="/viewordersadmin" class="btn btn-outline-dark btn-lg">View Orders</a></p>

 

<br/>

       <p style="text-align: center;"><a href="/pdf" class="btn btn-outline-dark btn-lg">Generate Report</a></p>  -->



</body>

</html>