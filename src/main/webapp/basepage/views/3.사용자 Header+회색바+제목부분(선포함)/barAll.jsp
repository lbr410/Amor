<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- 브라우저 스타일 초기화 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
</head>
<style>
	a {
		text-decoration: none;
	}
	body {
		font-family: 'Nanum Gothic', sans-serif;
		font-size: 16px;
		font-weight: 400;
		line-height: 1.4;
		color: #333333;
	}
	img {
		display: block;
	}
	.body-inner {
		width: 1100px;
		margin: 0 auto;
		position: relative;
	}

	/**GRAY BAR*/
	.gray-bar {
		width: 100%;
		height: 34px;
		padding-top: 140px;
		position: relative;
		background: #F8F8F8;
		margin-bottom: 64px;
	}

	.navigate {
		width: 1100px;
		margin: 0 auto;
	}

	.navigate-msg {
		padding-top: 8px;
		font-size: 14px;
		margin-left: 0;
	}
		a {
		text-decoration: none;
	}
	body {
		font-family: 'Nanum Gothic', sans-serif;
		font-size: 16px;
		font-weight: 400;
		line-height: 1.4;
		color: #333333;
	}
	img {
		display: block;
	}
	.body-inner {
		width: 1100px;
		margin: 0 auto;
		position: relative;
	}

	/**BORDER BAR*/
	.border-bar {
		margin-top: 300px;
		width: 1100px;
		margin: 0 auto;
		display: block;
		position: relative;
		border-bottom: solid 1px #D9D9D9;
	}

	.border-title {
		margin-top: 78px;
		display: block;
		margin-bottom: 20px;
		font-size: 24px;
	}
</style>
<body>
<%@include file="../header.jsp" %>
<!-- GRAY BAR -->
<div class="gray-bar">
  <div class="navigate">
    <div class="navigate-msg">홈 > 마이페이지 > 회원정보 수정</div>
  </div>
</div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">회원가입</div>
</div>
<!-- 이 밑으로 작업 -->

</body>
</html>