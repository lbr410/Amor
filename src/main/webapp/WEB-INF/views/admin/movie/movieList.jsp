<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function moviePopUp(){
	window.open('moviePopUp.do','movieContent','width=570,height=300,top=400,left=1300');
}
function movieUpdate(){
	location.href='movieUpdate.do';
}
</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">회원 조회</label>
<div class="contentsearch">
	<div class="search">
		<input type="text"  placeholder="아이디를 검색해주세요." class="box">
		<img src="img/Icon_Search.png" class="btn">
	</div>
</div>
</div>
<div class="contentMain">
<div class="table">
	<table>
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
	<tbody>
	<tr>
		<td>1</td>
		<td>오펜하이머</td>
		<td>이수민</td>
		<td>안재영,우선철,송준</td>
		<td>로맨스</td>
		<td>필리핀</td>
		<td>19</td>
		<td>200분</td>
		<td>1,100,000명</td>
		<td><a href="javascript:moviePopUp()">[줄거리보기]</a></td>
		<td>Y</td>
		<td>10.0</td>
		<td>test.png</td>
		<td><input type="button" value="수정" onclick="movieUpdate()"></td>
		<td><input type="button" value="삭제"></td>
		
	</tr>
	</tbody>
	</table>
</div>
</div>
</div>
</body>
</html>