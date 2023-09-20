<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">회원 조회</label>
<div class="contentsearch">
	<div class="search">
		<input type="text"  placeholder="아이디를 검색해주세요." class="box">
		<img src="img/Icon_Search.png" class="btn">
	</div>
</div>
</div>
<div class="contentMain">
<div class="table">
	<table>
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>연락처</th>
		<th>주소</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>가입일자</th>
		<th>탈퇴일자</th>
		<th>제한여부</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>1</td>
		<td>hong</td>
		<td>홍길동</td>
		<td>010-1234-1234</td>
		<td>[01234] 서울시 마포구 마포동 떙땡아파트 101호 </td>
		<td>1995.09.12</td>
		<td>남자</td>
		<td>2023.09.30</td>
		<td>2023.09.30</td>
		<td>n</td>
	</tr>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>