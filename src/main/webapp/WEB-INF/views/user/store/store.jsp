<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 스토어</title>
<link rel="stylesheet" href="/amor/resources/css/user/store.css">
</head>
<%@include file="../header.jsp" %>
<body>
<div class="back">
<div class="img"><img src="/amor/resources/img/store_banner.jpg" alt="banner"></div>
</div>
<div class="body-inner">
	<div class="border-bar">
		<div class="border-title">스토어</div>	
</div>
<div class="tapMenu">
	<div class="menu1"><label>관람권</label></div>
	<div class="menu2"><label>스낵</label></div>
	<div class="menu3"><label>음료</label></div>
</div>
<div class="title1">관람권</div>
<table class="table">
<tbody>
	<tr>
		<td class="prodContent">
			<span class="prodImg"></span>
			<span class="prodTitle"></span>
			<span class="prodPrice"></span>
		</td>
	</tr>
</tbody>
</table>
	
</div>
</body>
<%@include file="../footer.jsp" %>
</html>