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
	
	<!-- MOVIE CHART -->
  	<div class="movie-wraper">
	<div class="title-bar">
		<div class="menu">
			<ul class="now-movie">
				<li>현재 상영작</li>
			</ul>
		</div>
		<div class="more-movie">
		<a href="#">더 많은 영화 보기</a>
		</div>
	</div>
	
	<!-- MOVIE TABLE -->
	<div class="container">
    <table border="1">
        <tfoot>
            <tr>
                <td>페이징 영역</td>
            </tr>
        </tfoot>
        <tbody>
            <c:forEach var="dto" items="${lists}" varStatus="status">
                <c:if test="${status.index % 4 == 0}">
                    <tr>
                </c:if>
                <td>
                    <table border="1">
                        <tbody>
                            <tr>
                                <td class="rank">${dto.rank}<em>위</em></td>
                            </tr>
                            <tr>
                                <td class="movie-poster">
                                    <c:url var="contentUrl" value="movieContent.do">
                                        <c:param name="movie_filename" value="${dto.movie_filename}" />
                                    </c:url>
                                    <img src="${contentUrl}" alt="${dto.movie_filename}" class="poster-img">
                                </td>
                            </tr>
                            <tr>
                                <td class="main-info">
                                    <span class="movie_maxage">${dto.movie_maxage}</span>
                                    <span title="제목" class="movie_name">
                                        <a href="#">${dto.movie_name}</a>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td class="sub-info">
                                    <span class="movie_review_star">관람 ${dto.movie_review_star}</span>
                                    <span class="movie_opendate">개봉일 ${dto.movie_opendate}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="ticketing.do">
                                        <input type="button" value="예매하기" class="ticketingBtn">
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </td>
                <c:if test="${status.index % 4 == 3 or status.last}">
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
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
				<span class="more">더보기</span>
			</div>
			<table class="product">
			  <tr>
			    <td class="product_img"><img src="#" alt="product_img"></td>
			    <td class="product_info">
			      <div class="product_title">상품명</div>
			      <div class="product_price">가격</div>
			    </td>
			  </tr>
			  <tr>
			    <td class="product_img"><img src="#" alt="product_img"></td>
			    <td class="product_info">
			      <div class="product_title">상품명</div>
			      <div class="product_price">가격</div>
			    </td>
			  </tr>
			</table>
		</div>
		<div class="right-section">
			<div class="sub-title">
				<span class="product_store">관람권</span>
				<span class="more">더보기</span>
			</div>
			<table class="product">
			  <tr>
			    <td class="product_img"><img src="#" alt="product_img"></td>
			    <td class="product_info">
			      <div class="product_title">상품명</div>
			      <div class="product_price">가격</div>
			    </td>
			  </tr>
			  <tr>
			    <td class="product_img"><img src="#" alt="product_img"></td>
			    <td class="product_info">
			      <div class="product_title">상품명</div>
			      <div class="product_price">가격</div>
			    </td>
			  </tr>
			</table>
		</div>
	</section>
	<%@ include file="../views/user/footer.jsp" %>
</body>
</html>