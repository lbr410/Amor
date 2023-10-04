<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.mypageDiv{
	width: 1000px;
	height: 192px;
	border-radius: 5px;
	background: #FFF;
	box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
	margin: 0 auto;
	margin-top: 210px;
}
.mypageDiv hr{
	width: 970px;
	border: 1px solid #EDEDED;
	margin-top: 0px;
	margin-bottom: 0px;
}
.usertitle{
	display: flex;
	width: 965px;
	height: 40px;
	padding: 23px 10px 0px 25px;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
	color: #000;
	font-family: Inter;
	font-size: 20px;
	font-style: normal;
	font-weight: 400;
	line-height: normal;
	display: inline-block;	
}
.usertitle label{
	color: #000;
	font-family: Inter;
	font-size: 20px;
	font-style: normal;
	font-weight: 600;
	line-height: normal;
}
.titleNameDiv{
	display: inline-block;
	width: 920px;
}
.usertitle .useredit{
	color: #000;
	font-size: 14px;
	font-style: normal;
	font-weight: 500;
	line-height: normal;
	
}
.pagemenu{
	display: flex;
	width: 1000px;
	height: 121px;
	justify-content: center;
	align-items: center;
	gap: 28px;
	flex-shrink: 0;
}
.pagemenu button:hover{
	display: flex;
	width: 189px;
	height: 59px;
	padding: 10px 23px;
	justify-content: center;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
	border-radius: 5px;
	border: 1px solid #1A2C82;
	background: #1A2C82;
	color: #FFF;
	font-family: Inter;
	font-size: 18px;
	font-style: normal;
	font-weight: 500;
	line-height: normal;
	letter-spacing: 1.9px;
}
.pagemenu button{
	display: flex;
	width: 189px;
	height: 59px;
	padding: 10px 23px;
	justify-content: center;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
	border-radius: 5px;
	border: 1px solid #1A2C82;
	background: #FFF;
	color: #1A2C82;
	font-family: Inter;
	font-size: 18px;
	font-style: normal;
	font-weight: 500;
	line-height: normal;
	letter-spacing: 1.9px;
}
.mypagetitle{
	display: flex;
	width: 960px;
	height: 50px;
	padding: 20px 20px 10px 20px;
	align-items: center;
	gap: 20px;
	flex-shrink: 0;
	color: #000;
	font-family: Inter;
	font-size: 20px;
	font-style: normal;
	font-weight: 500;
	line-height: normal;
	margin: 0 auto;
	border-bottom: 2px solid #EDEDED;
}
.mypagetitle .title1{
	color: #000;
	font-size: 20px;
	font-weight: 500;
}  
.mypagetitle .title2{
	color:#979797;
	font-size: 20px;
	font-weight: 500;
}  
/* 클릭한 버튼 및 레이블 스타일 */
.pagemenu button.active,
.mypagetitle label.active-label {
    background: #1A2C82;
    color: #FFF;
    border: 1px solid #1A2C82;
}
a:visited{
	color:#181818;
}
a:link{
	color:#181818;
	text-decoration: none;
}

</style>
<body>
	<div class="mypageDiv">
		<div class="usertitle"><div class="titleNameDiv"><label>${sessionScope.sname}</label>님 반갑습니다:)</div><label class="useredit"><a href="/amor/myAmor/userInfoUpdateForm.do">편집</a></label></div>
		<hr>
		<div class="pagemenu">
			<a href="/amor/myAmor/ticketingHistory.do" onclick="show(event)"><button id="btn1">예매내역</button></a>
			<a href="/amor/myAmor/storePayment.do" onclick="show(event)"><button id="btn2">스토어 내역</button></a>
			<a href="/amor/myAmor/reviewList.do" onclick="show(event)"><button id="btn3">관람평</button></a>
			<a href="/amor/myAmor/memberInquiryList.do" onclick="show(event)"><button id="btn4">1:1문의</button></a>
		</div>
	</div>
<script>
//버튼 클릭 시 실행되는 함수
function show(event) {
    // 이전에 활성화된 버튼이 있으면 스타일 초기화
    if (activeButton !== null) {
        activeButton.classList.remove("active");
    }

    // 현재 클릭한 버튼을 활성화로 표시
    var clickedButton = event.target;
    clickedButton.classList.add("active");

    // 클릭한 버튼을 현재 활성화된 버튼으로 설정
    activeButton = clickedButton;

    // 로컬 스토리지에 현재 활성화된 버튼의 ID를 저장
    localStorage.setItem("activeButton", clickedButton.id);
}

// 페이지 로드 시 초기 버튼 설정 (로컬 스토리지에서 정보를 읽어와 설정)
document.addEventListener("DOMContentLoaded", function() {
    var storedActiveButtonId = localStorage.getItem("activeButton");
    var initialButton = document.getElementById(storedActiveButtonId || "btn1");
    
    // 저장된 버튼 ID가 없으면 예매내역 버튼을 기본으로 선택
    initialButton.classList.add("active");
    activeButton = initialButton;
});

</script>
</body>
</html>