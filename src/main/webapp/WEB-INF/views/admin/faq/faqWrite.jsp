<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : FAQ 등록</title>
<link rel="stylesheet" href="/amor/resources/css/admin/faqWrite.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">FAQ 등록</label>
</div>
<div class="contentMain">
<form name="faqAdd" action="faqWrite.do" method="post">
<div class="faqDiv">
	<div class="titleDiv">
		<label>제목</label>
		<input type="text" name="faq_subject" required="required">
	</div>
	<div class="typeDiv">
		<label>구분</label>
		<select name="faq_type">
			<option value="1" selected>영화관</option>
			<option value="2">회원</option>
			<option value="3">온라인</option>
			<option value="4">스토어</option>
		</select>
	</div>
	<div class="contentDiv">
		<label>본문 내용</label>
		<textarea name="faq_content" maxlength="700" required="required" id="text"></textarea>
		<div class="countDiv">(<span id="count">0</span> / 700)</div>
	</div>
	<div class="faqBtn">
		<a href="/amor/admin/faq/faqList.do"><input type="button" class="cancel" value="취소"></a>
		<input type="submit" class="submit" value="등록">
	</div>
</div>
</form>
</div>
</div>
<script>
	let text= document.getElementById("text");
	let count= document.getElementById("count");
	let maxLength = 700;
    text.addEventListener("input", function() {
        let current=text.value.length;
        let remain=maxLength - current;
        if(current<=700){
        	count.innerHTML=current;
        }	
});
</script>
</body>
</html>