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

	  
	  function On(NUMBER){

		       $.ajax({
		        type : "GET",
		        url :'<c:url value="/AriplaneSearchAjax?FLYING_NUMBER='+NUMBER+'&MEMBER_NUMBER=${MEMBER_NUMBER}"/>',
		        data : "data",
		        success : function(data){
		        	if(data.bool!=true){
		        		location.href='/reservationForm?flying_number='+NUMBER;
		        	}
		        	else{
		        		alert('이미 예약한 스케쥴입니다.');
		        	}
		        	
		        },
		    error: function(data){
		        alert("에러가 발생했습니다.");
		        
		    }
		    
		     });    
		  
		  
		  
		  
		  
	  }
	 
	 
 	  

</script>




</head>
<body>
<table border="1">
	<tr>
		<th>출발지</th>
		<th>도착지</th>
		<th>경유지</th>
		<th>날짜</th>
		<th>가격</th>
		<th>비행기</th>
	</tr>
	<c:choose>
	<c:when test="${fn:length(list)>0 }">
 		 	<c:forEach var="list" items="${list}" varStatus="status">
 		 	<%-- onclick = " location.href='/reservationForm?flying_number=${list.FLYING_NUMBER}' --%>
		        <tr id="T" onclick ="On('${list.FLYING_NUMBER}');" >
		 		  <td>${list.START_POINT}</td>
		          <td>${list.END_POINT}</td>
		          <td>${list.STOPOVER}</td>
		          <td>${list.START_DATE}~${list.END_DATE}</td>
		          <td>${list.PRICE}</td>
		          <td>${list.AIRPLANE}</td>
		        </tr>
		        
	        </c:forEach>
	    </c:when>
	     <c:otherwise>
		 조회된결과 없음
		 </c:otherwise>
	
	</c:choose>








</table>
</body>
</html>