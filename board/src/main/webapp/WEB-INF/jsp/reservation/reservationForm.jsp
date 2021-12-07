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
	
	
	
	var sum=0;
	var string='';
    for(var i=11; i<=49; i++){
    	
    		 string+='<input type="checkbox" name="'+i+'" id="checkBoxId" value="'+i+'" onchange="getCheckBoxYn()">'; 
    		
    		
    	
    	
    	}
    	
    	/*  var+='<input type="checkbox" name="'i'" id="'i'" >' */
    	
      $("#divv").html(string); 
    
	
	/* div.innerHTML=var; */
	
      
	});
function getCheckBoxYn(){
	
	if($("input:checkbox[id='checkBoxId']").is(":checked") == true){
    	//test01 체크박스가 체크되어습니다.
		console.log('ss');
    	alert('ss');
    }else{
    	//test01 체크박스가 체크되어 있지 않습니다.
    }
}
</script>


</head>
<body>

 		 	
	        <div id="divv">
	        </div>
	        
	        <br>
	   <input type="checkbox" id="checkBoxId">
	   
	  

</body>
</html>