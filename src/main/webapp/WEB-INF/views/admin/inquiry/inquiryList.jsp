<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 1:1 문의 목록</title>
<style>
.answerWait {
	color: red;
}
.paging {
	margin-top: 30px;
	text-align: center;
	font-size: 16px;
}

.paging a:hover{
	color: #2E90FF;
	font-weight: normal;
}

.nowPage {
	color: #2E90FF !important;
	font-weight: bold;
}
.answerComplete {
	color: blue;
}
.cancelBtn { 
   border:none;
   width: 50px;
   height: 30px;
   border-radius: 3px;
   background: #EEEEEE;
   color: #1A2C82;
   cursor: pointer;
}

</style>
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>
function block(idx) {

	blockTag=document.getElementsByName('member_block'+idx)[0];
	block_value=blockTag.value;
	let param='inquiry_idx='+idx+'&value='+block_value;	
	sendRequest('inquiryBlock.do',param,null,'GET');	
	
}
</script>
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
       	<c:if test="${dto.inquiry_astatus eq 'y'}">
			<td><label class="answerComplete">답변완료</label></td>
		</c:if>
       	<c:if test="${dto.inquiry_astatus eq 'n'}">
       		<td><label class="answerWait">답변대기</label></td>
       	</c:if>
        <td>${dto.inquiry_writedate}</td>
        <td class="nyTd">
			<select name="member_block${dto.inquiry_idx}" class="selectBox" id="blockId" onchange="block(${dto.inquiry_idx})">
				<option value="n" <c:if test="${dto.member_block=='n'}">selected</c:if>>N</option>
				<option value="y" <c:if test="${dto.member_block=='y'}">selected</c:if>>Y</option>
			</select>			
		</td>
        <td class="tableBtn">
	   			<c:if test="${dto.inquiry_astatus eq 'y'}">
	   				<c:url var="deleteUrl" value="inquiryDelete.do">
						<c:param name="idx">${dto.inquiry_idx }</c:param>
					</c:url>
				<a href="${deleteUrl }"><button class="cancelBtn">삭제</button></a>
       			<c:url var="updateUrl" value="inquiryUpdateForm.do">
				<c:param name="idx">${dto.inquiry_idx }</c:param>
				</c:url>
				<a href="${updateUrl }"><button class="cancelBtn">수정</button></a>
   				<input type="hidden" name="inquiry_idx" value="${dto.inquiry_idx}">
			</c:if>
			<c:if test="${dto.inquiry_astatus eq 'n'}">
					<c:url var="deleteUrl" value="inquiryDelete.do">
						<c:param name="idx">${dto.inquiry_idx }</c:param>
					</c:url>
					<a href="${deleteUrl }"><button class="cancelBtn">삭제</button></a>
				<input type="hidden" name="inquiry_idx" value="${dto.inquiry_idx}">
			</c:if>
		<input type="hidden" name="inquiry_idx" value="${dto.inquiry_idx}">
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