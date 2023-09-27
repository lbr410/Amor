<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르: 상영영화리스트</title>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">회원 조회</label>
</div>
<div class="contentMain">
<div class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>상영 날짜</th>
		<th>시작 시간</th>
		<th>상영 스크린</th>
		<th>상영 중인 영화 이름</th>
		<th>수정 및 삭제</th>
	</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="4"> ${playpageStr }</td>
		</tr>
	</tfoot>
	<tbody>
		<c:if test="${empty lists }">
			<tr>
			<td colspan="4">등록된 상영 영화가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${lists }">
			<tr>
			<td>${dto.playing_movie_date }</td>
			<td>${dto.playing_movie_start }</td>
			<td>${dto.theater_name }</td>
			<td>${dto.movie_name }</td>
			<td><input type="button" value="수정" onclick="location.href='playingMovieUpdate.do?playing_movie_idx=${dto.playing_movie_idx}'">
				<input type="button" value="삭제" onclick="location.href='playingMovieDelete.do?playing_movie_idx=${dto.playing_movie_idx}'"></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>