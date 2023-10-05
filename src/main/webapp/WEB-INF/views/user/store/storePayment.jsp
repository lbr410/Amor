<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 스토어 결제</title>
<link rel="stylesheet" href="/amor/resources/css/user/storePayment.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- <script src="/amor/resources/js/kakaopay.js"></script> -->
<script>
function paySubmit() {
	window.alert(${dto.product_idx});
	window.alert(${dto.product_price}); //상품 고유 금액
}
</script>
<body>
<%@include file="../header.jsp" %>

<div class="body-inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label>상품정보</label><label>결제수단</label><label>결제하기</label>
		</div>
		<div class="commonMid">
			<div class="content1">
				<div class="prodDiv">
					<div class="prodImg">
						<img src="/amor/resources/upload/product/${dto.product_img}" class="img">
					</div>
					<div class="prodTitle">${dto.product_title }</div>
					<div class="prodNum">수량 : ${num }개</div>
				</div>
			</div>
			<div class="content2">
				<div class="payType">
					<button id="payBtn" value="c">카카오페이</button>
				</div>
			</div>
			<div class="content3">
				<div class="payDiv">
					<div class="payDiv1"><p class="d1">수량</p><p class="d2">${num }개</p></div>
					<div class="payDiv2"><p class="d1">결제금액</p><p class="d2">${dto.product_price2 }원</p></div>
					<div class="payDiv3"><button class="submitBtn" id="submitBtn" disabled> 결제하기</button></div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
var button = document.getElementById('payBtn');
var submitBtn= document.getElementById('submitBtn');
var clickState=false;
button.addEventListener('click', function() {
	if(clickState){
		button.classList.remove('clicked');
		submitBtn.disabled=true;
	}else{
		button.classList.add('clicked');
		submitBtn.disabled=false;
	}
	clickState = !clickState;
})
</script>
<script>
$(function(){
	var param='idx='+${dto.product_idx}+'&product_price='+${dto.product_price}+'&num='+${num};
	$('#submitBtn').click(function(){
		$.ajax({		
			url:'kakaopay.do?'+param,
			dataType:'json',
			success:function(data){
				window.alert(data.tid);
				var box = data.next_redirect_pc_url;
				//window.open(box,'payPopup','width=500,height=500');
				window.open(box);
			},
			error:function(error){
				alert(error);
			}
		});
	});
});
</script>
</body>

<%@include file="../footer.jsp" %>
</html>