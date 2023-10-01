<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : FAQ 목록</title>
<link rel="stylesheet" href="/amor/resources/css/admin/faqList.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">FAQ 목록</label>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>구분</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="4" align="center">	
			<div class="paging">${pageStr }</div></td>
		</tr>	
	</tfoot>
	<tbody>
	<c:if test="${empty lists }">
		<tr>
			<td colspan="4" align="center">	
			등록된 FAQ가 없습니다.</td>
		</tr>	
	</c:if>
	<c:forEach var="dto" items="${lists }">
		<tr>
			<td class="idxTd">${dto.faq_idx }</td>
			<td class="type">${dto.faq_type2}</td>
			<c:url var="contentUrl" value="faqContent.do">
				<c:param name="faq_idx">${dto.faq_idx }</c:param>			
			</c:url>
			<td class="subject"><a href="${contentUrl }">${dto.faq_subject }</a></td>
			<td>${dto.faq_writedate }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>