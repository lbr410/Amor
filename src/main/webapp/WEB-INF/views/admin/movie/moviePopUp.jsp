<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 영화 줄거리</title>
<link rel="stylesheet" href="/amor/resources/css/admin/moviePopUp.css">
</head>
<body>
<h1>영화 줄거리</h1>
<hr id="moviePopuphr">
<h2>${dto.movie_name }</h2>
<br>
${movieContent }
</body>
</html>