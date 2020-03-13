<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>

<style>
#left{
float:left;
}
#right{
float:right;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<title>GetMed</title>

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
	
	
	
	<br><br><br>
	<div class="card text-center" >
  <div class="card-header">
   <p style="margin-right:6%; font-weight:bolder;font-size:25px"> Medicine Details</p>
  </div>
  <div class="card-body" style="margin-left:30%">
    <h5 class="card-title" style="margin-right:55%"><c:out value="${meds.name}"/></h5>
   <table><tr>
        <td id="left">Medicine Id: </td>
        <td id="right"><c:out value="${meds.mid}"/></td>
        </tr>
        
        <tr>
        <td id="left">Medicine Name: </td>
        <td id="right"><c:out value="${meds.name}"/></td>
        </tr>
        
        <tr>
        <td id="left">Medicine Brand: </td>
        <td id="right"><c:out value="${meds.brand}"/></td>
        </tr>
        
        <tr >
        <td id="left">Medicine Price: </td>
        <td id="right"><c:out value="${meds.price}"/></td>
        </tr>
        
        <tr>
        <td id="left">Medicine Stock: </td>
        <td id="right"><c:out value="${meds.stock}"/></td>
        </tr>
        
        <tr>
        <td id="left">Medicine Type: </td>
        <td id="right"><c:out value="${meds.type}"/></td>
        </tr>
        
        <tr>
        <td id="left">For Disease : </td>
        <td id="right"><c:out value="${meds.disease}"/></td>
        </tr>
        
        <tr>
        <td id="left">Medicine Sold: </td>
        <td id="right"><c:out value="${meds.sales}"/></td>
        </tr>
        <tr>
        <td id="left">City Of Sale: </td>
        <td id="right"><c:out value="${meds.city}"/></td>
        </tr>
        
        <tr>
        <td id="left">Medicine Expiry Date: </td>
        <td id="right"><c:out value="${meds.expiryDate}"/></td>
        </tr>
        
        </table>
      
    <a href="editMedicine?mid=${meds.mid}" id="left"class="btn btn-primary">Edit</a>
    <a href="adhome" class="btn btn-primary" id="right" style="margin-right:54%">Back</a>

  </div>

</div>
	
	
	

         <%--  <h4 class="modal-title">Medicine Details</h4>
          
        
        <div class="modal-body">
        <table>
        <tr>
        <td>Medicine Id : </td>
        <td><c:out value="${meds.mid}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Name : </td>
        <td><c:out value="${meds.name}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Brand : </td>
        <td><c:out value="${meds.brand}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Price : </td>
        <td><c:out value="${meds.price}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Stock  : </td>
        <td><c:out value="${meds.stock}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Type : </td>
        <td><c:out value="${meds.type}"/></td>
        </tr>
        
        <tr>
        <td>For Disease : </td>
        <td><c:out value="${meds.disease}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Sold : </td>
        <td><c:out value="${meds.sales}"/></td>
        </tr>
        <tr>
        <td>City Of Sale : </td>
        <td><c:out value="${meds.city}"/></td>
        </tr>
        
        <tr>
        <td>Medicine Expiry Date : </td>
        <td><c:out value="${meds.expiryDate}"/></td>
        </tr>
        
        </table>
        
        </div>
  


 --%>





<%-- <br/>
					<a href="editMedicine?mid=${meds.mid}" id="submit" role="button" type="submit"
						class="btn btn-irenic float-left btn-lg" tabindex="0">
						<span>edit</span>
					</a>
					<a href="/adhome"  role="button" type="reset"
						class="btn btn-irenic float-right btn-lg" tabindex="0">
	Cancel	</a>

 --%>


</body>

</html>

