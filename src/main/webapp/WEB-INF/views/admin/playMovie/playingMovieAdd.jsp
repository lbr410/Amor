<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르: 상영영화등록</title>
<style>
table {
	margin: 30px auto;
	width : 400px;
	height: 600px;
	table-layout: fixed;	
}

table td {
	text-align: center;
}

.nextBtn { // 파란버튼
   border:none;
   padding: 2px 21px 6px 21px;
   width: 150px;
   height: 40px;
   border-radius: 3px;
   background: #1A2C82;
   color: #C7E3FF;
   cursor: pointer;
}

.cancelBtn { // 회색버튼
   border:none;
   padding: 2px 21px 6px 21px;
   width: 150px;
   height: 40px;
   border-radius: 3px;
   background: #EEEEEE;
   color: #1A2C82;
   cursor: pointer;
}

</style>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">상영 시간 등록</label>
</div>
<div class="contentMain">
<div class="table">
<section>
	<article>
	<form name="playingMovieAdd" action="playingMovieAdd.do" method="post">
		<table>
			<tr>
				<td>상영 영화 선택</td>
				<td><select name="movie_idx">
				<c:if test="${empty movieLists }">
					<option selected disabled>등록된 영화가 없습니다.</option>				
				</c:if>
				<c:forEach var="map" items="${movieLists }">
					<option value="${map.MOVIE_IDX}" name="movie_idx">${map.MOVIE_NAME}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>상영 스크린 선택</td>
				<td><select name="theater_idx">
				<c:if test="${empty screenLists }">
					<option selected disabled>등록된 상영관이 없습니다.</option>				
				</c:if>
				<c:forEach var="map" items="${screenLists }">
					<option value="${map.THEATER_IDX}" name="theater_idx">${map.THEATER_NAME}</option>
				</c:forEach>
				</select></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="상영 등록" class="nextBtn">&nbsp;&nbsp;
				<input type="reset" value="다시 작성" class="cancelBtn"></td>
			</tr>
		</table>
	</form>
	</article>
</section>
</div>
</div>
</div>
</body>
</html>