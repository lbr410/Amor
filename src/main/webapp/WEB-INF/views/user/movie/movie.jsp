<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 현재 상영작</title>
<style>
a{
	text-decoration: none;
	color: 333333;
}
.gray-bar{
    width: 100%;
    height: 14px;
    background-color: #F7F8F9;
    padding: 8px 8px 16px 8px;
    margin-top: 120px;
}
.gray-bar .location{
    width: 1100px;
    margin: 0 auto;
}
.gray-bar .location .home{
    margin-left: 80px;
    color: #666666;
    font-size: 14px;
}
.gray-bar .location a{
    color: #666666;
    text-decoration: none;
        font-size: 14px;
}
.location a::before{
    content: ' >';
    color:#666666;
    display: inline;
    margin-left: 5px;
    margin-right: 5px;
    position: relative;
}
.body-inner{
    width: 1100px;
    margin: 0 auto;
}
.title-bar{
	display: flex;
	width: 1100px;
	padding-top: 128px;
	padding-bottom: 78px;
	justify-content: center;
	align-items: center;
	gap: 600px;
}
.title-bar .menu{
	display: flex;
	width: 357px;
	padding: 10px 0px;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
}
.title-bar .menu .now-movie{
	font-size: 30px;
	color: #333333;
	margin-right: 24px;
}
.title-bar .menu .comming-movie{
	font-size: 24px;
	color: #666666;
}
.movie-section{
	width: 100%;
	hegiht: 870px;
	padding-bottom: 60px;
	margin-bottom: 170px;
}
/*MOVIE TITLE*/
.movie-title{
	width: 980px;
	margin: 0 auto;
	position: relative;
}
.movie-title .title-bar{
	display: flex;
	width: 980px;
	padding-top: 128px;
	padding-bottom: 78px;
	justify-content: center;
	align-items: center;
	gap: 500px;
}
.movie-title .title-bar .menu{
	display: flex;
	width: 357px;
	align-items: center;
	gap: 10px;
	flex-shrink: 0;
}
.movie-section .title-bar .menu .now-movie{
	font-size: 30px;
	color: #333333;
	margin-right: 24px;
}
.movie-section .title-bar .menu .comming-movie{
	font-size: 24px;
	color: #666666;
}
/*MOVIE CHART*/
.container{
  display: grid;
  margin: 0 auto;
  align-items: center;
  box-sizing: border-box;
  gap: 80px 20px;
  grid-template-columns: repeat(4, 230px);
}
.chart{
	width: 980px;
	margin: 0 auto;
	height: auto;
	position: relative;
	margin-bottom: 170px;
}

.rank{
    width: 230px;
    height: 60px;
    text-align: left;
    font-size: 28px;
    font-weight: bold;
}
.movie_poster{
    width: 230px;
    height: 300px;
    border-radius: 5px;
    background-color: #666666;
}
.movie_poster img{
	width: 230px;
    height: 300px;
    overflow:hidden;
    border-radius: 5px;
    background-color: #666666;
}
/* TITLE */
.movie_maxapge{
	width: 34px;
	height: 34px;
}
.movie_maxage img{
	width: 24px;
	height: 24px;
}
.movie_class{
	height: 40px;
	font-weight: bold;
	font-size: 18px;
}
.sub-info{
	height: 40px;
	font-size: 16px;
}
.container .rank-movie .title-area{
    display: inline-block;
    width: 230px;
    height: 34px;
    font-size: 20px;
    padding: 14px 0;
    font-weight: bold;
}
.container rank-movie .title-area .movie-name{
	height: 34px;
}
.container .rank-movie .info-area{
    width: 230px;
    height: 18px;
    padding-bottom: 18px;
}
.container .rank-movie .info-area .movie_audience .rate span ::after{
    content: '|';
    margin-left: 5px;
    color:#333333;
}

button{
    background-color: #1A2C82;
    color: #FFFFFF;
    border: none;
    width: 230px;
    border-radius: 5px;
    text-align: center;
    font-size: 14px;
    font-weight: bold;
    cursor: pointer;
    padding: 18px 0 18px 0;
}
.ticketing-btn .button{
    background-color: #1A2C82;
    color: #FFFFFF;
    border: none;
    height: 48px;
    text-align: center;
    font-size: 14px;
    font-weight: bold;
    cursor: pointer;
    padding: 18px 0 18px 0;
}
</style>
</head>
<%@ include file="../header.jsp" %>
<body>
	<!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="userMovie.do" title="영화 페이지로 이동">영화</a>
            <a href="userMovie.do" title="현재 상영작 페이지로 이동">현재 상영작</a>
        </div>
    </div>
    
    <div class="body-inner">
	   
    </div>
    
	<!-- MOVIE CHART -->
	<div class="movie-section">
	<!-- MOVIE TITLE MENU -->
  	<div class="movie-title">
	<div class="title-bar">
		<div class="menu"><ul class="now-movie"><li>현재 상영작</li></ul></div>
		<div class="">
			<ul id="tabFilter">
                    <li class="on">
                        <a href="#">예매순</a>
                    </li>
                    <li>
                        <a href="">관람평 많은 순</a>
                    </li>
            </ul>
      </div>
	</div>
	
	<!-- MOVIE CHART -->
	<div class="chart">
	<div class="movie_total">총 영화수 </div>
	<div class="container">
	<c:if test="${empty lists }">
	<div>상영중인 영화가 없습니다.</div>
	</c:if>
		<c:forEach var="mdto" items="${lists }">
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <div class="rank"><span class="rank-txt">위</span></div>
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
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">관객수 : ${mdto.movie_audience }</span>
                        </span>
                        <span class="movie_opendate">개봉일 : ${mdto.movie_opendate }</span>
                    </div>
                    <div class="book-btn" >
                        <c:url var="ticketingUrl" value="/amor/ticketing/ticketing.do">
                       		<c:param name="movie_idx">${mdto.movie_idx }</c:param>
                       	</c:url>
                       		<a href="${ticketingUrl}">
                       		 <button type="ticketing-btn" title="영화 예매하기">예매하기</button>
                       		 </a>
                    </div>
                </div>
            </div>
          </c:forEach>
     </div>
	</div>
	</div>
	</div>

</body>
<%@ include file="../footer.jsp" %>
</html>