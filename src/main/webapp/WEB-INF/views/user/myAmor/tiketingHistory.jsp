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
	padding-left: 40px;
	}
	
	.btn {
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
    position: relative;
    font-size: 2rem;
    color: white;
  }
  
  .star input {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    opacity: 0;
    cursor: pointer;
  }
  
  .starBack span {
  	padding-bottom: 5px;
  	position: relative;
  	background-color: #FFF0BB;
  	border-radius: 10px;
  }
  
  .star span {
    width: 0;
    position: absolute; 
    left: 0;
    color: #FFAC33;
    overflow: hidden;
    pointer-events: none;
  }
  
  .name {
 	line-height: 50px;
  	height: 50px;
  	margin-right: 30px;
  	margin-left: 40px;
  	float:left;
  }
  
  .thumbnail {
 	width: 262px;
	height: 193px;
  	object-fit: contain;
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
    <c:if test="${temp.timelimit == 'y'}">
    	<c:url var="cancellticket" value="cancellation.do">
			<c:param name="ticketnum">${temp.ticketnum}</c:param>    
			<c:param name="timelimit">${temp.timelimit}</c:param>    		
		</c:url>
    	<input type = "button" value = "예매 취소" class = "button" onclick = "Cancellation(${cancellticket})">
  	</c:if>
  	<c:if test="${temp.timelimit == 'n'}">
  		${temp.timelimit}
  		<input type = "button" value = "관람평 작성" class = "button" id="openReview">
  	</c:if>
  	
  </div>
</div>
</c:forEach>
</c:if>
<c:if test="${empty list}">
<div class = "nullcontent">예매 내역이 없습니다.</div>
</c:if>
</div>
</div>

<!-- 관람평 리뷰 -->

<form name="reviewUpload" action="/amor/user/myAmor/reviewAdd.do" enctype="multipart/form-data">
<div id="myReviewBtn" class="btn">
	<div class="btn-content">
		
		<span id="closeBtn" class="closeBtn2">&times;</span>
		<span class="name">이름</span>
		<span class="starBack">	
		<span class="star">
			<img src="/amor/resources/img/Stars_background.png">
		<span><img src="/amor/resources/img/Stars_rating.png"></span>
			<input type="range" name="movie_review_star" oninput="drawStar(this)" value="1" step="1" min="1" max="10">
		</span>
		</span>
		<br>
		<div id="container">
			<div id="box1" class="container2">
				<img id="reviewPreview" class="thumbnail">
				<div class="inputfile">
				<input type="file" name="movie_review_img" value="파일찾기" class="fileBtn" id="fileInput" onchange="imgPreview(this)">
				</div>
			</div>
			<div id="box2"><textarea cols="55" rows="12" name="movie_review_content" placeholder="관람평을 작성해주세요"></textarea></div>
		</div>
		<p class="centerBtn"><input type="submit" value="작성 완료" class="cancelBtn">
		&nbsp;&nbsp;<input type="reset" value="다시 작성" class="cancelBtn"></p>
		
	</div>
</div>
</form>
</body>
<script src = "/amor/resources/js/httpRequest.js"></script>
<script>
	function Cancellation(url){
		location.href = url;
	}
</script>
<script type="text/javascript">
	const openReviewBtn = document.getElementById("openReview");
	const myReviewBtn = document.getElementById("myReviewBtn");
	const closeBtn = document.getElementById("closeBtn");
	
	openReviewBtn.addEventListener("click", () => {
		myReviewBtn.style.display = "block";
	});
	
	closeBtn.addEventListener("click", () =>{
		myReviewBtn.style.display = "none";
	});
	
	window.addEventListener("click", (event) => {
        if (event.target == myReviewBtn) {
            myReviewBtn.style.display = "none";
        }
    });		    
	
	function drawStar(target) {
		window.alert(document.querySelector(".star span").style.width);
		document.querySelector(".star span").style.width = target.value*10+'%';		
	}
	
	function imgPreview(input){
		let reviewImgId = 'reviewPreview';
		
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