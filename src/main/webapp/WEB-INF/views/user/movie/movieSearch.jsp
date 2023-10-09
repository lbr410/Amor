<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
<link rel="stylesheet" href="/amor/resources/css/user/movie.css">
<!--브라우저 스타일 초기화-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<%@ include file="../header.jsp" %>
<style>
	.material-icons{
	color: #FFAC33;
	vertical-align: middle;
	
	}
	.movie_name{
	font-size: 16px;
	}
</style>
<body>
	<!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="/amor/movie/movie.do" title="영화 페이지로 이동">영화</a>
        </div>
    </div>
    <div class="body-inner"></div>
	<!-- MOVIE CHART -->
	<div class="movie-section">
	<!-- MOVIE TITLE MENU -->
  	<div class="movie-title">
	
	<div class="title-bar1">
	<div class="left-title">
	  <div class="movieNow">'${search}' 검색 결과</div>
	</div>
	</div>
	<!-- MOVIE CHART -->
	<div class="chart">
	<div class="container">	
	<c:if test="${empty lists}">
	<div>검색된 영화가 없습니다.</div>
	</c:if>
		<c:if test="${!empty lists}">
		<c:forEach var="temp" items="${lists}">
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="movieContentForm.do">
							<c:param name="movie_idx">${temp.movie_idx}</c:param>
                    	</c:url>
                    <a href="${MovieContentUrl}"><img src="/amor/resources/upload/movie/${temp.movie_poster}" alt="영화 포스터"></a>
                    </div>
                    <div class="title-area">
                        <span class="movie_maxage">
                            <c:if test="${0==temp.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==temp.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==temp.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==temp.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                        </span>
                        <span title="제목" class="movie_name">${temp.movie_name }</span>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                            <span class="material-icons">star</span> ${temp.avg_movie_review_star} &nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">&nbsp;개봉일 : ${temp.movie_opendate}</span>
                    </div>
                    <div class="book-btn" >
                        <c:url var="ticketingUrl" value="/ticketing/ticketing.do">
                       		<c:param name="movie_name">${temp.movie_name}</c:param>
                       	</c:url>
                     	<a href = "${ticketingUrl}">
                     		<button type="button" name="ticketing-btn" title="영화 예매하기">예매하기</button>
                     	</a>
                    </div>
                </div>
            </div>
          </c:forEach>
     </c:if>
     </div>	
	</div>
	</div>
 <c:if test="${!empty pageTag}">
<div class = "paging">${pageTag}</div>
</c:if>
	</div>
<%@ include file="../footer.jsp" %>
</body>
</html>