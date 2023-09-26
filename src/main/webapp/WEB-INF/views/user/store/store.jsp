<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle">
        		<label>콜라M</label>
        	</div>
        	<div class="prodPrice">
        		<label>3,000원</label>
        	</div>
        </div>
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle"></div>
        	<div class="prodPrice"></div>
        </div>
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle"></div>
        	<div class="prodPrice"></div>
        </div> 
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle"></div>
        	<div class="prodPrice"></div>
        </div>     
    </div>
</div>
<div id="sc2">
<div class="title">스낵</div>
    <div class="prodDiv">
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle">
        		<label>콜라M</label>
        	</div>
        	<div class="prodPrice">
        		<label>3,000원</label>
        	</div>
        </div>
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle"></div>
        	<div class="prodPrice"></div>
        </div>
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle"></div>
        	<div class="prodPrice"></div>
        </div> 
        <div class="product">
        	<div class="prodImg"></div>
        	<div class="prodTitle"></div>
        	<div class="prodPrice"></div>
        </div>     
    </div>
</div>
<div id="sc3">
<div class="title">음료</div>
</div>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>