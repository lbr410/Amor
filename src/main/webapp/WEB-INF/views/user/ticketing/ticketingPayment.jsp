<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- 브라우저 스타일 초기화 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
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
	
	#container {
	display: flex;
	margin: 5% auto;
	width: 1100px;
	}
	
	#box1{
	flex:1;

	}
	
	#box2{
	flex:2;
	
	}
	
	#box3{
	flex:3
	
	}
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
<div id="container">

<div id="box1">
예매내역

</div>

<div id="box2">
<h3>결제수단</h3>

</div>

<div id="box3">
<h3>결제하기</h3>

</div>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>