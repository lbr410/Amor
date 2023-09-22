<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#container {
	display: flex;
	margin: 5% auto;
	}
	
	#box1{
	flex:1;
	display:table;
	}
	
	.inputfile {
	text-align: center;
	line-height: 50px;
	}
	
	#box2{
	flex:2;
	padding-left: 10px;
	}
	
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
		width: 700px;
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
	
	.fileBtn {
  	   vertical-align:middle;
	   border:none;
	   border-radius: 3px;
	   color: #1A2C82;
	   cursor: pointer;
	}
	
	.closeBtn2 {
		float: right;
		cursor: pointer;
	}
	.centerBtn {
		text-align: center;
	}
	
  .star {
    position: relative;
    font-size: 2rem;
    color: white;
  }
  
  .star input {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    opacity: 0;
    cursor: pointer;
  }
  
  .starBack span {
  	padding-bottom: 5px;
  	position: relative;
  	background-color: #FFF0BB;
  	border-radius: 10px;
  }
  
  .star span {
    width: 0;
    position: absolute; 
    left: 0;
    color: #FFAC33;
    overflow: hidden;
    pointer-events: none;
  }
  
  .name {
 	line-height: 50px;
  	height: 50px;
  	margin-right: 30px;
  	margin-left: 40px;
  	float:left;
  }
  
  
  
</style>
</head>
<body>

<button class="nextbtn" id="openReview">관람평 작성</button>

<form>
<div id="myReviewBtn" class="btn">
	<div class="btn-content">
		
		<span id="closeBtn" class="closeBtn2">&times;</span>
		<span class="name">이름</span>
		<span class="starBack">	
		<span class="star">
		<img src="/amor/resources/img/Stars_background.png">
		<span><img src="/amor/resources/img/Stars_rating.png"></span>
		<input type="range" name="movie_review_star" oninput="drawStar(this)" value="1" step="1" min="1" max="10">
		</span>
		</span>
		<br>
		<div id="container">
		<div id="box1">
		<div class="inputfile">
		<input type="file" name="movie_review_img" value="파일찾기" class="fileBtn">
		</div>
		</div>
		<div id="box2"><textarea cols="55" rows="10" name="movie_review_content" placeholder="관람평을 작성해주세요"></textarea></div>
		</div>
		<p class="centerBtn"><input type="submit" value="작성 완료" class="cancelBtn">
		&nbsp;&nbsp;<input type="reset" value="다시 작성" class="cancelBtn"></p>
		
	</div>
</div>
</form>

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
	
	function drawStar(target) {
		document.querySelector(".star span").style.width = target.value*10+'%';		
	}
	
</script>

</body>
</html>