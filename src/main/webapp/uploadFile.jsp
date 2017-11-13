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
	
		</script>
		
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
			<jsp:include page = "header.jsp" />
			
	<div id="showMessage" align="center" style="color:green;display:none" >
				upload is success.
			</div>		
	<H1 ALIGN="CENTER" style="color: black">Upload Here</H1>
	<form:form method="POST" action="/classroom/submitUpload" modelAttribute="uploadform" name="uploadform" id="uploadform" enctype="multipart/form-data">
		<div>
			<table align="center" style="color:black">
				<tr>
					<td><h3 style="color: black">Resource</h3>
					<td>
					<td><form:input type="text" name="resource" path="resource"/>
					<td>
				</tr>
				<tr>
					<td><h3 style="color: black">Link</h3>
					<td>
					<td><form:input type="text" name="link" path="link" />
					<td>
				</tr>

				
				<tr>
					<td><h3 style="color: black">PDF:</h3>
					<td>
					<td><form:input type="file" name="pdf"  path="pdf"/>
					<td>
				</tr>
				
			
				
				
				<tr>
					<td><h3 style="color: black">Article Name:</h3>
					<td>
					<td><form:input type="text" name="articleName" path="articleName" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: black">Student Name:</h3>
					<td>
					<td><form:input type="text" name="studentName" path="studentName" />
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