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
	
		<script type="text/javascript">
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

					           console.log(res);
				            if(res.success){
				               //Set response
				           console.log("here");
				               var dubid ='\'#Unsubscribe'+id+'\'';
				              $('#showMessage').css("display","block");
				        
				           
				            
				            }else{
				              }
				         }
				      });
			      
			     location.reload();
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
			<div id="showMessage" align="center" style="color:green;display:none" >
				Deleted the selected discussion.
			</div>	
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
			<div class="pagination">
			<table  id="example" rules="none" align="center"  style="color:black" cellpadding="10" cellspacing="10">
		
				<tbody>

				<tr >
				<c:forEach items="${platformList}" var="platformValue">
				<tr >
				
 				<td> <a  href="platformDiscussion?id=${platformValue.getId() }"> ${platformValue.getDiscussionName()}</a></td>
 				</tr>
 				<tr>
 				<td>  ${platformValue.getFirstName()}     ${platformValue.getLastName()} ||  ${platformValue.getUsername()} </td>
 				<td>
 				  ${platformValue.getTags()}  </td>
 				  <td> <div align="center"><a href="javascript:void(0);" ><img onclick="deleteDiscussion(${platformValue.getId() })" src="/Images/delete-button.png" style="height: 25px; width: 25px;">
 				  </a>
 				  </div>
 				  </td>
 				
 				</tr>
 				<tr><td>--------------------------------------------------------------------------------</td>
 				</tr>
 				
				</c:forEach>
				 
				 </tr> 
				 </tbody>
				 
				
			</table>
			</div>
			<br/>
			<br/>
			<div align="center"><a href="/classroom/newDiscussion" class="button">Post new question</a></div>
		  
			
			
			
					
							
								
						
			
	</body>	
</html>