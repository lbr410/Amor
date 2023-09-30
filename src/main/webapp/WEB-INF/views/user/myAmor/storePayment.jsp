<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/amor/resources/css/user/tiketingHistory.css" />
</head>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;
   margin-bottom: 64px;
   position: absolute;
}
.nullcontent{
	margin-left:50px;
	margin-top:50px;
}
</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/myAmor/ticketingHistory.do"><label class="title1">상품 내역</label></a> <a href="/amor/myAmor/cancellHistory.do"><label class="title2">취소 내역</label></a></div>
<!-- 이 밑으로 작업 -->
<c:if test="${!empty list}">
<c:forEach var="temp" items="${list}" >
<div class="contentbox">
  <img class="movieimg" src="/amor/resources/upload/product/${temp.productimg}"/>
  <div class="contentbox2">
    <div class="contentbox3">
      <div class="content-container">
        <span>
          <span class="span">
          ${temp.productname}<br/>
          </span>
          <span class="span2">
          <br/></span>
          <span class="span3">
            결제 날짜
          </span>
          <span class="span4">
            ${temp.paymentdate}<br/>
          </span>
          <span class="span5">
          결제 방법
          </span>
          <span class="span6">
            ${temp.payment}<br/>
          </span>
          <span class="span7">
          수량
          </span>
          <span class="span8">
            ${temp.amount}개<br/>
          </span>
           <span class="span9">
           금액
          </span>
          <span class="span10">
            ${temp.price} <br/>
          </span>
          </span>
      </div>
    </div>
    <c:if test="${temp.status == '미승인'}">
    	<c:url var="cancellticket" value="cancellation.do">
			<c:param name="paymentidx">${temp.paymentidx}</c:param>    
			<c:param name="useridx">${temp.useridx}</c:param>    		
		</c:url>
    	<input type = "button" value = "구매 취소" class = "button" onclick = "Cancellation(${cancellticket})">
  	</c:if>
  	<c:if test="${temp.status == 'y'}">
  		<div class = "button">구매 완료</div>
  	</c:if>
  </div>
</div>
</c:forEach>
</c:if>
<c:if test="${empty list}">
<div class = "nullcontent">구매 내역이 없습니다.</div>
</c:if>
</div>
</div>
</body>
<script src = "/amor/resources/js/httpRequest.js"></script>
<script>
	function Cancellation(url){
		location.href = url;
	}
</script>
</html>