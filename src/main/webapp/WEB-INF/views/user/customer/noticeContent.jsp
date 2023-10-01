<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 공지사항 내용</title>
<style>
.content{
	margin-top: 140px;
}
table{
	width:800px;
	margin: 0 auto;
	padding-top: 35px;
	border-spacing: 0px;
}
.th{
	background-color: #F8F8F8;
	color:#000000;
	height: 30px;
}
.th2{
	background-color: #ff7f50;
	color:white;
	height: 30px;
	border-bottom: 1px solid white;
}
.td1{
	border-bottom: 1px solid #ff7f50;
	padding-left: 10px;
}
.td2{
	border-top: 1px solid #ff7f50;
	border-bottom: 1px solid #ff7f50;
	padding-left: 10px;
}
.content{
	border-bottom: 1px solid #ff7f50;
}
#noticelist {
	display: inline-block;
	margin-left:750px;
	font-size: 12px;
	font-weight: normal;
}
.contentDiv{
	margin-top: 15px;
	margin-bottom: 15px;
    width: 700px;
    text-align: left;
}
</style>
</head>
<%@include file = "../header.jsp" %>
<section class="content">

		<table>
		<thead>
			<tr>
				<th>번호</th>
				<td>${dto.notice_idx }</td>
				<th>조회수</th>
				<td>${dto.notice_readnum }</td>
				<th>작성일</th>
				<td>${dto.notice_writedate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="5" align="left">${dto.notice_subject  }</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
				<div id="noticelist"><a href="/amor/customer/noticeList.do">목록으로</a></div>
			</tr>
		</tfoot>
		<tbody>
	<tr>
		<td colspan="6" align="left">
		${dto.notice_content }</td>
	</tr>
</tbody>
</table>

</section>
<%@ include file="../footer.jsp" %>
</body>
</html>