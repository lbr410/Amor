<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 영화예매 내역</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/tiketingHistory.css">
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
#btn1{
    background: #1A2C82;
    color: #FFF;
    border: 1px solid #1A2C82;
    cursor: pointer;
}
</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "ticketingHistory.do"><label class="title1">예매내역</label></a> <a href="cancelHistory.do"><label class="title2">취소내역</label></a></div>
</div></div>
<div class="mypageContent">
<c:if test="${!empty list}">
<c:forEach var="temp" items="${list}">
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
            ${temp.changeScreeningDate} ~ ${temp.changeEndDate}<br/>
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
            카카오페이<br/>
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
    <c:if test="${temp.timelimit == 'y'}">
    	<c:url var="cancellticket" value="cancellation.do">
			<c:param name="ticketingidx">${temp.ticketingidx}</c:param>    
			<c:param name="playingMovieidx">${temp.playingMovieidx}</c:param>    		
			<c:param name="seateNum">${temp.seatnum}</c:param>    		
			<c:param name="movieidx">${temp.movieidx}</c:param>    		
		</c:url>
    	<a href = "${cancellticket}"><input type = "button" value = "예매 취소" class = "button"></a>
  	</c:if>
  	<c:if test="${temp.timelimit == 'n' && temp.state != 'r'}">
  		<input type = "button" value = "관람평 작성" class = "button" onclick="document.getElementById('myReviewBtn${vs.index}').style.display='block'">
  	</c:if>  	
  	<c:if test="${temp.timelimit != 'y' && temp.timelimit == 'n' && temp.state == 'r'}">
  		<span class = "cancelmsg">관람평 완료</span>
  	</c:if>
  </div>
</div>

<!-- 관람평 리뷰 -->

<form name="reviewUpload" action="movieReviewAdd.do" method="post" enctype="multipart/form-data">
<div id="myReviewBtn${vs.index}" class="btn" onclick="if (event.target == myReviewBtn${vs.index}) { document.getElementById('myReviewBtn${vs.index}').style.display='none'}">
	<div class="btn-content">
		
		<span id="closeBtn" class="closeBtn2" onclick="document.getElementById('myReviewBtn${vs.index}').style.display='none'">&times;</span>
		<span class="reviewtitle">관람평 작성</span>
		<br>
		<br>
		<span class="name">${sessionScope.sname }님</span>
		<span class="starBack">	
		<span class="star">
			☆☆☆☆☆
		<span class="starAll${vs.index}" style="width: 50%;">★★★★★</span>
			<input type="range" name="movie_review_star" oninput="drawStar(this, '.starAll${vs.index}')" min="1" max="10">
		</span>
		</span>
		<br>
		<div id="container">
			<div id="box1" class="container2">
				<img id="reviewPreview${vs.index }" class="thumbnail">
				<div class="inputfile">
				<input type="file" name="movie_review_img" value="파일찾기" class="fileBtn" id="fileInput" onchange="imgPreview(this, 'reviewPreview${vs.index }')" required>
				</div>
			</div>
			<div id="box2"><textarea cols="55" rows="10" name="movie_review_content" placeholder="관람평을 작성해주세요" maxlength="200" class="reviewTextarea" required></textarea></div>
		</div>
		<p class="centerBtn"><input type="submit" value="작성 완료" class="cancelBtn"></p>
		
	</div>
</div>
	<input type="hidden" name="ticketing_idx" value="${temp.ticketingidx}">
	<input type="hidden" name="movie_idx" value="${temp.movieidx }">
	<input type="hidden" name="member_idx" value="${temp.memberidx }">
</form>
</c:forEach>

</c:if>
<c:if test="${empty list}">
<div class = "nullcontent">예매 내역이 없습니다.</div>
</c:if>

</div>
<c:if test="${!empty page}">
<div class = "paging">${page}</div>
</c:if>
</body>
<%@include file = "../footer.jsp" %>
<script src = "/amor/resources/js/httpRequest.js"></script>
<script type="text/javascript">

	function drawStar(target, aaa) {
		document.querySelector(aaa).style.width = target.value*10+'%';		
	}
	
	function imgPreview(input, bbb){
		let reviewImgId = bbb;
		
		if (input.files && input.files[0]) {
		    var reader = new FileReader();
		    reader.onload = function(e) {
		    	document.getElementById(reviewImgId).src = e.target.result;
		    };
		    reader.readAsDataURL(input.files[0]);
		  } else {
		    document.getElementById(reviewImgId).src = "";
		  }
	}
</script>
</html>