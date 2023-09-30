<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 비밀번호 확인</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" href="/amor/resources/css/user/userPwdCheck.css">
</head>

<body>
<%@include file="../header.jsp" %>
<!-- GRAY BAR -->
<div class="gray-bar">
  <div class="navigate">
    <div class="navigate-msg">홈 > 마이페이지 > ${msg }</div>
  </div>
</div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">비밀번호 확인</div>
</div>
<div class="body-inner">
<form name="pwdCheck" action="userPwdCheckSubmit.do" method="post">
<input type="hidden" name="typemsg" value="${msg }">
	<div class="form">
		<label>비밀번호</label>
		<input type="password" name="pwd" class="text" maxlength="12" required="required"> 
		<div class="btn">
		<a href="/index.do"><input type="button" value="취소" class="cancel"></a>
		<input type="submit" value="확인" class="submit">
		</div>
	</div>
</form>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>