<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 영화 등록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/movieAdd.css">
<script type="text/javascript">
function moviePreview(input,num){
	let movieImgId = 'moviePreview'+num;
	
	if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	    	document.getElementById(movieImgId).src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById(movieImgId).src = "";
	  }
}
//러닝타임 숫자만 입력받게
function checkNumber(event) {
	if(event.key >= 0 && event.key <= 9) {
	    return true;
	}
	return false;
}

</script>
</head>
<body>
<%@include file="../admin_header.jsp" %><!-- 질문 -->
<div class="content">
<div class="content-title"><label class="titletext">영화 등록</label>
</div>
<div class="contentMain">

<div class="movieAddbox">
	<form name="movieAdd" action="movieAdd.do" class="movieAddform" method="post" enctype="multipart/form-data">
		<div class="movieAddImgDiv">
			<div id="moviePosterDiv">
				<div class="moviePosterImg"><img id="moviePreview0"></div>
				<label for="btn_movieposter"><div class="btn_moviePimg">이미지 선택</div></label><input id="btn_movieposter" type="file" name="movie_poster" onchange="moviePreview(this,0);">
			</div>
			<div id="movieStillCutDiv">
				<div id="movieStillCutDivPart1">
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg"><img id="moviePreview1"></div><label for="btn_movieSt1"><div class="btn_movieSimg">스틸컷1</div></label><input id="btn_movieSt1" type="file" name="movie_stillcut1" onchange="moviePreview(this,1);"></div>
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg"><img id="moviePreview2"></div><label for="btn_movieSt2"><div class="btn_movieSimg">스틸컷2</div></label><input id="btn_movieSt2" type="file" name="movie_stillcut2" onchange="moviePreview(this,2);"></div>
					<div class="movieStillCutImgandbutton1"><div class="movieStillCutImg"><img id="moviePreview3"></div><label for="btn_movieSt3"><div class="btn_movieSimg">스틸컷3</div></label><input id="btn_movieSt3" type="file" name="movie_stillcut3" onchange="moviePreview(this,3);"></div>
				</div>
				<div id="movieStillCutDivPart2">
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg"><img id="moviePreview4"></div><label for="btn_movieSt4"><div class="btn_movieSimg">스틸컷4</div></label><input id="btn_movieSt4" type="file" name="movie_stillcut4" onchange="moviePreview(this,4);"></div>
					<div class="movieStillCutImgandbutton"><div class="movieStillCutImg"><img id="moviePreview5"></div><label for="btn_movieSt5"><div class="btn_movieSimg">스틸컷5</div></label><input id="btn_movieSt5" type="file" name="movie_stillcut5" onchange="moviePreview(this,5);"></div>
				</div>
			</div>
		</div>
		<div class="movieAddTextDiv">
			<table id="movieAddTextDivTable">
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
					<td><select name="movie_maxage">
						<option value="0">ALL</option>
						<option value="1">12세 이상 시청</option>
						<option value="2">15세 이상 시청</option>
						<option value="3">18세 이상 시청</option></select></td>
				</tr>
				<tr>
					<th>개봉날짜</th><td><input type="date" name="movie_opendate" placeholder="개봉 날짜를 입력해주세요" required="required"></td>
				</tr>
				<tr>	
					<th>러닝타임</th><td><input type="text" name="movie_runningtime" placeholder="러닝타임을 입력해주세요(단위 : 분)" required="required" onkeypress="return checkNumber(event)"></td>
				</tr>
				<tr>
					<th>국적</th><td><input type="text" name="movie_country" placeholder="국적을 입력해주세요" required="required"></td>
				</tr>
				<tr>
					<th>줄거리</th><td><textarea name="movie_content" rows="15" cols="40" placeholder="내용을 입력해주세요" required="required"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" class="movieAddSumit"><input type="button" value="취소" onclick="location.href='/amor/admin/movie/movieList.do'"> &nbsp; <input type="submit" value="저장"> </td>
				</tr>
			
			</table>
		</div>
	</form>
</div>


</div>
</div>
</body>
</html>