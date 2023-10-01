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
<form class="inquiryWriteForm" action="inquiryWrite.do" method="post">
	<div class="titleDiv">
		<label>제목</label>
		<input type="text" name="inquiry_subject" required="required">
	</div>
	<div class="contentDiv">
		<label>내용</label>
		<textarea name="inquiry_content" maxlength="1000" required="required" id="text"></textarea>
		<div class="countDiv">(<span id="count">0</span> / 1000)</div>
	</div>
	<div class="fileDiv">
		<label>첨부파일</label>
		<input type="file" id="selectFile" name="inquiry_filename" accept=".jpg, .gif, .bmp, .png, .jpeg, .jpg, .gif, .bmp, .png, .jpeg">
		<input type="button" value="파일 선택" onclick="document.getElementById('selectFile').click();">
	</div>
	<div><img src="/amor/resources/img/"></div>
	<div class="btnDiv">
		<input type="button" value="취소" onclick="javascript: location.href='/amor/user/myAmor.do'">
		<input type="submit" value="등록하기">
	</div>
</form>

</div>
</div>

<%@include file="../footer.jsp" %>
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