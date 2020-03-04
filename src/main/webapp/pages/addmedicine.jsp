<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    
  </head>
  <body>
    <f:form  action="/rty" role="form" modelAttribute="sign" method="post">
    <table>
        <tr >
            <%-- <td>MID:</td>
            
            <td>
            <f:input class="form-group" path="mid" type="number"  name="mid"  />
                                         
            <f:errors path="firstName"/>
                                             </td> --%>
            </tr>
        <tr><td>Name:</td>
            <td><f:input class="form-group" path="name" type="text"  name="name" />
  <f:errors path="name"/></td>
        </tr>

<tr >

<td>brand:</td>
<td><f:input path="brand" class="form-group" type="text"  name="brand"/>
                     <f:errors path="brand"/> </td>
</tr>
                                        
 <tr >
            <td>price:</td>
            
            <td>
            <f:input class="form-group" path="price" type="number"  name="price" step="0.1" />
                                         
         <f:errors path="price"/> 
                                                                                                            </td>
            </tr>
 <tr >
            <td>stock:</td>
            
            <td>
            <f:input class="form-group" path="stock" type="number"  name="stock"  />
                                         
           <f:errors path="stock"/>
                                                                                                            </td>
            </tr>
            
             <tr><td>disease:</td>
            <td><f:input class="form-group" path="disease" type="text"  name="disease" />
  <f:errors path="disease"/> </td>
        </tr>

  <tr><td>city:</td>
            <td><f:input class="form-group" path="city" type="text"  name="city" />
 <f:errors path="city"/> </td>
        </tr>
<tr>
<td>expiryDate:</td>
            
            
            <td>
           
<f:input path="expiryDate" name="expiryDate" type="date"  />
            
                             
          <f:errors path="expiryDate"/> 
                                                                                                            </td>
            </tr> 


</table>


<button type="submit" class="btn btn-outline-secondary btn-lg" >Submit</button>
<button type="reset" class="btn btn-outline-secondary btn-lg">Reset</button>

</f:form>




  </body>


</html>
