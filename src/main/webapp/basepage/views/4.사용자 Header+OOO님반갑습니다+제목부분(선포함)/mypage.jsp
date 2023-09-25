<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />

</head>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;
   margin-bottom: 64px;
   position: absolute;
}

</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="mypageHeader.jsp" %>
<div class="mypagetitle"><a href="#"><label class="title1">예매내역</label></a> <a href="#"><label class="title2">취소내역</label></a></div>
<!-- 이 밑으로 작업 -->

</div>
</div>
</body>
</html>