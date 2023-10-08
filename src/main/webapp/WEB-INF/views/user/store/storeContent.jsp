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

function submit() {
	var numTag=document.getElementById('num');
	var num=numTag.innerHTML; //갯수
	
	var totalTag=document.getElementById('total');
	var total=totalTag.innerHTML;
	
	var priceTag=document.getElementById('amass'); //누적
	var price=parseInt(priceTag.value);

	location.href='storePaymentForm.do?num='+num+'&idx='+${dto.product_idx};

}
</script>

   <%@include file="../header.jsp" %>
<body>
    <!-- GRAY BAR -->
   <!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="/amor/store.do" title="스토어 페이지로 이동">스토어</a>            
            <a href="/amor/store/storeContentForm.do?product_idx=${dto.product_idx }" title="스토어 페이지로 이동">${dto.product_title }</a>
        </div>
    </div>
    <div class="body-inner">
        <div id="contents" class="contents-detail">
        <div class="pd-wrap">
            <div class="pd-img">
                <div class="main-img">
                <img src="/amor/resources/upload/product/${dto.product_img}" class="prodImg">
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
                            <th class="txt-product" scope="row" colspan="2">
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
                <c:if test="${dto.product_soldout=='y' }">
                    <button class="btn-mins">-</button>
                </c:if>
                <c:if test="${dto.product_soldout=='n' }">
                    <button class="btn-mins" onclick="minus()">-</button>
                </c:if>
                    <div class="txt-num" id="num">1</div>
                <c:if test="${dto.product_soldout=='y' }">
                    <button class="btn-plus">+</button>
                </c:if>
                <c:if test="${dto.product_soldout=='n' }">
                    <button class="btn-plus" onclick="plus()">+</button>
                </c:if>
                </div>
                <div class="txt-price-wrap">
                    <p>총 상품금액</p>
                    <div class="txt-price-str">
                        <label id="total">${dto.product_price2 }</label>
                        <em>원</em>
                        <input type="hidden" name="amass" id="amass" value="${dto.product_price }">
                        <input type="hidden" name="total" value="">                 
                    </div>
                </div>
                <div class="btn-wrap">
                <c:if test="${dto.product_soldout=='y' }">
                	 <button class="btn2">품절</button>  
               	</c:if>
               <c:if test="${dto.product_soldout=='n' }">
               		 <button class="btn2" onclick="submit()">구매하기</button>
               </c:if>	 	             
                </div>  
            </div>

           <div class="how"><p>사용 방법</p></div>
            <div class="howto">
            	${dto.product_content }
            </div>
        </div>       
    </div>
   </div>
</body>
<%@include file="../footer.jsp" %>
</html>