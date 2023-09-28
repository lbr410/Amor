<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/amor/resources/css/user/index.css" />
<!--Google Material Icons-->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
<script defer src="/amor/resources/js/youtube.js"></script>
<script defer src="/amor/resources/js/index.js"></script>
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
	
	<!-- MOVIE TITLE MENU -->
  	<div class="movie-title">
	<div class="title-bar">
		<div class="menu"><ul class="now-movie"><li>현재 상영작</li></ul></div>
		<div class="more-movie"><a href="/amor/movie/moreMovie.do">더 많은 영화 보기</a></div>
	</div>
	
	<!-- MOVIE CHART -->
	<div class="chart">
	<div class="container">
	<c:if test="${empty mlists }">
	<div class="nomovie">상영중인 영화가 없습니다.</div>
	</c:if>
		<c:set var="rank" value="1" />
		<c:forEach var="mdto"  items="${mlists }" begin="1" end="4" >
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <div class="rank">${rank }<span class="rank-txt">위</span></div>
                    <div class="movie_poster">
                   	 	<c:url var="MovieContentUrl" value="/amor/movie/movieContentForm.do">
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
           </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                                관객수 ${mdto.movie_audience }<em>명 | </em>
                            </span>
                        </span>
                        <span class="date">
                            개봉일 ${mdto.movie_opendate }
                        </span>
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
                <c:set var="rank" value="${rank+1 }" />
          </c:forEach>
          </div>
     </div>
</div> 
</div>

 	<!-- PROMOTION BANNER -->
	<section class="navi">
    <div class="promotion">
      <div class="swiper-container">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <img src="/amor/resources/img/promotion_slide1.jpg" alt="ads_filename" />
          </div>
          <div class="swiper-slide">
            <img src="/amor/resources/img/promotion_slide2.jpg" alt="ads_filename" />
          </div>
          <div class="swiper-slide">
				<img src="/amor/resources/img/promotion_slide3.jpg" alt="ads_filename" />
          </div>
        </div>
      </div>
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
				<span class="product_store">패키지</span>
				<span class="more"><a href="/amor/store.do">더보기</a></span>
			</div>
			<table class="product">
			<c:forEach var="pdto"  items="${slists }" begin="1" end="2">
			  <tr>
			    <td class="product_img">
			    	<c:url var="storeContentUrl" value="store/storeContentForm.do">
			    		<c:param name="product_idx">${pdto.product_idx }</c:param>
			    	</c:url>
			    	<a href="${storeContentUrl }"><img src="/amor/resources/upload/store/${pdto.product_img }" alt="스토어"></a>
			    </td>
			    <td class="product_info">
			      <div class="product_title">${pdto.product_title }</div>
			      <div class="product_price">${pdto.product_price }</div>
			    </td>
			  </tr>
			  </c:forEach>
			</table>
		</div>
		<div class="right-section">
			<div class="sub-title">
				<span class="product_store">관람권</span>
				<span class="more"><a href="/amor/store.do">더보기</a></span>
			</div>
			<table class="product">
			<c:forEach var="tdto"  items="${tlists }" begin="1" end="2">
			  <tr>
			    <td class="product_img">
				    <c:url var="storeContentUrl" value="store/storeContentForm.do">
				    	<c:param name="product_idx">${tdto.product_idx }</c:param>
			    	</c:url>
			    	<a href="${storeContentUrl }"><img src="/amor/resources/upload/store/${tdto.product_img }" alt="관람권"></a>
			    </td>
			    <td class="product_info">
			      <div class="product_title">${tdto.product_title }</div>
			      <div class="product_price">${pdto.product_price }</div>
			    </td>
			  </tr>
			  </c:forEach>
			</table>
		</div>
	</section>
	<%@ include file="../views/user/footer.jsp" %>
</body>
</html>