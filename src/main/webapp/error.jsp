<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.virtualclassroom.model.*"%>

<%@ page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<title>Home Page</title>
		<link rel="stylesheet" href="/homepage.css">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/lightbox.css">
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
		
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

		<script src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		
		<script type="text/javascript">
		$(document).ready(function(){
	
			getData();
			console.log("entered");
	
		
		});

		</script>
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		<jsp:include page = "header.jsp" />
			<br/>
			<br/>
			
				<div class="selectShadow"></div>
				<div class="pop deletPop">
				
					
		<h2 id="spnQues">Are you sure you want to delete the selected
			document?</h2>
		<div class="form-row clear uploadRow  model-footer"
			style="border: none; margin: 0">
			<button class="btn btn-danger no btn-cancel">NO</button>
			<button class="btn btn-primary yes">YES</button>
		</div>
	</div>
	
	<div class="alertPop animated fadeInRight ">
		<span class="clsAlert clsBtn"><i class="fa fa-times"
			aria-hidden="true"></i></span>
		<div>
			<span class="alertMsg">Alert</span>
		</div>
	</div>
	<div id="showMessage" align="center" style="color:green;display:none" >
				Deleted the selected discussion.
			</div>	
			
			<div id="loadinggif" align="center"  style="color:green;display:none" >
				<img src="/Images/loading.gif"></img>
			</div>	
	<div id="showMessage1" align="center" style="color:red;display:none" >
				The username and/or password you provided is wrong.
			</div>	
			<br/>
			<br/>
		  
			
			
			
					
							
								
						
			
	</body>	
</html>