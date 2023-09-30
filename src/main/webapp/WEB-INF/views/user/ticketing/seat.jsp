<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 좌석 선택</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/seat.css">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="body-inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label>인원/좌석 선택</label>
		</div>
		<div class="commonMid">
			<div class="personnelDiv">
				<div class="countDiv">
					성인&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn">&nbsp;
					<input type="text" value="0" class="countText">&nbsp;
					<input type="button" value="+" class="countBtn2">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					청소년&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn">&nbsp;
					<input type="text" value="0" class="countText">&nbsp;
					<input type="button" value="+" class="countBtn2">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					시니어&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn">&nbsp;
					<input type="text" value="0" class="countText">&nbsp;
					<input type="button" value="+" class="countBtn2">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					장애인&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn">&nbsp;
					<input type="text" value="0" class="countText">&nbsp;
					<input type="button" value="+" class="countBtn2">
					</span>
				</div>
			</div>
			<div class="seatDiv">
				<div class="seatSel"></div>
				<div class="menual"></div>
			</div>
			<div class="infoDiv">
				<div class="movieInfo">
					<img src="/amor/resources/img/introImg.jpg" alt="영화 이미지" class="posterImg">
					<div class="movieName">1947 보스톤</div>
					<div class="movieTime">23.09.30(토) | 20:25~22:25</div>
					<div class="theaterName">동백꽃관</div>
				</div>
				<div class="priceInfo">총 합계 15,000원</div>
				<a href="#">
					<div class="payGo">결제하기</div>
				</a>
			</div>
		</div>
	</div>
</div>

</body>
<%@include file="../footer.jsp" %>
</html>