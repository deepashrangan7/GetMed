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


function pdf()
{
// var a=document.getElementById("pdf").value;      
alert(a);

 /*   for(var i = 0; i < param; i++) {
       alert(i);
       document.write('<input type="text" name="Fname">');
   }
 */

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


<title>PDF</title>
</head>

<body>
<br />
<br />
<div class="tile">

<div class="tile-header">
<h2
style="color: teal; opacity: .75; font-size: 2rem; display: flex; justify-content: center; align-items: center; height: 100%;">
Pdf Generation </h2>
</div>

<div class="tile-body">
<form id="form" action="generatepdf" method=post>




<label class="form-input"> <i class="material-icons">person</i>
<br>&nbsp &nbsp &nbsp &nbsp
<select id="typepdf" name="typepdf">
   <option value="stock">Stock</option>
   <option value="brand">Brand</option>
   <option value="disease">Disease</option>
   <option value="sales">Sales</option>
   <option value="date">Expiry Date</option>
 </select> <!-- <span class="label">Select Any one of the well known question</span> -->


</label>



<br />
<br />




<button role="button" type="submit"
class="btn btn-irenic float-left" tabindex="0">
<span>Submit</span>
</button>

<a role="button" type="submit" href="/adminhomepage"
class="btn btn-irenic float-right" tabindex="1">
<span>Back</span>
</a>



</form>




<br />
<br />

</div>
</div>



</body>

</html>