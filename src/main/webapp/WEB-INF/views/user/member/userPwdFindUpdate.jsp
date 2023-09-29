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
let authOk = '인증번호가 일치합니다.';

// 비밀번호 유효성 체크
function pwdChk(pwd) {
    let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
    let state = document.getElementById('pwdChkMsg');
    
    if (pwd.value != '') {
        if (!reg.test(pwd.value)) {
            state.innerHTML = '8~12자, 영문, 숫자, 특수문자를 조합하여 입력하세요.';
            state.style.color = 'red';
            return false;
        } else {
            state.innerHTML = pwdOk;
            state.style.color = 'green';
            return true;
        }
    } else {
        state.innerHTML = '';
        return false;
    }
}

// 비밀번호와 재확인이 일치한지 확인
function samePwdChk(pwd2) {
    let pwd1 = document.getElementById('pwd1').value;
    let state = document.getElementById('pwdSameChkMsg');
    
    if (pwd2.value != '') {
        if (pwd1 == pwd2.value) {
            state.innerHTML = samePwdOk;
            state.style.color = 'green';
            return true; // 비밀번호 일치하면 true 반환
        } else {
            state.innerHTML = '비밀번호가 일치하지 않습니다.';
            state.style.color = 'red';
            return false; // 비밀번호 불일치하면 false 반환
        }
    } else {
        state.innerHTML = '';
        return false;
    }
}

// 폼 전송 시 유효성 체크 함수 호출
function validateForm() {
    let pwd1 = document.getElementById('pwd1');
    let pwd2 = document.getElementById('pwd2');

    // 비밀번호 유효성 체크와 비밀번호 확인 일치 여부를 확인하고, 둘 다 true여야 제출이 가능하도록
    if (pwdChk(pwd1) && samePwdChk(pwd2)) {
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
            <span class="txt-info">Home으로 돌아가기</span>
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
                <form name="userPwdFindUpdate" action="userPwdFindUpdateSubmit.do" method="post" class="table-wrap">
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