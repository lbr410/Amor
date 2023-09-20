<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	button {
		background-color: transparent;
		border: none;
	}
	/**BORDER BAR*/
	.border-bar {
		margin-top: 300px;
		padding-top: 140px;
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
	
	/**MENU*/
	 #category-bar {
		display: flex;
		width: 1100px;
		gap: 32px;
		overflow: auto;
	}
	.category-button {
		color: #BCBCbC;
		width: 550px;
		height: 66px;
		font-size: 12px;
		font-weight: 600;
		cursor: pointer;
		border-bottom: 2px solid transparent;
	}

	.category-button:hover {
		color: #000000;
		border-bottom: 2px solid #DDDDDD;
	}

	#active-category-button {
		color: #000000;
		border-bottom: 2px solid #000000;
	}
        
</style>
</head>
<body>
	<%@include file="../header.jsp" %>
	<section class="body-inner">
	<!-- BORDER BAR-->
	<div class="border-bar">
		<div class="border-title">
		회원가입
		</div>
	</div>
	<!-- CATEGORY TABMENU-->
	<div id="category-bar">
		<button class="category-button" id="active-category-button">
			<div>FAQ</div>
		</button>
		<button class="category-button">
			<div>공지사항</div>
		</button>
	</div>
	</section>
</body>
	<%@include file="../footer.jsp" %>
	<script>
  document.querySelectorAll('.category-button').forEach(button => {
    button.addEventListener("click", event => {
      document.querySelector("#active-category-button").removeAttribute('id')

      button.setAttribute('id', 'active-category-button')
    })
  })
</script>
</html>