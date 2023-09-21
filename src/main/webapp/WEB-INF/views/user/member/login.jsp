<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 로그인</title>
</head>
<link rel="stylesheet" href="css/login.css">
<body>
<%@include file="../header.jsp" %>
<div class="inner">
<form name="loginForm" action="member/login.do">
<div class="loginDiv">
	<label>로그인</label>
	<input type="text" placeholder="아이디를 입력해주세요." class="text"> 
	<input type="text" placeholder="비밀번호를 입력해주세요." class="text"> 
	<div class="idCheck"><input type="checkbox" value="on"> 아이디 기억하기</div>
	<input type="submit" value="로그인" class="submit">
	<a href="#"><input type="button" value="회원가입" class="join"></a>
	<div class="find"><a href="#"><label>아이디 찾기</label></a><a href="#"><label>비밀번호 찾기</label></a></div>
</div>
</form>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>