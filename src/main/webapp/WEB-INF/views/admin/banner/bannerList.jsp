<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 베너 관리</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/bannerList.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">베너 목록</label>
</div>
<div class="contentMain">
<div class="bannerViewDiv">
<div class="bannerMid">
	<div class="mainbanner">메인 베너</div>
	<div class="arrow-next"></div>
	<div class="sidebanner">사이드 베너</div>
</div>
</div>
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>베너 위치</th>
		<th>베너 이름</th>
		<th>URL 경로</th>
		<th>영상 ID</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>메인</td>
		<td>이름</td>
		<td>URI</td>
		<td>영상ID</td>
		<td>수정 버튼 </td>
		<td>삭제버튼</td>
	</tr>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>