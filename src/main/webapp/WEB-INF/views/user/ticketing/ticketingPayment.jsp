<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.body-inner{
	width: 100%;
	height:1000px;
	margin: 0 auto;
	position: relative;
	background: #333;
}
.commonBack{
	background: #333;
	width: 100%;
	height: 900px;
	position: absolute;
}
.commonDiv{
	width: 1100px;
	height: 616px;
	flex-shrink: 0;
	padding-top: 210px;
	margin: 0 auto;
	marign-bottom: 30px;
}
.commonTop{
	display: flex;
	width: 1100px;
	height: 50px;
	justify-content: center;
	align-items: flex-start;
	flex-shrink: 0;
	background: #1A2C82;
}
.commonTop label{
	display: flex;
	width: 366.6px;
	height: 50px;
	justify-content: center;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
	color: #FFF;
	font-family: Inter;
	font-size: 18px;
	font-style: normal;
	font-weight: 400;
	line-height: normal;
	letter-spacing: 0.9px;
}
.commonMid{
	background: #FFF;
	width: 1100px;
	height: 620px;
	flex-shrink: 0;
}
.content1{
	width: 366px;
	height: 600px; 
	float:left;
	text-indent: 90px;
}
.content2{
	width: 366px;
	height: 600px;
	float:left;
	border-right: 1px solid #1A2C82;
	border-left: 1px solid #1A2C82;
}
.content3{
	width: 365px;
	height: 600px;
	display:inline-block;
	text-align: center;
}

.ticketingInfo {
	border: none;
	height: 25px;
	font-size: 15px;
}

.ticketingInfo:focus {
	outline: none;
}

.ticketingInfo2 {
	border: none;
	height: 25px;
	width: 10px;
	font-size: 15px;
}

.ticketingInfo2:focus {
	outline: none;
}

.ticketingInfo3 {
	border: none;
	height: 25px;
	font-size: 18px;
	font-weight: bold;
	padding-bottom: 10px;
}

.ticketingInfo3:focus {
	outline: none;
}

.ticketingInfo4 {
	border: none;
	height: 25px;
	width: 280px;
	font-size: 15px;
}

.ticketingInfo4:focus {
	outline: none;
}

.ticketingInfo5 {
	border: none;
	height: 25px;
	width: 70px;
	font-size: 15px;
}

.ticketingInfo5:focus {
	outline: none;
}

.ticketingPoster {
	margin: 30px auto;
	width: 200px;
	object-fit: contain;
}

.ticketingBox {
	margin-top: 30px;
	display: inline-flex;
	padding: 15px 16px 15px 23px;
	justify-content: flex-end;
	align-items: flex-start;
	gap: 172px;
	border-top: 1px solid #D9D9D9;
	border-right: 1px solid #D9D9D9;
	border-left: 1px solid #D9D9D9;
}

.ticketingBox2 {
	display: inline-flex;
	padding: 15px 16px 15px 23px;
	justify-content: flex-end;
	align-items: flex-start;
	gap: px;
	border-top: 1px solid #D9D9D9;
	border-right: 1px solid #D9D9D9;
	border-left: 1px solid #D9D9D9;
}
.ticketingTable{
	margin: 30px auto;
	width : 300px;
	font-weight: bold;
}

.ticketingTable2 {
	text-align: left;
	border-top: 1px solid #D9D9D9;
	border-left: 1px solid #D9D9D9;
	line-height: 60px;
	text-indent: 15px;
}

.ticketingTable3 {
	text-align: right;
	border-top: 1px solid #D9D9D9;
	border-right: 1px solid #D9D9D9;
	line-height: 60px;
	padding-right: 15px; 
}

.ticketingTable5 { 
   border:none;
   padding: 2px 21px 6px 21px;
   width: 300px;
   height: 60px;
   border-radius: 3px;
   background: #1A2C82;
   color: #C7E3FF;
   cursor: pointer;
}

</style>
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