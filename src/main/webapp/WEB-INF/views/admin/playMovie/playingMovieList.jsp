<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 상영 영화 목록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/playingMovieList.css">
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>
document.addEventListener("DOMContentLoaded", function() {
    show();
});

function show(aaa) {
	let selectMovie = document.getElementById('movieName');
	let movie_idx = selectMovie.options[selectMovie.selectedIndex].value;
	let cp = aaa;
	if (cp == undefined) {
		cp = 1;
	}
	let param = 'movie_idx='+movie_idx+'&cp='+cp;
	sendRequest ('playingMovieList2.do',param,showResult,'GET');

}
function showResult() {
	if (XHR.readyState==4) {
		if (XHR.status==200){
		
			let data=XHR.responseText;
			let objdata=JSON.parse(data);
			let playingList = objdata.lists;
			let str = '';
			
			for (let i=0;i<playingList.length;i++) {
				let dto = playingList[i];
				str += '<tr><td>'+dto.playing_movie_date+'</td>\n<td>'
				+dto.playing_movie_start+'</td>\n<td>'+dto.theater_name
				+'</td>\n<td>'+dto.movie_name+'</td><td><input type="button" class="smallBtn" value="수정" onclick="location.href=\'playingMovieUpdate.do?playing_movie_idx='
				+dto.playing_movie_idx+'\'">&nbsp;<input type="button" class="smallBtn" value="삭제" onclick="location.href=\'playingMovieDelete.do?playing_movie_idx='
				+dto.playing_movie_idx+'\'"></td></tr>';
			}

			let trTag = document.getElementById('playingMovieList');
			
			if (str == '') {
				str = '<td colspan="5">등록된 상영영화가 없습니다.</td>'
			}
			
			trTag.innerHTML = str;
			
			let pageList = objdata.playingMoviepageStr;
			let divTag = document.getElementById('paging');
			
			if (str == '<td colspan="5">등록된 상영영화가 없습니다.</td>') {
				divTag.innerHTML = '';
			} 
			if (str != '<td colspan="5">등록된 상영영화가 없습니다.</td>') {
				divTag.innerHTML = pageList;
			} 
		}
	}
	
}

</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">상영 영화 목록</label>
<select class="box" id="movieName" onchange="show()">
		<option value="aa">모두보기</option>
	<c:forEach var="mdto" items="${movieList }" begin = "1" end = "${movieList.size() }" step = "1">
		<option value="${mdto.MOVIE_IDX }">${mdto.MOVIE_NAME}</option>
	</c:forEach>
</select>
</div>
<div class="contentMain">
<div id="tableDiv" class="tableDiv">
	<table class="commonTable">
	<thead>
	<tr>
		<th>상영 날짜 </th>
		<th>시작 시간</th>
		<th>상영 스크린</th>
		<th>상영 중인 영화 이름</th>
		<th>수정 및 삭제</th>
	</tr>
	</thead>
	<tbody id="playingMovieList">
	</tbody>
	</table>
		<div class="paging" id="paging"></div>
</div>
</div>
</div>
</body>
</html>