<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	/**BORDER BAR*/
	.border-bar {
		margin-top: 300px;
		padding-top: 140px;
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
</head>
<body>
	<%@include file="../header.jsp" %>
	<!-- BORDER BAR-->
	<div class="border-bar">
		<div class="border-title">
		회원가입
		</div>
	</div>
</body>
	<%@include file="../footer.jsp" %>
</html>