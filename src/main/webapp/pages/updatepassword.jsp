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
window.setTimeout(function() {
$btn.classList.add('granted');
}, 1500);
}
}

$btn.addEventListener("click", signIn);
</script>


<link rel="stylesheet" href="style1.css">
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
<br />
<br />
<div class="tile">

<div class="tile-header"style="padding-left: 26%;">
<h2
style="color: teal; opacity: .75; font-size: 2rem; display: flex; justify-content: center; align-items: center; height: 100%;">
Recovery Question</h2>
</div>

<div class="tile-body">
<form id="form" action="newpassword" method="post">


<label class="form-input"> <i class="material-icons">person</i>
<input  type="text" autofocus="true" name="id"
required="true" /> <span class="label">What is your
Email Id?</span>
<div class="underline"></div>
</label>


<label class="form-input"> <i class="material-icons">person</i>
<br>&nbsp; &nbsp; &nbsp; &nbsp;
<select id="question" name="question">
   <option value="q1">What is your Nick name?</option>
   <option value="q2">What is your Favourite colour?</option>
   <option value="q3">Who is your Favourite Hero?</option>
 </select> <!-- <span class="label">Select Any one of the well known question</span> -->
<div class="underline"></div>
</label>


<label class="form-input"> <i class="material-icons">person</i>
<input  type="text" autofocus="true" name="answer"
required="true" /> <span class="label">Enter your answer</span>
<div class="underline"></div>
</label>
<div style="text-align: center; color: red;">
<c:if test="${result == 'wrong' }">
<p style="text-align: center;color:red;">Enter Correct Answer</p>
</c:if>
</div>
<br />
<br />



<div style="margin-left: 4em;"class="submit-container clearfix d-flex flex-row justify-content-between" style="margin-top: 2rem;">
<button role="button" type="submit"
class="btn btn-irenic float-left" tabindex="0">
<span>Submit</span>
</button >
 <%String role=(String)session.getAttribute("role"); %>
<a  href=<%="/log?role="+role%> class="btn btn-irenic " tabindex="0">
<span>Back</span>
</a>
<input type="reset" value="clear" class="btn btn-irenic float-right"
tabindex="0">
</div>

</form>




<br />
<br />

</div>
</div>



</body>

</html>