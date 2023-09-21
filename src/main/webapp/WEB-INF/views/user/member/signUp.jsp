<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 회원가입</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/signUp.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
                document.getElementById("address").value = addr+extraAddr;
                
                document.getElementById("detailAddress").focus();
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
</script>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="border-bar">
		<div class="border-title">
		회원가입
		</div>
	</div>
	<form class="signUpForm">
	<div class="signUpDiv">
		<div class="signUpMenu">아이디</div>
		<div><input type="text" name="member_id" placeholder="6자 이상 입력바랍니다." class="textBoxDeco1" maxlength="12"></div>
		<div class="chks"><!-- state --></div>
		
		<div class="signUpMenu">비밀번호</div>
		<div><input type="text" id="pwd1" name="member_pwd" class="textBoxDeco2" maxlength="12"
			onkeypress="pwdChk"></div>
		
		<div class="signUpMenu">비밀번호 재확인</div>
		<div><input type="text" id="pwd2" class="textBoxDeco1" maxlength="12"></div>
		<div class="chks"><!-- state --></div>
		
		<div class="signUpMenu">이름</div>
		<div><input type="text" name="member_name" class="textBoxDeco2" maxlength="20"></div>
		
		<div class="signUpMenu">생년월일</div>
		<div class="birthDiv">
			<input type="text" name="member_birth_year" placeholder="년(4자)" class="year" maxlength="4"
				onkeypress="return checkNumber(event)">
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
				onkeypress="return checkNumber(event)">
		</div>
		
		<div class="signUpMenu">성별</div>
		<div class="genderBox">
			<input type="radio" name="member_gender" value="m">남자
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
				onkeypress="return checkNumber(event)">
		</div>
		
		<div class="signUpMenu">이메일 인증</div>
		<div>
			<input type="text" name="member_email" class="emailTextBoxDeco" maxlength="50">
			<input type="button" value="인증번호 받기" class="smallBtnDeco">
		</div>
		
		<div class="signUpMenu">인증번호</div>
		<div>
			<input type="text" name="authNum" class="emailAuthTextBoxDeco" maxlength="6"
				onkeypress="return checkNumber(event)">
			<input type="button" value="인증하기" class="smallBtnDeco">
		</div>
		<div class="chks"><!-- state --></div>
		
		<div class="signUpMenu">주소</div>
		<div>
			<input type="text" name="member_zip" id="postcode" class="zipTextBoxDeco" readonly>
			<input type="button" onclick="getAddr()" value="우편번호 검색" class="smallBtnDeco">
		</div>
		<div><input type="text" name="member_addr1" id="address" class="textBoxDeco1" maxlength="60"></div>
		<div><input type="text" name="member_addr2" id="detailAddress" class="textBoxDeco1" maxlength="60"></div>
		<div><input type="submit" class="signUpBtn" value="가입하기"></div>
	</div>
	</form>
</body>
	<%@include file="../footer.jsp" %>
</html>