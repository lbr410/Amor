<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 공지사항 목록</title>
<link rel="stylesheet" href="/amor/resources/css/user/customer.css">
</head>
<%@ include file="../header.jsp" %>
<body>
    <!-- GRAY NAVIGATE BAR -->
    <div class="gray-bar">
        <div class="location">
        	Home
            <a href="/amor/customer/faqList.do" title="페이지로 이동">고객센터</a>
            <a href="/amor/customer/noticeList.do" title="공지사항 페이지로 이동">공지사항</a>
        </div>
    </div>
    
    <div class="body-inner">
        <!-- BORDER BAR -->
        <div class="border-bar">
            <div class="border-title">고객센터</div>
        </div>
        <!-- CATEGORY BAR -->
        <div id="category-bar">
        	<a href="/amor/customer/faqList.do">
            <button class="category-button">
                <div>FAQ</div>
            </button>
            </a>
            <a href="/amor/customer/noticeList.do">
            <button class="category-button" id="active-category-button">
                <div>공지사항</div>
            </button>
            </a>
        </div>
        <div class="customerSection">
        <form name="customer" class="customerTable">
            <table class="commontable">
                <thead>
                    <tr>
                    	<th>번호</th>
                        <th>제목</th>
                        <th>등록일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tfoot>
					<tr>
						<td colspan="4" align="center">
						<div class="paging">${pageStr }</div>
					</tr>
                </tfoot>
                <tbody>
                <c:if test="${empty lists }">
                	<tr>
                		<td colspan="4" align="center">등록된 공지사항이 없습니다.</td>
                	</tr>
                </c:if>
                <c:forEach var="dto" items="${lists }">
                    <tr class="customer">
                    	<td class="notice_idx">${dto.notice_idx }</td>
						<c:url var="contentUrl" value="noticeContent.do">
							<c:param name="notice_idx">${dto.notice_idx }</c:param>			
						</c:url>
                        <td class="notice_subject"><a href="${contentUrl }">${dto.notice_subject }</a></td>
                        <td class="notice_writedate">${dto.notice_writedate }</td>
                        <td class="notice_readnum">${dto.notice_readnum }</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
    </div>
<%@ include file="../footer.jsp" %>
</body>
<script>
    document.querySelectorAll('.category-button').forEach(button => {
      button.addEventListener("click", event => {
        document.querySelector("#active-category-button").removeAttribute('id')
  
        button.setAttribute('id', 'active-category-button')
      })
    })
  </script>
</html>