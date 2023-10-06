<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 재고관리 목록</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/productList.css">
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>

</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">판매상품 목록</label>
<div class="contentsearch">
	<div class="search">
		<input type="text" id="prodSearch" placeholder="제목을 검색해주세요." class="box">
		<a href="javascript: prodSearchList()"><img src="img/Icon_Search.png" class="btn"></a>
	</div>
</div>
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
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="9" align="center">
			<c:if test="${!empty lists }"><div class="paging">${pageStr }</div></c:if>
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists}">
		<tr>
			<td colspan="9" align="center">등록된 재고상품이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists}">
		<tr>
			<td><span>${dto.inventory_idx}</span></td>
			<td>
				${dto.inventory_category }
			</td>
			<td>${dto.inventory_name}</td>
			<td>${dto.inventory_num }</td>
			<td>${dto.inventory_brand}</td>
			<td>${dto.inventory_unit }</td>
			<td>${dto.inventory_optimal }</td>
			<td>
				<c:if test="${!empty dto.inventory_current }">
				<input type="button" class="smallBtn" value="입력">
				</c:if> ${dto.inventory_current }</td>
			<td>${dto.inventory_deviation }</td>
			<td>
				<select name="product_soldout${dto.product_idx}" class="soldOutSel" onchange="soldOutYN(${dto.product_idx})">
					<option value="y" <c:if test="${dto.product_soldout eq 'y'}">selected</c:if>>Y</option>
					<option value="n" <c:if test="${dto.product_soldout eq 'n'}">selected</c:if>>N</option>
				</select>
			</td>
			<td class="tableBtn">
				<input type="button" class="smallBtn" value="수정" onclick="javascirpt: location.href='/amor/admin/product/productUpdate.do?idx=${dto.product_idx}'">
				<input type="button" class="smallBtn" value="삭제" onclick="productDel(${dto.product_idx})">
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