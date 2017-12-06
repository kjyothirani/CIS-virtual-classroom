<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>Home Page</title>
		<link rel="stylesheet" href="/homepage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
	
			var modelAttr = $("#subject").val();
			console.log(modelAttr);
			
			 $('#submitButton1').click(function(e) {
				   console.log($('form[name=uploadform]'));
			      //Prevent default submission of form
			      e.preventDefault();
			      //Remove all errors
			      $('input').next().remove();
			      window.location = 'submitsubject?subject='+modelAttr;
			   });
		});
		</script>
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
				
				<jsp:include page = "header.jsp" />
				
				<table align="center" cellpadding="10">
					<tr>
					  <td>Select your Subject you want to upload the document:</td>
					  </tr>
					 <tr>
						<td><select path="subject" id="subject">
								<option value="Advance Java" selected="selected">Advance Java</option>
								<option value="Legal Environment System">Legal Environment System</option>
								<option value="Software Engineering">Software Engineering</option>
								<option value="Client side Internet Resources">Client side Internet Resources</option>
						</select></td>
					</tr>
					<tr><td><input type="submit"  id="submitButton1"  value="Proceed to view" class="button"  /></td></tr>
				</table>
				
	</body>	
</html>