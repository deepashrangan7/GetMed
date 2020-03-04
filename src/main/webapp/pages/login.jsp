

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

<style>
        @import url("https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Monoton");
        @import url("https://fonts.googleapis.com/icon?family=Material+Icons");

        * {
            box-sizing: border-box;
        }


        html {
            font-size: 14px;
        }

        body {
            background: linear-gradient(to bottom, #330f42, #ffffff);
            color: #454749;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Source Sans Pro', sans-serif;
            min-height: 100vh;
        }

        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            font-family: Monoton, sans-serif;
            margin-bottom: .5rem;
        }

        /**
 * Tiles
 */
        .tile {
            background-color: #ffffff;
            border-radius: .1rem;
            box-shadow: 0 0.75rem 1.5rem rgba(0, 0, 0, 0.2), 0 0.25rem 0.25rem rgba(0, 0, 0, 0.2);
            position: relative;
            width: 100%;
            min-width: 320px;
            max-width: 30rem;
            overflow: hidden;
        }

        .tile .tile-header {
            background-position: center;
            background-size: cover;
            height: 5rem;
        }

        .tile .tile-body {
            padding: 2rem;
        }

        /**
 * Forms
 */
        .form-input {
            display: block;
            position: relative;
            margin-bottom: 1rem;
        }

        .form-input>.material-icons {
            position: absolute;
            font-size: 1.5rem;
            top: 1.2rem;
        }

        .form-input>.material-icons~input,
        .form-input>.material-icons~.label,
        .form-input>.material-icons~.underline {
            margin-left: 2.25rem;
            width: calc(100% - 2.25rem);
        }

        .form-input input {
            border: none;
            box-shadow: none;
            padding-top: 1.5rem;
            padding-right: 0;
            padding-bottom: 0.5rem;
            padding-left: 0;
            outline-style: none;
            width: 100%;
        }

        .form-input input~.label {
            color: #868e96;
            font-size: 1rem;
            margin: 0;
            pointer-events: none;
            position: absolute;
            top: 1.5rem;
            left: 0;
            transition: top .2s, font .2s;
            z-index: 1;
        }

        .form-input input~.underline {
            background-color: #bdc1c5;
            height: 1px;
            width: 100%;
            position: absolute;
            bottom: 0;
        }

        .form-input input:hover~.underline,
        .form-input input:focus~.underline {
            background-color: #07beb8;
        }

        .form-input input:hover~.label,
        .form-input input:focus~.label {
            color: #07beb8;
        }

        .form-input input:focus~.underline {
            height: 2px;
        }

        .form-input input:focus~.label,
        .form-input input:valid~.label {
            top: 0;
            font-size: 0.85rem;
        }

        .form-input input:-webkit-autofill~.label {
            top: 0;
            font-size: 0.85rem;
        }

        /**
 * Buttons
 */
        .btn {
            border-radius: .2rem;
            display: inline-block;
            padding-top: 0.5rem;
            padding-right: 1rem;
            padding-bottom: 0.5rem;
            padding-left: 1rem;
        }

        .btn,
        [role="button"],
        [type="button"] {
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
        }

        .btn-irenic {
            background-color: #07beb8;
            color: white;
        }

        .btn-irenic:hover,
        .btn-irenic:focus,
        .btn-irenic:active {
            background-color: #06a5a0;
        }

        .btn-serene {
            background-color: #3dccc7;
            color: white;
        }

        .btn-serene:hover,
        .btn-serene:focus,
        .btn-serene:active {
            background-color: #32beb9;
        }

        .btn-tranquil {
            background-color: #68d8d6;
            color: white;
        }

        .btn-tranquil:hover,
        .btn-tranquil:focus,
        .btn-tranquil:active {
            background-color: #54d3d0;
        }

        .btn-calm {
            background-color: #9ceaef;
            color: white;
        }

        .btn-calm:hover,
        .btn-calm:focus,
        .btn-calm:active {
            background-color: #86e5eb;
        }

        .btn-cool {
            background-color: #c4fff9;
            color: white;
        }

        .btn-cool:hover,
        .btn-cool:focus,
        .btn-cool:active {
            background-color: #abfff6;
        }

        .btn-ice {
            background-color: #ffffff;
            color: white;
        }

        .btn-ice:hover,
        .btn-ice:focus,
        .btn-ice:active {
            background-color: #f2f2f2;
        }

        .btn-base {
            background-color: #454749;
            color: white;
        }

        .btn-base:hover,
        .btn-base:focus,
        .btn-base:active {
            background-color: #393a3c;
        }

        /**
 * Utilities
 */
        .clearfix:after {
            content: "";
            display: table;
            clear: both;
        }

        .float-right {
            float: right;
        }

        /**
 *
 */
        .submit-container {
            position: relative;
        }

        .submit-container #submit {
            position: relative;
            z-index: 2;
            outline: none;
            opacity: 1;
            transition: transform .1s ease-in, opacity .1s ease-in, border-radius .1s ease-in;
            right: -1px;
        }

        .submit-container #submit span {
            opacity: 1;
            transition: opacity .1s ease-in;
        }

        .submit-container #submit.pending {
            transform: scale(0.55, 1.5);
            background-color: #07beb8;
            border-radius: 50%;
            opacity: 1;
        }

        .submit-container #submit.pending span {
            opacity: 0;
        }

        .submit-container #submit.pending~.login-pending {
            opacity: 1;
            transform: scale(1, 1);
            z-index: 3;
        }

        .submit-container #submit.granted~.login-pending {
            opacity: 1;
            transform: translate(-9rem, -11rem) scale(18, 18);
            z-index: 3;
        }

        .submit-container #submit.granted~.login-pending .spinner {
            opacity: 0;
        }

        .submit-container #submit.granted~.login-pending .login-granted-content {
            opacity: 1;
        }

        .submit-container .login-pending {
            height: 3rem;
            width: 3rem;
            background-color: #07beb8;
            position: absolute;
            border-radius: 50%;
            right: 1rem;
            bottom: -0.5rem;
            opacity: 0;
            overflow: hidden;
            transform: translate(0, 0) scale(0.5, 0.5);
            transition: transform .2s ease-in, scale .2s ease-in;
            z-index: 1;
        }

        .submit-container .login-pending .login-granted-content {
            background-image: url(pic.jpg);
            background-position: center;
            background-size: cover;
            color: #ffffff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            width: 100%;
            opacity: 0;
            position: absolute;
            top: 0;
            left: 0;
            transition: opacity .2s ease-in .2s;
            text-shadow: 0px 0px 20px #ffffff;
        }

        .submit-container .login-pending .login-granted-content .material-icons {
            font-size: 5px;
            position: relative;
            left: 1.25px;
        }

        .spinner {
            width: 3rem;
            height: 3rem;
            position: relative;
            margin: 0 auto;
        }

        .spinner .dot1,
        .spinner .dot2 {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #68d8d6;
            opacity: 0.6;
            position: absolute;
            top: 0;
            left: 0;
            -webkit-animation: dot-bounce 2.0s infinite ease-in-out;
            animation: dot-bounce 2.0s infinite ease-in-out;
        }

        .spinner .dot2 {
            -webkit-animation-delay: -1.0s;
            animation-delay: -1.0s;
        }

        @-webkit-keyframes dot-bounce {

            0%,
            100% {
                -webkit-transform: scale(0);
            }

            50% {
                -webkit-transform: scale(1);
            }
        }

        @keyframes dot-bounce {

            0%,
            100% {
                transform: scale(0);
                -webkit-transform: scale(0);
            }

            50% {
                transform: scale(1);
                -webkit-transform: scale(1);
            }
        }

        .label {
            display: inline;
            padding: .2em .6em .3em;
            font-size: 75%;
            font-weight: 400;
            line-height: 1;
            color: #fff;
            text-align: left;
            white-space: nowrap;
            vertical-align: baseline;
            border-radius: .25em;
        }
   
</style>
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
System.out.println(msg);
%>
    <div class="tile">
     
      <div class="tile-header">
       <h2 style="color:teal; opacity: .75; font-size: 4rem; display: flex; justify-content: center; align-items: center; height: 100%;"><u> SIGN IN</u></h2>
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
            <input  role="button" type="submit" class="btn btn-irenic float-right" tabindex="0" value="login"/>
            
            <a id="submit" href="/sign" role="button" type="button" class="btn btn-irenic float-left" tabindex="0">
              <span>SignUp</span>
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
      <p style="text-align: center;font-size: large;"><a href="#">forgot Password?</a></p>
    
      </div>
    </div>
      
     
    
  </body>

</html>

  