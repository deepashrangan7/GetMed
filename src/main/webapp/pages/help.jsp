<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GetMed Help Center</title>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style type="text/css">

body{
background-color: #25274d;
}
.contact{
padding: 4%;
height: 400px;
}
.col-md-3{
background: #ff9b00;
padding: 4%;
border-top-left-radius: 0.5rem;
border-bottom-left-radius: 0.5rem;
}
.contact-info{
margin-top:10%;
}
.contact-info img{
margin-bottom: 15%;
}
.contact-info h2{
margin-bottom: 10%;
}
.col-md-9{
background: #fff;
padding: 3%;
border-top-right-radius: 0.5rem;
border-bottom-right-radius: 0.5rem;
}
.contact-form label{
font-weight:600;
}
.contact-form button{


font-weight: 600;
width: 25%;
}
.contact-form button:focus{
box-shadow:none;
}

</style>


</head>
<body>


<div class="container contact">
<div class="row">
<div class="col-md-3">
<div class="contact-info">
<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
<h2>Contact Us</h2>
<h4>We would love to hear from you !</h4>
</div>
</div>


<div class="col-md-9">
<div class="contact-form">
<form id="form" action="helpper" method="post" > 
<div class="form-group">
 <label class="control-label col-sm-2" for="fname">First Name:</label>
 <div class="col-sm-10">          
<input type="text" class="form-control" id="name" placeholder="Enter Your Name" required="required" name="name"/>
 </div>
</div>

<div class="form-group">
 <label class="control-label col-sm-2" for="email">Email:</label>
 <div class="col-sm-10">
<input type="email" class="form-control" id="email" placeholder="Enter email" required="required" name="uid"/>
 </div>
</div>

<div class="form-group">
 <label class="control-label col-sm-2" for="lname">Issue:</label>
 <div class="col-sm-10">          
<input type="text" class="form-control" id="issue" placeholder="Enter The Issue" required="required"  name="issue" >
 </div>
</div>
<div class="form-group">
 <label class="control-label col-sm-2" for="comment">Description:</label>
 <div class="col-sm-10">
<textarea class="form-control" rows="5" id="description" name="description" required="required"></textarea>
 </div>
</div>
<div class="form-group">        
 <div class="col-sm-offset-2 col-sm-10 submit-container clearfix d-flex flex-row justify-content-between"style="margin-top: 2rem;"" >
<button type="submit" class="btn btn-secondary">Submit</button>
 <a type="submit" class="btn btn-secondary" href="/uhome">Back</a>
 
 </div>
 

</div>

<div style="color: red;text-align: left;padding-left: 0%"> *For more queries don't hesitate to contact 8888888888.</div>
</form>
</div>

</div>


</div>
</div>




</body>
</html>