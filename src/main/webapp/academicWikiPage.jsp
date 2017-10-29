<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.virtualclassroom.model.*"%>
<%@ page import="com.ucmo.virtualclassroom.dao.*"%>
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
			height:40px;
			width:150px;
			align: center;
			
			}
		</style>
		
	</head>
		
		<body background ="/Images/vcback.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
				<div id="header">	
				
						<div style="background-color: black"><img src="/Images/ucmo.png"  height="200" width="200" alt="coverImage"  border="0">
						<img src="/Images/vcimg.jpg"  height="200" width="1200" alt="coverImage1"  border="0"></div>
				</div>
				
			<div id="navButton">
				<ul>
					
					<li class="dropdown">
						<a href="home.html" class="dropbtn">Academic Wiki</a>
						
					</li>
					
					
					<li class="dropdown">
					
						<a href="#" class="dropbtn">UCMO Platform</a>
						
					
					</li>
					
					
					<li class="dropdown">
						<a href="contacts.html" class="dropbtn">Virtual Huddle</a>
						
					</li>
					
					
				</ul>
			</div>
			
			<br/>
			<br/>
			
			<table border="1" align="center" style="color:white">
			
				<tr>
					<td>Resource  </td>
					<td>Link  </td>
					<td>PDF  </td>
					<td>Uploaded Date  </td>
					<td>Article Name  </td>
					<td>Student Name  </td>
				</tr>
				<tr>
				<c:forEach items="${academicList}" var="academicList">
				<tr>
				
 				<td>${academicList.getResource()}</td>
 				<td>${academicList.getLink()}</td>
 				<td>${academicList.getPdf()}</td>
 				<td>${academicList.getDate()}</td>
 				<td>${academicList.getArticleName()}</td>
 				<td>${academicList.getStudentName()}</td>
 				</tr>
				</c:forEach>
				 
				 </tr> 
				 
				 
				
			</table>
			
			<table align="center">
				<tr><a href="/classroom/upload" class="button">Upload New</a></tr>
			</table>
			
			
					
							
								
						
			
	</body>	
</html>