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
<div class="mypagetitle"><a href = "/amor/myAmor/ticketingHistory.do"><label class="title2">예매내역</label></a> <a href="/amor/myAmor/cancellHistory.do"><label class="title1">취소내역</label></a></div>
<!-- 이 밑으로 작업 -->
<c:if test="${!empty list}">
<c:forEach var="temp" items="${list}" >
<div class="contentbox">
  <img class="movieimg" src="/amor/resources/upload/movie/1.jpg"/>
  <div class="contentbox2">
    <div class="contentbox3">
      <div class="content-container">
        <span>
          <span class="span">
          ${temp.moviename}<br/>
          </span>
          <span class="span2">
          <br/></span>
          <span class="span3">
            예매 번호
          </span>
          <span class="span4">
            ${temp.ticketnum}<br/>
          </span>
          <span class="span5">
          관람 일시
          </span>
          <span class="span6">
            ${temp.screeningdate}<br/>
          </span>
          <span class="span7">
          상영관
          </span>
          <span class="span8">
             ${temp.theatername}, ${temp.seatnum}<br/>
          </span>
           <span class="span9">
           결제 날짜
          </span>
          <span class="span10">
            ${temp.reservetime} <br/>
          </span>
          <span class="span11">
          결제방법
          </span>
          <span class="span12">
            ${temp.payment}<br/>
          </span>
          <span class="span13">
          금액 
          </span>
          <span class="span14">
            ${temp.changePrice}
          </span>
          </span>
      </div>
    </div>
    <span class = "cancellmsg">취소완료</span>
  </div>
</div>
</c:forEach>
</c:if>
<c:if test="${empty list}">
<div class = "nullcontent">예매 내역이 없습니다.</div>
</c:if>
</div>
</div>
</body>
<script src = "/amor/resources/js/httpRequest.js"></script>
<script>
	function Cancellation(ticketnum){
		alert('ss');
		let param = 'ticketnum='+ticketnum;
		sendRequest('cancellation.do',param,null,'GET');
	}
</script>
</html>