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
				
				<li class="nav-item"><a class="nav-link text-light"
					href="#work">CONTACT</a></li>
				<li class="nav-item"><a class="nav-link text-light" href="#why">HELP</a></li>
			<li class="nav-item"><a class="nav-link text-light" href="/logout">LOGOUT</a></li>
			
			</ul>
		</div>
	</nav>
	<br />
	<br />
	<br />
	<br />

<%

AdminBean ab=(AdminBean)session.getAttribute("id");
String role="";
String name=ab.getFirstName()+" "+ab.getLastName();
if(ab.getRole()==1)
	role="ADMIN";
else
	role="USER";

Integer i=(Integer)session.getAttribute("addm");
String msg="";
if(i==1)
	msg="Your Datails are submitted successfully";
else if(i==2)
	msg="Medicine Details Editted Successfully";
else if(i==3)
	msg="Stock Updated Successfully";
else
	msg="";
%>
<p style="font-size: 24px;text-align: center;font-weight: bold;"><%="Welcome "+name+" ("+role+")"%>
</p>
	<br />
	<br />
<p style="text-align: center;color:green;"><%=msg%></p>
<br/>
<br/>
	<p style="text-align: center;"><a href="/adhome"  class="btn btn-outline-dark btn-lg">Medicine Information</a>
	
	
</p>
<br/>
	<p style="text-align: center;"><a href="/viewupdate" class="btn btn-outline-dark btn-lg">Update Stocks</a></p>
   

<br/>
	<p style="text-align: center;"><a href="#" class="btn btn-outline-dark btn-lg">New Orders</a></p>


<br/>
	<p style="text-align: center;"><a href="#" class="btn btn-outline-dark btn-lg">Your Orders</a></p>
   
</body>
</html>