<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<ul class="comming-movie">
				<li>상영 예정작</li>
			</ul>
		</div>
		<div class="more-movie">
		<a href="#">더 많은 영화 보기</a>
		</div>
	</div>
	<!-- table -->
	 <div class="container">
		<div class="movie-wrapper"></div>
			<div class="rank-movie">
				<div class="rank">
					1
				<span class="rank-txt">위</span>
			</div>
			<div class="movie-list-info">
				<img src="#" class="movie-poster">
			</div>
			<div class="title-area">
				<span class="movie-grade">
			<img src="#" alt="12세 관람가">
                </span>
                <span title="제목" class="title">제목</span>
            </div>
            <div class="info-area">
                <span class="review-rate">
                    <span class="rate">
                        관람평 %
                    </span>
                </span>
                <span class="date">
                    개봉일 2023.09.27
                </span>
            </div>
            <div class="book-btn" >
                <a href="#">
                    <button type="button" title="영화 예매하기">예매하기</button>
                </a>
              </div>
        </div>
        </div>
 	</div>
  </div>
 	<!-- PROMOTION BANNER -->
	<section class="notice-inner">
		<div class="promotion">
		<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="./image/promotion_slide1.jpg" alt="노크, 깨어날 수 없는 악몽의 시작" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
			<div class="swiper-slide">
				<img src="./image/promotion_slide1.jpg" alt="노크, 깨어날 수 없는 악몽의 시작" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
			<div class="swiper-slide">
				<img src="./image/promotion_slide1.jpg" alt="노크, 깨어날 수 없는 악몽의 시작" />
				<a href="#" class="btn">자세히 보기</a>
			</div>
			<div class="swiper-slide">
				<img src="./image/promotion_slide1.jpg" alt="노크, 깨어날 수 없는 악몽의 시작" />
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
			<h3>패키지</h3>
		</div>
		</div>
	</section>

<%@ include file="../views/user/footer.jsp" %>
</body>
</html>