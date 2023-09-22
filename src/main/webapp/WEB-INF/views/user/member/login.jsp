<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 로그인</title>
</head>
<link rel="stylesheet" href="/amor/resources/css/user/login.css">
<body>
<%@include file="../header.jsp" %>
<div class="body-inner">
<form name="loginForm" action="loginSubmit.do" method="post">
	<div class="loginDiv">
		<label>로그인</label>
		<input type="text"  name="id" placeholder="아이디를 입력해주세요." class="text"> 
		<input type="password" name="pwd" placeholder="비밀번호를 입력해주세요." class="text"> 
		<div class="idCheck"><input type="checkbox" name="saveid" value="on" ${empty cookie.saveid?'':'checked'}> 아이디 기억하기</div>
		<input type="submit" value="로그인" class="submit">
		<a href="#"><input type="button" value="회원가입" class="join"></a>
		<div class="find"><a href="userIdFind.do"><label>아이디 찾기</label></a><a href="userPwdFind.do"><label>비밀번호 찾기</label></a></div>
	</div>
</form>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>