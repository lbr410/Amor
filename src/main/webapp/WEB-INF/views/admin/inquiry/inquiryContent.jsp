<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 1:1 문의 내용</title>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">1:1 문의 내용</label>
</div>
	<div class="UpdateForm">
		<div class="menu">
			<span class="menuname">제목</span>
			<input type="text" name="inquiry_title" class="textBoxDeco1" maxlength="30" value="${dto.inquiry_title}" required>
		</div>
</div>
</div>
</body>
</html>