<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 배너 등록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/bannerList.css">
<script type="text/javascript">
function banneralready(){
	window.alert('해당 배너는 이미 등록되어 있습니다.');
}

function bannerAdd(idx){
	let banner_idx = idx;
	location.href='bannerAdd.do?banner_idx='+banner_idx;
}
function bannerUpdate(idx){
	let banner_idx = idx;
	location.href='bannerUpdate.do?banner_idx='+banner_idx;
}
function bannerDelete(idx){
	let banner_idx = idx;
	location.href='bannerDelete.do?banner_idx='+banner_idx;
}


</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">배너 등록</label>
</div>
<div class="contentMain">
<div class="bannerViewDiv">
<div class="bannerMid">
	<div class="mainbanner" 
	<c:if test="${btnOk eq 'bothOpen' || btnOk eq 'sideLock'}"> onclick="bannerAdd(1)"</c:if>
	<c:if test="${!(btnOk eq 'bothOpen' || btnOk eq 'sideLock')}"> onclick="banneralready()"</c:if>
	>메인 배너</div>
	<div class="arrow-next"></div>
	<div class="sidebanner" 
	<c:if test="${btnOk eq 'bothOpen' || btnOk eq 'mainLock'}"> onclick="bannerAdd(2)"</c:if>
	<c:if test="${!(btnOk eq 'bothOpen' || btnOk eq 'mainLock')}"> onclick="banneralready()"</c:if>
	>사이드 배너</div>
</div>
</div>
<div class="tableDiv">
	<table class="commonTables">
	<thead>
	<tr>
		<th class="bannerAreaTd">배너 위치</th>
		<th class="bannerNameTd">배너 이름</th>
		<th class="urlPathTd">URL 경로</th>
		<th class="sourceTd">소스</th>
		<th class="updateDelDeco"></th>
		<th class="updateDelDeco"></th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${empty lists}">
		<tr>
			<td colspan="6">없음</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists}">
		<tr>
			<td class="bannerAreaTd">
			<c:if test="${dto.banner_idx == 1}">메인 배너</c:if>
			<c:if test="${dto.banner_idx == 2}">사이드 배너</c:if>
			</td>
			<td class="bannerNameTd">${dto.banner_name }</td>
			<td class="urlPathTd">${dto.banner_url }</td>
			<td class="sourceTd">${dto.banner_source }</td>
			<td class="updateDelDeco"><input class="btn_banner" type="button" value="수정" onclick="bannerUpdate(${dto.banner_idx})"></td>
			<td class="updateDelDeco"><input class="btn_banner" type="button" value="삭제" onclick="bannerDelete(${dto.banner_idx})"></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>