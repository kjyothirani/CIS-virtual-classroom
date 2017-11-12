<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>virtual huddle</title>
		<link rel="stylesheet" href="/homepage.css">
		<script src="/js/datatable.js"></script>
		
		<script>
			$(function() {
				
			
			   /*  Submit form using Ajax */
			   $('#submitButton').click(function(e) {
				   console.log($('form[name=virtualhuddleform]'));
				      
			      //Prevent default submission of form
			      e.preventDefault();
			      
			      //Remove all errors
			      $('input').next().remove();
			 
			      
			      $.post({
			         url : 'submithuddle',
			         data : $("#virtualhuddleform").serialize(),
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
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		<jsp:include page = "header.jsp" />
			
		
	<div id="showMessage" align="center" style="color:green;display:none" >
				Huddle saved successfully
			</div>		
	
	<form:form method="POST" modelAttribute="virtualhuddleform" name="virtualhuddleform" id="virtualhuddleform">
		<div>
			<table id="example" align="center">
				<tr>
					<td><h3 style="color: black">Virtual Huddle Name:</h3>
					<td>
					<td><input type="text" name="huddlename" />
					<td>
				</tr>

				<tr>
					<td><h3 style="color: black">select date</h3>
					<td>
					<td><input type="date" id="datepicker" name="selectdate" />
					<td>
				</tr>

				
				
				<tr>
					<td><h3 style="color: black">Huddle Description:</h3>
					<td>
					<td><input type="text" name="description" />
					<td>
				</tr>
				
				<tr>
					<td><h3 style="color: black">Huddle Place:</h3>
					<td>
					<td><input type="text" name="huddleplace" />
					<td>
				</tr>

				
				<tr>
					<td><input type="submit" id="submitButton" value="Submit"  /></td>
				</tr>
			</table>
			
			

		</div>
	</form:form>
	<div align="center">
		<input type="button" value="Subscribe">
		<input type="button" value="Unsubscribe">	
	</div>
</body>
</html>