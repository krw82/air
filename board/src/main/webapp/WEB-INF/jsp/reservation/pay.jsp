
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String name = (String)request.getAttribute("name");
    String email = (String)request.getAttribute("email");
    String phone = (String)request.getAttribute("phone");
    String address = (String)request.getAttribute("address");
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>


<script>
  
	
    var IMP = window.IMP; 
    IMP.init('imp01474368'); 
    IMP.request_pay({
    	pg : "kakaopay", 
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '결제',
        amount : 1,
        buyer_email : '<%=email%>',
        buyer_name : '<%=name%>',
        buyer_tel : '<%=phone%>',
        buyer_addr : '<%=address%>',
         buyer_postcode : ''
       // m_redirect_url : 'redirect url'
    }, function(rsp) {
        if ( rsp.success ) {
            var msg = '결제가 완료되었습니다.';
           
              location.href='/sendMail?FLYING_NUMBER=${FLYING_NUMBER}';  
        } else {
            var msg = '결제에 실패하였습니다.';
            location.href='/AJ/payFa';  
            rsp.error_msg;
            
        }
    });
	

    </script>




<title>Insert title here</title>
</head>
<body>
<input type="hidden" value="${SEAT}" name="SEAT">
<input type="hidden" value="${FLYING_NUMBER}" name="FLYING_NUMBER">
</body>
</html>