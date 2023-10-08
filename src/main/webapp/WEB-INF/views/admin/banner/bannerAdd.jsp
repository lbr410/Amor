<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 베너 등록</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/bannerAdd.css">
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">베너 등록</label>
</div>
<div class="contentMain">
	<div class="bannerViewDiv">
		<div class="bannerMid">
			<div class="mainbanner">메인 베너</div>
			<div class="arrow-next"></div>
			<div class="sidebanner">사이드 베너</div>
		</div>
	</div>
	<div class="bannerAddFormDiv">
		<form name="bannerAdd" action="bannerAdd.do" method="post">
			<input type="hidden" name="banner_idx" value="${banner_idx}">
			<table>
				<tr>
					<th>제목</th><td><input type="text" name="banner_name" required="required"></td>
				</tr>
				<tr>
					<th>URL</th><td><input type="text" name="banner_url" required="required"></td>
				</tr>
				<tr>
					<th>소스</th><td><input type="text" name="banner_source" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" class="bannerAddSumit"><input type="button" value="취소" onclick="location.href='/amor/admin/banner/bannerList.do'"> &nbsp; <input type="submit" value="저장"></td>
				</tr>
			
			</table>
		
		</form>
		
	</div>


</div>
</div>
</body>
</html>