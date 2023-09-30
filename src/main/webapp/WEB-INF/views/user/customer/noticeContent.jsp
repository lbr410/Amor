<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 공지사항 내용</title>
<style>

table{
	width:800px;
	padding-top: 35px;
	border-spacing: 0px;
}
.th1{
	background-color: #ff7f50;
	color:white;
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
<section>
	<article>
		<table>
			<thead>
				<tr>
					<th class="th2">번호</th>
					<td class="notice_idx" >${dto.notice_idx }</td>
					<th class="th2">작성날짜</th>
					<td class="notice_writedate">${dto.notice_writedate }</td>
				</tr>
				<tr>
					<th class="th1">조회수</th>
					<td class="td1">${dto.notice_readnum }</td>
				</tr>
				<tr>
					<th class="th1">제목</th>
					<td colspan="3" class="td1">${dto.notice_subject }</td>
				</tr>
				<tr>
					<td colspan="4" class="content">
					<div class="contentDiv">${dto.notice_content().replaceAll("\n", "<br>") }</div></td>
				</tr>
		</table>
		<div id="noticelist"><a href="/amor/customer/noticeList.do">목록으로</a></div>
	</article>
</section>
<%@ include file="../footer.jsp" %>
</body>
</html>