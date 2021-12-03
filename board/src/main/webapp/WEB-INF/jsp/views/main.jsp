<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>


<script type="text/javascript">
$(document).ready(function() {
	var vtx ="";
	$('#krw').on("click",function(){
	$.ajax({
		url : '<c:url value="/main"/>',
		type : "GET",
		data : "",
	
		success : function(data) {
			
			
			
			  
			 		$.each(data.board, function(index, el){	
			 			 alert(el.MEMBER_ID);
			 		});
			 	
			
				}, error: function(data){
			        alert("에러가 발생했습니다.");
			        return false;	}
		});
	});
	
	});



	


</script>
</head>
<body>
<input type="button" id="krw">

 		
asdas

</body>
</html>