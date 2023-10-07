<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 재고상품 수정</title>
<link rel="stylesheet" href="/amor/resources/css/admin/inventoryWrite.css">
<script>
function checkNumber(event) {
	if(event.key >= 0 && event.key <= 9) {
		return true;
	}
	return false;
}
</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">현재 재고량 입력</label></div>
<div class="contentMain">
<form name="inventoryUpdate" action="inventoryUpdate.do" method="post">
<input type="hidden" name="inventory_idx" value="${dto.inventory_idx }">
	<div class="inventoryDiv">
		<div class="titleDiv">
			<label class="invenMenu">카테고리</label>
			<select name="inventory_category" class="cateMenu" id="selectTag1">
				<option value="d" ${dto.inventory_category eq 'd' ? 'selected' : ''}>식료품</option>
    			<option value="s" ${dto.inventory_category eq 's' ? 'selected' : ''}>원액</option>
    			<option value="t" ${dto.inventory_category eq 't' ? 'selected' : ''}>이벤트 세트</option>
			</select>
		</div>
	</div>
	<hr class="line">
	<div class="inventoryDive">
		<div class="titleDiv">
			<label class="invenMenu">재고 상품명</label>
			<input type="text" name="inventory_name" value="${dto.inventory_name }" class="textBox" required>
		</div>
		<div class="titleDiv">
			<label class="invenMenu">브랜드</label>
			<input type="text" name="inventory_brand" value="${dto.inventory_brand }" class="textBox" required>
		</div>
		<div class="titleDiv">
			<label class="invenMenu">품번</label>
			<select name="inventory_num" class="cateMenu" id="selectTag">
				<option value="1" selected>SNCO1TDS</option>
				<option value="2">SNC01TDB</option>
				<option value="3">SNC01TDV</option>
				<option value="4">DNK02HRC</option>
				<option value="5">DNK02HRM</option>
				<option value="6">DNK02HRH</option>
				<option value="7">ETS03FGM</option>
				<option value="8">ETS03FGC</option>
				<option value="9">ETS03FGP</option>
			</select>
		</div>
		<div class="titleDiv">
			<label class="invenMenu">단위</label>
			<select name="inventory_unit" class="cateMenu" id="selectTag">
				<option value="1" selected>개(unit)</option>
				<option value="2">kg</option>
				<option value="3">L</option>
				<option value="4">개봉포장(pack)</option>
				<option value="5">Box</option>
				<option value="6">세트(set)</option>
			</select>
		</div>
		<div class="titleDiv">
			<label class="invenMenu">적정 재고량</label>
			<input type="text" name="inventory_optimal" class="textBox" value="${dto.inventory_optimal }" maxlength="6" required>
		</div>
		<div class="titleDiv">
			<label class="invenMenu">현재 재고량</label>
			<input type="text" name="inventory_current" class="textBox" value="${dto.inventory_current }" maxlength="6" required>
		</div>
		<input type="hidden" name="inventory_deviation" value="${dto.inventory_deviation }">
		</div>
		<div class="btnDiv">
			<input type="button" value="취소" class="cancelBtn" onclick="javascript: location.href='/amor/admin/inventory/inventoryList.do'">&nbsp;
			<input type="submit" value="등록" class="addBtn">
		</div>
</form> 
</div>
</div>
</body>
</html>