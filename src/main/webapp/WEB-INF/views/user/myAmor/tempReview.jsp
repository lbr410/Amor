<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.btn {
		display: none;
		position: fixed;
		z-index: 1;
		left: 0;
		top: 0;
		width: 100%;
        height: 100%;
        background-color: rgba(0,0,0,0.7);
	}
	
	.btn-content {
		background-color: #fff;
		margin: 10% auto;
		padding: 20px;
		border: 2px solid #1A2C82;
		width: 70%;
		box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
		border-radius: 15px;
	}
	
	.nextbtn {
		 border:none;
  		 padding: 2px 21px 6px 21px;
		 width: 150px;
		 height: 40px;
		 border-radius: 3px;
		 background: #1A2C82;
		 color: #C7E3FF;
		 cursor: pointer;
	}
	
	.cancelBtn {
	   border:none;
	   padding: 2px 21px 6px 21px;
	   width: 150px;
	   height: 40px;
	   border-radius: 3px;
	   background: #EEEEEE;
	   color: #1A2C82;
	   cursor: pointer;
	}
	
	.closeBtn2 {
		float: right;
		cursor: pointer;
	}
	.reviewFile{
		float:left;
		margin-right: 50px;
		margin-left: 100px;
	}
	.reviewContent {
		text-align: center;
	}
	.centerBtn {
		text-align: center;
	}
</style>
</head>
<body>

<button class="nextbtn" id="openReview">관람평 작성</button>

<div id="myReviewBtn" class="btn">
	<div class="btn-content">
		<form>
		<span id="closeBtn" class="closeBtn2">&times;</span>
		<p>이름</p>
		<input type="radio" name="movie_review_star" value="1" id="rate1"><label for="rate1"></label>
		<p class="reviewFile"><input type="file" name="movie_review_img" value="파일찾기" class="cancelBtn"></p>
		<p class="reviewContent"><textarea cols="55" rows="10" name="movie_review_content" placeholder="관람평을 작성해주세요"></textarea></p>
		<p class="centerBtn"><input type="submit" value="작성 완료" class="cancelBtn">
		&nbsp;&nbsp;<input type="reset" value="다시 작성" class="cancelBtn"></p>
		</form>
	</div>
</div>

<script>
	const openReviewBtn = document.getElementById("openReview");
	const myReviewBtn = document.getElementById("myReviewBtn");
	const closeBtn = document.getElementById("closeBtn");
	
	openReviewBtn.addEventListener("click", () => {
		myReviewBtn.style.display = "block";
	});
	
	closeBtn.addEventListener("click", () =>{
		myReviewBtn.style.display = "none";
	});
	
	window.addEventListener("click", (event) => {
        if (event.target == myReviewBtn) {
            myReviewBtn.style.display = "none";
        }
    });

</script>

</body>
</html>