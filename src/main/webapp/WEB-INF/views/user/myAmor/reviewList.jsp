<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 관람평 목록</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <link rel="stylesheet" type="text/css" href="/amor/resources/css/user/reviewList.css">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><label class="title1">관람평 목록</label></div>
</div></div>
<div class="mypageContent">

<div class="reviewTable">
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
			<c:if test="${!empty reviewLists }">
				<tr>
					<td colspan="5" class="paging">${reviewpageStr}</td>
				</tr>
			</c:if>
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
					<input type="button" value="삭제" onclick="location.href='reviewDelete.do?movie_review_idx=${dto.movie_review_idx }&ticketing_idx=${dto.ticketing_idx}'" class="smallBtn"></td>
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
</div>
</div>

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
<%@include file="../footer.jsp" %>
</html>