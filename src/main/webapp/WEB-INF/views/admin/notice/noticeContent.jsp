<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 공지사항 본문 보기</title>
<link rel="stylesheet" href="/amor/resources/css/admin/noticeContent.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">공지사항 본문 보기</label>
</div>
<div class="contentMain">
<div class="noticeTable">
<table>
<thead>
	<tr>
		<th>번호</th>
		<td>${dto.notice_idx }</td>
		<th>조회수</th>
		<td>${dto.notice_readnum }</td>
		<th>작성일</th>
		<td>${dto.notice_writedate }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5" align="left">${dto.notice_subject  }</td>
	</tr>
</thead>
<tfoot>
	<tr>
		<td colspan="6" align="right">
		<c:url var="deleteUrl" value="noticeDelete.do">
			<c:param name="idx">${dto.notice_idx }</c:param>
		</c:url>
		<a href="${deleteUrl }"><button class="delete">삭제</button></a>
		<c:url var="updateUrl" value="noticeUpdateForm.do">
			<c:param name="idx">${dto.notice_idx }</c:param>
		</c:url>
		<a href="${updateUrl }"><button class="update">수정</button></a>
	</tr>
</tfoot>
<tbody>
	<tr>
		<td colspan="6" align="left">
		${dto.notice_content }</td>
	</tr>
</tbody>
</table>

</div>
</div>
</div>
</body>
</html>