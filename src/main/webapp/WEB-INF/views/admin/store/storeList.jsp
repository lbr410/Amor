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
	sendRequest('storeListSubmit.do',param,function (){showResult(storeIdx, status)},'GET');	

}
function showResult(storeIdx, status) {
	if(XHR.readyState==4){
		if(XHR.status==200){
			 var submitBtn=document.getElementById('submitBtn'+storeIdx);
		     var cancelBtn=document.getElementById('cancelBtn'+storeIdx);
		     var statusText=document.getElementById('statusText'+storeIdx);
		     
		     if (status=='y') {
		         submitBtn.remove();
		         cancelBtn.remove();
		         statusText.innerHTML='<span style="color:blue">승인완료</span>';
		     } else if (status=='n') {
		         submitBtn.remove();
		         cancelBtn.remove();
		         statusText.innerHTML='<span style="color:red">취소완료</span>';
		     }	
		}
	}
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
			<c:if test="${!empty lists }"><div class="paging">${pageStr }</div></c:if></td>			
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists }">
		<tr>
			<td colspan="8" align="center">
			조회된 결제목록이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="dto" items="${lists }">
	<tr>
		<td>${dto.store_payment_idx }</td>
		<td>${dto.member_id }</td>
		<td class="title">${dto.product_title }</td>
		<td>${dto.store_payment_amount }</td>
		<td>${dto.c }</td>
		<c:if test="${dto.store_payment_payment=='c' }">
			<td>카카오페이</td>
		</c:if>
		<td>${dto.store_payment_paymentdate }</td>
		<c:choose>
			<c:when test="${dto.store_payment_status=='미승인' }">
				<td class="btnTd" id="statusText${dto.store_payment_idx}">
				<button class="submit" id="submitBtn${dto.store_payment_idx}"  onclick="clickBtn(${dto.store_payment_idx},'y')">승인</button> 
				<button class="cancel" id="cancelBtn${dto.store_payment_idx}" onclick="clickBtn(${dto.store_payment_idx},'n')">취소</button></td>
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