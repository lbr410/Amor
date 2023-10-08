<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 베너 관리</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/bannerList.css">
<script type="text/javascript">
function bannerAdd(idx){
	let banner_idx = idx;
	location.href='bannerAdd.do?banner_idx='+banner_idx;
}

</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">베너 목록</label>
</div>
<div class="contentMain">
<div class="bannerViewDiv">
<div class="bannerMid">
	<div class="mainbanner" onclick="bannerAdd(1)">메인 베너</div>
	<div class="arrow-next"></div>
	<div class="sidebanner" onclick="bannerAdd(2)">사이드 베너</div>
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
	<c:if test="${empty lists}">
	<c:forEach var="dto" items="lists">
		<tr>
			<td>
			<c:if test="${banner_idx == 1}">메인 베너</c:if>
			<c:if test="${banner_idx == 2}">사이드 베너</c:if>
			</td>
			<td>이름</td>
			<td>URI</td>
			<td>영상ID</td>
			<td><input class="btn_banner" type="button" value="수정" onclick="bannerUpdate(${banner_idx})"></td>
			<td><input class="btn_banner" type="button" value="삭제" onclick="bannerDelete(${banner_idx})"></td>
		</tr>
	</c:forEach>
	</c:if>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>