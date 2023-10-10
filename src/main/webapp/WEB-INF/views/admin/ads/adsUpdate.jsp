<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 광고 수정</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/admin/adsUpdate.css">

<script type="text/javascript">
function adsimgPreview(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('imgadsPreview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('imgadsPreview').src = "";
	  }
	}
	
function checkFileUpload() {
    var fileInput = document.getElementById('btn_adsimg');
    if (!fileInput.files || fileInput.files.length == 0) {
        alert('파일을 선택해주세요.');
        return false;
    }
    return true;
}

</script>

</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">광고 수정</label>
</div>
<div class="contentMain">
	<div class="adsViewDiv">
	<div class="adsMid">
		<div class="firstads">첫번째 광고</div>
		<div class="arrow-next1"></div>
		<div class="secondads">두번째 광고</div>
		<div class="arrow-next2"></div>
		<div class="thirdads">세번째 광고</div>
	</div>
	</div>
	<div class="adsUpdateFormDiv">
		<form name="adsUpdate" action="adsUpdate.do" method="post" enctype="multipart/form-data" onsubmit="return checkFileUpload()">
			<input type="hidden" name="ads_idx" value="${ads_idx}">
			<table>
				<tr>
					<th>제목</th><td><input type="text" name="ads_name" required="required" value="${dto.ads_name}"></td>
				</tr>
				<tr>
					<th>URL</th><td><input type="text" name="ads_url" required="required" value="${dto.ads_url}"></td>
				</tr>
				<tr>
					<th class="adsimgth">광고 이미지</th>
					<td>
					<div class="adsImg">
						<label for="btn_adsimg"><div class="btn_adsPimg">이미지 선택</div></label>
						<input id="btn_adsimg" type="file" name="ads_filename" onchange="adsimgPreview(this);">
						<div class="adsPreviewimg"><img id="imgadsPreview"></div>
					</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="adsUpdateSumit">  <input type="button" value="취소" onclick="location.href='/amor/admin/ads/adsList.do'"> &nbsp; <input type="submit" value="저장"></td>
				</tr>
			
			</table>
		
		</form>
		
	</div>
</div>
</div>
</body>
</html>