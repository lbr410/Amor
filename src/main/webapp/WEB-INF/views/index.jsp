<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/amor/resources/css/user/index.css" />
<script defer src="/amor/resources/js/youtube.js"></script>
<title>Amor Cinema</title>
</head>
<%@ include file="../views/user/header.jsp" %>
<body>
	<!--YOUTUBE VIDEO-->
	<a href="#">
		<section class="youtube">
		<div class="youtube__area">
			<div id="player"></div>
		</div>
		<div class="youtube__cover"></div>
		<div class="inner"></div>
	</section>
	</a>
	<div class="movie-section">
	
	<!-- MOVIE CHART -->
  	<div class="movie-wraper">
	<div class="title-bar">
		<div class="menu">
			<ul class="now-movie">
				<li>현재 상영작</li>
			</ul>
		</div>
		<div class="more-movie">
		<a href="movieList.do">더 많은 영화 보기</a>
		</div>
	</div>
	
	<!-- MOVIE TABLE -->
	<div class="container">
	<table border="1" width="800">
	<tbody>
		<c:if test="${empty lists} }">
		<tr>
			<td>
			조회된 영화가 없습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="dto" items="${lists }">
			<tr>
				<td class="rank">1<em>위</em></td>
			</tr>
			<tr>
				<td class="movie-poster">
					<c:url var="contentUrl" value="movieContent.do">
					<c:param name="movie_filename"><img src="/amor/resources/img/" alt="movie_filename" class="poster-img"></c:param>
					</c:url>
				</td>
			</tr>
			<tr>
				<td class="main-info">
					<span class="movie_maxage">${dto.movie_grade }</span>
					<span title="제목" class="movie_name">
					<a href="#">${dto.movie_name }</a></span>
				</td>
			</tr>
			<tr>
				<td class="sub-info">
					<span class="movie_review_star">관람 ${dto.movie_review_star}</span>
					<span class="movie_opendate">개봉일 ${dto.movie_opendate }</span>
				</td>
			</tr>
			<tr>
				<td>
				<a href="ticketing.do">
					<input type="button" value="예매하기" class="ticketingBtn">
				</a>
				</td>
			</tr>
		</c:forEach>
		
	</tbody>
	</table>
	</div>
	 <div class="container">
		<div class="movie-wrapper"></div>
			<div class="rank-movie">
				<div class="rank">
					1
				<span class="rank-txt">위</span>
			</div>
			<div class="movie-list-info">
				<img src="#" class="movie-poster" alt="movie_poster">
			</div>
			<div class="title-area">
				<span class="movie_maxage">
			<img src="/amor/resources/img/movie_maxage_12.png" alt="12세 관람가">
                </span>
                <span title="제목" class="movie_name">제목</span>
            </div>
            <div class="info-area">
                <span class="review-rate">
                    <span class="movie_review">
                        관람평
                    </span>
                </span>
                <span class="movie_opendate">
                    개봉일 2023.09.27
                </span>
            </div>
            <div class="book-btn" >
                <a href="ticketing.do">
                    <button type="button" title="영화 예매하기">예매하기</button>
                </a>
              </div>
        </div>
        </div>
 	</div>
  </div>
 	<!-- PROMOTION BANNER -->
	<section class="notice-inner">
		<div class="ads">
		<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="/amor/resources/img/#.jpg" alt="ads_filename" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
			<div class="swiper-slide">
				<img src="/amor/resources/img/#.jpg" alt="ads_filename" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
			<div class="swiper-slide">
				<img src="/amor/resources/img/#.jpg" alt="ads_filename" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
			<div class="swiper-slide">
				<img src="/amor/resources/img/#.jpg" alt="ads_filename" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
		</div>
		</div>
		<div class="swiper-pagination"></div>
			<div class="swiper-prev">
		     	<span class="material-icons">arrow_back</span>
			</div>
			<div class="swiper-next">
				<span class="material-icons">arrow_forward</span>
			</div>
		</div>
	</section>
		
	<!-- bottom store section -->
	<section class="store-section">
		<div class="left-section">
			<div class="sub-title">
				<span class="store">패키지</span>
				<span class="more">더보기</span>
			</div>
			<div></div>
		</div>
		<div class="right-section">
			<div class="sub-title">
				<span class="store">관람권</span>
				<span class="more">더보기</span>
			</div>
		</div>
	</section>
<%@ include file="../views/user/footer.jsp" %>
</body>
</html>