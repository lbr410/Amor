<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르: 관람평 목록</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />

</head>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
  height: 8000px;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;
   margin-bottom: 64px;
   position: absolute;
}

.reviewTable {
	margin: 50px auto;
	width: 900px;
}

table {
	width: 900px;
}

table thead tr {
	height: 100px;
	line-height: 100px;
	text-align: center;
}

table tbody tr {
	height: 70px;
	line-height: 70px;
	text-align: center;
	background-color: #F8F9FA;
	border-bottom: 2px solid white;
}

table tfoot tr {
	height: 100px;
	line-height: 100px;
	text-align: center;
}

.paging {
	height : 80px;
	margin-top: 70px;
	text-align: center;
	font-size: 16px;
}

.paging a:hover{
	color: #324ABC;
	font-weight: normal;
}

.nowPage {
	color: #324ABC !important;
	font-weight: bold;
}

.reviewImg {
 	width: 262px;
	height: 193px;
  	object-fit: contain;
  	border: none;
  	border-top: 3px solid #EEEEEE;
  	border-bottom: 3px solid #EEEEEE;
  	border-left: 3px solid #EEEEEE;
  	border-right: 3px solid #EEEEEE;
}

</style>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>

<div class="mypagetitle"><label>관람평 목록</label></div>

<div class="reviewTable">
	<form>
		<table>
			<thead>
				<tr>
					<th>작성 날짜</th>
					<th>관람 영화</th>
					<th>관람평</th>
					<th>수정 및 삭제</th>
					<th></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="5" class="paging">${reviewpageStr}</td>
				</tr>
			</tfoot>
			<tbody>
			<c:if test="${empty reviewLists }">
				<tr>
					<td colspan="5" >등록된 관람평이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${reviewLists }" varStatus="vs">
				<tr>
					<td>${dto.movie_review_writedate }</td>
					<td>${dto.movie_name }</td>
					<td>${dto.movie_review_shortcontent }</td>
					<td><input type="button" value="수정">&nbsp;&nbsp;&nbsp;
					<input type="button" value="삭제"></td>
					<td onclick="document.getElementById('reviewContent${vs.index}').style.display='block'">▽</td>
				</tr>
				<tr id="reviewContent${vs.index }" style="display:none;">
					<td><img src="/amor/resources/upload/movie/${dto.movie_review_img}" class="reviewImg"></td>
					<td colspan="3">${dto.movie_review_content }</td>
					<td onclick="document.getElementById('reviewContent${vs.index}').style.display='none'">&time;</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
</div>

</div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>