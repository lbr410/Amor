<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 판매상품 목록</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/productList.css">
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>
	// 품절 여부 표시
	function soldOutYN(idx) {
		let soldout = document.getElementsByName('product_soldout'+idx)[0].value;
		
		let param = 'idx='+idx+'&soldout='+soldout;
		sendRequest('soldOutChk.do', param, null, 'POST');
	}
	
	// 상세내용 팝업
	function productPopUp(idx) {
		window.open('productPopUp.do?idx='+idx, 'popup', 'width=500, height=500');
	}
	
	// 스토어 제목 조회
	function prodSearchList() {
		let search = document.getElementById('prodSearch').value;
		
		let param = 'search='+search;
		sendRequest('prodSearchList.do', param, null, 'GET');
		location.href='prodSearchList.do?search='+search;
	}
</script>
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
			<th class="tableTitle">제목</th>
			<th class="tableContent">상세보기</th>
			<th class="tableCategory">분류</th>
			<th class="tablePrice">판매가</th>
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
			<td class="tableNum">${dto.product_idx}</td>
			<td class="tableImg">
				<img src="/amor/resources/img/leaf.png" class="prodImg" alt="상품 이미지">
				${dto.product_img}
			</td>
			<td class="tableTitle">${dto.product_title}</td>
			<td class="tableContent">
				<a href="javascript: productPopUp(${dto.product_idx})">상세내용 보기</a>
			</td>
			<td class="tableCategory">${dto.product_category}</td>
			<td class="tablePrice">${dto.product_price}</td>
			<td class="tableSoldout">
				<select name="product_soldout${dto.product_idx}" id="yn" class="soldOutSel" onchange="soldOutYN(${dto.product_idx})">
					<option value="y" <c:if test="${dto.product_soldout eq 'y'}">selected</c:if>>Y</option>
					<option value="n" <c:if test="${dto.product_soldout eq 'n'}">selected</c:if>>N</option>
				</select>
			</td>
			<td class="tableBtn">
				<input type="button" class="smallBtn" value="수정">
				<input type="button" class="smallBtn" value="삭제">
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<c:if test="${!empty lists}">
		<tr>
			<td colspan="8"><div class="paging">${pageStr}</div></td>
		</tr>
	</c:if>
	</tfoot>
	</table>
</div>
</div>
</div>
</body>
</html>