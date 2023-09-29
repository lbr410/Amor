<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 영화 상세</title>
<link rel="stylesheet" href="/amor/resources/css/user/movieContent.css"></link>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script>
$(document).ready(function(){
  $('.tabcontent > div').hide();
  $('.tabnav li:first-child a').addClass('active');
  $('.tabcontent > div:first-child').show();

  $('.tabnav a').click(function(e) {
    e.preventDefault();
    var target = $(this).attr('href');
    $('.tabnav a').removeClass('active');
    $(this).addClass('active');
    $('.tabcontent > div').hide();
    $(target).fadeIn();
  });
});
</script>
</head>
<%@ include file="../header.jsp" %>
<body>
<!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="/amor/movie/movie.do" title="영화 페이지로 이동">영화</a>
            <a href="/amor/movie/movie.do" title="현재 상영작 페이지로 이동">현재 상영작</a>
        </div>
    </div>
   <div class="body-inner"></div>
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
                        <span class="txt-time">${dto.movie_runningtime }
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
                </li>
                <li>
                	<span class="movie_audience">
                		관객수 : ${dto.movie_audience }
                	</span>
                </li>
            </ul>
            <br>
            <div class="movie_content">
                    <textarea class="content" style="overflow-y:scroll;" readonly>
                    ${dto.movie_content }
                    </textarea>
            </div>
            <div class="btn-wrap">
                <button class="blue-btn">예매하기</button>
            </div>
            </div>
        </div>
    </div>
    <section class="movie-detail">
	  <div class="tab">
	    <ul class="tabnav">
	      <li><a href="#tab01" class="btn">탭1</a></li>
	      <li><a href="#tab02" class="btn">탭2</a></li>
	    </ul>
	    <div class="tabcontent">
	      <div id="tab01">tab1 content</div>
	      <div id="tab02">tab2 content</div>
	    </div>
  	</div><!--tab-->
   </section>
</body>
<%@ include file="../footer.jsp" %>
</html>