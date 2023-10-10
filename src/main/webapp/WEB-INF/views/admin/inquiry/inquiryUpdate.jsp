<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 1:1 문의 수정</title>
<link rel="stylesheet" href="/amor/resources/css/admin/inquiryContent.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">1:1 문의 내용</label></div>
	<div class="memberInfo">
		<div class="titleDiv">
		<label class="info">아이디 </label>
		<span>  ${dto.member_id }</span>
		</div>
		<div class="titleDiv">
		<label class="info">전화번호</label>
		<span>${dto.member_tel1} ${dto.member_tel2 }</span>
		</div>
		<div class="titleDiv">
		<label class="info">이메일</label>
		<span>${dto.member_email }</span>
		</div>
	</div>
	<div class="inquirySub">
	<label class="infoSub">문의유형</label>
	<span>
	<c:choose>
	    <c:when test="${dto.inquiry_type eq 0}">문의</c:when>
	    <c:when test="${dto.inquiry_type eq 1}">불만</c:when>
	    <c:when test="${dto.inquiry_type eq 2}">칭찬</c:when>
	    <c:when test="${dto.inquiry_type eq 3}">제안</c:when>
	    <c:when test="${dto.inquiry_type eq 4}">분실물</c:when>
	</c:choose>
	</span>
	<div class="titleDiv">
	<label class="info">답변상태</label>
	<span class="infoSub">${dto.inquiry_astatus }</span>
	</div>
	</div>
	<div class="inquirySub">
	<label class="infoSub">제목</label>
	<span>${dto.inquiry_subject }</span>
	</div>
	<div class="inquiryCon">
	<label class="infoCon">내용</label>
	<span class="inquiryConText">${dto.inquiry_content }</span>
	</div>
	<div class="fileDiv">
	<label class="infoFile">첨부 파일</label>
	<span>
    <img src="/amor/resources/upload/inquiry/${Sdto.inquiry_filename}" class="img" alt="inquiry_filename_img">
	</span>
	</div>

	<div class="answerDiv">1:1 문의 답변</div>
	<label class="infoCon">답변내용</label>
	<div class="answerCon">${dto.inquiry_answer }</div>
	<div class="btnDiv">
		<input type="button" class="cancelBtn" value="목록으로" onclick="javascript: location.href='/amor/admin/inquiry/inquiryList.do'">
		<input type="button" class="cancelBtn" value="수정하기" onclick="javascript: location.href='/amor/admin/inquiry/inquiryUpdateForm.do?idx=${dto.inquiry_idx}'">
		</div>
		<input type="hidden" name="inquiry_idx" value="${dto.inquiry_idx}">

	<form name="inquiryAnswerForm" action="inquiryContent.do" method="post">
		<div class="AnswerDiv">
		<label class="info-content">내용</label>
			<textarea name="inquiry_answer" maxlength="1000" required="required" class="textBox2" id="text"></textarea>
		<div class="countDiv">(<span id="count">0</span> / 1000)</div>
		</div>
		<div class="btnDiv">
			<input type="button" value="취소" onclick="javascript: location.href='/amor/admin/inquiry/inquiryList.do'">
			<input type="submit" value="등록하기">
		</div>
		<input type="hidden" name="inquiry_idx" value="${dto.inquiry_idx}">
	</form>
</div>

<script>
let text = document.getElementById("text");
let count = document.getElementById("count");
let maxLength = 1000; // 최대 글자 수
text.addEventListener("input", function() {
    let current = text.value.length;
    let remain = maxLength - current;
    if (current <= maxLength) {
        count.innerHTML = current;
    }
});
</script>
</body>
</html>