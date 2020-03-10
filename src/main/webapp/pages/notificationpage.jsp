<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetMed</title>
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
       
		<button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navigation-bar" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon text-light">&#9776;</span>
		</button>
		<img src="logo2.png" alt="logo" style="height:5%;width: 5%"/>
		<a class="navbar-brand text-light" href="/adminhomepage" >GetMed</a>
		<div class="collapse navbar-collapse" id="navigation-bar">
			<ul class="navbar-nav ml-auto " >
				<li class="nav-item "><a class="nav-link text-light" href="/adminhomepage">HOME</a></li>
				  <li class="nav-item"><a class="nav-link text-light" href="/logout">LOGOUT</a></li>
			
                </ul>
		</div>
		</nav>
<br/><br/><br/>
<c:choose>
<c:when test="${noti==0}">
<h3 style="color:green;text-align:center;">No New Notification </h3>

</c:when>

<c:otherwise>


<table class="table table-hover" style="padding-top: 5em;">

				<thead>
					<tr>

						<th scope="col">Medicine Name</th>
						<th scope="col">Brand</th>
						<th scope="col">Type</th>
						<th scope="col">Issue</th>
						<th scope="col">Action</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nott}" var="med">
						<tr>

							<th><c:out value="${med.name}" /></th>
							<td><c:out value="${med.brand}" /></td>
							<td><c:out value="${med.type}" /></td>
							<td><p style="color:red;">Out Of Stock</p></td>
							<td><a class="btn btn-outline-success btn-md"href="updatemedicine?mid=${med.mid}">Update Stock</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>



</c:otherwise>

</c:choose>

</body>
</html>