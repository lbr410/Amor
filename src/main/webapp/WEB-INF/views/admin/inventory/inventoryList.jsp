<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 재고관리 목록</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/inventoryList.css">
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>

</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">재고관리 목록</label>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
		<tr>
			<th>번호</th>
			<th>카테고리</th>
			<th>품명</th>
			<th>품번</th>
			<th>브랜드</th>
			<th>단위</th>
			<th>적정재고량</th>
			<th>현재고량</th>
			<th>차이</th>
			<th></th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="10" align="center">
			<c:if test="${!empty lists }"><div class="paging">${pageStr }</div></c:if>
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists}">
		<tr>
			<td colspan="10" align="center">등록된 재고상품이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists}">
		<tr>
			<td><span>${dto.inventory_idx}</span></td>
			<td>
				<c:choose>
	                <c:when test="${dto.inventory_category eq 'd'}">식료품</c:when>
	                <c:when test="${dto.inventory_category eq 's'}">원액</c:when>
	                <c:when test="${dto.inventory_category eq 't'}">이벤트 세트</c:when>
	                <c:otherwise>알 수 없음</c:otherwise> 
            	</c:choose>
			</td>
			<td>${dto.inventory_name}</td>
			<td>
				<c:choose>
					<c:when test="${dto.inventory_num eq '1'}">SNCO1TDS</c:when>
					<c:when test="${dto.inventory_num eq '2'}">SNCO1TDB</c:when>
					<c:when test="${dto.inventory_num eq '3'}">SNCO1TDQ</c:when>
					<c:when test="${dto.inventory_num eq '4'}">DNK02HRC</c:when>
					<c:when test="${dto.inventory_num eq '5'}">DNK02HRM</c:when>
					<c:when test="${dto.inventory_num eq '6'}">DNK02HRH</c:when>
					<c:when test="${dto.inventory_num eq '7'}">ETS03FGM</c:when>
					<c:when test="${dto.inventory_num eq '8'}">ETS03FGC</c:when>
					<c:when test="${dto.inventory_num eq '9'}">ETS03FGP</c:when>
				</c:choose>
			</td>
			<td>${dto.inventory_brand}</td>
			<td>
				<c:choose>
					<c:when test="${dto.inventory_unit eq '1'}">개(unit)</c:when>
					<c:when test="${dto.inventory_unit eq '2'}">kg</c:when>
					<c:when test="${dto.inventory_unit eq '3'}">L</c:when>
					<c:when test="${dto.inventory_unit eq '4'}">개봉포장(pack)</c:when>
					<c:when test="${dto.inventory_unit eq '5'}">Box</c:when>
					<c:when test="${dto.inventory_unit eq '6'}">세트(set)</c:when>
				</c:choose>
			</td>
			<td>${dto.inventory_optimal }</td>
			<td>
				<c:if test="${0!= dto.inventory_current }">
				${dto.inventory_current }
				</c:if>
				<c:if test="${0==dto.inventory_current }">
				<input type="button" class="smallBtn1" value="입력" onclick="javascript: location.href='/amor/admin/inventory/inventoryUpdateForm.do?idx=${dto.inventory_idx}'">
				</c:if>
			</td>
			<td>
			${dto.inventory_deviation }</td>
			<td>
				<c:choose>
    			<c:when test="${dto.inventory_current != 0}">
        			<input type="button" class="smallBtn2" value="수정" onclick="javascript: location.href='/amor/admin/inventory/inventoryUpdateForm.do?idx=${dto.inventory_idx}'">
    			</c:when>
    			<c:otherwise>
        			<!-- 원하는 다른 내용을 여기에 추가할 수 있습니다. -->
    			</c:otherwise>
				</c:choose>
				<input type="button" class="smallBtn2" value="삭제" onclick="javascript: location.href='/amor/admin/inventory/inventoryDelete.do?idx=${dto.inventory_idx}'">
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