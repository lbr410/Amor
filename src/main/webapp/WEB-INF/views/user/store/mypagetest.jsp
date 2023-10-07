<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 마이페이지 : 스토어 내역</title>
<link rel="stylesheet" href="/amor/resources/css/user/storePaymentList.css" />
</head>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
  padding-top: 200px;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;

}
.mypagetitle .title1{
	color: #000;
	font-size: 20px;
	font-weight: 500;
	cursor: pointer;
}  
.mypagetitle .title2{
	color:#979797;
	font-size: 20px;
	font-weight: 500;
	cursor: pointer;
} 
.mypageContent{
	padding-top: 150px;
	margin: 0 auto;
	width: 1000px;
	margin-bottom: 50px;
}
.testtable{
	width: 1000px;
	margin:0 auto;
}
.testtable tbody tr{
	height: 60px;
}
#btn2{
    background: #1A2C82;
    color: #FFF;
    border: 1px solid #1A2C82;
    cursor: pointer;
}
</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/myAmor/storeHistory.do"><label class="title1">상품 내역</label></a> <a href="/amor/myAmor/storeCancellList.do"><label class="title2">취소 내역</label></a></div>
</div></div>
<div class="mypageContent">
<!-- 여기 안에서 작업 -->
	<table class="testtable">	
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
	<c:forEach begin="1" end="10" step="1">
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
	</c:forEach>
	</tbody>
	</table>
<!-- -------- -->
</div>
</body>
<%@include file="../footer.jsp" %>
</html>