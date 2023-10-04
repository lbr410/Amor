<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 관람평 보기</title>
<link rel="stylesheet" href="/amor/resources/css/admin/reviewPopup.css">
</head>
<body>
<div class="popupTitle"><label>${dto.member_id }</label>님 관람평</div>
<div class="popupContent">
	<div class="popupImg"><img src="/amor/resources/upload/review/${dto.movie_review_img }" class=img alt="review_img"></div>
	<div class="popupTextDiv">
		<div class="popupText">${dto.movie_review_content }</div>
	</div>
</div>
</body>
</html>