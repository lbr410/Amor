<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
}
body {
	font-family: 'Nanum Gothic', sans-serif;
	font-size: 16px;
	font-weight: 400;
	line-height: 1.4;
	color: #333333;
}
img {
	display: block;
}
.body-inner {
	width: 1100px;
	margin: 0 auto;
	position: relative;
}

/**GRAY BAR*/
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
    margin-left: 0;
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
    </style>
</head>

<body>
    <%@include file="../header.jsp" %>
   <!--GRAY NAVIGATE BAR-->
    <div class="gray-bar">
        <div class="location">
            <span class="home">Home</span>
            <a href="/amor/movie/movie.do" title="영화 페이지로 이동">영화</a>
            <a href="/amor/movie/movie.do" title="현재 상영작 페이지로 이동">현재 상영작</a>
        </div>
    </div>

</body>
	<%@include file="../footer.jsp" %>
</html>
