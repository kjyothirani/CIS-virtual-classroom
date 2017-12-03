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
		
		<style>
		.table tbody tr td {text-align: center;}
		.right {text-align: center;}
		</style>	
		<script type="text/javascript">
		$(document).ready(function(){
	
			getData();
			var modelAttr = $("#modelAttr").val();
			if('yes'==modelAttr)
				  $('#showMessage').css("display","block");
		
		});
		
		function getData()
		{
		
			   $.get({
			         url : 'getWikiList',
			         beforeSend : function(xhr, opts){
			        	    $('#loadinggif').css("display","block");
			         },
			         success : function(res) {

			        	  $('#loadinggif').css("display","none");
			           
			        		$('#example').dataTable({
			   				data:res,
			   				"columnDefs": {
		   					    
		   					      className: "dt-head-center"
		   					    
		   					  },
			   			    	"aoColumns": [
			   			    	 { "mData": "articleName" , "sClass": "right" },
			   						 { "mData": "resource" , "sClass": "right" },
			   						 { "mData": "pdf", "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
				   				            $(nTd).html("<a target=\"_blank\" href='/classroom/download?file="+oData.pdf+"'>"+oData.pdf+"</a>");
				   				        },"sClass": "right"  },
			   						 { "mData": "date","sClass": "right" },
			   					
			   						 { "mData": "studentName"  , "sClass": "right"}

			   						 
			   					]
			   				
			   			});
			            
			            }
			      });
		}
		</script>
		
	
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
			
				<div id="showMessage" align="center" style="color:green;display:none;font-size: 30px" >
				New article is saved successfully.
			</div>	
			<div class="pagination">
			<table id="example" rules="none" "border="0" rules="none" class="hover">
				<thead>
				<tr>
				<th>Article Name  </th>
					<th>Resource  </th>
					<th>PDF  </th>
					<th>Uploaded Date  </th>
					
					<th>Student Name  </th>
				</tr>
				</thead>
		
				 
				
			</table>
			
			</div>
			<br/>
			<br/>
			
			<div align="center"><a href="/classroom/upload" class="button">Upload New</a></div>
		  
			<input type="hidden" id="modelAttr" name="modelAttr" value="${message}"/>
			
			
					
							
								
						
			
	</body>	
</html>