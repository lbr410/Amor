<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 결제 내역 확인</title>
<link rel="stylesheet" href="/amor/resources/css/user/ticketingPayDetail.css">
</head>
<%@include file="../header.jsp" %>
<body>
<!-- BORDER BAR-->
<div class="border-bar">
	<div class="border-title">
		결제 내역 확인 
	</div>
</div>
<div class="border-sub"></div>
<div class="body-inner">
<div class="payForm">
	<table class="payTable">
	<tbody>
		<tr>
			<th>예매번호</th>
			<td>${partner_order_id }</td>
			<th>결제일자</th>
			<td>${approved_at }</td>
		</tr>
		<tr>
			<th>영화명</th>
			<td>${movie_name }</td>
			<th>상영일시</th>
			<td>
			<f:parseDate var="ticketing_date" value="${ticketing_screeningtime }" pattern="yyyy-MM-dd HH:mm"/>
			<f:formatDate var="ticketing_format_date" value="${ticketing_date }" pattern="yyyy년 MM월 dd일 HH시 mm분"/>
			${ticketing_format_date }
			</td>
		</tr>
		<tr>
			<th>상영관</th>
			<td>${theater_name }&nbsp;&nbsp;&nbsp;${ticketing_seat }</td>
			<th class="cancel">취소가능시간</th>
			<td class="cancel">
			<f:parseDate var="ticketing_date2" value="${ticketing_cancel }" pattern="yyyy-MM-dd HH:mm"/>
			<f:formatDate var="ticketing_format_date2" value="${ticketing_date2 }" pattern="yyyy년 MM월 dd일 HH시 mm분"/>
			${ticketing_format_date2 }
			</td>
		</tr>
		<tr>
			<th>인원</th>
			<td>${ticketing_personnel }</td>
			<th class="cancel">결제 금액</th>
			<td class="cancel"><f:formatNumber type="number" value="${amountTotal }" pattern="#,###"/>원</td>
		</tr>	
	</tbody>
	</table>
	<div class="btnDiv">
		<a href="/amor/index.do"><button class="submitBtn2">확인</button></a>
		<a href="/amor/myAmor/ticketingHistory.do"><button class="submitBtn3">예매 내역 보기</button></a>	
	</div>
</div>
</div>
</body>
	<%@include file="../footer.jsp" %>
</html>