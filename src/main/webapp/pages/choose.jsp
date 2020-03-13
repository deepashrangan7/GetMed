
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
<script>

var $btn = document.getElementById("submit");
var $form = document.getElementById("form")

function signIn() {
  if ($form.checkValidity()) {
    $btn.classList.add('pending');
    window.setTimeout(function(){ $btn.classList.add('granted'); }, 1500);
  }
}

$btn.addEventListener("click", signIn);
</script>


   <link rel="stylesheet" href="style1.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
   integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
   integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
   crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
   integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
   crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
   integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
   crossorigin="anonymous"></script>


</head>
  <body>
    
 
    <div class="tile">
     
      <div class="tile-header">
        </div>
      
      <div class="tile-body">
     
        <div class="container" style="width:120%;">
         
          <h2 style="color:black; opacity: .75; font-size: 2rem; display: flex; height: 100%; margin-left: 5em;">Choose Role</h2>
     
          <br /><br />
          
          <a class="btn btn-dark btn-lg" style="width: 80%;" href="/log?role=ad" role="button">&nbsp;Admin&nbsp;</a>
          <br /><br /><br />
          <a class="btn btn-dark btn-lg" style="width: 80%;" href="/log?role=us" role="button">Customer</a>
          <br /><br />
          
          
          <c:if test="${updatepass == 'yes' }">
          
        <p style="color:green;margin-left: 12em;">PASSWORD UPDATED SUCCESSFULLY
          </p>
          </c:if>
          </div> 
          <!--  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  -->
           <div style="color:green;text-align:center;padding-right: 10ex; "> 
          <c:if test="${help == 'success' }">
      
        Thanks for reaching us.Your problem is <br/>
        reported to the admin.
         
          
          </c:if>
          <c:if test="${result == 'correct' }">
      
        <p style="color: green;">Your  Id is  ${mid} 
          </p>
          </c:if>
          </div> 
      </div>

    
    </div>
  
      
     
    
  </body>

</html>


  