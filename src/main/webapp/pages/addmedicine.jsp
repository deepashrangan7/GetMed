<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

	<div class="tile">

		<div class="tile-header">
			<h2
				style="color: teal; opacity: .75; font-size: 4rem; display: flex; justify-content: center; align-items: center; height: 100%;">Fill
				Out</h2>
		</div>

		<div class="tile-body">
			<f:form id="form" action="/addmedicine" method="post"
				modelAttribute="addmed">
				<label class="form-input"> <i class="material-icons">person</i>
					<f:input path="name" type="text" autofocus="true" name="name"
						required="true" /> <span class="label">Medicine Name</span>
					<div class="underline"></div>
				</label>
				<p style="color: red;">
					<f:errors path="name"></f:errors>
				</p>
				<label class="form-input"> <i class="material-icons">person</i>
					<f:input path="brand" type="text" name="brand" required="true" />
					<span class="label">Brand Name</span>
					<div class="underline"></div>
				</label>
				<p style="color: red;">
					<f:errors path="brand"></f:errors>
				</p>
				<label class="form-input"> <i class="material-icons">person</i>
					<f:input path="price" type="number" name="price" step="0.1"
						required="true" /> <span class="label">Price</span>
					<div class="underline"></div>
				</label>
				<p style="color: red;">
					<f:errors path="price"></f:errors>
				</p>
				<label class="form-input"> <i class="material-icons">person</i>
					<f:input type="number" path="stock" name="stock" required="true" />
					<span class="label">Stock</span>
					<div class="underline"></div>
				</label>
				<p style="color: red;">
					<f:errors path="name"></f:errors>
				</p>
				<label class="form-input"> <i class="material-icons">person</i>
					<f:input type="text" name="disease" path="disease" required="true" />
					<span class="label">disease</span>
					<div class="underline"></div>
				</label>

				<p style="color: red;">
					<f:errors path="disease"></f:errors>
				</p>

				<label class="form-input"> <i class="material-icons" style="padding-right: 10em;"
				>person</i>
&nbsp;&nbsp;
					<div class="col-md-5 mb-5" style="padding-left: 3em;">
						
						<f:select
							class="custom-select" name="type" path="type" required="true">
						<f:option value="normal">Normal</f:option>
							<f:option value="vaccine">Vaccine</f:option>
						<f:option value="capsule">capsule</f:option>
						<f:option value="syrup">syrup</f:option>
						</f:select>
						</div> 
					
					
				</label>




				<label class="form-input"> <i class="material-icons">person</i>
					<f:input path="city" type="text" name="city" required="true" /> <span
					class="label">City</span>
					<div class="underline"></div>
				</label>
				<p style="color: red;">
					<f:errors path="city"></f:errors>
				</p>


				<label class="form-input"> <i class="material-icons">person</i>
					<f:input path="expiryDate" type="date" placeholder="expiry Date"
						name="expiryDate" required="true" /> <span class="label"></span>
					<div class="underline"></div>
				</label>
				<p style="color: red;">
					<f:errors path="expiryDate"></f:errors>
				</p>

				<div class="submit-container clearfix" style="margin-top: 2rem;">

					<button id="submit" role="button" type="submit"
						class="btn btn-irenic float-left btn-lg" tabindex="0">
						<span>Submit</span>
					</button>
					<input id="submit" value="clear" role="button" type="reset"
						class="btn btn-irenic float-right btn-lg" tabindex="0">


					<div class="login-pending">
						<div class=spinner>
							<span class="dot1"></span> <span class="dot2"></span>
						</div>

						<div class="login-granted-content">
							<i class="material-icons">done</i>
						</div>
					</div>
				</div>
			</f:form>

		</div>
	</div>



</body>

</html>

