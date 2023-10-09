<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 현재 상영작</title>
<link rel="stylesheet" href="/amor/resources/css/user/movie.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />

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
    <div class="body-inner"></div>
	<!-- MOVIE CHART -->
	<div class="movie-section">
	<!-- MOVIE TITLE MENU -->
  	<div class="movie-title">
	
	<div class="title-bar">
	<div class="left-title">
	  <div class="movieNow">현재 상영작</div>
	  <div class="movieCome">| <a href="/amor/movie/movieCome.do">상영 예정작</a></div>
	</div>
	<div class="right-button">
 		<div class="sortAudience" onclick="toggleSort('sort1')">관람객순</div>
  		<div class="sortReview" onclick="toggleSort('sort2')"> | 관람평 많은순</div>
	</div>
	</div>
	<!-- MOVIE CHART -->
	<div class="chart">
	<div id="sort1" class="movie-content">
	<div class="movie_total">총 영화수 ${totalCnt }</div>
	<div class="container">
	<c:if test="${empty mlists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:set var="rank" value="1" />
		<c:forEach var="mdto" items="${mlists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <div class="rank"><span class="rank-txt">${rank }위</span></div>
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="movieContentForm.do">
							<c:param name="movie_idx">${mdto.movie_idx }</c:param>
                    	</c:url>
                    <a href="${MovieContentUrl}"><img src="/amor/resources/upload/movie/${mdto.movie_poster }" alt="영화 포스터"></a>
                    </div>
                    <div class="title-area">
                        <span class="movie_maxage">
                            <c:if test="${0==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                        </span>
                        <span title="제목" class="movie_name">${mdto.movie_name }</span>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                             <span class="rate">
                            <span class="material-icons">star</span> ${temp.avg_movie_review_star} &nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${mdto.movie_opendate }</span>
                    </div>
                    <div class="book-btn" >
                        <c:url var="ticketingUrl" value="/amor/ticketing/ticketing.do">
                       		<c:param name="movie_idx">${mdto.movie_idx }</c:param>
                       	</c:url>
                     	<a href="${ticketingUrl}">
                     		<button type="button" name="ticketing-btn" title="영화 예매하기">예매하기</button>
                     	</a>
                    </div>
                </div>
            </div>
            <c:set var="rank" value="${rank+1 }" />
        </c:forEach>
     	</div>
	</div>
	<div id="sort2" class="movie-content" style="display: none;">
	<div class="movie_total">총 영화수 ${totalCnt }</div>
	<div class="container">
	<c:if test="${empty mlists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:set var="rank" value="1" />
		<c:forEach var="mdto" items="${mlists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <div class="rank"><span class="rank-txt">${rank }위</span></div>
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="movieContentForm.do">
							<c:param name="movie_idx">${mdto.movie_idx }</c:param>
                    	</c:url>
                    <a href="${MovieContentUrl}"><img src="/amor/resources/upload/movie/${mdto.movie_poster }" alt="영화 포스터"></a>
                    </div>
                    <div class="title-area">
                        <span class="movie_maxage">
                            <c:if test="${0==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==mdto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                        </span>
                        <span title="제목" class="movie_name">${mdto.movie_name.substring(0, 10)}</span>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                             <span class="rate">
                            <span class="material-icons">star</span> ${temp.avg_movie_review_star} &nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${mdto.movie_opendate }</span>
                    </div>
                    <div class="book-btn" >
                        <c:url var="ticketingUrl" value="/amor/ticketing/ticketing.do">
                       		<c:param name="movie_idx">${mdto.movie_idx }</c:param>
                       	</c:url>
                     	<a href="${ticketingUrl}">
                     		<button type="button" name="ticketing-btn" title="영화 예매하기">예매하기</button>
                     	</a>
                    </div>
                </div>
            </div>
            <c:set var="rank" value="${rank+1 }" />
        </c:forEach>
     	</div>
	</div>
	</div>
	</div>
	</div>
<%@ include file="../footer.jsp" %>
<script>
function toggleSort(sortId) {
	  var sort1Container = document.getElementById('sort1');
	  var sort2Container = document.getElementById('sort2');
	  var sortAudienceButton = document.querySelector('.sortAudience');
	  var sortReviewButton = document.querySelector('.sortReview');

	  // 각 컨테이너를 표시/숨김 처리
	  if (sortId === 'sort1') {
	    sort1Container.style.display = 'block';
	    sort2Container.style.display = 'none';
	    sortAudienceButton.style.color = 'black';
	    sortReviewButton.style.color = '#DDDDDD';
	  } else if (sortId === 'sort2') {
	    sort1Container.style.display = 'none';
	    sort2Container.style.display = 'block';
	    sortAudienceButton.style.color = '#DDDDDD';
	    sortReviewButton.style.color = 'black';
	  }
	}
</script>
</body>
</html>