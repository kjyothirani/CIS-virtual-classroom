<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>Home Page</title>
		<link rel="stylesheet" href="/homepage.css">

	
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
			<jsp:include page = "header.jsp" />
			
			 <c:if test = "${loginFailure == 'yes'}">
			 <div id="loginFailure" align="center" style="color:red"> The id and/or password is incorrect. Please provide valid credentials.</div>
			 </c:if>
		
	<H1 ALIGN="CENTER" style="color: black">Student Login</H1>
	<form:form method="POST" action="loginPage" modelAttribute="loginform">
		<div>
			<table align="center">
				
				<tr>
					<td><h3 style="color: black">Student ID:</h3>
					<td>
					<td><input type="text" name="studentID" />
					<td>
				</tr>

				
				
				<tr>
					<td><h3 style="color: black">Password:</h3>
					<td>
					<td><input type="text" name="password" />
					<td>
				</tr>

				
				<tr>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>



		</div>
	</form:form>
</body>
</html>