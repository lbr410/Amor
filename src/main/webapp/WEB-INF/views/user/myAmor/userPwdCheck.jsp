<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
</head>
<style>
	a {
		text-decoration: none;
	}
	body {
		font-family: 'Nanum Gothic', sans-serif;
		font-size: 16px;
		font-weight: 400;
		line-height: 1.4;
		color: #333333;
	}
	img {
		display: block;
	}
	.body-inner {
		width: 1100px;
		margin: 0 auto;
		position: relative;
	}

	/**GRAY BAR*/
	.gray-bar {
		width: 100%;
		height: 34px;
		padding-top: 140px;
		position: relative;
		background: #F8F8F8;
		margin-bottom: 64px;
	}

	.navigate {
		width: 1100px;
		margin: 0 auto;
	}

	.navigate-msg {
		padding-top: 8px;
		font-size: 14px;
		margin-left: 0;
	}
		a {
		text-decoration: none;
	}
	body {
		font-family: 'Nanum Gothic', sans-serif;
		font-size: 16px;
		font-weight: 400;
		line-height: 1.4;
		color: #333333;
	}
	img {
		display: block;
	}
	.body-inner {
		width: 1100px;
		margin: 0 auto;
		position: relative;
	}

	/**BORDER BAR*/
	.border-bar {
		margin-top: 300px;
		width: 1100px;
		margin: 0 auto;
		display: block;
		position: relative;
		border-bottom: solid 1px #D9D9D9;
	}

	.border-title {
		margin-top: 78px;
		display: block;
		margin-bottom: 20px;
		font-size: 24px;
	}
.form{
		width: 415px;
		height: 236px;
		display: flex;
		flex-direction: column;
		justify-content: center; 
		align-items: center; 
		margin: 0 auto; 
		margin-top: 40px;
}
.form label{
		width: 325px;
		height: 17px;
		align-items: center;
		flex-shrink: 0;
		padding: 10px 0px 10px 6px;
		color: #363636;
		text-align: center;
		font-family: Inter;
		font-size: 14px;
		font-style: normal;
		font-weight: 600;
		line-height: normal;
		text-align: left;
}
.form .text{
		display: flex;
		width: 290px;
		height: 35px;
		padding: 10px 20px;
		justify-content: center;
		align-items: center;
		gap: 10px;
		flex-shrink: 0;
		margin-bottom:13px;
		border: 1px solid #1A2C82;
		border-radius: 3px;
		margin-bottom: 58px;
}
.cancel{
		width: 150px;
		height: 40px;
		padding: 10px 15px;
		justify-content: center;
		align-items: center;
		flex-shrink: 0;
		border-radius: 5px;
		background: #EEE;
		border:none;
		color: #1A2C82;
		font-family: Inter;
		font-size: 15px;
		font-style: normal;
		font-weight: 400;
		line-height: normal;
		float: left;
		margin-right: 31px;
}
.submit{
		width: 150px;
		height: 40px;
		padding: 10px 15px;
		justify-content: center;
		align-items: center;
		gap: 10px;
		flex-shrink: 0;
		border:none;
		border-radius: 5px;
		background: #1A2C82;
		color: #FFF;
		font-family: Inter;
		font-size: 15px;
		font-style: normal;
		font-weight: 400;
		line-height: normal;
}
.btn{

}
</style>
<body>
<%@include file="../header.jsp" %>
<!-- GRAY BAR -->
<div class="gray-bar">
  <div class="navigate">
    <div class="navigate-msg">홈 > 마이페이지 > 회원정보 수정</div>
  </div>
</div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">회원가입</div>
</div>
<div class="body-inner">
<form name="pwdCheck">
	<div class="form">
		<label>비밀번호</label>
		<input type="text" class="text"> 
		<div class="btn">
		<input type="button" value="취소" class="cancel">
		<input type="submit" value="확인" class="submit">
		</div>
	</div>
</form>
</div>
</body>
</html>