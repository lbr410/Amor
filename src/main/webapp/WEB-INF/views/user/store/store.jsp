<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 스토어</title>
<link rel="stylesheet" href="/amor/resources/css/user/store.css">
</head>
<%@include file="../header.jsp" %>
<body>
<div class="back">
<div class="imgbanner"><img src="/amor/resources/img/store_banner.jpg" alt="banner"></div>
</div>
<div class="body-inner">
	<div class="border-bar">
		<div class="border-title">스토어</div>	
</div>
<div class="tapMenu">
	<div class="menu1"><label><a href="#sc1">관람권</a></label></div>
	<div class="menu2"><label><a href="#sc2">스낵</a></label></div>
	<div class="menu3"><label><a href="#sc3">음료</a></label></div>
</div>
<div id="sc1">
<div class="title">관람권</div>
    <div class="prodDiv">
    <c:if test="${empty Tlists }">
    	<div class="msg">상품 준비 중입니다.</div>
    </c:if>
    <c:forEach var="Tdto" items="${Tlists }">
        <div class="product ${Tdto.product_price2=='품절'?'soldout':'' }">
        	<c:url var="detailUrl" value="store/storeContentForm.do">
				<c:param name="product_idx">${Tdto.product_idx }</c:param>
			</c:url>
        	<div class="prodImg"><a href="${detailUrl }"><img src="/amor/resources/upload/product/${Tdto.product_img}" class="img" alt="store_ticket_img"></a></div>
        	<div class="prodTitle">
        		<label><a href="${detailUrl }">${Tdto.product_title }</a></label>
        	</div>
        	<div class="prodPrice">
        	<c:if test="${Tdto.product_price2=='품절' }">
        	 <div class="soldout-cover"></div>
        		<label><span>${Tdto.product_price2 }</span></label>
        	</c:if>
        	<c:if test="${Tdto.product_price2!='품절' }">
        		<label><span>${Tdto.product_price2 }</span>원</label>
        	</c:if>
        	</div>
        </div>
     </c:forEach>
    </div>
</div>
<div id="sc2">
<div class="title">스낵</div>
    <div class="prodDiv">
     <c:if test="${empty Slists }">
    	<div class="msg">상품 준비 중입니다.</div>
    </c:if>
    <c:forEach var="Sdto" items="${Slists }">
        <div class="product ${Sdto.product_price2=='품절'?'soldout':'' }" >
        	<c:url var="detailUrl" value="store/storeContentForm.do">
				<c:param name="product_idx">${Sdto.product_idx }</c:param>
			</c:url>
        	<div class="prodImg">
        	<a href="${detailUrl }"><img src="/amor/resources/upload/product/${Sdto.product_img}" class="img" alt="store_snack_img"></a>
        	</div>
        	<div class="prodTitle">
        		<label>${Sdto.product_title }</label>
        	</div>
        	<div class="prodPrice">
        	<c:if test="${Sdto.product_price2=='품절' }">
        	<div class="soldout-cover"></div>
        		<label><span>${Sdto.product_price2 }</span></label>
        	</c:if>
        	<c:if test="${Sdto.product_price2!='품절' }">
        		<label><span>${Sdto.product_price2 }</span>원</label>
        	</c:if>
        	</div>
        </div>
     </c:forEach>   
    </div>
</div>
<div id="sc3">
<div class="title">음료</div>
    <div class="prodDiv">
     <c:if test="${empty Dlists }">
    	<div class="msg">상품 준비 중입니다.</div>
    </c:if>
    <c:forEach var="Ddto" items="${Dlists }">
        <div class="product ${Ddto.product_price2=='품절'?'soldout':'' }">
        	<c:url var="detailUrl" value="store/storeContentForm.do">
				<c:param name="product_idx">${Ddto.product_idx }</c:param>
			</c:url>
        	<div class="prodImg">
        	<a href="${detailUrl }"><img src="/amor/resources/upload/product/${Ddto.product_img}" class="img" alt="store_drink_img"></a>
        	</div>
        	<div class="prodTitle">
        		<label><a href="${detailUrl }">${Ddto.product_title }</a></label>
        	</div>
        	<div class="prodPrice">
        	<c:if test="${Ddto.product_price2=='품절' }">
        	<div class="soldout-cover"></div>
        		<label><span>${Ddto.product_price2 }</span></label>
        	</c:if>
        	<c:if test="${Ddto.product_price2!='품절' }">
        		<label><span>${Ddto.product_price2 }</span>원</label>
        	</c:if>
        	</div>
        </div>
     </c:forEach>   
    </div>
</div>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>