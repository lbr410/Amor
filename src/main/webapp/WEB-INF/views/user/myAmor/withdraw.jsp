<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 회원탈퇴</title>
 <!-- 브라우저 스타일 초기화 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" href="/amor/resources/css/user/withdraw.css">
</head>
<script>

function show() {
	var check=document.getElementById("check");
	if (!check.checked) {
        window.alert('유의 및 안내 사항을 확인해주세요.');    
    }else{
    	var confirm=window.confirm('탈퇴하시겠습니까?');
    	if(confirm){
    		window.location='withdrawSubmit.do';
    	}else{
    		window.location='/amor/index.do'
    	}
    }
}
</script>


<body>
<%@include file="../header.jsp" %>
   <!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="/amor/myAmor/ticketingHistory.do" title="마이페이지로 이동">마이페이지</a>
            <a href="/amor/myAmor/userInfoUpdateForm.do" title="회원 정보 수정페이지로 이동">회원정보 수정</a>
            <a href="#" title="회원탈퇴 페이지로 이동">회원탈퇴</a>
        </div>
    </div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">회원탈퇴</div>
</div>
<!-- 이 밑으로 작업 -->
<div class="body-inner">
<form name="withDraw">
<div class="deleteForm">
	<div class="deleteTextForm">
	<div class="deleteText">
		<div class="text1">회원 탈퇴 시 유의사항</div>
		<div class="text2">
		아모르 회원 탈퇴 시 일정기간 재가입이 불가능합니다. <br>
		회원 탈퇴를 하시면 해당 아이디는 즉시 탈퇴 처리되며, 해당 아이디에 대한 회원 정보 및 서비스 정보는 모두 삭제됩니다. <br>
		탈퇴한 아이디는 영구적으로 사용이 중지되며, 30일 이후에 가입이 가능합니다. <br>
		회원 정보 보존 안내 사항 탈퇴 후 30일간 재가입 방지 및 포인트 불법 이용 및 부정 행위를 방지하기 위해 회원님의 아이디를 포함한 회원 정보가 보존됩니다. <br>
		(회원가입 시 동의하신 개인정보 처리 방침에 명시한 파기절차와 방법에 따라 30일 이후 회원 정보를 지체 없이 파기합니다) <br>
		전자상거래 이용내역이 있는 회원님은 전자상거래 등에서의 소비자보호에 관한 법률에 의거 교환/반품/환불 및 사후처리(A/S)등을 위해 회원 정보가 관리됩니다.<br>
		</div>
	</div>
	</div>
		<div class="deleteCheck">
		<div class="checkBox"><input type="checkbox" value="on" id="check"><label>유의 및 안내 사항을 모두 확인하였습니다.</label></div>
	</div>
	<div class="btn">
		<input type="button" value="탈퇴" class="submit" onclick="show()">
		<a href="/amor/index.do"><input type="button" value="취소" class="cancel"></a>
	</div>
</div>
</form>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>