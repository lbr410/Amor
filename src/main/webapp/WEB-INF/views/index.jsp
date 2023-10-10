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

<script defer src="/amor/resources/js/index.js"></script>
<title>Amor Cinema</title>
<script>
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

function onYouTubePlayerAPIReady() {
  // <div id="player"></div>
  new YT.Player('player', {
    videoId: '${blists[0].banner_source}', // 최초 재생할 유튜브 영상 ID
    playerVars: {
      autoplay: true, // 자동 재생 유무
      loop: true, // 반복 재생 유무
      playlist: '${blists[1].banner_source}' // 반복 재생할 유튜브 영상 ID 목록
    },
    events: {
      // 영상이 준비되었을 때,
      onReady: function (event) {
        event.target.mute() // 음소거!
      }
    }
  })
}

</script>
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
		<div class="more-movie"><a href="/amor/movie/movie.do">더 많은 영화 보기</a></div>
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
           			</div>
                     <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                            <span class="material-icons">star</span> ${mdto.avg_movie_review_star} &nbsp;
                            </span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${mdto.movie_opendate }</span>
                    </div>
                    <div class="book-btn" >
                     	<a href="/amor/ticketing/ticketing.do">
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
            <img src="/amor/resources/upload/ads/${alists[0].ads_filename }" alt="ads_filename" />
          </div>
          <div class="swiper-slide">
            <img src="/amor/resources/upload/ads/${alists[1].ads_filename }" alt="ads_filename" />
          </div>
          <div class="swiper-slide">
            <img src="/amor/resources/upload/ads/${alists[2].ads_filename }" alt="ads_filename" />
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
			    	<a href="${storeContentUrl }"><img src="/amor/resources/upload/product/${pdto.product_img }" alt="스토어"></a>
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
			    	<a href="${storeContentUrl }"><img src="/amor/resources/upload/product/${tdto.product_img }" alt="관람권"></a>
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