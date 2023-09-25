<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.commonBack{
	background: #333;
	width: 100%;
	height: 900px;
	position: absolute;
}
.commonDiv{
	width: 1100px;
	height: 616px;
	flex-shrink: 0;
	margin-top: 210px;
}
.commonTop{
	display: flex;
	width: 1100px;
	height: 50px;
	justify-content: center;
	align-items: flex-start;
	flex-shrink: 0;
	background: #1A2C82;
}
.commonTop label{
	display: flex;
	width: 366.6px;
	height: 50px;
	justify-content: center;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
	color: #FFF;
	font-family: Inter;
	font-size: 18px;
	font-style: normal;
	font-weight: 400;
	line-height: normal;
	letter-spacing: 0.9px;
}
.commonMid{
	background: #FFF;
	width: 1100px;
	height: 566px;
	flex-shrink: 0;
}
.content1{
	width: 366px;
	height: 566px; 
	float:left;
}
.content2{
	width: 366px;
	height: 566px;
	float:left;
	border-right: 1px solid #1A2C82;
	border-left: 1px solid #1A2C82;
}
.content3{
	width: 365px;
	height: 566px;
	display:inline-block;
}
</style>
<body>
<%@include file="../header.jsp" %>
<div class="commonBack">
<div class="inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label>상품정보</label><label>결제수단</label><label>결제하기</label>
		</div>
		<div class="commonMid">
			<div class="content1"></div>
			<div class="content2"></div>
			<div class="content3"></div>
		</div>
	</div>
</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>