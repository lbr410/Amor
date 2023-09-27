<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 스토어</title>
<link rel="stylesheet" href="/amor/resources/css/user/storeContent.css">
</head>
<script>

function minus() {
	var product_price=${dto.product_price}; //원래 상품금액
	var numTag=document.getElementById('num'); 
	var num=numTag.innerHTML; //갯수
	
	var totalTag=document.getElementById('total');
	
	var priceTag=document.getElementById('amass');
	var price=parseInt(priceTag.value);
	
	if(num>1){
		num--;
		numTag.innerHTML=num;
		price=price-product_price;
		priceTag.value=price;

		var regexp = /\B(?=(\d{3})+(?!\d))/g;
		price=price.toString().replace(regexp, ','); 
		totalTag.innerHTML=price;
	}
	
	
}
function plus() {
	var product_price=${dto.product_price}; //원래 상품금액(3000)

	var numTag=document.getElementById('num');
	var num=numTag.innerHTML; //갯수
	var totalTag=document.getElementById('total');
	
	var priceTag=document.getElementById('amass'); //누적
	var price=parseInt(priceTag.value);

	if(num<10){
		num++;
		numTag.innerHTML=num;
		price=price+product_price;
		priceTag.value=price;

		var regexp = /\B(?=(\d{3})+(?!\d))/g;
		price=price.toString().replace(regexp, ','); 
		totalTag.innerHTML=price;
	}
	
}
</script>

   <%@include file="../header.jsp" %>
<body>
    <!-- GRAY BAR -->
    <div class="gray-bar">
        <div class="navigate">
            <div class="navigate-msg">홈 > 스토어 > 상세페이지</div>
        </div>
     </div>
    <div class="body-inner">
        <div id="contents" class="contents-detail">
        <div class="pd-wrap">
            <div class="pd-img">
                <div class="main-img">
                    <img src="#" alt="">
                </div>
            </div>
            <div class="pd-detail">
                <table class="pd-table" summary="상품 상세 설명">
                    <colgroup>
                        <col style="width: 30%;">
                        <col style="width: auto;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="txt-product" scope="row" class="tit" colspan="2">
                                ${dto.product_title }
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><span class="txt-sale">가격</span></td>
                            <td><span class="txt-price">${dto.product_price2 }<em>원</em></span></td>
                        </tr>
                        <tr>
                            <td><span class="txt-date">유효기간</span></td>
                            <td>구매일로부터 6개월 이내</td>
                        </tr>
                    </tbody>
                </table>
                <div class="bx-num">
                    <button class="btn-mins" onclick="minus()">-</button>
                    <div class="txt-num" id="num">1</div>
                    <button class="btn-plus" onclick="plus()">+</button>
                </div>
                <div class="txt-price-wrap">
                    <p>총 상품금액</p>
                    <div class="txt-price-str">
                        <label id="total">${dto.product_price2 }</label>
                        <em>원</em>
                        <input type="hidden" id="amass" value="${dto.product_price }">
                    </div>
                </div>
                <div class="btn-wrap">
                    <button class="btn2">구매하기</button>
                </div>
            </div>
           <div class="how">사용 방법</div>
            <div class="howto">
            	- 스토어 상품은 회원만 구매하실 수 있습니다. <br>
				- 유효기간은 24개월로 사용일 기준입니다. <br>
				- 결제가 완료된 상품은 myAmor > 스토어 내역에서 확인 가능합니다. <br>
            </div>
        </div>        
    </div>
   </div>
</body>
<%@include file="../footer.jsp" %>
</html>