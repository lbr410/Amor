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
   <div id="movie-section" class="movie-content" style="margin-top: 120px;">
        <div class="movie-wrap">
            <div class="movie-poster">
                <div class="movie-img">
                    <img class src="../" alt="movie poster">
                </div>
            </div>
            <div class="right-section">
            <div class="title-info">
                <div class="movie_name">잠</div> 
            </div>
            <ul class="movie-info">
                <li>
                    <p>
                    <span class="movie_opendate">2023.09.06 개봉</span>
                    </p>
                </li>
                <li>
                    <span class="movie_runningtime">
                        <p>
                        <span class="icon-clock">
                            <img src="#">
                        </span>
                        <span class="txt-time">
                            94
                        </span>
                        <em>분  </em>
                        </p>
                    </span>
                </li>
                <li>
                    <span class="movie_maxage">
                        <span class="txt-gr">
                            15
                            <em>세 이상 관람가</em>
                        </span>
                    </span>
                </li>
            </ul>
            <br>
            <div class="movie_content">
                <div class="txtarea">
                    <span>
                        내용
                    </span>
                </div>
            </div>
            <div class="btn-wrap">
                <button class="btn">예매하기</button>
            </div>
            </div>
        </div>
    </div>
</body>
<%@ include file="../footer.jsp" %>
</html>