<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 관람평 목록</title>
<link rel="stylesheet" href="/amor/resources/css/admin/reviewList.css">
</head>
<script src="/amor/resources/js/httpRequest.js"></script>
<script>
function contentPopup(reviewIdx) {	
	window.open('reviewPopup.do?idx='+reviewIdx,'contentPopup','width=600,height=550');
}
function block(idx) {
	blockTag=document.getElementsByName('member_block'+idx)[0];
	block_value=blockTag.value;	
	let param='idx='+idx+'&value='+block_value;	
	sendRequest('reviewListBlock.do',param,null,'GET');	
	
}
function deleteClick(idx) {
	let param='idx='+idx;
	let confirm=window.confirm('삭제하시겠습니까?');
	if(confirm){
		sendRequest('reviewListDelete.do',param,function (){
			var deleteId=document.getElementById('delete'+idx);
			deleteId.remove();
		},'GET');	
	}
}

function reviewSearch() {
	var search=document.getElementById('reviewSearch').value;
	var param='search='+search;
	location.href='reviewListSearch.do?search='+search;
}
</script>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">관람평 목록</label>
<div class="contentsearch">
	<div class="search">
		<input type="text"  placeholder="영화를 검색해주세요." class="box" id="reviewSearch">
		<a href="javascript:reviewSearch()"><img src="/amor/resources/img/icon_search.png" class="btn"></a>
	</div>
</div>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>영화</th>
		<th>관람평</th>
		<th>작성일</th>
		<th>제한</th>
		<th></th>
	</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="7" align="center">	
			<c:if test="${!empty lists }"><div class="paging">${pageStr }</div></c:if></td>
		</tr>
	</tfoot>
	<tbody>
		<c:if test="${empty lists }">
			<tr>
				<td colspan="7" align="center">
				등록된 관람평이 없습니다.
				</td>
			</tr>
		</c:if>	
		<c:forEach var="dto" items="${lists }">
		<tr id="delete${dto.movie_review_idx }">
			<td class="idTd" id="idxId">${dto.movie_review_idx }</td>
			<td>${dto.member_id }</td>
			<td class="nameTd">${dto.movie_name }</td>
			<td class="popupTd"><a href="javascript:contentPopup(${dto.movie_review_idx})">관람평 보기</a></td>
			<td class="dateTd">${dto.movie_review_writedate }</td>
			<td class="blockTd">
				<select name="member_block${dto.movie_review_idx}" class="selectBox" id="blockId" onchange="block(${dto.movie_review_idx})">
					<option value="n" <c:if test="${dto.member_block=='n'}">selected</c:if>>N</option>
					<option value="y" <c:if test="${dto.member_block=='y'}">selected</c:if>>Y</option>
				</select>
			</td>
			<td class="btnTd">
				<button class="deleteBtn" onclick="deleteClick(${dto.movie_review_idx})">삭제</button>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>