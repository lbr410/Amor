<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 비밀번호 찾기</title>
<link rel="stylesheet" href="/amor/resources/css/user/userIdFind.css">
<script type="text/javascript" src="../resources/js/httpRequest.js"></script>

<script>
var authOk = '인증번호가 일치합니다.';

/** 이메일 인증 */
var dataList = null;

// 인증번호 메일로 보내기
function sendMail() {
	let email = document.getElementById('email').value; // 이메일

	if(email != '') {		
		let param = 'email='+email;
		sendRequest('sendMail.do', param, sendMailCallBack, 'GET');
	} else {
		window.alert('이메일을 입력해주세요.');
	}
}

function sendMailCallBack() {
	if(XHR.readyState == 4) {
		if(XHR.status == 200) {
			let result = XHR.responseText;
			let objData = JSON.parse(result);
			
			dataList = objData.data;
			window.alert(dataList[0].msg);
		}
	}
}

// 사용자가 입력한 값과 인증번호가 일치하는지 확인
function authChk(auth) {
	let state = document.getElementById('authChkMsg');
	
	if(auth.value != '') {
		if(auth.value == dataList[0].authNum) {
			state.innerHTML = authOk;
			state.style.color = 'green';
		} else {
			state.innerHTML = '인증번호가 일치하지 않습니다.';
			state.style.color = 'red';
		}
	} else {
		state.innerHTML = '';
	}
}

//숫자만 입력되게
function checkNumber(event) {
	if(event.key >= 0 && event.key <= 9) {
		return true;
	}
	return false;
}

function emailOk() {
	let state = document.getElementById('authChkMsg').innerHTML;
	if(authOk == state) {
		return true;
	} else {
		window.alert('인증번호를 확인바랍니다.');
		return false;
	}
}

</script>
</head>
<body>
    <div class="top">
        <div class="navigate"><a href="/amor/index.do"><img src="/amor/resources/img/white_b_logo.png"></a>
        </div>
    </div>
    <div class="body-inner">
        <div class="center">
            <div class="ci">
                <a href="/amor/index.do" title="메인 페이지로 이동">
                    <img src="/amor/resources/img/main_logo.png" alt="amor cinema">
                </a>
            </div>
            <div class="find-section">
                <span class="col">
                    아이디/비밀번호 찾기
                </span>
                <div class="tab-list">
                    <ul>
                    	<li><a href="/amor/member/userIdFindForm.do" title="아이디찾기">아이디 찾기</a></li>
                    	<li class="on"><a href="/amor/member/userPwdFindForm.do" title="비밀번호 찾기">비밀번호 찾기</a></li>
                    </ul>
                </div>
                <div class="result-section"> 
                    <div class="txt-find">비밀번호 찾기</div>
                    <div class="id-result">
                        <span class="member_id">회원님의 아이디는 ${member_id} 로 등록되어 있습니다.</span>
                    </div>
                    <form class="table-wrap">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th class="signUpMenu">이메일 주소</th>
                                <td>
                                    <input type="text" name="member_email" id="email" maxlength="50" placeholder="이메일">
                                </td>
                                <td>
                                    <input type="button" class="gray-btn" value="인증번호 받기"  onclick="sendMail()"> 
                                </td>
                            </tr>
                            <tr>
                                <th class="signUpMenu">인증번호</th>
                                <td colspan="2">
                                    <input type="text" name="authNum" id="answer-num" class="textBoxDeco1" maxlength="6"
									onkeypress="return checkNumber(event)" oninput="authChk(this)" placeholder="인증번호" required>
                                	<div class="chks" id="authChkMsg"><!-- state --></div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="navi-info">
                        본인확인 이메일 주소와 입력한 이메일 주소가 같아야<br>
                        인증번호를 받을 수 있습니다.
                    </div>
                    <div class="btn-bottom">
                    <a href="/amor/member/userPwdFindUpdate.do">
                     <input type="button" class="blue-btn" value="확인" onclick="return emailOk()">
                    </a>
                    </div>
                </form>    
                </div>
            </div>
        </div>
    </div>
</body>
</html>