<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 공지사항 수정</title>
<link rel="stylesheet" href="/amor/resources/css/admin/noticeUpdate.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">공지사항 수정</label>
</div>
<div class="contentMain">
<form name="noticeUpdate" action="noticeUpdate.do" method="post">
<input type="hidden" name="idx" value="${dto.notice_idx }">
<div class="noticeDiv">
	<div class="titleDiv">
		<label>제목</label>
		<input type="text" name="notice_subject" required="required" value="${dto.notice_subject }">
	</div>
	<div class="contentDiv">
		<label>본문 내용</label>
		<textarea name="notice_content" maxlength="700" required="required" id="text">${dto.notice_content }</textarea>
		<div class="countDiv">(<span id="count">0</span> / 700)</div>
	</div>
	<div class="noticeBtn">
		<a href="/amor/admin/notice/noticeList.do"><input type="button" class="cancel" value="취소"></a>
		<input type="submit" class="submit" value="수정">
	</div>
</div>
</form>
</div>
</div>
<script>
	let text= document.getElementById("text");
	let count= document.getElementById("count");
	let maxLength= 700;
    window.onload= function() {
        let current=text.value.length;
        count.innerHTML=current;
    }
    
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