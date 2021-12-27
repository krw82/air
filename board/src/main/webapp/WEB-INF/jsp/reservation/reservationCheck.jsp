<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/pay?FLING_NUMBER=${MAP.FLYING_NUMBER }"> 
<table border ="1">
<tr>
<th>
ID 
</th>

<th>

스케쥴번호
</th>
<th>
비행기 
</th>
<th>
출발일 
</th>
<th>
도착일 
</th>
<th>
출발지 
</th>
<th>
경유지 
</th>
<th>
도착지 
</th>
<th>
가격 
</th>
<th>
좌석 
</th>
<tr>
<td> ${ID}</td>
<td> ${MAP.FLYING_NUMBER}</td>
<td> ${MAP.AIRPLANE}</td>
<td>${MAP.START_DATE}</td>
<td> ${MAP.END_DATE}</td>
<td> ${MAP.START_POINT}</td>
<td> ${MAP.STOPOVER}</td>
<td> ${MAP.END_POINT}</td>
<td>${MAP.PRICE}</td>
<td>${SEAT}</td>

</tr>
</table>
<input type="hidden" value="${MAP.FLYING_NUMBER}" name="FLYING_NUMBER">
<input type="hidden" value="${SEAT}" name="SEAT">

<input type="submit" value="다음">
</form>

</body>
</html>