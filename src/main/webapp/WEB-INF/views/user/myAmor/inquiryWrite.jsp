<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 1:1 문의</title>
<link rel="stylesheet" href="/amor/resources/css/user/inquiryWrite.css">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/customer/inquiryList.do"><label class="title1">1:1 문의</label></a></div>
</div></div>
<div class="mypageContent">
<form class="inquiryWriteForm" action="inquiryWrite.do" method="post" enctype="multipart/form-data">
	<div class="typeDiv">
		<label class="info">분류</label>
		<input type="radio" name="inquiry_type" value="0" checked>문의&nbsp;
		<input type="radio" name="inquiry_type" value="1">불만&nbsp;
		<input type="radio" name="inquiry_type" value="2">칭찬&nbsp;
		<input type="radio" name="inquiry_type" value="3">제안&nbsp;
		<input type="radio" name="inquiry_type" value="4">분실물
	</div>
	<div class="titleDiv">
		<label class="info">제목</label>
		<input type="text" name="inquiry_subject" required="required" class="textBox1">
	</div>
	<div class="contentDiv">
		<label class="info-content">내용</label>
			<textarea name="inquiry_content" maxlength="1000" required="required" class="textBox2" id="text"></textarea>
		<div class="countDiv">(<span id="count">0</span> / 1000)</div>
	</div>
	<div class="fileDiv">
		<label class="imgDiv2">
			<span class="menuname3">이미지</span>
			<input type="file" id="selectImg" name="inquiry_filename" accept=".jpg, .jpeg, .png"
				onchange="extensionCheck(this); setProdImg(event)" style="display: none" required>
			<input type="button" value="이미지 추가" onclick="document.getElementById('selectImg').click();" class="fileDeco">
			
		</label>
		<span class="filenavi">최대 5MB의 이미지(jpg, jpeg, png) 형식의 파일만 업로드하실 수 있습니다.</span>
		<span><img src="/amor/resources/img/preview.png" id="preview" onError="this.style.visibility='hidden'"></span>
	</div>
	<div class="btnDiv">
		<input type="button" value="취소" onclick="javascript: location.href='/amor/myAmor/memberInquiryList.do'" class="cancleBtn">
		<input type="submit" value="등록하기" class="nextBtn">
	</div>
</form>




<script>
	let text = document.getElementById("text");
	let count = document.getElementById("count");
	let maxLength = 1000; // 최대 글자 수
	text.addEventListener("input", function() {
	    let current = text.value.length;
	    let remain = maxLength - current;
	    if (current <= maxLength) {
	        count.innerHTML = current;
	    }
	});

	// 이미지 업로드시 확장자 확인
	function extensionCheck(rp) {
        let filename = rp.value;
        let len = filename.length;
        let filetype = filename.substring(len-4, len);
        
        if(filetype!='.jpg' && filetype!='.png' && filetype!='jpeg' && filetype!='xlsp' && filetype!='pptx') {
            window.alert('제시된 파일만 등록 가능합니다.');
            rp.value = '';
        }
    }
	
	// 업로드한 이미지 미리보기	
	function setProdImg(event) {
		let reader = new FileReader();
		
		reader.onload = function(event) {
			let img = document.getElementById('preview');
			img.setAttribute("src", event.target.result);			
		}
		reader.readAsDataURL(event.target.files[0]);
	}
	
</script>
</div>
</body>
<%@include file="../footer.jsp" %>
</html>