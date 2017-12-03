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
	<style>
	.greenbutton {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
	</style>	
		
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
					<td><h3 style="color: black">Article Name:</h3>
					<td>
					<td><form:input type="text" name="articleName" path="articleName" />
					<td>
				</tr>
				<tr>
					<td><h3 style="color: black">Resource description</h3>
					<td>
					<td><form:input type="text" name="resource" path="resource"/>
					<td>
				</tr>
			

				
				<tr>
					<td><h3 style="color: black">PDF:</h3>
					<td>
					<td><form:input type="file" name="pdf"  path="pdf"/>
					<td>
				</tr>
				
					<tr>
					<td><h3 style="color: black">Subject:</h3></td><td>
					<td><form:select path="subject">
					<form:option value="Java"></form:option>
					<form:option value=".Net"></form:option>
					<form:option value="Client Souce"></form:option>
					<form:option value="Internet for Enterprise"></form:option>
					<form:option value="Software Engineering"></form:option>
					</form:select>
					<td>
				</tr>
				
				
				
				<tr>
					<td><h3 style="color: black">Student name:</h3>
					<td>
					<td><form:input type="text" name="studentName" path="studentName"  disabled="true"/>
					<td>
				</tr>


				
				<tr>
					<td><input type="submit" id="submitButton" value="Upload" class="greenbutton" /></td>
				</tr>
			</table>
			
			

		</div>
	</form:form>
	
	
</body>
</html>