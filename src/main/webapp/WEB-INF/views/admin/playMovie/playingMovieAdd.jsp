<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 상영 시간 등록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/playingMovieAddUp.css">
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>

function show() {
	let movie_idx = document.getElementById('movieRunning').value;
	let param = 'movie_idx='+movie_idx;
	sendRequest ('movieRunning.do',param,showResult,'GET');

}
function showResult() {
	if (XHR.readyState==4) {
		if (XHR.status==200){
			let data=XHR.responseText;
			let objdata=JSON.parse(data);
			let movieRunning = objdata.running;
			
			let movieStart = document.getElementById('movieStart').value
			let movieDate = document.getElementById('movieDate').value
			
			let movieYear = parseInt(movieDate.substring(0,5));
			let movieMonth = parseInt(movieDate.substring(5,7))-1;
			let movieDay = parseInt(movieDate.substring(8,10));
			let runTimeHH = parseInt(movieStart.substring(0,2));
			let runTimeMM = parseInt(movieStart.substring(3,5));
			let movieRun = parseInt(movieRunning.MOVIE_RUNNINGTIME);
			
			let movieEnd = new Date (movieYear, movieMonth, movieDay, runTimeHH, runTimeMM, 0);
			
			movieEnd.setMinutes(movieEnd.getMinutes() + movieRun); 
			
			let movieEndHH = ('0'+movieEnd.getHours()).slice(-2);
			let movieEndMM = ('0'+movieEnd.getMinutes()).slice(-2);	
		
			document.getElementById('movieEnd').value = movieEndHH+':'+movieEndMM+':'+'00';
			
		}
	}
	
}
</script>
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
				<td class="playAdd" id="playAdd3">상영 영화 선택</td>
				<td class="playAdd">
				<select name="movie_idx" class="playAddInput2" id="movieRunning" onchange="show()">
				<c:if test="${empty movieLists }">
					<option selected disabled>등록된 영화가 없습니다.</option>				
				</c:if>
				<c:forEach var="map" items="${movieLists }">
					<option value="${map.MOVIE_IDX}" name="movie_idx">${map.MOVIE_NAME}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="playAdd" id="playAdd3">상영 스크린 선택</td>
				<td class="playAdd">
				<select name="theater_idx" class="playAddInput2">
				<c:if test="${empty screenLists }">
					<option selected disabled>등록된 상영관이 없습니다.</option>				
				</c:if>
				<c:forEach var="map" items="${screenLists }">
					<option value="${map.THEATER_IDX}" name="theater_idx">${map.THEATER_NAME}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="playAdd" id="playAdd3">상영 날짜 선택</td>
				<td class="playAdd"><input type="date" name="playing_movie_date" class="playAddInput" id="movieDate" required></td>
			</tr>
			<tr>
				<td class="playAdd" id="playAdd3">상영 시간</td>
				<td class="playAdd">
				<input type="time" name="playing_movie_start" class="playAddInput" id="movieStart" onchange="show()" required>&nbsp;&nbsp;~&nbsp;&nbsp;
				<input type="time" name="playing_movie_end" value="" class="playAddInput" id="movieEnd" readonly>
				</td>
			</tr>
			<tr>
				<td class="playAddBtn" colspan="2"><input type="submit" value="상영 등록" class="nextBtn">&nbsp;&nbsp;
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