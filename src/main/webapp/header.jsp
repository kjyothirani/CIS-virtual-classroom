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
			
			table{
			  border-collapse: collapse;
			}
		</style>
		<script src="/js/header.js"></script>
		<script>
		</script>
	</head>
		
		<body  background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
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
						<a href="listhuddles" class="dropbtn">Virtual Huddle</a>
						
					</li>
					<li>               </li><li> </li><li> </li><li> </li><li> </li>
						<li >
						<div id="username" class="dropbtn" style="padding-left: 700px"> </div>
						
					
					
					
				</ul>
			</div>
			
			<br/>
			<br/>
			
		
		  
			
			
			
					
							
								
						
			
	</body>	
</html>