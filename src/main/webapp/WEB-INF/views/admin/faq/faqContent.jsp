<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : FAQ 본문 보기</title>
<link rel="stylesheet" href="/amor/resources/css/admin/faqContent.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">FAQ 본문 보기</label>
</div>
<div class="contentMain">
<div class="faqTable">
<table>
<thead>
	<tr>
		<th>번호</th>
		<td>${dto.faq_idx }</td>
		<th>구분</th>
		<td>${dto.faq_type2 }</td>
		<th>작성일</th>
		<td>${dto.faq_writedate }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5" align="left">${dto.faq_subject  }</td>
	</tr>
</thead>
<tfoot>
	<tr>
		<td colspan="6" align="right">
		<c:url var="deleteUrl" value="faqDelete.do">
			<c:param name="idx">${dto.faq_idx }</c:param>
		</c:url>
		<a href="${deleteUrl }"><button class="delete">삭제</button></a>
		<c:url var="updateUrl" value="faqUpdateForm.do">
			<c:param name="idx">${dto.faq_idx }</c:param>
		</c:url>
		<a href="${updateUrl }"><button class="update">수정</button></a>
	</tr>
</tfoot>
<tbody>
	<tr>
		<td colspan="6" align="left">
		${dto.faq_content }</td>
	</tr>
</tbody>
</table>

</div>
</div>
</div>
</body>
</html>