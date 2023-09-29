<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 공지사항 목록</title>
<link rel="stylesheet" href="/amor/resources/css/admin/noticeList.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">공지사항 목록</label>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>등록일자</th>
		<th>조회수</th>
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
			등록된 공지사항이 없습니다.</td>
		</tr>	
	</c:if>
	<c:forEach var="dto" items="${lists }">
		<tr>
			<td>${dto.notice_idx }</td>
			<c:url var="contentUrl" value="noticeContent.do">
				<c:param name="notice_idx">${dto.notice_idx }</c:param>			
			</c:url>
			<td><a href="${contentUrl }">${dto.notice_subject }</a></td>
			<td>${dto.notice_writedate }</td>
			<td>${dto.notice_readnum }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>