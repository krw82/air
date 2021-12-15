<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/AJ/pay"> 
ID : ${ID}
<br>
스케쥴번호 : ${MAP.FLYING_NUMBER}
<br>
비행기 : ${MAP.AIRPLANE}
<br>
출발일 :${MAP.START_DATE}
<br>
도착일 :${MAP.END_DATE}
<br>
출발지 :${MAP.START_POINT}
<br>
경유지 :${MAP.STOPOVER}
<br>
도착지 :${MAP.END_POINT}
<br>
가격 :${MAP.PRICE}
<br>
좌석 :${SEAT}

<input type="hidden" value="${MAP.FLYING_NUMBER}" name="FLYING_NUMBER">
<input type="hidden" value="${SEAT}" name="SEAT">

<input type="submit" value="다음">
</form>

</body>
</html>