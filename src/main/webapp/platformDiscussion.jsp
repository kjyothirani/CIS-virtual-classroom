<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.virtualclassroom.model.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>Home Page</title>
		<link rel="stylesheet" href="/homepage.css">

		<style>
			.button {
			background-color: blue;
			border: none;
			color: white;
			padding: 10px 10px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;
			height:30px;
			align: center;
			
			}
			
			

			#academicWiki{
			 background-color: blue;
			}
			th{
				font-size: 18px;
			}
			tr:first-child {border: thin solid black;}
			table{
			  border-collapse: collapse;
			}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
		
		$(function() {
			
			 $('.text').hide();
			   /*  Submit form using Ajax */
			   $('#submitButton1').click(function(e) {
				   console.log($('form[name=uploadform]'));
				      
			      //Prevent default submission of form
			      e.preventDefault();
			      
			      //Remove all errors
			      $('input').next().remove();
			 
			      
			      $.post({
			         url : 'replyDiscussion',
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
	</head>
		
		<body background ="/Images/skulls.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
				<div id="header">	
				
						<div style="background-color: black"><img src="/Images/ucmo.png"  height="200" width="200" alt="coverImage"  border="0">
						<img src="/Images/vcimg.jpg"  height="200" width="1200" alt="coverImage1"  border="0"></div>
				</div>
				
			<div id="navButton">
				<ul>
					
					<li class="dropdown">
						<a href="academicWiki" class="dropbtn" id="academicWiki">Academic Wiki</a>
						
					</li>
					
					
					<li class="dropdown">
					
						<a href="platform" class="dropbtn">UCMO Platform</a>
						
					
					</li>
					
					
					<li class="dropdown">
						<a href="contacts.html" class="dropbtn">Virtual Huddle</a>
						
					</li>
					
					
				</ul>
			</div>
			
			<br/>
			<br/>
				<div id="showMessage" align="center" style="color:green;display:none" >
				Discussion reply is successfully posted.
			</div>		
			<table  rules="none" align="center"  style="color:black" cellpadding="10" cellspacing="10">
		
				<tbody>

				<tr >
				<c:forEach items="${platformDiscussionList}" var="platformDiscussionList">
 				<tr>
 				<td>  ${platformDiscussionList.getValue()}      </td>
 				<td>
 				
 				</tr>
 				<tr>
 				<td>  ${platformDiscussionList.getFirstName()}     ${platformDiscussionList.getLastName()} ||  ${platformDiscussionList.getUsername()} </td>
 			
 				
 				</tr>
 				<tr><td>--------------------------------------------------------------------------------</td>
 				</tr>
				</c:forEach>
 				</tr>
 				
				 
				 </tbody>
				 
				
			</table>
			<br/>
			<br/>
			
			<form:form method="POST" action="replyDiscussion" modelAttribute="platformForm">
		<div>
			<table align="center" cellpadding="10">
				
				<tr></tr>
				
					<tr>
				<td><input type="text" style="display: none" name="id"  value="${platformModel.id }"/>
				</tr>
				<tr>
					<td>
					<textarea name="discussion" rows="8" cols="50">
				
					</textarea>
					</td>
				</tr>

			

				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					
					<td></td>
				</tr>
			</table>
			<div align="center"><input type="submit"  id="submitButton" style="margin-right:150px;" value="Reply your Question" class="button"  />
			<a href="/classroom/newDiscussion" class="button">Post new question</a>
			</div>
			<div align="center"></div>

		</div>
	</form:form>
			
			
		  
			
			
			
					
							
								
						
			
	</body>	
</html>