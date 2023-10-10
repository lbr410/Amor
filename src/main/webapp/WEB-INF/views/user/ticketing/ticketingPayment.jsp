<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/amor/resources/css/user/ticketingPayment.css">
</head>
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<body>
<%@include file="../header.jsp" %>
<div class="body-inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label>예매정보</label><label>결제수단</label><label>결제하기</label>
		</div>
		<div class="commonMid">
		<form id="ticketingPayment" action="ticketingPaymentKako.do" method="post">
			<div class="content1">
				<div><img class="ticketingPoster" src="/amor/resources/upload/movie/${movie_poster }.jpg"></div>
				<div><input class="ticketingInfo3" type="text" name="movie_name" value="${movie_name }" readonly></div>
				<div><input class="ticketingInfo" type="text" name="ticketing_screeningtime" value="${playing_movie_start }" readonly></div>
				<div><input class="ticketingInfo" type="text" name="theater_name" value="${theater_name }" readonly></div>
				<c:if test="${adultC != 0}">
				<div>성인 <input class="ticketingInfo2" type="text" value="${adultC }" readonly>명</div>
				</c:if>
				<c:if test="${teenagerC != 0}">
				<div>청소년 <input class="ticketingInfo2" type="text" value="${teenagerC }" readonly>명</div>
				</c:if>
				<c:if test="${seniorC != 0 }">
				<div>시니어 <input class="ticketingInfo2" type="text" value="${seniorC }" readonly>명</div>
				</c:if>
				<c:if test="${disabledC != 0 }">
				<div>장애인 <input class="ticketingInfo2" type="text" value="${disabledC }" readonly>명</div>
				</c:if>
				<div><input class="ticketingInfo4" name="ticketing_seat" type="text" value="${playing_movie_seat}" readonly></div>
				<input type="hidden" name="playing_movie_idx" value="${playing_movie_idx }">
				<input type="hidden" name="theater_idx" value="${theater_idx }">
			</div>
			
			<div class="content2">
				<div class="payType">
					<button id="payBtn" type="button">카카오페이</button>
				</div>
			</div>
			<div class="content3">
				<table class="ticketingTable">
					<tr>
						<td class="ticketingTable2">수량</td>
						<td class="ticketingTable3">${ticketing_personnel }</td>
					</tr>
					<tr>
						<td class="ticketingTable2">결제금액</td>
						<td class="ticketingTable3">${ticketing_price }</td>
					</tr>
					<tr>
						<td colspan="2" class="ticketingTable4">
						<input type="hidden" name="ticketing_price" value="${ticketing_price }">
						<input type="hidden" name="ticketing_personnel" value="${ticketing_personnel }">
						<input type="submit" class="ticketingTable5" value="결제하기">
						</td>
					</tr>
				</table>
			</div>
			</form>
		</div>
	</div>
</div>

</body>
<%@include file="../footer.jsp" %>
</html>