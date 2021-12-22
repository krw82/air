<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() { 
	  var check=document.getElementsByName('check');
	  
	  $.each(${SEAT}, function(index, item){
		  check[item-11].disabled=true;
		 
	  });
	
	  $('input[name="check"]').change( function(){
			
		     $.ajax({
		        type : "GET",
		        url :'<c:url value="/SeatAjax"/>',
		        data : "data",
		        success : function(data){
		        	
		        	$('input[name=check]').attr("disabled",false);
		        	 $.each(${SEAT}, function(index, item){
		       		  check[item-11].disabled=true;
		       		
		       		 
		       	  });
		        },
		    error: function(data){
		        alert("에러가 발생했습니다.");
		        
		    }
		    
		     });   
		    
		  
		 	
		  
		  
			});   
 
		    
			
	  
	  
	  
		});





</script>
</head>
<body>
	<form action="/AJ/reservationCheck" method="get">
	<center>
 		 	<c:forEach var="list" items="${arr}" begin="11"  varStatus="status">
 		 		<img src="file/images.png" width="30">
		       <input type="radio" name= "check" value="${status.index}" class="check" style="position: relative; top: 20px; right: 31px;">  
		       
		      <c:if test="${status.count%5==0}"> 
		      <br>
		      <br>
		      </c:if>
	        </c:forEach>
	   
	 </center>


	        <br>
	        
	  <input type="submit" value="다음" style="float:right;">
	 
	   
	  </form>
 
</body>
</html>