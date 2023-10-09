<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 공지사항 내용</title>
<link rel="stylesheet" href="/amor/resources/css/user/noticeContent.css">
</head>
<%@include file = "../header.jsp" %>
<body>
    <!-- GRAY NAVIGATE BAR -->
    <div class="gray-bar">
        <div class="location">
        	Home
            <a href="/amor/customer/faqList.do" title="페이지로 이동">고객센터</a>
            <a href="/amor/customer/noticeList.do" title="공지사항 페이지로 이동">공지사항</a>
            <a href="#">공지사항 내용</a>
        </div>
    </div>
    
    <div class="body-inner">
        <!-- BORDER BAR -->
        <div class="border-bar">
            <div class="border-title">고객센터</div>
        </div>
<div class="noticeContent">
<section class="content">

		<table>
		<thead>
			<tr class="info-top">
				<th>번호</th>
				<td>${dto.notice_idx }</td>
				<th>조회수</th>
				<td>${dto.notice_readnum }</td>
				<th>작성일</th>
				<td>${dto.notice_writedate }</td>
			</tr>
			<tr class="info-middle">
				<th>제목</th>
				<td colspan="5" align="left">${dto.notice_subject  }</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
				<div id="noticelist">
					<a href="/amor/customer/noticeList.do">
						<button type="button" class="listBtn" title="공지사항 목록">목록으로</button>
					</a>
				</div>
			</tr>
		</tfoot>
		<tbody>
	<tr class="info-content">
		<td colspan="6" align="left">
		${dto.notice_content }</td>
	</tr>
</tbody>
</table>
</section>
</div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>