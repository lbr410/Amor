<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 마이페이지 : 영화 예매내역</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/tiketingHistory.css">
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

#container {
	display: flex;
	margin: 5% auto;
}
	
#box1{
	flex:1;
	display:table;
	padding-left: 10px;
	width: 262px;
	height: 193px;
}
	
.inputfile {
	text-align: center;
	line-height: 50px;
}
	
#box2{
	flex:2;
	padding-left: 20px;
}
	
.btn {
	margin-top: 60px;
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,0.7);
}
	
.btn-content {
	background-color: #fff;
	margin: 10% auto;
	padding: 20px;
	border: 2px solid #1A2C82;
	width: 700px;
	box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
	border-radius: 15px;
	border: 5px solid #1A2C82;
}
	
.nextbtn {
	border:none;
	padding: 2px 21px 6px 21px;
	width: 150px;
	height: 40px;
	border-radius: 3px;
	background: #1A2C82;
	color: #C7E3FF;
	cursor: pointer;
}
	
.cancelBtn {
   border:none;
   padding: 2px 21px 6px 21px;
   width: 150px;
   height: 40px;
   border-radius: 3px;
   background: #EEEEEE;
   color: #1A2C82;
   cursor: pointer;
}
	
.fileBtn {
	vertical-align:middle;
	border:none;
	border-radius: 3px;
	color: #1A2C82;
	cursor: pointer;
}
	
.closeBtn2 {
	float: right;
	cursor: pointer;
}

.centerBtn {
	text-align: center;
}
	
.star {
	padding-bottom: 5px;
	position: relative;
	font-size: 1.3rem;
	color: white;
}
 
.starBack span {
  	position: relative;
  	background-color: #FFF0BB;
  	border-radius: 5px;
}
  
.star span {
   position: absolute; 
   left: 0; 
   color: #FFAC33; 
   overflow: hidden; 
   pointer-events: none; 
   border-radius: 5px;
  }

.star input {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    opacity: 0;
    cursor: pointer;
  }  
  
.name {
  	margin-top:5px;
 	line-height: 30px;
  	height: 50px;
  	margin-right: 30px;
  	margin-left: 40px;
  	float:left;
  }
  
.thumbnail {
 	width: 262px;
	height: 193px;
  	object-fit: contain;
  	border: none;
  	border-top: 3px solid #EEEEEE;
  	border-bottom: 3px solid #EEEEEE;
  	border-left: 3px solid #EEEEEE;
  	border-right: 3px solid #EEEEEE;
}
  
.reviewtitle {
  	margin-left: 15px;
  	margin-bottom: 10px;
  	font-size: 25px;
  	font-weight: bold;
  	color: #1A2C82;
}
  
.reviewTextarea{
  	border: none;
  	border-top: 3px solid #EEEEEE;
  	border-bottom: 3px solid #EEEEEE;
  	border-left: 3px solid #EEEEEE;
  	border-right: 3px solid #EEEEEE;
  	resize: none;
}
</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/myAmor/ticketingHistory.do"><label class="title1">예매내역</label></a> <a href="/amor/myAmor/cancellHistory.do"><label class="title2">취소내역</label></a></div>
<!-- 이 밑으로 작업 -->
<c:if test="${!empty list}">
<c:forEach var="temp" items="${list}" varStatus="vs">
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
    <c:if test="${temp.timelimit == 'y'}">
    	<c:url var="cancellticket" value="cancellation.do">
			<c:param name="ticketnum">${temp.ticketnum}</c:param>    
			<c:param name="timelimit">${temp.timelimit}</c:param>    		
		</c:url>
    	<a href = "cancellticket"><input type = "button" value = "예매 취소" class = "button"></a>
  	</c:if>
  	<c:if test="${temp.timelimit == 'n'}">
  		${temp.timelimit}
  		<input type = "button" value = "관람평 작성" class = "button" onclick="document.getElementById('myReviewBtn${vs.index}').style.display='block'">
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
		<span class="name">${sessionScope.sname } 님</span>
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
			<div id="box2"><textarea cols="55" rows="12" name="movie_review_content" placeholder="관람평을 작성해주세요" maxlength="200" class="reviewTextarea" required></textarea></div>
		</div>
		<p class="centerBtn"><input type="submit" value="작성 완료" class="cancelBtn"></p>
		
	</div>
</div>
	<input type="hidden" name="ticketing_idx" value="${temp.ticketnum}">
	<input type="hidden" name="movie_idx" value="${temp.movieidx }">
	<input type="hidden" name="member_idx" value="${temp.memberidx }">
</form>

</c:forEach>
</c:if>
<c:if test="${empty list}">
<div class = "nullcontent">예매 내역이 없습니다.</div>
</c:if>
</div>
</div>
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