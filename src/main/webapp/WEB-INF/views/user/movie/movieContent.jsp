<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <div class="movie-audience">${dto.movie_audience }</div>
    </div>
    <div class="movie_content">
      <textarea class="content" style="overflow-y:scroll;" readonly>
      ${dto.movie_content }
      </textarea>
    </div>
    <div class="btn-wrap"><button class="blue-btn">예매하기</button></div>
  </div>
</div>
</div>
    <div class="infodiv"><input type="button" value="상세정보" class="infoBtn" id="detailMovie">
    <input type="button" value="관람평" class="infoBtn" id="reviewWrite"></div>
    
    <!-- 리뷰 페이지 -->
    <div id="review">
    	<div class="grayspace">
    		영화의 관람평입니다.
    	</div>
    	
    	<div>
    
    
    
    	</div>
    </div>
    
    
    <!-- 상세정보 페이지 -->
    <div id="moviedetail">
    	<div class="grayspace">
    		영화 상세정보 페이지입니다.
    	</div>
    	<div id="stillcontainer">
    		<div id="stillbox1">
    			<img src="/amor/resources/upload/movie/${dto.movie_stillcut1 }">
    		</div>
    		<div id="stillbox2">
    			<img src="">
    		</div>
    		<div id="stillbox3">
    			<img src="">
    		</div>
    		<div id="stillbox4">
    			<img src="">
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
		movieDetailBtn.style.display = "none";
	});
	
	detailMovie.addEventListener("click", () => {
		reviewBtn.style.display = "none";
		movieDetailBtn.style.display = "block";
	});

</script>    
</body>
<%@ include file="../footer.jsp" %>
</html>