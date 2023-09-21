<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 회원가입</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/terms.css">
<script>
	window.onload = function() {
		document.getElementById("t1").innerHTML = 
			'<object type="text/html" data="/amor/resources/etc/terms1.html" style="width:1000px; margin: 10px auto auto 40px; border: 1px solid #ededed; padding: 10px; height: 200px;"></object>';
		document.getElementById("t2").innerHTML = 
			'<object type="text/html" data="/amor/resources/etc/terms2.html" style="width:1000px; margin: 10px auto auto 40px; border: 1px solid #ededed; padding: 10px; height: 200px;"></object>';
		document.getElementById("t3").innerHTML = 
			'<object type="text/html" data="/amor/resources/etc/terms3.html" style="width:1000px; margin: 10px auto auto 40px; border: 1px solid #ededed; padding: 10px; height: 200px;"></object>';
	}
	
	// 전체 동의시 모든 체크박스에 체크
	function allChk(chk) {
		let allChkBox = document.getElementsByName("chk");
		
		allChkBox.forEach((checkbox) => {
		    checkbox.checked = chk.checked;
		});
	}
	
	// 체크박스 중 하나라도 체크 해제되면 전체 동의에 대한 체크박스 해제
	function allChkClear() {
		 // 전체 체크박스
		 let chks = document.querySelectorAll('input[name="chk"]');
		 
		 // 선택된 체크박스
		 let checked = document.querySelectorAll('input[name="chk"]:checked');
		 
		 // select all 체크박스
		 let allChk = document.querySelector('input[id="allChk"]');
		 
		 if(chks.length === checked.length)  {
			 allChk.checked = true;
		 }else {
			 allChk.checked = false;
		 }
	}
	
	// 필수 항목에 체크되어있으면 회원가입 페이지로 이동
	function check() {
		let chk1 = document.getElementsByName("chk")[0].checked;
		let chk2 = document.getElementsByName("chk")[1].checked;
		let chk3 = document.getElementsByName("chk")[2].checked;
		
		if(chk1 === true && chk2 === true) {
			location.href = "signUp.do";
		} else {
			window.alert('필수 항목에 체크바랍니다.');
		}
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
	<section class="termsSec">
		<div class="title">
			<img src="img.jpg" alt="leaf" class="titleImg">
			이용약관
		</div>
		<div id="t1">
			<!-- import -->
		</div>
		<div class="chk">(필수)위 이용약관에 대한 내용에 동의합니다. &nbsp;<input type="checkbox" name="chk" onclick="allChkClear()"></div>
		
		<div class="title">
			<img src="img.jpg" alt="leaf" class="titleImg">
			정보보호
		</div>
		<div id="t2">
			<!-- import -->
		</div>
		<div class="chk">(필수)위 정보보호에 대한 내용에 동의합니다. &nbsp;<input type="checkbox" name="chk" onclick="allChkClear()"></div>
		
		<div class="title">
			<img src="img.jpg" alt="leaf" class="titleImg">
			개인정보 제공 및 마케팅 이용수집
		</div>
		<div id="t3">
			<!-- import -->
		</div>
		<div class="chk">(선택)개인정보 제공 및 마케팅 이용수집에 대한 내용에 동의합니다. &nbsp;<input type="checkbox" name="chk" onclick="allChkClear()"></div>
		
		<div class="allCheck">위 이용약관에 모두 동의합니다. &nbsp;<input type="checkbox" id="allChk" onclick="allChk(this)"></div>
		<div class="btnDiv">
			<input type="button" value="회원가입" class="nextBtn" onclick="check()">&nbsp;
			<input type="button" value="취소" class="cancelBtn">
		</div>
	</section>
</body>
	<%@include file="../footer.jsp" %>
</html>