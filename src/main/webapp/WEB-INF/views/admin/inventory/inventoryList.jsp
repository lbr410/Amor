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
			<th class="tableNum">번호</th>
			<th class="tableImg">이미지</th>
			<th class="tableTitle">상품명</th>
			<th class="tableContent">상세보기</th>
			<th class="tableCategory">현재 재고량</th>
			<th class="tablePrice">제품 단가</th>
			<th class="tableSoldout">품절여부</th>
			<th class="tableBtn"></th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${empty lists}">
		<tr>
			<td colspan="8" align="center">등록된 상품이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists}">
		<tr>
			<td class="tableNum"><span id="idx${dto.inventory_idx}">${dto.product_idx}</span></td>
			<td class="tableImg">
				<img src="/amor/resources/upload/inventory/${dto.inventory_img}" class="invenImg" alt="상품 이미지">
			</td>
			<td class="tableTitle">${dto.inventory_title}</td>
			<td class="tableContent">
				<a href="javascript: productPopUp(${dto.inventory_idx})">상세내용 보기</a>
			</td>
			<td class="tablePrice">${dto.product_price}</td>
			<td class="tableSoldout">
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