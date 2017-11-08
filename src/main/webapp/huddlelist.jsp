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
			tr:first-child {border: thin solid black;}
			table{
			  border-collapse: collapse;
			}
		</style>
		
	</head>
		
		<body background ="/Images/bg.png" style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				<jsp:include page = "header.jsp" />
			
			<br/>
			<br/>
			
			<table border="1" rules="none" style="color:black" cellpadding="30" cellspacing="40">
				<thead>
				<tr class="border_bottom">
					<th>Huddle Name  </th>
					<th>Date  </th>
					<th>Huddle Description  </th>
					<th>Huddle  Place  </th>
					
				</tr>
				</thead>
				<tbody>
				<tr>
				<c:forEach items="${huddlelist}" var="huddle">
				<tr class="border_bottom">
				
 				<td>  ${huddle.getHuddlename()}</td>
 				<td> ${huddle.getSelectdate()}</td>
 				<td>  ${huddle.getDescription()}</td>
 				<td>${huddle.getHuddleplace()}</td>
 				
 				</tr>
				</c:forEach>
				 
				 </tr> 
				 </tbody>
				 
				
			</table>
			<br/>
			<br/>
			<div align="center"><a href="/classroom/virtualhuddle" class="button">Post new Huddle</a></div>
		  
			
			
			
					
							
								
						
			
	</body>	
</html>