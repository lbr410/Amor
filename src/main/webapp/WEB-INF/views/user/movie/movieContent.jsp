<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/movieConent.css"></link>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' 0,
  'opsz' 24
}
.meterial-icons{
	width: 24px;
	height: 24px;
}
</style>
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
                <div class="movie_name">${dto.movie_name }</div> 
            </div>
            <ul class="movie-info">
                <li><p><span class="movie_opendate">2023.09.06 개봉</span></p></li>
                <li><span class="movie_runningtime"><p>
                        <span class="material-icons">schedule</span>
                        <span class="txt-time">${movie_runningtime }
                        </span>
                        <em>분  </em>
                        </p>
                    </span>
                </li>
                <li>
                    <span class="movie_maxage">
                            <c:if test="${0==dto.movie_maxage}"><img src="/amor/resources/img/maxage_all.png" alt="ALL"></c:if>
							<c:if test="${1==dto.movie_maxage}"><img src="/amor/resources/img/maxage_12.png" alt="12세 관람가"></c:if>
							<c:if test="${2==dto.movie_maxage}"><img src="/amor/resources/img/maxage_15.png" alt="15세 관람가"></c:if>
							<c:if test="${3==dto.movie_maxage}"><img src="/amor/resources/img/maxage_18.png" alt="18세 관람가"></c:if>
                    </span>
                            <em>세 이상 관람가</em>
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