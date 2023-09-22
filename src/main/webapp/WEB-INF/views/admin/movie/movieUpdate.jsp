<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amor 관리자 : 영화 등록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/movieUpdate.css">
</head>
<body>
<%@include file="../admin_header_notable.jsp" %><!-- 질문 -->
<div class="content">
<div class="content-title"><label class="titletext">영화 수정</label>
</div>
<div class="contentMain">

<div class="movieUpdatebox">
	<form name="movieUpdate" action="movieUpdate.do" class="movieUpdateform" enctype="multipart/form-data">
		<div class="movieUpdateImgDiv">
			<div id="moviePosterDiv">
				<div class="moviePosterImg">포스터이미지</div>
				<input type="file" name="movie_poster">
			</div>
			<div id="movieStillCutDiv">
				<div id="movieStillCutDivPart1">
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg">스틸컷이미지1</div><input type="file" name="movie_stillcut1"></div>
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg">스틸컷이미지2</div><input type="file" name="movie_stillcut2"></div>
					<div class="movieStillCutImgandbutton1"><div class="movieStillCutImg">스틸컷이미지3</div><input type="file" name="movie_stillcut3"></div>
				</div>
				<div id="movieStillCutDivPart2">
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg">스틸컷이미지4</div><input type="file" name="movie_stillcut4"></div>
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg">스틸컷이미지5</div><input type="file" name="movie_stillcut5"></div>
				</div>
			</div>
		</div>
		<div class="movieUpdateTextDiv">
			<table id="movieUpdateTextDivTable">
				<tr>
					<th>영화제목</th><td><input type="text" name="movie_name" placeholder="영화 제목을 입력해주세요" required="required"></td>
				</tr>
				<tr>
					<th>장르</th>
					<td><select name="movie_genre" ><option value="공포">공포</option>
						<option value="로맨스">로맨스</option>
						<option value="뮤지컬">뮤지컬</option>
						<option value="스포츠">스포츠</option>
						<option value="액션">액션</option>
						<option value="전쟁">전쟁</option>
						<option value="코미디">코미디</option>
						<option value="판타지">판타지</option>
						<option value="SF">SF</option></select>
					</td>
				</tr>
				<tr>
					<th>감독</th><td><input type="text" name="movie_god" placeholder="감독을 입력해주세요" required="required"></td>
				</tr>
				<tr>
					<th>배우</th><td><input type="text" name="movie_actor" placeholder="배우를 입력해주세요" required="required"></td>
				</tr>
				<tr>
					<th>연령제한</th>
					<td><select name="movie_maxage"><option value="0">ALL</option>
						<option value="1">12세 이상 시청</option>
						<option value="2">15세 이상 시청</option>
						<option value="3">18세 이상 시청</option></select></td>
				</tr>
				<tr>
					<th>개봉날짜</th><td><input type="text" name="movie_opendate" placeholder="개봉 날짜를 입력해주세요" required="required"></td>
				</tr>
				<tr>	
					<th>러닝타임</th><td><input type="text" name="movie_runningtime" placeholder="러닝타임을 입력해주세요(단위 : 분)" required="required"></td>
				</tr>
				<tr>
					<th>국적</th><td><input type="text" name="movie_country" placeholder="국적을 입력해주세요" required="required"></td>
				</tr>
				<tr>
					<th>줄거리</th><td><textarea name="movie_content" rows="15" cols="40" placeholder="내용을 입력해주세요" required="required"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" class="movieUpdateSumit"><input type="submit" value="수정"> </td>
				</tr>
			
			</table>
		</div>
	</form>
</div>


</div>
</div>
</body>
</html>