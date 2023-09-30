<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 영화 관리</title>
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script type="text/javascript">


function moviePopUp(idx){
	let movie_idx = idx;
	window.open('moviePopUp.do?movie_idx='+movie_idx,'movieContent','width=570,height=300,top=400,left=1300');
}
function movieUpdate(idx){
	let movie_idx = idx;
	location.href='movieUpdate.do?movie_idx='+movie_idx;
}

function movieDelete(idx){
	let movie_idx = idx;
	location.href='movieDelete.do?movie_idx='+movie_idx;
}

function movieSearch(){
	let result = document.all.movieSearch.value;
	
	if(result == "" || result == null){
		window.alert('검색어2 입력바람');
	}else{
		location.href='movieList.do?search='+result;
	}
}

function movieStateYN(idx) {
	let state = document.getElementsByName('movie_state'+idx)[0].value;
	let param = 'idx='+idx+'&state='+state;
	sendRequest('stateChk.do',param, null, 'POST');
}

</script>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/movieList.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">영화 목록</label>
<div class="contentsearch">
	<div class="search">
		<input type="text" name="movieSearch" placeholder="영화제목을 검색해주세요." class="box">
		<img src="img/Icon_Search.png" class="btn" onclick="movieSearch()">
	</div>
</div>
</div>
<div class="contentMain">
<div class="tableDiv">
<div class="table">
	<table class="commonTable">
	<thead>
	<tr>
		<th>영화번호</th>
		<th>제목</th>
		<th>감독</th>
		<th>배우</th>
		<th>장르</th>
		<th>국적</th>
		<th>연령제한</th>
		<th>러닝타임</th>
		<th>관객수</th>
		<th>줄거리</th>
		<th>상영상태</th>
		<th>평점</th>
		<th>포스터이미지</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="15"><div class="paging">${pageStr}</div></td>
		</tr>
	</tfoot>
	<tbody>
	<c:if test="${empty lists }">
		<tr>
			<td colspan="15">없음</td>
		</tr>
	</c:if>
	
	<c:forEach var="dto" items="${lists }">
		<tr>
			<td>${dto.movie_idx }</td>
			<td>${dto.movie_name}</td>
			<td>${dto.movie_god }</td>
			<td>${dto.movie_actor }</td>
			<td>${dto.movie_genre }</td>
			<td>${dto.movie_country }</td>
			<td><c:if test="${0==dto.movie_maxage}">ALL</c:if>
				<c:if test="${1==dto.movie_maxage}">12</c:if>
				<c:if test="${2==dto.movie_maxage}">15</c:if>
				<c:if test="${3==dto.movie_maxage}">19</c:if>
			</td>
			<td>${dto.movie_runningtime }분</td>
			<td>${dto.movie_audience }명</td>
			<td><a href="javascript:moviePopUp(${dto.movie_idx})">[줄거리보기]</a></td>
			<td><select name="movie_state${dto.movie_idx}" class="soldOutSel" onchange="movieStateYN(${dto.movie_idx})">
					<option value="y" <c:if test="${dto.movie_state eq 'y'}">selected</c:if>>Y</option>
					<option value="n" <c:if test="${dto.movie_state eq 'n'}">selected</c:if>>N</option>
				</select></td>
			<td>10.0??</td>
			<td><img src="/amor/resources/upload/movie/${dto.movie_poster}" class="posterImg" alt="포스터 이미지"></td>
			<td><input class="btn_movie" type="button" value="수정" onclick="movieUpdate(${dto.movie_idx})"></td>
			<td><input class="btn_movie" type="button" value="삭제" onclick="movieDelete(${dto.movie_idx})"></td>
		</tr>
	</c:forEach>

	</tbody>
	</table>
	</div>
</div>
</div>
</div>
</body>
</html>