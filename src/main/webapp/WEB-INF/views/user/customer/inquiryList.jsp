<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 1:1 문의</title>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/customer/inquiryList.do"><label class="title1">1:1 문의</label></a></div>
<div class="inquiryQBtn">
	<a href="/amor/customer/inquiryWrite.do"><input type="button" value="1:1문의 쓰기"></a>
</div>
<form class="inquiryForm" action="inquiryContent.do" method="post">
	<div></div>

</form>

</div>
</div>

<%@include file="../footer.jsp" %>
</body>

</html>