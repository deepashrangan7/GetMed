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


          <h4 class="modal-title">Medicine Details</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
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
  









					<a href="editMedicine?mid=${meds.mid}" id="submit" role="button" type="submit"
						class="btn btn-irenic float-left btn-lg" tabindex="0">
						<span>edit</span>
					</a>
					<a href="/adhome"  role="button" type="reset"
						class="btn btn-irenic float-right btn-lg" tabindex="0">
	Cancel	</a>




</body>

</html>

