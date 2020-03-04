<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <style>#wrapper {width: 450px;} 
        #wrapper .container 
        {max-width: 100%; display: block;}
        </style>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css"/>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  

</head>
  <body>
    <nav class="navbar navbar-expand-lg fixed-top bg-dark">
       
		<button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navigation-bar" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon text-light">&#9776;</span>
		</button>
		<img src="logo2.png" alt="logo" style="height:5%;width: 5%"/>
		<a class="navbar-brand text-light" href="/adhome" >GetMed</a>
		<div class="collapse navbar-collapse" id="navigation-bar">
			<ul class="navbar-nav ml-auto " >
				<li class="nav-item "><a class="nav-link text-light" href="/adhome">HOME</a></li>
				<li class="nav-item"><a class="nav-link text-light" href="#work">CONTACT</a></li>
				<li class="nav-item"><a class="nav-link text-light" href="#why">HELP</a></li>
                </ul>
		</div>
		</nav>
<br/><br/><br/><br/><br/><br/>

<h3 style="text-align: center;">Medicine Information</h3>
<br/><br/>

<table class="table table-hover" style="padding-top:5em;">
  <thead>
    <tr>
      <th scope="col">Medicine Name</th>
      <th scope="col">Brand</th>
      <th scope="col">Price</th>
      <th scope="col">Stock</th>
     	<th scope="col">Disease</th>
     	<th scope="col">City</th>
    <th scope="col"> Expiry Date</th>
    <th scope="col">Edit</th>
    <th scope="col">Update</th>
    
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${medicines}" var="med">
    <tr>
    
      <th ><c:out value="${med.name}"/></th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
  </c:forEach>
     </tbody>
</table>
<a href="/addm">Add Medicine</a>
</body>
</html>