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
		<link rel="stylesheet" href="/css/academicwiki.css">
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		<script src="/js/datatable.js"></script>
		
		
		
		
	
	</head>
		
		<body  style="background-repeat:no-repeat; background-size: 1600px 800px;">
		
		
		
				
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
			<div class="pagination">
			<table id="example" rules="none" "border="0" rules="none">
				<thead>
				<tr>
					<th>Resource  </th>
					<th>Link  </th>
					<th>PDF  </th>
					<th>Uploaded Date  </th>
					<th>Article Name  </th>
					<th>Student Name  </th>
				</tr>
				</thead>
				<tbody>

				<c:forEach items="${academicList}" var="academicList">
				<tr>
				
 				<td>  ${academicList.getResource()}</td>
 				<td>  <a href="${academicList.getLink()}">${academicList.getLink()}</a></td>
 				<td>  <a href="${academicList.getPdf()}">${academicList.getPdf()}</a></td>
 				<td>${academicList.getDate()}</td>
 				<td>${academicList.getArticleName()}</td>
 				<td>${academicList.getStudentName()}</td>
 				</tr>
				</c:forEach>
				 
				 </tbody>
				 
				
			</table>
			
			</div>
			<br/>
			<br/>
			
			<div align="center"><a href="/classroom/upload" class="button">Upload New</a></div>
		  
			
			
			
					
							
								
						
			
	</body>	
</html>