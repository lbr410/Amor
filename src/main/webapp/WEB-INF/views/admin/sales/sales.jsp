<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 매출관리</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/sales.css">
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function () {
	    const tabLinks = document.querySelectorAll(".tabnav a");
	    const tabContents = document.querySelectorAll(".tabcontent > div");
	
	    tabLinks.forEach(function (tabLink, index) {
	        tabLink.addEventListener("click", function (event) {
	            event.preventDefault();
	
	            // 모든 탭 콘텐츠를 숨김
	            tabContents.forEach(function (content) {
	                content.style.display = "none";
	            });
	
	            // 클릭한 탭에 해당하는 콘텐츠를 표시
	            const targetId = tabLink.getAttribute("href").substring(1);
	            const targetContent = document.getElementById(targetId);
	            targetContent.style.display = "block";
	
	            // 모든 탭 링크에서 'active' 클래스 제거
	            tabLinks.forEach(function (link) {
	                link.classList.remove("active");
	            });
	
	            // 클릭한 탭 링크에 'active' 클래스 추가
	            tabLink.classList.add("active");
	        });
	
	        // 초기에 첫 번째 탭을 활성화
	        if (index === 0) {
	            tabLink.click();
	        }
	    });
	});
</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">매출 관리</label>
</div>
<div class="contentMain">
<div class="tab">
	<ul class="tabnav">
		<li><a href="#tab1" class="active">전체</a></li>
		<li><a href="#tab2">일자별조회</a></li>
		<li><a href="#tab3">월별조회</a></li>
	</ul>
	<div class="tabcontent">
		
		<div id="tab1">
			<!-- 전체 -->
			<label>기간</label>
			<input type="date"> ~ <input type="date">
			
			<label>구분</label>
			<span class="category">
				<input type="radio" value="all">전체
				<input type="radio" value="movie">영화
				<input type="radio" value="store">스토어
				<input type="button" value="조회" class="chkBtn">
			</span>
		</div>
		
		<div id="tab2">
			<!-- 일자별조회 -->
			2
		</div>
		
		<div id="tab3">
			<!-- 월별조회 -->
			3
		</div>
	</div>
</div>
</div>
</div>
</body>
</html>