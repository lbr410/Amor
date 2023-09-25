<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 판매상품 등록</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/productAdd.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">판매상품 등록</label>
</div>
<div class="contentMain">
<form class="prodAddForm">
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
	<div class="prodmenu"><span class="menuname">제목</span><input type="text" name="product_title" class="textBoxDeco1"></div>
	<div class="prodmenu"><span class="menuname">판매가</span><input type="text" name="product_price" maxlength="6" class="textBoxDeco1"></div>
	<div class="prodmenu">
		<textarea class="detailContent" placeholder="상세내용 입력 (최대 380자까지 입력)" name="product_content" maxlength="380" onkeyup="textCheck()"></textarea>
	</div>
	<div>
		<span class="imgDiv2">
			<span class="menuname3">이미지</span>
			<input type="file" id="selectImg" name="product_img" accept=".jpg, .jpeg, .png"
				onchange="extensionCheck(this); setProdImg(event)" style="display: none">
			<input type="button" value="이미지 추가" onclick="document.getElementById('selectImg').click();" class="fileDeco">
		</span>
		<span><img src="/amor/resources/img/preview.png" id="preview" onError="this.style.visibility='hidden'"></span>
	</div>
	</div>
	<div class="btnDiv">
		<input type="button" value="취소" class="cancelBtnDeco">&nbsp;
		<input type="submit" value="등록" class="addBtnDeco">
	</div>
</form>
</div>
</div>
</body>
</html>