<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 1:1 문의 목록</title>
<style>

</style>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">1:1 문의 목록</label></div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
		<tr>
			<th class="tableNum">번호</th>
			<th class="tableImg">문의유형</th>
			<th class="tableTitle">제목</th>
			<th class="tableContent">글쓴이</th>
			<th class="tableStatus">상태</th>
			<th class="tablePrice">제한여부</th>
			<th class="tableSoldout">등록일</th>
			<th class="tableBtn"></th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${empty lists}">
		<tr>
			<td colspan="8" align="center">1:1문의가 없습니다</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists}">
		<tr>
			<td class="tableNum"><span id="idx${dto.inquiry_idx}">${dto.inquiry_idx}</span></td>
			<td class="tableImg">
				<img src="/amor/resources/upload/inquiry/${dto.inquiry_filename}" class="prodImg" alt="문의 이미지">
			</td>
			<td class="tableTitle">${dto.inquiry_subject}</td>
			<td class="tableContent">
				<a href="${dto.inquiry_content})"></a>
			</td>
			<td class="tableStatus">
				<c:if test="${dto.inquiry_astatus eq 'y'}">답변완료</c:if>
				<c:if test="${dto.inquiry_astatus eq 'n'}">답변대기</c:if>
			</td>
			<td class="tableBtn">
				<input type="button" class="smallBtn" value="수정" onclick="">
				<input type="button" class="smallBtn" value="삭제" onclick="inquiryDel(${dto.inquiry_idx})">
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8"><div class="paging">${pageStr}</div></td>
		</tr>
	</tfoot>
	</table>
</div>
</div>
</div>
</body>
</html>