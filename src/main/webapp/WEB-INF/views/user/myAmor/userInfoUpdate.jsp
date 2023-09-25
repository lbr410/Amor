<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- 브라우저 스타일 초기화 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" type="text/css" href="/amor/resources/css/user/userInfoUpdate.css">
</head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../resources/js/httpRequest.js"></script>
<script>
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


window.onload=function () {
    var dbBirthMonth='${dto.member_birth_month}'; 
    var selectTag=document.getElementById('selectTag');  
    
    for(var i=0; i<selectTag.options.length; i++) {
        if(selectTag.options[i].value==dbBirthMonth) {
            selectTag.options[i].selected=true; 
          	break;
        }
    }
    var dbTel='${dto.member_tel1}'; 
    var tel1=document.getElementById('tel1Tag');  
	
    for(var j=0; j<tel1.options.length;j++){
    	if(tel1.options[j].value==dbTel){
    		tel1.options[j].selected=true;
    		break;
    	}
    } 
}

</script>
<body>
<%@include file="../header.jsp" %>
<!-- GRAY BAR -->
<div class="gray-bar">
  <div class="navigate">
    <div class="navigate-msg">홈 > 마이페이지 > 회원 수정</div>
  </div>
</div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">회원 수정</div>
</div>
<div class="body-inner">
<div class="subTap">
	<div class="subTap-menu1"><label>비밀번호 수정</label></div>
	<div class="subTap-menu2"><label>회원 탈퇴</label></div>
</div>
	<form class="signUpForm" onsubmit="return validation()">
	<div class="signUpDiv">
		<div class="signUpMenu">아이디</div>
		<div><input type="text" name="id" class="textBoxDeco1-1" readonly="readonly" value="${dto.member_id }" ></div>
		
		<div class="signUpMenu">이름</div>
		<div><input type="text" name="name" class="textBoxDeco2" readonly="readonly" value="${dto.member_name }"></div>
		
		<div class="signUpMenu">생년월일</div>
		<div class="birthDiv">
			<input type="text" name="member_birth_year" placeholder="년(4자)" class="year" maxlength="4"
				onkeypress="return checkNumber(event)" required value="${dto.member_birth_year }">
			<select name="member_birth_month" class="month" id="selectTag">
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<input type="text" name="member_birth_day" placeholder="일" class="day" maxlength="2" 
				onkeypress="return checkNumber(event)" required value="${dto.member_birth_day }">
		</div>
		
		<div class="signUpMenu">이메일</div>
		<div>
			<input type="text" name="email" class="emailTextBoxDeco" readonly="readonly" value="hong@naver.com" value="${dto.member_email }">
		</div>		
		
		<div class="signUpMenu">휴대전화</div>
		<div class="telDiv">
			<select name="member_tel1" class="tel1" id="tel1Tag">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="018">018</option>
				<option value="019">019</option>
			</select>
			<input type="text" name="member_tel2" class="tel2" maxlength="8" 
				onkeypress="return checkNumber(event)" required value="${dto.member_tel2 }">
		</div>
				
		<div class="signUpMenu">주소</div>
		<div>
			<input type="text" name="member_zip" id="postcode" class="zipTextBoxDeco" readonly value="${dto.member_zip }">
			<input type="button" onclick="getAddr()" value="우편번호 검색" class="smallBtnDeco" required>
		</div>
		<div><input type="text" name="member_addr1" id="address" class="textBoxDeco1" maxlength="60" required value="${dto.member_addr1 }"></div>
		<div><input type="text" name="member_addr2" id="detailAddress" class="textBoxDeco1" maxlength="60" required value="${dto.member_addr2 }"></div>
		<div><input type="submit" class="updateBtn" value="수정하기"></div>
	</div>
	</form>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>