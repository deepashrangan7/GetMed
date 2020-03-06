

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


    <title>GetMed</title>
</head>
  <body>
 <%
Integer i=(Integer)request.getAttribute("err");
String msg;
if(i==1)
	msg="Email and Password Doesn't Match";	
else if(i==2)
	msg="email cant Be empty";
else if(i==3)
	msg="password cant be empty";	
else
	msg="";
String s=(String)session.getAttribute("role");
if(s.equals("ad"))
	s="ADMIN";
else
	s="USER";
Integer add=(Integer)session.getAttribute("add");
String msgs="";
if(add==1)
	msgs="Account Created Succesfully Login Now";
	
%>
    <div class="tile">
     
      <div class="tile-header">
       <h2 style="color:black; opacity: .75; font-size: 2rem; display: flex; justify-content: center; align-items: center; height: 100%;text-align: center;"><%=s%> LOG IN</h2>
      </div>
      
      <div class="tile-body">
        <f:form  method="post" action="main" modelAttribute="login">
          <label class="form-input">
            <i class="material-icons">person</i>
            <f:input type="text" autofocus="true" name="email"  path="email" />
            <span class="label">Email Id</span>
          <f:errors path="email"></f:errors>
           </label>
          <label class="form-input">
            <i class="material-icons">lock</i>
            <input type="password" path="password" name="password"  />
            <span class="label">Password</span>
           </label>
          <f:errors path="password"></f:errors>
          
          <div class="submit-container clearfix" style="margin-top: 2rem;">          
            <input  role="button" type="submit" class="btn btn-outline-dark float-left btn-lg" tabindex="0" value="login"/>
            
            <a  href="/sign" role="button" type="button" class="btn btn-outline-dark float-right btn-lg" tabindex="0">
             SignUp
            </a>
              
            
            
            <div class="login-pending">
              <div class=spinner>
                <span class="dot1"></span>
                <span class="dot2"></span>
              </div>
              
              <div class="login-granted-content">
                <i class="material-icons">done</i>
              </div>
            </div>
          </div>
        </f:form>
      <br/><br/>
      <p style="color:red;"><%=msg%> </p>
      <br/><br/>
      <p style="color:green;"><%=msgs%></p>
      <p style="text-align: center;font-size: large;color:black;"><a href="#">forgot Password?</a></p>
    
      </div>
    </div>
      
     
    
  </body>

</html>

  