
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html>

<head>
  <title>GetMed</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
  <style>
    .flip-card {
      background-color: transparent;
      width: 300px;
      height: 200px;
      border: 1px solid #f1f1f1;
      perspective: 1000px;
      /* Remove this if you don't want the 3D effect */
    }

    /* This container is needed to position the front and back side */
    .flip-card-inner {
      position: relative;
      width: 100%;
      height: 100%;
      text-align: center;
      transition: transform 0.8s;
      transform-style: preserve-3d;
    }

    /* Do an horizontal flip when you move the mouse over the flip box container */
    .flip-card:hover .flip-card-inner {
      transform: rotateY(180deg);
    }

    /* Position the front and back side */
    .flip-card-front,
    .flip-card-back {
      position: absolute;
      width: 100%;
      height: 100%;
      -webkit-backface-visibility: hidden;
      /* Safari */
      backface-visibility: hidden;
    }

    /* Style the front side (fallback if image is missing) */
    .flip-card-front {
      background-color: white;
      color: black;
    }

    /* Style the back side */
    .flip-card-back {
      background-color: gray;
      color: white;
      transform: rotateY(180deg);
    }
  </style>
</head>

<body style="background-color:white;">

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
          <a class="nav-link" href="/uhome" style="color: white;"><span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/help" style="color: white;">Help</a>
        </li>&nbsp;&nbsp;&nbsp;&nbsp;
        <li> <p>${uname}</p></li>
      </ul>
      <f:form class="form-inline my-2 my-lg-0" action="viewmedicine" method="post" modelAttribute="sb">

        <input class="form-control mr-sm-2" type="search" placeholder="Search " aria-label="Search" name="name">
        <div class="col-auto my-1">

          <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="type">

            <option value="name" selected>Name</option>
            <option value="brand">Brand</option>
          </select>
        </div>
<!--  
        <div class="col-auto my-1">

          <f:select class="custom-select mr-sm-2" id="inlineFormCustomSelect" path="city" name="city">

            <f:option value="all" selected="true">All</f:option>
            <f:options items="${cities}"/>
          </f:select>
        </div>
-->
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search medicine</button>
      </f:form>&nbsp;
   <a href="/logout" class="btn btn-outline-danger btn-md">Log Out</a>
  
    </div>
   </nav>


  
 <br/><br/>
 <div class="container" style="text-align: center">
 
 <a href="/allmed" class="btn btn-outline-info btn-lg">view available medicine</a><br/>
&nbsp;<br/><br/>
 &nbsp;
 <a href="/orderhistory" class="btn btn-outline-info btn-lg">Order History</a><br/><br/><br/>
 &nbsp;<a href="/viewcart" class="btn btn-outline-info btn-lg">Order Medicine</a><br/><br/><br/>
 
</div>


  <div style="padding-top: 2em; padding-bottom: 2em;" class=" d-flex flex-row align-items-start">

  </div>

 
</body>

</html>