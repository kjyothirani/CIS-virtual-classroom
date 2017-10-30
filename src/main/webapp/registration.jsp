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
			         data : $('form[name=registrationform]'),
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
		
		
		
				
				<div id="header">	
				
						<div style="background-color: black"><img src="/Images/ucmo.png"  height="200" width="200" alt="coverImage"  border="0">
						<img src="/Images/vcimg.jpg"  height="200" width="1200" alt="coverImage1"  border="0"></div>
				</div>
				
			<div id="navButton">
				<ul>
					
					<li class="dropdown">
						<a href="home.html" class="dropbtn">Home</a>
						<div class="dropdown-content">
							<a href="about.html">About</a>
						</div>
					</li>
					
					
					<li class="dropdown">
					
						<a href="#" class="dropbtn">Login/Register</a>
						<div class="dropdown-content">
							<a href="/classroom/loginPage">Login</a>
							<a href="/classroom/register">Register</a>
						</div>
					
					</li>
					
					
					<li class="dropdown">
						<a href="contacts.html" class="dropbtn">Contact</a>
						
					</li>
					
					
				</ul>
			</div>
		<div id="showMessage" align="center" style="color:green;display:none" >
				Registration is success. Please click on login page to <a href="/classroom/loginPage">login</a>
			</div>
	<H1 ALIGN="CENTER" style="color: black">Student Registration Form</H1>
	<form:form method="POST" modelAttribute="registrationform">
		<div>
			<table align="center">
				<tr>
					<td><h3 style="color: black">Student Name:</h3>
					<td>
					<td><input type="text" name="studentName" />
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
					<td><input type="text" name="email" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: black">Password:</h3>
					<td>
					<td><input type="text" name="password" />
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