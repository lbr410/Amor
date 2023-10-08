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
        	Home
            <a href="/amor/customer/faqList.do" title="페이지로 이동">고객센터</a>
            <a href="/amor/customer/faqList.do" title="공지사항 페이지로 이동">faq</a>
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
            <button class="category-button" id="active-category-button">
                <div>FAQ</div>
            </button>
            </a>
            <a href="/amor/customer/noticeList.do">
            <button class="category-button">
                <div>공지사항</div>
            </button>
            </a>
        </div>
        <!-- TYPE -->
        <div class="faqListDiv">
        	<div class="pagemenu">
        		<button id="btn1">영화관 이용</button>
        		<button id="btn2">회원</button>
        		<button id="btn3">온라인</button>
        		<button id="btn4">스토어</button>
        	</div>
        </div>
        <div id="faq-content1" class="faq-content">
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
                        <c:if test="${1==dto.faq_type }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">
                        <c:if test="${1==dto.faq_type }">영화관 이용</c:if>
                        </td>
                        <td headers="thead1 row0" class="text_1">
                            <a  class="op" title="열림" aria-expanded="false">
                                <span>${dto.faq_subject }</span><strong class="txt_qna q">Q</strong>
                            </a>
                        </td>
                    </tr>
                    <tr class="acc_body" role="region">
                        <td colspan="2" headers="thead1 row0">
                            <div class="2" headers="thead1 row0">
                                <div class="op">
                                    <strong class="txt_qna a">
                                        <span>${dto.faq_subject }</span>
                                    </strong>
                                    <div class="open">
                                    	<p><em>Q . </em><span class="faq_subject">${dto.faq_subject }</span></p>
                                        <p><em>A . </em><span class="faq_content">${dto.faq_content }</span></p>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:if>
                    
                </c:forEach>
                </tbody>
            </table>
        </div>
    	</div>
    	</div>
       <div id="faq-content2" class="faq-content">
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
                        <c:if test="${2==dto.faq_type }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">
                        <c:if test="${2==dto.faq_type }">회원</c:if>
                        </td>
                        <td headers="thead1 row0" class="text_1">
                            <a  class="op" title="열림" aria-expanded="false">
                                <span>${dto.faq_subject }</span><strong class="txt_qna q">Q</strong>
                            </a>
                        </td>
                    </tr>
                    <tr class="acc_body" role="region">
                        <td colspan="2" headers="thead1 row0">
                            <div class="2" headers="thead1 row0">
                                <div class="op">
                                    <strong class="txt_qna a">
                                        <span>${dto.faq_subject }</span>
                                    </strong>
                                    <div class="open">
                                    	<p><em>Q . </em><span class="faq_subject">${dto.faq_subject }</span></p>
                                        <p><em>A . </em><span class="faq_content">${dto.faq_content }</span></p>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>
    <div id="faq-content3" class="faq-content">
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
                        <c:if test="${3==dto.faq_type }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">
                        <c:if test="${3==dto.faq_type }">온라인</c:if>
                        </td>
                        <td headers="thead1 row0" class="text_1">
                            <a  class="op" title="열림" aria-expanded="false">
                                <span>${dto.faq_subject }</span><strong class="txt_qna q">Q</strong>
                            </a>
                        </td>
                    </tr>
                    <tr class="acc_body" role="region">
                        <td colspan="2" headers="thead1 row0">
                            <div class="2" headers="thead1 row0">
                                <div class="op">
                                    <strong class="txt_qna a">
                                        <span>${dto.faq_subject }</span>
                                    </strong>
                                    <div class="open">
                                    	<p><em>Q . </em><span class="faq_subject">${dto.faq_subject }</span></p>
                                        <p><em>A . </em><span class="faq_content">${dto.faq_content }</span></p>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>
     <div id="faq-content4" class="faq-content">
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
                        <c:if test="${4==dto.faq_type }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">
                        <c:if test="${4==dto.faq_type }">스토어</c:if>
                        </td>
                        <td headers="thead1 row0" class="text_1">
                            <a  class="op" title="열림" aria-expanded="false">
                                <span>${dto.faq_subject }</span><strong class="txt_qna q">Q</strong>
                            </a>
                        </td>
                    </tr>
                    <tr class="acc_body" role="region">
                        <td colspan="2" headers="thead1 row0">
                            <div class="2" headers="thead1 row0">
                                <div class="op">
                                    <strong class="txt_qna a">
                                        <span>${dto.faq_subject }</span>
                                    </strong>
                                    <div class="open">
                                    	<p><em>Q . </em><span class="faq_subject">${dto.faq_subject }</span></p>
                                        <p><em>A . </em><span class="faq_content">${dto.faq_content }</span></p>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>
    </div>
<%@include file="../footer.jsp" %>
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
    document.addEventListener('DOMContentLoaded', function () {
        // 모든 FAQ 내용 숨기기
        const contents = document.querySelectorAll('.faq-content');
        contents.forEach(content => {
            content.style.display = 'none';
        });

        // 영화관 이용 버튼에 대한 내용 보이기
        document.getElementById('faq-content1').style.display = 'block';

        const buttons = document.querySelectorAll('.pagemenu button');
        buttons.forEach((button, index) => {
            button.addEventListener('click', () => {
                // 모든 FAQ 내용 숨기기
                contents.forEach(content => {
                    content.style.display = 'none';
                });

                // 클릭한 버튼에 해당하는 FAQ 내용 표시
                const contentId = 'faq-content' + (index + 1);
                document.getElementById(contentId).style.display = 'block';
            });
        });
    });
  </script>
</body>
</html>