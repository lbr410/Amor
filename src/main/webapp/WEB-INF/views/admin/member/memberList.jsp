<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 회원 목록</title>
<link rel="stylesheet" href="/amor/resources/css/admin/memberList.css">
</head>
<script>
function memberSearch() {
	var search=document.getElementById('memberSearch').value;
	var param='search='+search;
	location.href='memberSearch.do?search='+search;
}
</script>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">회원 조회</label>
<div class="contentsearch">
	<div class="search">
		<input type="text" placeholder="아이디를 검색해주세요." class="box" id="memberSearch">
		<a href="javascript:memberSearch()"><img src="/amor/resources/img/icon_search.png" class="btn"></a>
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
		<th>이름</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>연락처</th>
		<th>이메일</th>
		<th>주소</th>
		<th>제한여부</th>
		<th>가입일자</th>		
		<th>탈퇴여부</th>
		<th>탈퇴일자</th>
	</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="12"><div class="paging">${pageStr }</div></td>
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists }">
		<tr>
			<td colspan="12" align="center">조회된 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists }">
		<tr>
			<td>${dto.member_idx }</td>
			<td>${dto.member_id }</td>
			<td>${dto.member_name }</td>
			<td>${dto.member_birth_year }. ${dto.member_birth_month }.${dto.member_birth_day }</td>
			<td>${dto.member_gender }</td>
			<td>${dto.member_tel1 }${dto.member_tel2 }</td>
			<td>${dto.member_email }</td>
			<td>[${dto.member_zip }] ${dto.member_addr1 } ${dto.member_addr2 } </td>
			<td>${dto.member_block }</td>
			<td>${dto.member_joindate }</td>
			<td>${dto.member_quit }</td>
			<td>${dto.member_quitdate }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>