<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 회원가입</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/signUp.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../resources/js/httpRequest.js"></script>
<script>
	// Daum 주소 API
	function getAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = '';
                var extraAddr = '';

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }              
                }
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById('address').value = addr+extraAddr;
                
                document.getElementById('detailAddress').focus();
            }
        }).open();
    }
	
	// 숫자만 입력되게
	function checkNumber(event) {
		if(event.key === '.' || event.key === '-' || event.key >= 0 && event.key <= 9) {
			return true;
		}
		return false;
	}
	
	// 아이디 유효성 체크
	function idChk(id) {
		let reg = /^[A-Za-z0-9]{6,12}$/;
		let state = document.getElementById('idChkMsg');
		if(id.value != '') {
			if(!reg.test(id.value)) {
				state.innerHTML = '6~12자, 영문과 숫자를 조합하여 입력바랍니다.';
				state.style.color = 'red';
			} else {
				state.innerHTML = '사용 가능한 아이디입니다.';
				state.style.color = 'green';
			}
		} else {
			state.innerHTML = '';
		}
	}
	
	// 비밀번호 유효성 체크
	function pwdChk(pwd) {
		let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
		let state = document.getElementById('pwdChkMsg');
		if(pwd.value != '') {
			if(!reg.test(pwd.value)) {
				state.innerHTML = '8~12자, 영문, 숫자, 특수문자를 조합하여 입력바랍니다.';
				state.style.color = 'red';
			} else {
				state.innerHTML = '사용할 수 있는 비밀번호입니다.';
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
				state.innerHTML = '비밀번호가 일치합니다.';
				state.style.color = 'green';
			} else {
				state.innerHTML = '비밀번호가 일치하지 않습니다.';
				state.style.color = 'red';
			}
		} else {
			state.innerHTML = '';
		}
	}
	
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
				state.innerHTML = '인증번호가 일치합니다.';
				state.style.color = 'green';
			} else {
				state.innerHTML = '인증번호가 일치하지 않습니다.';
				state.style.color = 'red';
			}
		} else {
			state.innerHTML = '';
		}
	}
	
	// 회원가입 완료 전 모든 유효성 검사
	function validation() {
		// 아이디 유효한지
		
		// 비밀번호 유효한지
		
		// 이메일 인증했는지
	}
</script>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="border-bar">
		<div class="border-title">
		회원가입
		</div>
	</div>
	<form class="signUpForm" onsubmit="return validation()">
	<div class="signUpDiv">
		<div class="signUpMenu">아이디</div>
		<div><input type="text" name="member_id" placeholder="6자 이상 입력" class="textBoxDeco1" maxlength="12" 
			oninput="idChk(this)" required></div>
		<div class="chks" id="idChkMsg"><!-- state --></div>
		
		<div class="signUpMenu">비밀번호</div>
		<div><input type="password" id="pwd1" name="member_pwd" placeholder="8~12자리 영문, 숫자조합 입력" class="textBoxDeco1" maxlength="12"
			oninput="pwdChk(this)" required></div>
		<div class="chks" id="pwdChkMsg"><!-- state --></div>
		
		<div class="signUpMenu">비밀번호 재확인</div>
		<div><input type="password" id="pwd2" class="textBoxDeco1" maxlength="12" 
			oninput="samePwdChk(this)" required></div>
		<div class="chks" id="pwdSameChkMsg"><!-- state --></div>
		
		<div class="signUpMenu">이름</div>
		<div><input type="text" name="member_name" class="textBoxDeco2" maxlength="20" required></div>
		
		<div class="signUpMenu">생년월일</div>
		<div class="birthDiv">
			<input type="text" name="member_birth_year" placeholder="년(4자)" class="year" maxlength="4"
				onkeypress="return checkNumber(event)" required>
			<select name="member_birth_month" class="month">
				<option value="1" selected>01</option>
				<option value="2">02</option>
				<option value="3">03</option>
				<option value="4">04</option>
				<option value="5">05</option>
				<option value="6">06</option>
				<option value="7">07</option>
				<option value="8">08</option>
				<option value="9">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<input type="text" name="member_birth_day" placeholder="일" class="day" maxlength="2" 
				onkeypress="return checkNumber(event)" required>
		</div>
		
		<div class="signUpMenu">성별</div>
		<div class="genderBox">
			<input type="radio" name="member_gender" value="m" checked>남자
			<input type="radio" name="member_gender" value="f">여자
		</div>
		
		<div class="signUpMenu">휴대전화</div>
		<div class="telDiv">
			<select name="member_tel1" class="tel1">
				<option value="010" selected>010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="018">018</option>
				<option value="019">019</option>
			</select>
			<input type="text" name="member_tel2" class="tel2" maxlength="8" 
				onkeypress="return checkNumber(event)" required>
		</div>
		
		<div class="signUpMenu">이메일 인증</div>
		<div>
			<input type="text" name="member_email" id="email" class="emailTextBoxDeco" maxlength="50">
			<input type="button" value="인증번호 받기" class="smallBtnDeco" onclick="sendMail()" required>
		</div>
		
		<div class="signUpMenu">인증번호</div>
		<div>
			<input type="text" name="authNum" id="auth" class="textBoxDeco1" maxlength="6"
				onkeypress="return checkNumber(event)" oninput="authChk(this)" required>
		</div>
		<div class="chks" id="authChkMsg"><!-- state --></div>
		
		<div class="signUpMenu">주소</div>
		<div>
			<input type="text" name="member_zip" id="postcode" class="zipTextBoxDeco" readonly>
			<input type="button" onclick="getAddr()" value="우편번호 검색" class="smallBtnDeco" required>
		</div>
		<div><input type="text" name="member_addr1" id="address" class="textBoxDeco1" maxlength="60" required></div>
		<div><input type="text" name="member_addr2" id="detailAddress" class="textBoxDeco1" maxlength="60" required></div>
		<div><input type="submit" class="signUpBtn" value="가입하기"></div>
	</div>
	</form>
</body>
	<%@include file="../footer.jsp" %>
</html>