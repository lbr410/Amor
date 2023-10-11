<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 비밀번호 찾기</title>
<link rel="stylesheet" href="/amor/resources/css/user/userIdFind.css">
<script>
let pwdOk = '사용할 수 있는 비밀번호입니다.';
let samePwdOk = '비밀번호가 일치합니다.';
// 비밀번호 유효성 체크
function pwdChk(pwd) {
	let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
	let state = document.getElementById('pwdChkMsg');
	if(pwd.value != '') {
		if(!reg.test(pwd.value)) {
			state.innerHTML = '8~12자, 영문, 숫자, 특수문자를 조합하여 입력바랍니다.';
			state.style.color = 'red';
		} else {
			state.innerHTML = pwdOk;
			state.style.color = 'green';
		}
	} else {
		state.innerHTML = '';
	}
	
	let pwd2 = document.getElementById('pwd2').value;
	let state2 = document.getElementById('pwdSameChkMsg');

	if(pwd2 != '') {
		if(pwd.value != pwd2) {
			state2.innerHTML = '비밀번호가 일치하지 않습니다.';
			state2.style.color = 'red';		
		} else {
			state2.innerHTML = '비밀번호가 일치합니다.';
			state2.style.color = 'green';
		}
	} else {
		state2.innerHTML = '';
	}
}

// 비밀번호와 재확인이 일치한지 확인
function samePwdChk(pwd2) {
	let pwd1 = document.getElementById('pwd1').value;
	let state = document.getElementById('pwdSameChkMsg');
	if(pwd2.value != '') {
		if(pwd1 == pwd2.value) {
			state.innerHTML = samePwdOk;
			state.style.color = 'green';		
		} else {
			state.innerHTML = '비밀번호가 일치하지 않습니다.';
			state.style.color = 'red';
		}
	} else {
		state.innerHTML = '';
	}
}

// 폼 전송 시 유효성 체크 함수 호출
function validation() {
	let pwdChkMsg = document.getElementById('pwdChkMsg').innerHTML;
	let pwdSameChkMsg = document.getElementById('pwdSameChkMsg').innerHTML;
	if(pwdChkMsg != pwdOk){
		window.alert('비밀번호를 확인해주세요.')
		document.getElementById('pwd1').focus()
		return false;		
	}else if(pwdSameChkMsg != samePwdOk){
		window.alert('비밀번호가 일치하지 않습니다.');
		document.getElementById('pwd2').focus();
		return false;		
	}
	return true;
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
                        <li>
                            <a href="userIdFindForm.do" title="아이디찾기">
                                아이디 찾기
                            </a>
                        </li>
                        <li class="on">
                            <a href="userPwdFindForm.do" title="비밀번호 찾기">
                                비밀번호 찾기
                            </a>
                        </li>
                    </ul>
                </div>
                <form name="userPwdFindUpdate" action="userPwdFindUpdateSubmit.do" method="post" class="table-wrap" onsubmit="return validation()">
                <table class="table">
                    <tbody>
                        <tr>
                            <th>비밀번호 재설정</th>
                            <td colspan="2">
                                <input type="password" id="pwd1" name="member_pwd" placeholder="8~12자리 영문, 숫자조합 입력" class="textBoxDeco1" maxlength="12"
								oninput="pwdChk(this)" required >
								<div class="chks" id="pwdChkMsg"><!-- state --></div>
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호 재확인</th>
                            <td>
                                <input type="password" id="pwd2" class="textBoxDeco1" maxlength="12" placeholder="다시 입력해주세요."
								oninput="samePwdChk(this)" required>
                            	<div class="chks" id="pwdSameChkMsg"><!-- state --></div>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
                    <div class="btn-bottom">
                        <button type="submit" id="btn-Search" class="blue-btn">
                            확인
                    </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>