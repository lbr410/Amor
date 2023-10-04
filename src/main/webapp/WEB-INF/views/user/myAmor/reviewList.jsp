<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 관람평 목록</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />

</head>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
  height: 8000px;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;
   margin-bottom: 64px;
   position: absolute;
}

.reviewTable {
	margin: 50px auto;
	width: 800px;
}

table {
	width: 800px;
}

table thead tr {
	height: 100px;
	line-height: 100px;
	text-align: center;
}

table tbody tr {
	text-align: center;
	background-color: #F8F9FA;
	border-bottom: 30px solid white;
}

table tfoot tr {
	height: 100px;
	line-height: 100px;
	text-align: center;
}

.paging {
	height : 80px;
	margin-top: 70px;
	text-align: center;
	font-size: 16px;
}

.paging a:hover{
	color: #324ABC;
	font-weight: normal;
}

.nowPage {
	color: #324ABC !important;
	font-weight: bold;
}

.reviewImg {
 	width: 262px;
	height: 193px;
  	object-fit: contain;
  	border: none;
}

.reviewTd1 {
	width: 150px;	
}

.reviewTd2 {
	width: 150px;
}

.reviewTd3 {
	height: 80px;
	line-height: 80px;
	cursor: pointer;
	color: #1A2C82;
}

.reviewTdContent {
	height: 200px;
	text-align: left;	
	vertical-align: middle;
	white-space: pre-line;
}

.reviewTdContent2 {
	object-fit: contain;
	text-align: center;
	border: none;
	width: 150px;
}

.reviewTdContent3 {
	height: 200px;
	text-align: center;	
	vertical-align: middle;
	cursor: pointer;
}

.smallBtn {
	border:none;
	padding-bottom: 2px;
	width: 50px;
	height: 25px;
	border-radius: 3px;
	background: #EEEEEE;
	color: #1A2C82;
	cursor: pointer;
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
 
 .starAll {
 	background-color: none;
 	vertical-align: middle;
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
	width: 700px;
	box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
	border-radius: 15px;
	border: 5px solid #D9D9D9;
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
  	color: gray;
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

<div class="mypagetitle"><label>관람평 목록</label></div>

<div class="reviewTable">
	<form>
		<table>
			<thead>
				<tr>
					<th>작성 날짜</th>
					<th>관람 영화</th>
					<th>관람평점</th>
					<th>수정 및 삭제</th>
					<th></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="5" class="paging">${reviewpageStr}</td>
				</tr>
			</tfoot>
			<tbody>
			<c:if test="${empty reviewLists }">
				<tr>
					<td colspan="5" >등록된 관람평이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${reviewLists }" varStatus="vs">
				<tr>
					<td class="reviewTd1">${dto.movie_review_writedate }</td>
					<td class="reviewTd">${dto.movie_name }</td>
					<td class="reviewTd">
					
					<span class="starBack">	
					<span class="star">
						☆☆☆☆☆
					<span class="starAll" style="width: ${dto.movie_review_star}0%;">★★★★★</span>
						<input type="range" name="movie_review_star"  min="1" max="10">
					</span>
					</span>
					
					</td>
					<td class="reviewTd2"><input type="button" value="수정" class="smallBtn" onclick="document.getElementById('myReviewBtn${vs.index}').style.display='block'">&nbsp;&nbsp;&nbsp;
					<input type="button" value="삭제" onclick="location.href='reviewDelete.do?movie_review_idx=${dto.movie_review_idx }'" class="smallBtn"></td>
					<td class="reviewTd3" onclick="document.getElementById('reviewContent${vs.index}').style.display=''">▽</td>
				</tr>
				<tr id="reviewContent${vs.index }" style="display:none;">
					<td class="reviewTdContent2" colspan="2"><img src="/amor/resources/upload/review/${dto.movie_review_img}" class="reviewImg"></td>
					<td class="reviewTdContent" colspan="2">${dto.movie_review_content }</td>
					<td class="reviewTdContent3" onclick="document.getElementById('reviewContent${vs.index}').style.display='none'">&times;</td>
				</tr>
				
				<!-- 관람평 수정 -->
				<form name="reviewUpdate" action="reviewUpdate.do" method="post" enctype="multipart/form-data">
				<div id="myReviewBtn${vs.index}" class="btn" onclick="if (event.target == myReviewBtn${vs.index}) { document.getElementById('myReviewBtn${vs.index}').style.display='none'}">
					<div class="btn-content">
						<span id="closeBtn" class="closeBtn2" onclick="document.getElementById('myReviewBtn${vs.index}').style.display='none'">&times;</span>
						<span class="reviewtitle">관람평 수정</span>
						<br>
						<br>
						<span class="name">${sessionScope.sname } 님</span>
						<span class="starBack">	
						<span class="star">
							☆☆☆☆☆
						<span class="starAll${vs.index}" style="width: ${dto.movie_review_star}0%;">★★★★★</span>
							<input type="range" name="movie_review_star" oninput="drawStar(this, '.starAll${vs.index}')" min="1" max="10">
						</span>
						</span>
						<br>
						<div id="container">
							<div id="box1" class="container2">
								<img src="/amor/resources/upload/review/${dto.movie_review_img }" id="reviewPreview${vs.index }" class="thumbnail">
								<div class="inputfile">
								<input type="file" name="movie_review_img" value="파일 찾기" class="fileBtn" id="fileInput" onchange="imgPreview(this, 'reviewPreview${vs.index }')" required>
								</div>
							</div>
							<div id="box2"><textarea cols="55" rows="12" name="movie_review_content" maxlength="200" class="reviewTextarea" required>${dto.movie_review_content }</textarea></div>
						</div>
						<p class="centerBtn"><input type="submit" value="수정하기" class="cancelBtn"></p>
					</div>
					</div>
						<input type="hidden" name="movie_review_idx" value="${dto.movie_review_idx}">
				</form>
					
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>

</div>
</div>
<%@include file="../footer.jsp" %>
<script type="text/javascript">

	function drawStar(target, aaa) {
		document.querySelector(aaa).style.width = target.value*10+'%';		
	}	   
	
	function imgPreview(input, bbb, ccc){
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
</body>
</html>