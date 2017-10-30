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
			         url : 'submitDiscussion',
			         data : $("#platformForm").serialize(),
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
		<style>
			#ucmoplatform{
			 background-color: blue;
			}
			.button {
			background-color: blue;
			border: none;
			color: white;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;
			height:30px;
			width:150px;
	
	
			
				
		</style>
		
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
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
					
						<a href="platform" id="ucmoplatform" class="dropbtn">UCMO Platform</a>
						
					
					</li>
					
					
					<li class="dropdown">
						<a href="contacts.html" class="dropbtn">Virtual Huddle</a>
						
					</li>
					
					
					
					
				</ul>
			</div>
			
				<div id="showMessage" align="center" style="color:green;display:none" >
				Discussion is successfully posted.
			</div>		
		<form:form method="POST" modelAttribute="platformForm">
		<div>
			<table align="center" cellpadding="10">
				<tr>
					<td>Title</td>
					<td><textarea name="discussionName" rows="1" cols="50">What's your programming Question? Be specific</textarea></td>
				</tr>
				
				<tr></tr>
				<tr>
					<td>Describe..</td>
					<td>
					<textarea name="discussion" rows="8" cols="50">
				
					</textarea>
					</td>
				</tr>

				<div>	<hr> </div>
			
				<tr>
					<td>Tags:</td>
				
					<td><input type="text" name="tags" />
				</tr>
				
				<tr>
					<td>First Name:</td>
				
					<td><input type="text" name="firstName" />
				</tr>
				<tr>
					<td>Last Name:</h3></td>
				
					<td><input type="text" name="lastName" /></td>
					
				</tr>

				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					
					<td></td>
				</tr>
			</table>
			<div align="center"><input type="submit"  id="submitButton" style="margin-right:150px;" value="Post your Question" class="button"  /></div>
			

		</div>
	</form:form>
			
	
	
</body>
</html>