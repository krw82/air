<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
 		 	
		        <tr onclick = " location.href='/reservationForm?flying_number=${list.FLYING_NUMBER}' ">
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