<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 현재 상영작</title>
<style>
.movie-section{
	width: 100%;
	hegiht: 870px;
	padding-bottom: 60px;
	margin-bottom: 170px;
	background-color: #F8F9FA;
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
	gap: 480px;
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
  gap: 20px;
  grid-template-columns: repeat(4, 230px);
}
.chart{
	width: 980px;
	margin: 0 auto;
	position: relative;
	margin-bottom: 170px;
}

.rank{
    width: 230px;
    height: 60px;
    text-align: left;
    font-size: 30px;
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
.main-info{
	height: 40px;
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
    width: 230px;
    height: 34px;
    font-size: 20px;
    padding: 14px 0;
    font-weight: bold;
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
.book-btn .button{
    background-color: #1A2C82;
    color: #FFFFFF;
    border: none;
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
            <a href="#" title="영화 페이지로 이동">영화</a>
            <a href="#" title="현재 상영작 페이지로 이동">현재 상영작</a>
        </div>
    </div>
    
    	<div class="body-inner">
	        <div class="tab-select">
            <ul id="tabMenu">
                <li class="on">
                    <a href="#">현재 상영작</a>
                </li>
                <li>
                    <a hreef="">상영 예정작</a>
                </li>
            </ul>
            <div class="filter-select">
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
    </div>
    
	<!-- MOVIE CHART -->
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
		<c:forEach var="mdto" begin="1" end="16" >
            <div class="movie-wrapper">
                <div class="rank-movie">
                    <div class="rank"><span class="rank-txt">위</span></div>
                    <div class="movie_poster"></div>
                    <div class="title-area">
                        <span class="movie_maxage">
                        ALL</span>
                        <span title="제목" class="movie_name">제목</span>
                    </div>
                    <div class="info-area">
                        <span class="movie_audience">
                            <span class="rate">
                                관람객 수 명
                            </span>
                        </span>
                        <span class="date">
                            개봉일
                        </span>
                    </div>
                    <div class="book-btn" >
                        <a href="/amor/ticketing/ticketing.do">
                            <button type="button" title="영화 예매하기">예매하기</button>
                        </a>
                    </div>
                </div>
            </div>
          </c:forEach>
     </div>
</div>
</div>


</body>
<%@ include file="../footer.jsp" %>
</html>