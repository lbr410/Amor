<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 광고 등록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/adsList.css">
<script type="text/javascript">

function adsalready(){
	window.alert('해당 광고가 이미 등록되어있습니다.');
}
function adsAdd(idx){
	let ads_idx = idx;
	location.href='adsAdd.do?ads_idx='+ads_idx;
}
function adsUpdate(idx){
	let ads_idx = idx;
	location.href='adsUpdate.do?ads_idx='+ads_idx;
}
function adsDelete(idx){
	let ads_idx = idx;
	location.href='adsDelete.do?ads_idx='+ads_idx;
}

</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">광고 등록</label>
</div>
<div class="contentMain">
	<div class="adsViewDiv">
	<div class="adsMid">
		<div class="firstads"
		<c:if test="${btnOk eq 'allOpen' || btnOk eq 'fOpen' || btnOk eq 'fsOpen' || btnOk eq 'ftOpen'}"> onclick="adsAdd(1)"</c:if>
		<c:if test="${!(btnOk eq 'allOpen' || btnOk eq 'fOpen' || btnOk eq 'fsOpen' || btnOk eq 'ftOpen')}"> onclick="adsalready()"</c:if>
		>첫번째 광고</div>
		<div class="arrow-next1"></div>
		<div class="secondads" 
		<c:if test="${btnOk eq 'allOpen' || btnOk eq 'sOpen' || btnOk eq 'stOpen' || btnOk eq 'fsOpen'}"> onclick="adsAdd(2)"</c:if>
		<c:if test="${!(btnOk eq 'allOpen' || btnOk eq 'sOpen' || btnOk eq 'stOpen' || btnOk eq 'fsOpen')}"> onclick="adsalready()"</c:if>
		>두번째 광고</div>
		<div class="arrow-next2"></div>
		<div class="thirdads" 
		<c:if test="${btnOk eq 'allOpen' || btnOk eq 'tOpen' || btnOk eq 'stOpen' || btnOk eq 'ftOpen'}"> onclick="adsAdd(3)"</c:if>
		<c:if test="${!(btnOk eq 'allOpen' || btnOk eq 'tOpen' || btnOk eq 'stOpen' || btnOk eq 'ftOpen')}"> onclick="adsalready()"</c:if>
		>세번째 광고</div>
	</div>
	</div>



<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>광고 위치</th>
		<th>광고 이름</th>
		<th>URL 경로</th>
		<th>광고 이미지</th>
		<th>수정</th>
		<th>삭제</th>
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
			<td>
			<c:if test="${dto.ads_idx == 1}">첫번째 광고</c:if>
			<c:if test="${dto.ads_idx == 2}">두번째 광고</c:if>
			<c:if test="${dto.ads_idx == 3}">세번째 광고</c:if>
			</td>
			<td>${dto.ads_name }</td>
			<td>${dto.ads_url }</td>
			<td>${dto.ads_filename }</td>
			<td><input class="btn_ads" type="button" value="수정" onclick="adsUpdate(${dto.ads_idx})"></td>
			<td><input class="btn_ads" type="button" value="삭제" onclick="adsDelete(${dto.ads_idx})"></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>