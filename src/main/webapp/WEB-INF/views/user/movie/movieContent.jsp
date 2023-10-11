<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 영화 상세</title>
<link rel="stylesheet" href="/amor/resources/css/user/movieContent.css"></link>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<%@ include file="../header.jsp" %>
<body>
<!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="/amor/movie/movie.do" title="영화 페이지로 이동">영화</a>
            <a href="/amor/movie/movie.do" title="현재 상영작 페이지로 이동">현재 상영작</a>
        </div>
    </div>
   
   <div id="movie-section" class="movie-content" style="margin-top: 120px;">
    <div class="movie-wrap">
  	<div class="movie_poster">
    <img src="/amor/resources/upload/movie/${dto.movie_poster }" alt="영화 포스터">
  	</div>
  <div class="right-section">
    <div class="title-info">
      <div class="movie_name">${dto.movie_name }</div> 
    </div>
    <div class="movie-info">
      <div class="movie-opendate">${dto.movie_opendate } |</div>
      <span class="material-icons">schedule</span>
	  <div class="movie_runningtime">${dto.movie_runningtime }분 |</div>
      <div class="movie_maxage">
		<c:if test="${0==dto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"><div class="ageTxt">전체 관람가 |</div></c:if>
		<c:if test="${1==dto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"><div class="ageTxt">12세 관람가 |</div></c:if>
		<c:if test="${2==dto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"><div class="ageTxt">15세 관람가 |</div></c:if>
		<c:if test="${3==dto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"><div class="ageTxt">18세 관람가 |</div></c:if></div>
    </div>
    <div class="movie_content">
      <textarea class="content">${dto.movie_content }</textarea>
    </div>
    <div class="btn-wrap"><button class="blue-btn" type="button" onclick="location.href='/amor/ticketing/ticketing.do'">예매하기</button></div>
  </div>
</div>
</div>
    <div class="infodiv"><input type="button" value="상세정보" class="infoBtn" id="detailMovie">
    <input type="button" value="관람평" class="infoBtn" id="reviewWrite"></div>
    
    <!-- 리뷰 페이지 -->
    <div id="review">
    	<div class="grayspace">
    		<div class="movieReviewInfo">영화의 관람평을 들어보세요!</div>
    	</div>
    	<div class="movieReviewInfoTable">   			
    			<table class="reviewTableINfo">
			<thead>
				<tr class="reviewTableInfoThead">
					<th>작성 날짜</th>
					<th>회원아이디</th>
					<th>관람평점</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tfoot>
			<c:if test="${!empty rlists}">
				<tr class="reviewTableInfoTfoot">
					<td colspan="5" class="paging">${reviewPage}</td>
				</tr>
			</c:if>
			</tfoot>
			<tbody>
			<c:if test="${empty rlists }">
				<tr class="reviewTableINfoTbody">
					<td class="reviewTd7" colspan="5" >등록된 관람평이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${rlists }" varStatus="vs">
				<tr class="reviewTableINfoTbody">
					<td class="reviewTd1">${dto.movie_review_writedate }</td>
					<td class="reviewTd5">${dto.member_id }</td>
					<td class="reviewTd" colspan="2">
					
					<span class="starBack">	
					<span class="star">
						☆☆☆☆☆
					<span class="starAll" style="width: ${dto.movie_review_star}0%;">★★★★★</span>
						<input type="range" name="movie_review_star"  min="1" max="10">
					</span>
					</span>
					
					</td>
					<td class="reviewTd3" onclick="document.getElementById('reviewContent${vs.index}').style.display=''">▽</td>
				</tr>
				<tr class="reviewTableINfoTbody" id="reviewContent${vs.index }" style="display:none;">
					<td class="reviewTdContent2" colspan="2"><img src="/amor/resources/upload/review/${dto.movie_review_img}" class="reviewImg"></td>
					<td class="reviewTdContent" colspan="2">${dto.movie_review_content }</td>
					<td class="reviewTdContent3" onclick="document.getElementById('reviewContent${vs.index}').style.display='none'">&times;</td>
				</tr>
				
			</c:forEach>
			</tbody>
		</table>
    	</div>
    </div>
    
    
    <!-- 상세정보 페이지 -->
    <div id="moviedetail">
    	<div class="grayspace">
    		<table class="movieInfotable">
    		<tr>
    			<th class="movieTitleInfo">영화정보</th>
    			<td></td>
    		</tr>
    		<tr>
    			<th class="movieTitleTh">장르</th> 
    			<td>${dto.movie_genre }</td>
    		</tr>
    		<tr>
    			<th class="movieTitleTh">감독</th> 
    			<td>${dto.movie_god }</td>
    		</tr>
    		<tr>
    			<th class="movieTitleTh">출연</th> 
    			<td>${dto.movie_actor }</td>
    		</tr>
    		</table>
    	</div>
    	<div id="stillcontainer">
    		<div id="stillbox">
    			<div class="stillcutTitle">스틸컷</div>
    			<table class="moviedetailtable">
    				<tr>
    					<td rowspan="2"><img class="thumnail" src="/amor/resources/upload/movie/${dto.movie_stillcut1 }"></td>
    					<td><img class="thumnail" src="/amor/resources/upload/movie/${dto.movie_stillcut2 }"></td>
    					<td><img class="thumnail" src="/amor/resources/upload/movie/${dto.movie_stillcut3 }"></td>
    				</tr>
    				<tr>
    					<td><img class="thumnail" src="/amor/resources/upload/movie/${dto.movie_stillcut4 }"></td>
    					<td><img class="thumnail" src="/amor/resources/upload/movie/${dto.movie_stillcut5 }"></td>
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    
<script>

	const reviewWrite = document.getElementById("reviewWrite");
	const detailMovie = document.getElementById("detailMovie");	
	
	const reviewBtn = document.getElementById("review");
	const movieDetailBtn = document.getElementById("moviedetail");
	
	reviewWrite.addEventListener("click", () => {
		reviewBtn.style.display = "block";
		detailMovie.style.borderBottom = "none";
		reviewWrite.style.borderBottom = "2px solid black";
		movieDetailBtn.style.display = "none";
	});
	
	detailMovie.addEventListener("click", () => {
		reviewBtn.style.display = "none";
		reviewWrite.style.borderBottom = "none";
		detailMovie.style.borderBottom = "2px solid black";
		movieDetailBtn.style.display = "block";
	});

</script>    
</body>
<%@ include file="../footer.jsp" %>
</html>