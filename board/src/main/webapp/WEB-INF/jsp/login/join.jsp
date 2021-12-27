<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=ADDRESS]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}
</script>



</head>
<body>
<form action="/join" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="ID"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="NAME"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="PASSWORD"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="ADDRESS" id="address_kakao"></td>
	</tr>
	<tr>
		<td>핸드폰번호</td>
		<td><input type="text" name="PHONE_NUMBER"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="EMAIL"></td>
	</tr>
</table>
<input type="submit">
</form>
</body>
</html>