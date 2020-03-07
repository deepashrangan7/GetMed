
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
          <a class="nav-link" href="/uhome" style="color: white;">Home <span class="sr-only">(current)</span></a>
        </li>
        
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
      </f:form>
    </div>
  </nav>

  <div style="padding-top: 2em; padding-bottom: 2em;" class=" d-flex flex-row align-items-start">


    <div class="flip-card">
      <div class="flip-card-inner">
        <div class="flip-card-front">
          <img src="alo.jpg" alt="Avatar" style="width:100%;height:100%;">
        </div>
        <div class="flip-card-back">
          <h1>Aloe Vera Gel</h1>
          <p>

            Aloe vera is most commonly used as a topical medication, rubbed onto the skin rather than eaten. It has long
            been known as a treatment for sores, particularly burns, including sunburns


          </p>

        </div>
      </div>
    </div>

    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel"
      style="padding-top: 0em;width: 60%;height: 60%;">



      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>



      <div class="carousel-inner">



        <div class="carousel-item active">
          <img class="d-block w-100" src="pic1.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
          <img class="d-block w-100" src="pic2.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
          <img class="d-block w-100" src="pic3.jfif" alt="Third slide">
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    <div class="flip-card">
      <div class="flip-card-inner">
        <div class="flip-card-front">
          <img src="med2.jfif" alt="Avatar" style="width:300px;height:300px;">
        </div>
        <div class="flip-card-back">
          <h1>Neem Oil</h1>
          <p>Maintain the softness, suppleness, and radiance of skin and hair.</p>
          <p>Stimulate the growth of thicker, longer, and stronger hair.</p>
        </div>
      </div>
    </div>


  </div>
 <br/><br/>
 <a href="/allmed">view all medicine</a>
</body>

</html>