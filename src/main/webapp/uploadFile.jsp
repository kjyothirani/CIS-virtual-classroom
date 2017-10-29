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
				   console.log($('form[name=uploadform]'));
				      
			      //Prevent default submission of form
			      e.preventDefault();
			      
			      //Remove all errors
			      $('input').next().remove();
			 
			      
			      $.post({
			         url : 'submitUpload',
			         data : $("#uploadform").serialize(),
			         success : function(res) {

				           console.log(res);
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
		
		<body background ="/Images/skulls.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
				<div id="header">	
				
						<div style="background-color: black"><img src="/Images/ucmo.png"  height="200" width="200" alt="coverImage"  border="0">
						<img src="/Images/vcimg.jpg"  height="200" width="1200" alt="coverImage1"  border="0"></div>
				</div>
				
			<div id="navButton">
				<ul>
					
					<li class="dropdown">
						<a href="/classroom/academicWiki" class="dropbtn">Academic Wiki</a>
						
					</li>
					
					
					<li class="dropdown">
					
						<a href="#" class="dropbtn">UCMO Platform</a>
						
					
					</li>
					
					
					<li class="dropdown">
						<a href="contacts.html" class="dropbtn">Virtual Huddle</a>
						
					</li>
					
					
					
					
				</ul>
			</div>
	<div id="showMessage" align="center" style="color:green;display:none" >
				upload is success.
			</div>		
	<H1 ALIGN="CENTER" style="color: black">Upload Here</H1>
	<form:form method="POST" modelAttribute="uploadform" name="uploadform" id="uploadform">
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
					<td><input type="text" name="link" />
					<td>
				</tr>

				
				<tr>
					<td><h3 style="color: black">PDF:</h3>
					<td>
					<td><input type="text" name="pdf" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: black">Uploaded Date:</h3>
					<td>
					<td><input type="text" name="uploadedDate" />
					<td>
				</tr>
				
				
				<tr>
					<td><h3 style="color: black">Article Name:</h3>
					<td>
					<td><input type="text" name="articleName" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: black">Student Name:</h3>
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