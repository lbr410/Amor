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
    pwd2Tag.addEventListener("input", check2);
}
function check() {
	var pwd1Tag=document.getElementById("pwd1Tag");
	var pwd2Tag=document.getElementById("pwd2Tag");
	var checkTag=document.getElementById("check");
    var pwd1Value=pwd1Tag.value;
    var pwd2Value=pwd2Tag.value;
    
	let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
	if(pwd1Value != '') {
		if(!reg.test(pwd1Value)) {
			checkTag.innerHTML='<p style="color:red; font-size:13px; font-weight:normal;">8~12자, 영문, 숫자, 특수문자를 조합하여 입력바랍니다.</p>';
		} else {
			checkTag.innerHTML= '<p style="color:green; font-size:13px; font-weight:normal;">사용할 수 있는 비밀번호입니다.</p>';
		}
	} else {
		checkTag.innerHTML = '';
	}
}
function check2() {
	var pwd1Tag=document.getElementById("pwd1Tag");
	var pwd2Tag=document.getElementById("pwd2Tag");
	var checkTag=document.getElementById("check2");
    var pwd1Value=pwd1Tag.value;
    var pwd2Value=pwd2Tag.value;
    
    if (pwd1Value!=pwd2Value) {
        checkTag.innerHTML='<p style="color:red; font-size:13px; font-weight:normal;">비밀번호가 일치하지 않습니다.</p>';
    } else {
        checkTag.innerHTML='<p style="color:green; font-size:13px; font-weight:normal;">비밀번호가 일치합니다.</p>';
    }
}

function submit() {
    var pwd1Tag=document.getElementById("pwd1Tag");
    var pwd2Tag=document.getElementById("pwd2Tag");
    var pwd1Value=pwd1Tag.value;
    var pwd2Value=pwd2Tag.value;
    var checkTag=document.getElementById("check");
    var checkTag2=document.getElementById("check2");
    if(pwd1Value=='' || pwd2Value==''){
    	if(pwd1Value=='' ){
    		checkTag.innerHTML='<p style="color:red; font-size:13px; font-weight:normal;">비밀번호를 입력해주세요.</p>';
    	}else if(pwd2Value=='')
    		checkTag2.innerHTML='<p style="color:red; font-size:13px; font-weight:normal;">비밀번호를 입력해주세요.</p>';
    }else{
    	if(pwd1Value==pwd2Value){
    		var param='pwd='+pwd1Value;
        	sendRequest('userPwdUpdateSubmit.do',param,showResult,'POST');	
    	}
    	
    }
}

function showResult() { 
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data=XHR.responseText; 
			window.alert('비밀번호가 수정되었습니다.');
			location.href='/amor/index.do';
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
		<input type="password" class="text" id="pwd1Tag" placeholder="8~12자리 영문, 숫자조합 입력"
		maxlength="12"> 
		<label class="checkMsg" id="check"></label>
		
		<label>비밀번호 확인</label>
		<input type="password" class="text2" id="pwd2Tag"> 
		<label class="checkMsg2" id="check2"></label>

		<div class="btn">
		<a href="/amor/index.do"><input type="button" value="취소" class="cancel"></a>
		<input type="button" value="수정" class="submit" onclick="submit()">
		</div>
	</div>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>