

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
                window.setTimeout(function () { $btn.classList.add('granted'); }, 1500);
            }
        }

        $btn.addEventListener("click", signIn);

function fun(){
document.getElementById("age").value="";
alert("hii")
	
}
        
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
    <br />
    <br />
    <div class="tile">

        <div class="tile-header">
            <h2
                style="color:black; opacity: .75; font-size: 4rem; display: flex; justify-content: center; align-items: center; height: 100%;justify-content: center;">
                SIGN UP</h2>
        </div>

        <div class="tile-body">
            <f:form id="form" action="home" method="post" modelAttribute="signup">
                <label class="form-input">
                    <i class="material-icons">mail</i>
                    <f:input type="text" autofocus="true" name="emaiId"  path="emailId"/>
                    <span class="label">Email Id</span>
                 <p style="color:red;"><f:errors path="emailId"></f:errors></p>
                </label>

                <label class="form-input">
                    <i class="material-icons">person</i>
                    <f:input type="text" autofocus="true" name="firstName"  path="firstName"/>
                    <span class="label">First Name</span>
                <p style="color:red;"><f:errors path="firstName"></f:errors></p>
                   
                </label>


                <label class="form-input">
                    <i class="material-icons">person</i>
                    <f:input path="lastName" type="text" autofocus="true" id="lastName" name="lastName" />
                    <span class="label">Last Name</span>
                    <p style="color:red;"><f:errors path="lastName"></f:errors></p>
                
                </label>

                <label class="form-input">
                    <i class="material-icons">lock</i>
                    <f:input type="password" name="password" path="password" />
                    <span class="label">Password</span>
                    <p style="color:red;"><f:errors path="password"></f:errors></p>
                
                </label>

                <label class="form-input">
                    <i class="material-icons">person</i>
                    <f:input type="number" path="age" min="1" max="150" name="age"  id="age"/>
                    <span class="label">Age</span>
                    <p style="color:red;"><f:errors path="age"></f:errors></p>
                
                </label>
                <i class="material-icons">person</i>
                &nbsp;&nbsp;
                <f:radiobutton value="male" name="gender" path="gender"/> Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <f:radiobutton value="female" name="gender" path="gender"/> Female
                <br/>
                <p style="color:red;"><f:errors path="gender"></f:errors></p>
                
                <label class="form-input">
                    <i class="material-icons">phone</i>
                    <f:input type="text" name="contact" path="contact" pattern="[6-9]{1}[0-9]{9}" />
                    <span class="label">Contact Number</span>
                    <p style="color:red;"><f:errors path="contact"></f:errors></p>
                
                </label>

                <div class="submit-container clearfix" style="margin-top: 2rem;">

                    <button  role="button" type="submit" class="btn btn-irenic float-left"
                        tabindex="0">
                        <span>Next</span>
                    </button>
                    
                    
                   
<a href="/sign">Clear</a>


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
            <br /><br />
            <%String role=(String)session.getAttribute("role"); %>
            <p style="text-align: center;font-size: large;">Already Have Account? <a href=<%="/log?role="+role%>>Login</a></p>

        </div>
    </div>



</body>

</html>