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
			<th class="tableTitle">글쓴이</th>
			<th class="tableContent">제목</th>
			<th class="tableStatus">상태</th>
			<th class="tablePrice">등록일</th>
			<th class="tableSoldout">제한여부</th>
			<th class="tableBtn"></th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="8">
			<c:if test="${!empty lists }"><div class="paging">${pageStr}</div></c:if></td>
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists}">
		<tr>
			<td colspan="8" align="center">1:1문의가 없습니다</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists}">
    <tr>
        <td class="tableNum"><span>${dto.inquiry_idx}</span></td>
        <c:url var="contentUrl" value="inquiryContent.do">
        	<c:param name="idx">${dto.inquiry_idx }</c:param>
        </c:url>
        <td class="tableImg">
            <c:choose>
                <c:when test="${dto.inquiry_type eq 0}">문의</c:when>
                <c:when test="${dto.inquiry_type eq 1}">불만</c:when>
                <c:when test="${dto.inquiry_type eq 2}">칭찬</c:when>
                <c:when test="${dto.inquiry_type eq 3}">제안</c:when>
                <c:when test="${dto.inquiry_type eq 4}">분실물</c:when>
            </c:choose>
        </td>
        <td class="tableTitle">${dto.member_id}</td>
        <td class="tableContent">
        <a href="${contentUrl}">${dto.inquiry_subject}</a></td>
        <td>
        	<c:if test="${dto.inquiry_astatus =='y'}">답변완료</c:if>
        	<c:if test="${dto.inquiry_astatus =='n'}">답변대기</c:if>
        </td>
        <td>${dto.inquiry_writedate}</td>
        <td class="nyTd">
			<select name="member_block" class="selectBox" id="blockId" onchange="block(${dto.member_idx})">
				<option value="n" <c:if test="${dto.member_block=='n'}">selected</c:if>>N</option>
				<option value="y" <c:if test="${dto.member_block=='y'}">selected</c:if>>Y</option>
			</select>			
		</td>
        <td class="tableBtn">
            <input type="button" class="smallBtn" value="삭제" onclick="inquiryDel(${joinDTO.idto.inquiry_idx})">
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