
<%@page import="java.util.Map"%>
<%@page import="com.project.model.MedicineBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!doctype html>

<html>

<head>
<title>GetMed</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
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
.flip-card-front, .flip-card-back {
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

<body style="background-color: white;">
	<div style="padding-bottom: 2em;">
		<nav class="navbar navbar-expand-lg navbar-light bg-dark"
			style="color: aliceblue;">
			<img src="logo2.png" alt="logo" width="5%" height="5%"> <a
				class="navbar-brand" href="#" style="color: white;">GetMed</a>
			<button style="color: white;" class="navbar-toggler bg-light"
				type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/uhome"
						style="color: white;">Home <span class="sr-only">(current)</span></a>
					</li>

				</ul>
							</div>
							

<div class="collapse navbar-collapse" id="navbarSupportedContent" style="float: right;text-align: right;">
				<ul class="navbar-nav mr-auto" style="float: right;text-align: right;">
					<li class="nav-item active" style="text-align: right;">
					<a href="/viewmedicine" class="btn btn-outline-success btn-md">Continue Shopping</a></li>

				</ul>
							</div>
		
							
		</nav>
	</div>
	<br />
	
	
	
	
	<br />
			<p style="text-align: center;font-size: 28px;font-weight:bolder;">Total Amount : ${total}Rs/-</p>
		<br/><br/>
		
		
		
   <div class="col-md-6 offset-md-3">
                    <span class="anchor" id="formPayment"></span>
                    <hr class="my-5">

                    
                    <div class="card card-outline-secondary">
                        <div class="card-body">
                            <h3 class="text-center"> Card Payment</h3>
                            <hr>
                          
                            <form class="form" role="form" autocomplete="off" action="/orderdone">
                                <div class="form-group">
                                    <label for="cc_name">Card Holder's Name</label>
                                    <input type="text" class="form-control" id="cc_name"  placeholder="ENTER NAME OF CARD HOLDER" required="required">
                                </div>
                                <div class="form-group">
                                    <label>Card Number</label>
                                    <input type="text" class="form-control" autocomplete="off" maxlength="20" pattern="\d{16}" title="Credit card number" required="true" placeholder="Enter 16  DiGIT CARD NUMBER">
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-12">Card Exp. Date</label>
                                    <div class="col-md-4">
                                        <select class="form-control" name="cc_exp_mo" size="0">
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <select class="form-control" name="cc_exp_yr" size="0">
                                            <option>2018</option>
                                            <option>2019</option>
                                            <option>2020</option>
                                            <option>2021</option>
                                            <option>2022</option>
                                            <option>2023</option>
                                            <option>2024</option>
                                            <option>2025</option>
                                            <option>2026</option>
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" class="form-control" autocomplete="off" maxlength="3" pattern="\d{3}" placeholder="CVV"title="Three digits at back of your card" required="" placeholder="CVC">
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-md-12">Amount</label>
                                </div>
                                <%
                                Double pri=(Double)session.getAttribute("total");
                                
                                %>
                                <div class="form-inline">
                                    <div class="input-group">
                                        <div class="input-group-prepend"><span class="input-group-text">$</span></div>
                                        <input type="text" class="form-control text-right" id="exampleInputAmount" value=<%=pri %> disabled="disabled">
                                        <div class="input-group-append"><span class="input-group-text">.00</span></div>
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group row">
                                    <div class="col-md-6">
                                        <a href="/uhome" class="btn btn-default btn-lg btn-block">Cancel</a>
                                    </div>
                                    <div class="col-md-4" style="float: right;">
                                     <button type="submit" class="btn btn-primary btn-lg" >
&nbsp;&nbsp;Pay&nbsp;&nbsp;
</button>
</div>
                                </div>
                            </form>
                        </div>
                    </div>

</div>
<br/><br/><br/>
<div style="text-align: center;padding-top:3 em;">

<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Cash On Delivery
</button>

</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Order Booking</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h3 style="text-align: center;">!!Press Confirm to Book your Order!!</h3>

      </div>
      <div class="modal-footer">
        
        <a type="button" class="btn btn-primary btn-lg" href="/orderdone">Confirm</a>
      </div>
    </div>
  </div>
</div>

</body>

</html>