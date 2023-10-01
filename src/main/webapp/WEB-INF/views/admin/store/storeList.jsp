<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 스토어 결제 목록</title>
<link rel="stylesheet" href="/amor/resources/css/admin/storeList.css">
</head>
<script src="/amor/resources/js/httpRequest.js"></script>
<script>
function clickBtn(storeIdx, status) {
    var param='status='+status+'&idx='+storeIdx;	
	sendRequest('storeListSubmit.do',param,null,'GET');	
	window.location.reload();	
}
</script>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">스토어 결제 목록</label>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>상품명</th>
		<th>수량</th>
		<th>결제금액</th>
		<th>결제수단</th>       
		<th>결제일자</th>
		<th></th>
	</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="8" align="center">	
			<div class="paging">${pageStr }</div></td>			
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists }">
		<tr>
			<td colspan="8" align="center">
			조회된 결제 목록이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists }">
	<tr>
		<td>${dto.store_payment_idx }</td>
		<td>${dto.member_id }</td>
		<td class="title">${dto.product_title }</td>
		<td>${dto.store_payment_amount }</td>
		<td>${dto.c }</td>
		<td>${dto.store_payment_payment }</td>
		<td>${dto.store_payment_paymentdate }</td>
		<c:choose>
			<c:when test="${dto.store_payment_status=='미승인' }">
				<td class="btnTd">
				<button class="submit" id="submitBtn" onclick="clickBtn(${dto.store_payment_idx},'y')">승인</button> 
				<button class="cancel" id="cancelBtn" onclick="clickBtn(${dto.store_payment_idx},'n')">취소</button></td>
			</c:when>
			<c:when test="${dto.store_payment_status=='n' }">
				<td class="cancelText">취소완료</td>
			</c:when>
			<c:when test="${dto.store_payment_status=='y' }">
				<td class="okText">승인완료</td>
			</c:when>
		</c:choose>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>