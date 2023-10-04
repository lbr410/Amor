<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 판매상품 등록</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/productAdd.css">
<script>
	// 상세내용 글자수 확인
	function textCheck() {
		document.getElementById('textLength').innerHTML = document.getElementById('prodContent').value.length;
	}
	
	// 이미지 업로드시 확장자 확인
	function extensionCheck(rp) {
        let filename = rp.value;
        let len = filename.length;
        let filetype = filename.substring(len-4, len);
        
        if(filetype!='.jpg' && filetype!='.png' && filetype!='jpeg') {
            window.alert('이미지 파일만 등록 가능합니다.');
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
	
	// 숫자만 입력되게
	function checkNumber(event) {
		if(event.key >= 0 && event.key <= 9) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">판매상품 등록</label>
</div>
<div class="contentMain">
<form class="prodAddForm" name="productAdd" action="productAdd.do" method="post" enctype="multipart/form-data">
	<div class="AddForm1">
	<div class="prodmenu">
		<span class="menuname2">카테고리</span>
		<select name="product_category" class="cateMenu">
			<option value="d">음료</option>
			<option value="s">스낵</option>
			<option value="t">관람권</option>
		</select>
	</div>
	</div>
	<hr class="line">
	<div class="AddForm2">
		<div class="prodmenu">
			<span class="menuname">제목</span>
			<input type="text" name="product_title" class="textBoxDeco1" maxlength="30" required>
		</div>
		
		<div class="prodmenu">
			<span class="menuname">판매가</span>
			<input type="text" name="product_price" maxlength="6" class="textBoxDeco1" onkeypress="return checkNumber(event)" required>
		</div>
		
		<div class="prodmenu">
			<textarea class="detailContent" id="prodContent" placeholder="상세내용 입력 (최대 380자까지 입력)" name="product_content" maxlength="380" oninput="textCheck()" required></textarea>
			<div class="textCount">(<span id="textLength">0</span> / 380)</div>
		</div>
		
		<span class="imgDiv2">
			<span class="menuname3">이미지</span>
			<input type="file" id="selectImg" name="product_img" accept=".jpg, .jpeg, .png"
				onchange="extensionCheck(this); setProdImg(event)" style="display: none" required>
			<input type="button" value="이미지 추가" onclick="document.getElementById('selectImg').click();" class="fileDeco">
		</span>
		<span><img src="/amor/resources/img/preview.png" id="preview" onError="this.style.visibility='hidden'"></span>
	</div>
	<div class="btnDiv">
		<input type="button" value="취소" class="cancelBtnDeco" onclick="javascript: location.href='/amor/admin/product/productList.do'">&nbsp;
		<input type="submit" value="등록" class="addBtnDeco">
	</div>
</form>
</div>
</div>
</body>
</html>