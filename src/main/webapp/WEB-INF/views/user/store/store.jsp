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
<div class="img"><img src="/amor/resources/img/store_banner.jpg" alt="banner"></div>
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
        <div class="product">
        	<c:url var="detailUrl" value="storeContentForm.do">
				<c:param name="product_idx">${Tdto.product_idx }</c:param>
			</c:url>
        	<div class="prodImg"></div>
        	<div class="prodTitle">
        		<label><a href="${detailUrl }">${Tdto.product_title }</a></label>
        	</div>
        	<div class="prodPrice">
        		<label>${Tdto.product_price2 }</label>
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
    <c:forEach var="Ddto" items="${Slists }">
        <div class="product">
        	<c:url var="detailUrl" value="storeContentForm.do">
				<c:param name="product_idx">${Sdto.product_idx }</c:param>
			</c:url>
        	<div class="prodImg"></div>
        	<div class="prodTitle">
        		<label>${Sdto.product_title }</label>
        	</div>
        	<div class="prodPrice">
        		<label>${Sdto.product_price2 }</label>
        	</div>
        </div>
     </c:forEach>   
    </div>
</div>
<div id="sc3">
<div class="title">음료</div>
    <div class="prodDiv">
     <c:if test="${empty Dlists }">
    	<div class="msg">상품 준비 중..</div>
    </c:if>
    <c:forEach var="Ddto" items="${Dlists }">
        <div class="product">
        	<c:url var="detailUrl" value="storeContentForm.do">
				<c:param name="product_idx">${Ddto.product_idx }</c:param>
			</c:url>
        	<div class="prodImg"></div>
        	<div class="prodTitle">
        		<label><a href="${detailUrl }">${Ddto.product_title }</a></label>
        	</div>
        	<div class="prodPrice">
        		<label>${Ddto.product_price2 }</label>
        	</div>
        </div>
     </c:forEach>   
    </div>
</div>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>