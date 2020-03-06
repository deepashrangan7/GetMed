<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.project.model.MedicineBean"%>
<%@page import="com.project.model.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>

<html>
<head>
  <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
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



<title>GetMed</title>
</head>


<body>


  <nav class="navbar navbar-expand-lg navbar-light bg-dark" style="color: aliceblue; ">
    <img src="logo2.png" alt="logo" width="5%" height="5%">
    <a class="navbar-brand" href="#" style="color: white;">GetMed</a>
    <button style="color: white;" class="navbar-toggler bg-light" type="button" data-toggle="collapse"
      data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/adminhomepage" style="color: white;">Home<span class="sr-only">(current)</span></a>
        </li>
       
      </ul>
      <f:form  modelAttribute="ts" action="viewstock" method="post" class="form-inline my-2 my-lg-0" >
<div class="col-auto my-1">

          <f:select path="type" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="type">
            <f:option value="all" selected="true">All</f:option>
            <f:option value="normal" >Normal</f:option>
            <f:option value="capsule">Capsule</f:option>
            <f:option value="vaccine">Vaccine</f:option>
            <f:option value="syrup">Syrup</f:option>
          </f:select>
        </div>

        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Find Medicine</button>
      </f:form>
    </div>
  </nav>
	<br />
	<br />
	<br />

<c:choose>
<c:when test="${fn:length(mediciness) eq 0}">
<h2 style="text-align: center">No Medicine for This Type</h2>
</c:when>
<c:otherwise>
<table class="table table-hover" style="padding-top:5em;">
  
  <thead>
    <tr>
    <th scope="col">Medicine Id</th>
      <th scope="col">Medicine Name</th>
      <th scope="col">Brand</th>
    <th scope="col">Type</th>
       <th scope="col">Price</th>
      <th scope="col">InStock</th>
     	<th scope="col">Disease</th>
     	<th scope="col">City</th>
    <th scope="col"> Expiry Date</th>
        </tr>
  </thead>
  <tbody>
    <c:forEach items="${mediciness}" var="med">
    <tr>
    <th >      <c:out value="${med.mid}"/>
        
    </th>
      <td ><c:out value="${med.name}"/></td>
      <td><c:out value="${med.brand}"/></td>
      <td><c:out value="${med.type}"/></td>
      <td><c:out value="${med.price}"/></td>
      <td><c:out value="${med.stock}"/></td>
      <td><c:out value="${med.disease}"/></td>
      <td><c:out value="${med.city}"/></td>
      <td><fmt:formatDate value="${med.expiryDate}" pattern="dd-MM-yyyy"/>
  </td>
      
    </tr> 	
  </c:forEach>
     </tbody>
</table>

</c:otherwise>
</c:choose>
</body>
</html>


