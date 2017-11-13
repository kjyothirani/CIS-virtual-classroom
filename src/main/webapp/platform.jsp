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
		
		function getData()
		{
			
		
		      $.get({
			         url : 'platformdata',
			         beforeSend : function(xhr, opts){
			        	    $('#loadinggif').css("display","block");
			         },
			         success : function(res) {

			        	  $('#loadinggif').css("display","none");
			           
			        		$('#example').dataTable({
			   				data:res,
			   			    	"aoColumns": [
			   						 { "mData": "discussionName", "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
			   				            $(nTd).html("<a href='platformDiscussion?id="+oData.id+"'>"+oData.discussionName+"</a>");
			   				        } },
			   						  { "mData": "username" },
			   						  { "mData": "tags" },
			   						 { "mData": "id" , "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
		$(nTd).html("<a href=\"javascript:void(0);\" ><img onclick=\"deleteDiscussion("+oData.id+")\" src=\"/Images/delete-button.png\" style=\"height: 25px; width: 25px;\"> </a>"
				   		 				 );}}
			   						 
			   					]
			   			});
			            
			            }
			      });
		}
		function deleteDiscussion(id)
		{
			console.log("entered");
			$('.pop').show();
			$('.selectShadow').show();
			var $this = $(this);
			function hidePop(){
				$('.pop').hide();
				$('.selectShadow').hide();
			}
			$('.yes').off('click').on('click', function() {
				console.log("clicked yes");
				$this.closest(".gridBlock").addClass("tobedeleted");
			      $.post({
				         url : 'deleteDiscussion?id='+id,
				         success : function(res) {

					           
				            if(res.success){
				               //Set response
				         
				           
				              $('#showMessage').css("display","block");
				              $('#loadinggif').css("display","block");
				              $('#example').DataTable().destroy();
				              getData();
				             
				            }else{
				              }
				         }
				      },5000);
			      
				hidePop();
			});
			$('.no').on('click', function() {
				hidePop();
			});	
			console.log(id);
	
			
		}
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
	<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>DiscussionName</th>
                <th>Username</th>
                <th>Tags</th>
                 <th></th>
            </tr>
        </thead>
       
    </table>
			<br/>
			<br/>
			<div align="center"><a href="/classroom/newDiscussion" class="button">Post new question</a></div>
		  
			
			
			
					
							
								
						
			
	</body>	
</html>