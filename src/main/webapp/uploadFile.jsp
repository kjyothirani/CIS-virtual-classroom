<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>Home Page</title>
		<link rel="stylesheet" href="/homepage.css">
		
		
		
	</head>
		
		<body background ="/Images/vcback.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
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
		
	<H1 ALIGN="CENTER" style="color: white">Upload Here</H1>
	<form:form method="POST" modelAttribute="uploadform">
		<div>
			<table align="center">
				<tr>
					<td><h3 style="color: white">Resource</h3>
					<td>
					<td><input type="text" name="resource" />
					<td>
				</tr>

				<tr>
					<td><h3 style="color: white">Link</h3>
					<td>
					<td><input type="text" name="link" />
					<td>
				</tr>

				
				<tr>
					<td><h3 style="color: white">PDF:</h3>
					<td>
					<td><input type="text" name="pdf" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: white">Uploaded Date:</h3>
					<td>
					<td><input type="text" name="uploadedDate" />
					<td>
				</tr>
				
				
				<tr>
					<td><h3 style="color: white">Article Name:</h3>
					<td>
					<td><input type="text" name="articleName" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: white">Student Name:</h3>
					<td>
					<td><input type="text" name="studentName" />
					<td>
				</tr>
				

				
				<tr>
					<td><input type="submit" id="submitButton" value="Upload"  /></td>
				</tr>
			</table>
			
			

		</div>
	</form:form>
	
	
</body>
</html>