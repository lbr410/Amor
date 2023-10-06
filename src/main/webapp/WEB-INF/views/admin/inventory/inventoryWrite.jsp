<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 재고상품 등록</title>
<link rel="stylesheet" href="#">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">재고상품 등록</label></div>
<div class="contentMain">
<form name="inventoryWrite" action="inventoryWrite.do" method="post">
	<div class="inventoryDiv">
		<div class="titleDiv">
			<label>카테고리</label>
			<select name="inventory_category">
				<option value="d" selected>스낵</option>
				<option value="s">음료</option>
				<option value="t">관람권</option>
				<option value="l">영화 전단지</option>
			</select>
		</div>
	</div>
	<div class="contentDiv">
		<label>품번</label>
	</div>
</form> 
</div>
</div>
</body>
</html>