<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 상영예정작</title>
<link rel="stylesheet" href="/amor/resources/css/user/movieCome.css">
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
            <a href="/amor/movie/movieCome.do" title="상영예정작 페이지로 이동">상영 예정작</a>
        </div>
    </div>
    <div class="body-inner"></div>
	<!-- MOVIE CHART -->
	<div class="movie-section">
	<!-- MOVIE TITLE MENU -->
  	<div class="movie-title">
	
	<div class="title-bar">
	<div class="left-title">
	  <div class="movieNow"><a href="/amor/movie/movie.do">현재 상영작</a></div>
	  <span class="tmiddle"> |&nbsp;</span><div class="movieCome"><a href="/amor/movie/movieCome.do">상영 예정작</a></div>
	</div>
	<div class="right-button">
 		<button class="sort1" id="active-button">개봉일순</button>
  		<span class="middle"> | </span><button class="sort2" id="button">가나다순</button>
	</div>
	</div>
	</div>
	</div>
	<!-- MOVIE CHART -->
	<div id="movie-content1" class="movie-content">
	<div class="chart">
	<div class="container">
	<c:if test="${empty clists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:forEach var="cdto" items="${clists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                        <div class="rank"></div>
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="/movie/movieContentForm.do">
							<c:param name="movie_idx">${cdto.movie_idx }</c:param>
                    	</c:url>
                    <a href="${MovieContentUrl}"><img src="/amor/resources/upload/movie/${cdto.movie_poster }" alt="영화 포스터"></a>
                    </div>
                    <div class="title-area">
                        <span class="movie_maxage">
                            <c:if test="${0==cdto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==cdto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==cdto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==cdto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                        </span>
                        <a href="${MovieContentUrl}"><span title="제목" class="movie_name" name="truncatedTitle">${cdto.truncatedTitle }</span></a>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                            <span class="material-icons">star</span> ${cdto.avg_movie_review_star} &nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${cdto.movie_opendate }</span>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
	</div>
	</div>
	<div id="movie-content2" class="movie-content">
	<div class="chart">
	<div class="container">
	<c:if test="${empty nlists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:forEach var="ndto" items="${nlists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                        <div class="rank"></div>
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="/movie/movieContentForm.do">
							<c:param name="movie_idx">${ndto.movie_idx }</c:param>
                    	</c:url>
                    <a href="${MovieContentUrl}"><img src="/amor/resources/upload/movie/${ndto.movie_poster }" alt="영화 포스터"></a>
                    </div>
                    <div class="title-area">
                        <span class="movie_maxage">
                            <c:if test="${0==ndto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==ndto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==ndto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==ndto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                        </span>
                        <a href="${MovieContentUrl}"><span title="제목" class="movie_name" name="truncatedTitle">${ndto.truncatedTitle }</span></a>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                            <span class="material-icons">star</span>
                            <fmt:formatNumber value="${ndto.avg_movie_review_star}" pattern="0.0" />&nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${ndto.movie_opendate }</span>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
	</div>
	</div>
	
	
<script>
document.addEventListener('DOMContentLoaded', function () {
    const sortButtons = document.querySelectorAll('.sort1, .sort2');
    document.querySelector('.sort1').classList.add('active');
    sortButtons.forEach(button => {
        button.addEventListener('click', function () {
            // 모든 버튼에서 active 클래스 제거
            sortButtons.forEach(btn => btn.classList.remove('active'));
            // 현재 클릭한 버튼에 active 클래스 추가
            this.classList.add('active');
        });
    });
});
document.addEventListener('DOMContentLoaded', function () {
    const contents = document.querySelectorAll('.movie-content');
    contents.forEach(content => {
        content.style.display = 'none';
    });

    document.getElementById('movie-content1').style.display = 'block';

    const buttons = document.querySelectorAll('.right-button button');
    buttons.forEach((button, index) => {
        button.addEventListener('click', () => {
            contents.forEach(content => {
                content.style.display = 'none';
            });

            const contentId = 'movie-content' + (index + 1);
            document.getElementById(contentId).style.display = 'block';
        });
    });
});
</script>
</body>
<%@ include file="../footer.jsp" %>
</html>
