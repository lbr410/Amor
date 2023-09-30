<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/faq.css">
</head>
<body>
<%@include file="../header.jsp" %>
    <!-- GRAY NAVIGATE BAR -->
    <div class="gray-bar">
        <div class="location">
            <a href="#" title="페이지로 이동">고객센터</a>
            <a href="#" title="FAQ 페이지로 이동">FAQ</a>
        </div>
    </div>
    
    <div class="body-inner">
    <div class="title">고객센터</div>
        <!-- BORDER BAR -->
        <div class="border-bar">
            <div class="border-title">FAQ</div>
        </div>
        <!-- CATEGORY BAR -->
        <div id="category-bar">
        	<a href="/amor/customer/faqList.do">
            <button class="category-button" id="active-category-button">
                <div>FAQ</div>
            </button>
            </a>
            <a href="/amor/customer/noticeList.do">
            <button class="category-button" id="category-button">
                <div>공지사항</div>
            </button>
            </a>
        </div>
        <!-- TYPE -->
        <div class="faqListDiv">
        	<div class="pagemenu">
        		<a href="#"><button id="btn1">영화관 이용</button></a>
        		<a href="#"><button id="btn2">회원</button></a>
        		<a href="#"><button id="btn3">온라인</button></a>
        		<a href="#"><button id="btn4">스토어</button></a>
        	</div>
        </div>
        <div class="tab_wrap">
        <div class="tab_con">
            <table class="tb_wrap">
                <thead>
                    <tr>
                        <th scope="col" id="thead0">구분</th>
                        <th scope="col" id="thead1">질문</th>
                    </tr>
                </thead>
                <tfoot>
                	<tr>
                		<td colspan="2" align="center">
                			<div class="paging">${pageStr }</div>
                		</td>
                	</tr>
                </tfoot>
                <tbody id="tab">
                <c:if test="${empty lists }">
                	<tr>
                	<td colspan="2" align="center">
                		등록된 faq가 없습니다.
                	</td>
                	</tr>
                </c:if>
                <c:forEach var="dto" items="${lists }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">${dto.faq_type }</td>
                        <td headers="thead1 row0" class="text_1">
                            <a href="#" class="op" title="열림" aria-expanded="false">
                                <strong class="txt_qna q">Q 
                                    ${dto.faq_subject }
                                </strong>
                            </a>
                        </td>
                    </tr>
                    <tr class="acc_body" role="region">
                        <td colspan="2" headers="thead1 row0">
                            <div class="2" headers="thead1 row0">
                                <div class="op">
                                    <strong class="txt_qna a">
                                        <span></span>
                                    </strong>
                                    <div>
                                        <p><span>${dto.faq_content }</span></p>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </div>
<%@include file="../footer.jsp" %>
</body>
<script>
    document.querySelectorAll('.category-button').forEach(button => {
      button.addEventListener("click", event => {
        document.querySelector("#active-category-button").removeAttribute('id')
  
        button.setAttribute('id', 'active-category-button')
      })
    })
    document.addEventListener('DOMContentLoaded', function () {
            const accHeads = document.querySelectorAll('.acc_head');

            accHeads.forEach(accHead => {
                accHead.addEventListener('click', () => {
                    const accBody = accHead.nextElementSibling;

                    accBody.classList.toggle('active');
                });
            });
        });
  </script>
</html>