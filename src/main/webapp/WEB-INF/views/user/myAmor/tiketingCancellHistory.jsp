<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 마이페이지 : 영화예매 취소내역</title>
<link rel="stylesheet" href="/amor/resources/css/user/tiketingHistory.css" />
</head>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
  padding-top: 200px;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;

}
.mypagetitle .title1{
	color: #000;
	font-size: 20px;
	font-weight: 500;
	cursor: pointer;
}  
.mypagetitle .title2{
	color:#979797;
	font-size: 20px;
	font-weight: 500;
	cursor: pointer;
} 
.mypageContent{
	padding-top: 150px;
	margin: 0 auto;
	width: 1000px;
	margin-bottom: 50px;
}
</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "myAmor/ticketingHistory.do"><label class="title2">예매내역</label></a> <a href="myAmor/cancellHistory.do"><label class="title1">취소내역</label></a></div>
</div></div>
<div class="mypageContent">
<c:if test="${!empty list}">
<c:forEach var="temp" items="${list}" >
<div class="contentbox">
  <img class="movieimg" src="/amor/resources/upload/movie/${temp.movieimg}"/>
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
            ${temp.changeScreeningDate}<br/>
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
            ${temp.changeReserveTime} <br/>
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
<div class = "nullcontent">취소 내역이 없습니다.</div>
</c:if>

</div>
<c:if test="${!empty page}">
<div class = "paging">${page}</div>
</c:if>
</body>
<%@include file = "../footer.jsp" %>
</html>