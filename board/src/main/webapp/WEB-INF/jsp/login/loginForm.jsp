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

var bool=true;
	function login(){
		 var id = document.getElementById( 'ID' ).value;
		 var password = document.getElementById( 'PASSWORD' ).value;
		 
		 
		 if(id==""||password==""){
			 alert('필수 입력란이 비어있습니다.');
			 return false;
		 }else{
			 
			 $.ajax({
			        type : "GET",
			        url :'<c:url value="/loginAjax"/>',
			        data : {ID :id},
			        async : false,
			        success : function(data){
			        	
			        	 if(data.member!=null){
			        		if(data.member.PASSWORD==password){
			        			alert(data.member.PASSWORD);
			        			bool=true;
			        			console.log(bool);
			        			
			        			
			        		}
			        		else{
			        			alert('비밀번호가 틀렸습니다');
			        			bool=false;
			        			console.log(bool);
			        			
			        		}
			        	}
			        	else{
			        		alert('아이디가 없습니다.');
			        		bool=false;
			        		console.log(bool);
			        		
			        	}
			        
			        	 console.log(bool);
			        
			        
			        
			        
			        
			        },
			    error: function(data){
			        alert("에러가 발생했습니다.");
			        
			    }
			    
			     }); 
			 
			
			 console.log(bool);
		 }
		 
		console.log(bool);
		return bool;
	
	}
	
	
	
	
</script>
</head>
<body>
<form action="/success" method="POST" onsubmit="return login();">
<table>
	<tr>
		<td>
			아이디
		</td>
		<td>
			<input type="text" name="ID" id="ID">
		</td>
	</tr>
	<tr>
		<td>
			비밀번호
		</td>
		<td>
			<input type="text" name="PASSWORD" id="PASSWORD">
		</td>
	</tr>

</table>


<input type="submit">
</form>
</body>
</html>