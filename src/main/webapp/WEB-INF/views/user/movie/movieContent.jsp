<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/movieConent.css"></link>
</head>
<%@ include file="../header.jsp" %>
<body>
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
                    <a href="">상영 예정작</a>
                </li>
            </ul>
            <div class="filter-select">
                <ul id="tabFilter">
                    <li class="on">
                        <a href="#">예매순</a>
                    </li>
                    <li>
                        <a hreef="">관람평 많은 순</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="movie-wrapper"></div>
            <div class="rank-movie">
                <div class="rank">
                    1
                    <span clas="rank-txt">위</span>
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
</body>
<%@ include file="../footer.jsp" %>
</html>