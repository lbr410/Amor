<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	
	body{
	width: 1100px;
	}
	
	div{
		margin-top: 200px;
		margin-left: 550px;
	}
	
	img {
		width: 200px;
		margin-bottom: 10px;
	}
	
	span{
	font-size: 14px;
	}
	.text1{
		width:200px;
		height: 35px;
		border: 1.5px solid #d9d9d9;
		border-radius: 3px;
		border-color: #1A2C82;
		padding-left: 5px;
		margin-bottom: 10px;
	}
	
	.text2{
		width:200px;
		height: 35px;
		border: 1.5px solid #d9d9d9;
		border-radius: 3px;
		border-color: #1A2C82;
		padding-left: 5px;
		margin-bottom: 5px;
	}
	
	.button{
		width:210px;
		height: 35px;
		border:none;
		padding: 2px 21px 6px 21px;
		border-radius: 3px;
		background: #1A2C82;
		color: #C7E3FF;
		cursor: pointer;
	}
	
	
</style>
<body>
<div>
<img src="/amor/resources/img/main_logo.png">
<form name = "admin" action = "/amor/admin/adminMain.do">
<input type = "text" name = "admin_id" class = "text1" placeholder="아이디를 입력하세요."><br>
<input type = "password" name = "admin_pwd" class = "text2"  placeholder="비밀번호를 입력하세요."><br>
<input type = "checkbox" name = "id_remember"><span>ID 기억하기</span> &nbsp;
<input type = "checkbox" name = "autoLogin"> <span>자동 로그인</span><br>
<input type = "submit" value = "로그인" class = "button">
</form>
</div>
</body>
</html>