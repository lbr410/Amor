<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    
	<!-- MOVIE CHART -->
  	<div class="movie-wraper">
	<div class="title-bar">
		<div class="menu">
			<ul class="now-movie">
				<li>현재 상영작</li>
			</ul>
			<ul class="com-movie">
				<li>상영 예정작</li>
			</ul>
		</div>
		<div class="more-movie">
		<a href="movieList.do">더 많은 영화 보기</a>
		</div>
	</div>
	
</body>
<%@ include file="../footer.jsp" %>
</html>