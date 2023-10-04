<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 1:1 문의</title>
<style>
.body-inner{
	margin-bottom: 78px;
}
.inquiryWriteForm{width: 1000px; margin: 0 auto;}
.titleDiv, .fileDiv, .typeDiv{
	width: 850px;
    height: 40px;
    font-size: 16px;
    margin: 0 auto;
    padding: 24px 24px 18px 24px;
    justify-content: center;
    border-bottom: 1px solid #DDDDDD;
}
.countDiv{
	width: 850px; height: 40px; font-size: 14px; padding: 24px 24px 18px 24px;
	padding-right: 24px;text-align: right;}
.contentDiv{
	width: 850px;
    font-size: 16px;
    margin: 0 auto;
    padding: 24px 24px 18px 24px;
    justify-content: center;
    border-bottom: 1px solid #333333;
}
.titleDiv .input{width: 400px, height: 40px;}
.info{ width: 200px; padding: 24px;margin-left: 48px;}
.info-content{ width: 200px; padding: 24px; margin-left: 48px;}
.content{ border-style: solid;
	border-color: #979797;
	border-width: 1px;
	padding: 3px 23px 3px 23px;
	flex-direction: row;
	gap: 10px;
	align-items: center;
	justify-content: flex-start;
	flex-shrink: 0;
	width: 600px;
	position: relative;
	overflow: hidden;}
.btnDiv{padding: 24px 0px 24px 0px;
	display: flex;
	flex-direction: row;
	gap: 690px;
	align-items: flex-start;
	justify-content: flex-start;
	flex-shrink: 0;
	width: 850px;
	margin: 0 auto;
	position: relative;}
.nextBtn { 
	border:none;
	padding: 2px 21px 6px 21px;
	width: 150px;
	height: 40px;
	border-radius: 3px;
	background: #1A2C82;
	color: #C7E3FF;
	cursor: pointer;
}
.cancleBtn { 
   border:none;
   padding: 2px 21px 6px 21px;
   width: 150px;
   height: 40px;
   border-radius: 3px;
   background: #EEEEEE;
   color: #1A2C82;
   cursor: pointer;
}
.typeDiv{
}
.inquiry-content{ width: }
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/customer/inquiryList.do"><label class="title1">1:1 문의</label></a></div>
<form class="inquiryWriteForm" action="inquiryWrite.do" method="post" enctype="multipart/form-data">
	<div class="typeDiv">
		<label class="info">분류</label>
		<input type="radio" name="inquiry_type" value="0" checked>문의
		<input type="radio" name="inquiry_type" value="1">불만
		<input type="radio" name="inquiry_type" value="2">칭찬
		<input type="radio" name="inquiry_type" value="3">제안
		<input type="radio" name="inquiry_type" value="4">분실물
	</div>
	<div class="titleDiv">
		<label class="info">제목</label>
		<input type="text" name="inquiry_subject" required="required" class="inquiry_subject">
	</div>
	<div class="contentDiv">
		<label class="info-content">내용</label>
		<textarea name="inquiry_content" maxlength="1000" required="required" class="content" id="text"></textarea>
		<div class="countDiv">(<span id="count">0</span> / 1000)</div>
	</div>
	<div class="fileDiv">
		<label class="info">첨부파일</label>
		<input type="file" id="selectFile" name="inquiry_filename" accept=".jpg, .gif, .bmp, .png, .jpeg, .jpg, .gif, .bmp, .png, .jpeg">
		<div><img src="/amor/resources/img/"></div>
	</div>
	<div class="btnDiv">
		<input type="button" value="취소" onclick="javascript: location.href='/amor/myAmor/memberInquiryList.do'" class="cancleBtn">
		<input type="submit" value="등록하기" class="nextBtn">
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