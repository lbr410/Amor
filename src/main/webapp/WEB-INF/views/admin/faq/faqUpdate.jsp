<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : FAQ 수정</title>
<link rel="stylesheet" href="/amor/resources/css/admin/faqUpdate.css">
</head>
<script>
window.onload=function(){

}
</script>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">FAQ 수정</label>
</div>
<div class="contentMain">
<form name="faqUpdate" action="faqUpdate.do" method="post">
<input type="hidden" name="faq_idx" value="${dto.faq_idx }">
<div class="faqDiv">
	<div class="titleDiv">
		<label>제목</label>
		<input type="text" name="faq_subject" required="required" value="${dto.faq_subject }">
	</div>
	<div class="typeDiv">
		<label>구분</label>
		<select name="faq_type" id="selectTag">
			<option value="1">영화관</option>
			<option value="2">회원</option>
			<option value="3">온라인</option>
			<option value="4">스토어</option>
		</select>
	</div>
	<div class="contentDiv">
		<label>본문 내용</label>
		<textarea name="faq_content" maxlength="700" required="required" id="text">${dto.faq_content }</textarea>
		<div class="countDiv">(<span id="count">0</span> / 700)</div>
	</div>
	<div class="faqBtn">
		<a href="/amor/admin/faq/faqList.do"><input type="button" class="cancel" value="취소"></a>
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
        
    	let dbFaqType='${dto.faq_type}';
    	let selectTag=document.getElementById('selectTag');
    	for(let i=0;i<selectTag.options.length;i++){
    		if(selectTag.options[i].value==dbFaqType){
    			selectTag.options[i].selected=true;
    			break;
    		}
    	}
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