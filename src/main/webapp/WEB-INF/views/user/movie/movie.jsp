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
</body>
<%@ include file="../footer.jsp" %>
</html>