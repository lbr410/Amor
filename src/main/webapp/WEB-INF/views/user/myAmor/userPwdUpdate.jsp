<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 비밀번호 수정</title>
 <!-- 브라우저 스타일 초기화 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" href="/amor/resources/css/user/userPwdUpdate.css">
</head>
<script src="/amor/resources/js/httpRequest.js"></script>
<script>
window.onload=function() {
    pwd1Tag.addEventListener("input", check);
    pwd2Tag.addEventListener("input", check);
}
function check() {
	var pwd1Tag=document.getElementById("pwd1Tag");
	var pwd2Tag=document.getElementById("pwd2Tag");
	var checkTag=document.getElementById("check");
    var pwd1Value=pwd1Tag.value;
    var pwd2Value=pwd2Tag.value;

    if (pwd1Value!=pwd2Value && pwd2Value!='') {
        checkTag.innerHTML='<p style="color:red; font-size:13px; font-weight:normal;">비밀번호가 일치하지 않습니다.</p>';
    } else {
        checkTag.innerHTML='';
    }
}

function submit() {
    var pwd1Tag=document.getElementById("pwd1Tag");
    var pwd2Tag=document.getElementById("pwd2Tag");
    var pwd1Value=pwd1Tag.value;
    var pwd2Value=pwd2Tag.value;
    var checkTag=document.getElementById("check");
    if(pwd1Value=='' || pwd2Value==''){
    	checkTag.innerHTML='<p style="color:red; font-size:13px; font-weight:normal;">비밀번호를 입력해주세요.</p>';
    }else{
    	var param='pwd='+pwd1Value;
    	sendRequest('userPwdUpdateSubmit.do',param,showResult,'POST');	
    }
}

function showResult() { 
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data=XHR.responseText; 
		}
	}
}
</script>
<body>
<%@include file="../header.jsp" %>
<!-- GRAY BAR -->
<div class="gray-bar">
  <div class="navigate">
    <div class="navigate-msg">홈 > 마이페이지 > 비밀번호 수정</div>
  </div>
</div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">비밀번호 수정</div>
</div>
<!-- 이 밑으로 작업 -->
<div class="body-inner">
	<div class="form">
		<label>비밀번호</label>
		<input type="password" class="text" id="pwd1Tag"> 
		<label>비밀번호 확인</label>
		<input type="password" class="text2" id="pwd2Tag"> 
		<label class="checkMsg" id="check"></label>
		<div class="btn">
		<input type="button" value="취소" class="cancel">
		<input type="button" value="수정" class="submit" onclick="submit()">
		</div>
	</div>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>