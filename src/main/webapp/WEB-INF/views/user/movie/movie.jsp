<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	  <div class="movieNow"><a href="/amor/movie/movie.do">현재 상영작</a></div>
	  <span class="tmiddle"> |&nbsp;</span><div class="movieCome"><a href="/amor/movie/movieCome.do">상영 예정작</a></div>
	</div>
	<div class="right-button">
 		<button class="sort1" id="active-button">관람객순</button>
  		<span class="middle"> | </span><button class="sort2" id="button">관람평 많은순</button>
	</div>
	</div>
	</div>
	</div>
	<!-- MOVIE CHART -->
	<div id="movie-content1" class="movie-content">
	<div class="chart">
	<c:set var="rank" value="1" />
	<div class="container">
	<c:if test="${empty mlists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:forEach var="mdto" items="${mlists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <c:choose>
                    <c:when test="${rank < 11}">
                        <div class="rank"><span class="rank-txt">${rank }위</span></div>
                    </c:when>
                    <c:otherwise>
                        <div class="rank"></div>
                    </c:otherwise>
                	</c:choose>
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
                        <span title="제목" class="movie_name" name="truncatedTitle">${mdto.truncatedTitle }</span>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                            <span class="material-icons">star</span> 
                            <fmt:formatNumber value="${mdto.avg_movie_review_star}" pattern="0.0" />&nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${mdto.movie_opendate }</span>
                    </div>
                    <div class="book-btn" >
                    <c:url var="ticketingUrl" value="/ticketing/ticketing.do">
                       		<c:param name="movie_name">${mdto.movie_name}</c:param>
                       		<c:param name="movie_maxage">${mdto.movie_maxage}</c:param>
                       		<c:param name="movie_idx">${mdto.movie_idx}</c:param>
                    </c:url>
                   	<a href="${ticketingUrl }">
                   		<button type="button" name="ticketing-btn" title="영화 예매하기">예매하기</button>
                   	</a>
                    </div>
                </div>
            </div>
            <c:choose>
            <c:when test="${rank < 11}">
                <c:set var="rank" value="${rank + 1}" />
            </c:when>
            <c:otherwise>
                <!-- 10 이상인 경우에는 rank를 증가시키지 않음 -->
            </c:otherwise>
        </c:choose>
        </c:forEach>
    </div>
	</div>
	</div>
	<div id="movie-content2" class="movie-content">
	<div class="chart">
	<c:set var="rank" value="1" />
	<div class="container">
	<c:if test="${empty rlists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:forEach var="rdto" items="${rlists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <c:choose>
                    <c:when test="${rank < 11}">
                        <div class="rank"><span class="rank-txt">${rank }위</span></div>
                    </c:when>
                    <c:otherwise>
                        <div class="rank"></div>
                    </c:otherwise>
                	</c:choose>
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="movieContentForm.do">
							<c:param name="movie_idx">${rdto.movie_idx }</c:param>
                    	</c:url>
                    <a href="${MovieContentUrl}"><img src="/amor/resources/upload/movie/${rdto.movie_poster }" alt="영화 포스터"></a>
                    </div>
                    <div class="title-area">
                        <span class="movie_maxage">
                            <c:if test="${0==rdto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==rdto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==rdto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==rdto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                        </span>
                        <span title="제목" class="movie_name">${rdto.movie_name }</span>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                            <span class="material-icons">star</span>
                            <fmt:formatNumber value="${rdto.avg_movie_review_star}" pattern="0.0" />&nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${rdto.movie_opendate }</span>
                    </div>
                    <div class="book-btn" >
                    <c:url var="ticketingUrl" value="/ticketing/ticketing.do">
                       		<c:param name="movie_name">${rdto.movie_name}</c:param>
                       		<c:param name="movie_maxage">${rdto.movie_maxage}</c:param>
                       		<c:param name="movie_idx">${rdto.movie_idx}</c:param>
                       	</c:url>
                     	<a href="${ticketingUrl }">
                     		<button type="button" name="ticketing-btn" title="영화 예매하기">예매하기</button>
                     	</a>
                    </div>
                </div>
            </div>
            <c:choose>
            <c:when test="${rank < 11}">
                <c:set var="rank" value="${rank + 1}" />
            </c:when>
            <c:otherwise>
                <!-- 10 이상인 경우에는 rank를 증가시키지 않음 -->
            </c:otherwise>
        </c:choose>
        </c:forEach>
    </div>
	</div>
	</div>
	
	
<script>
document.addEventListener('DOMContentLoaded', function () {
    const sortButtons = document.querySelectorAll('.sort1, .sort2');

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
