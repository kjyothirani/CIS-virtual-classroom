<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>Home Page</title>
		<link rel="stylesheet" href="/homepage.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
		
		
		$(function() {
				
			 $('.text').hide();
			   /*  Submit form using Ajax */
			   $('#submitButton').click(function(e) {
			   
			      //Prevent default submission of form
			      e.preventDefault();
			      
			      //Remove all errors
			      $('input').next().remove();
			      
			      $.post({
			         url : 'submitRegistration',
			         data : $('#registrationform').serialize(),
			         success : function(res) {
			        	 
			            if(res.success){
			               //Set response
			           console.log("here");
			              $('#showMessage').css("display","block");
			             
			 
			            
			            }else{
			              //Set error messages
			             
			              }
			          
			         }
			      });
			   });
			});
		</script>

	
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
			<jsp:include page = "header.jsp" />
			
		<div id="showMessage" align="center" style="color:green;display:none" >
				Registration is success. Please click on login page to <a href="/classroom/loginPage">login</a>
			</div>
	<H1 ALIGN="CENTER" style="color: black">Student Registration Form</H1>
	<form:form method="POST" modelAttribute="registrationform">
		<div>
			<table align="center">
				<tr>
					<td><h3 style="color: black">User Name:</h3>
					<td>
					<td><input type="text" name="username" />
					<td>
				</tr>
				<tr>
					<td><h3 style="color: black">Password:</h3>
					<td>
					<td><input type="text" name="password" />
					<td>
				</tr>
				<tr>
					<td><h3 style="color: black">Student ID:</h3>
					<td>
					<td><input type="text" name="studentID" />
					<td>
				</tr>

				
				<tr>
					<td><h3 style="color: black">Email:</h3>
					<td>
					<td><input type="text" name="emailId" />
					<td>
				</tr>
				

<tr>
					<td><h3 style="color: black">First Name:</h3>
					<td>
					<td><input type="text" name="firstname" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: black">Last Name:</h3>
					<td>
					<td><input type="text" name="lastname" />
					<td>
				</tr>
				
				<tr>
					<td><input type="submit" id="submitButton" value="register"  /></td>
				</tr>
			</table>
			
			

		</div>
	</form:form>
	
	
</body>
</html>