<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 스토어 결제 목록</title>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">스토어 결제 목록</label>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>상품명</th>
		<th>수량</th>
		<th>결제금액</th>
		<th>결제수단</th>       
		<th>결제일자</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>1</td>
		<td>hong</td>
		<td>콜라M</td>
		<td>2</td>
		<td>3,000원</td>
		<td>신용카드</td>
		<td>2023.09.12</td>
		<td>승인 / 취소</td>
	</tr>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>