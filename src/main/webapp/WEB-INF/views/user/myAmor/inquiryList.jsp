<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 1:1 문의</title>
<link rel="stylesheet" href="/amor/resources/css/user/inquiryList.css">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/myAmor/memberInquiryList.do"><label class="title1">1:1 문의</label></a></div>
</div></div>
<div class="mypageContent">
<div class="inquiryQBtn">
	<a href="/amor/myAmor/inquiryWrite.do"><input type="button" value="1:1문의 쓰기"></a>
</div>
        <div class="tab_wrap">
        <div class="tab_con">
            <table class="tb_wrap">
                <thead>
                    <tr>
                    	<th scope="col" id="thead0">구분</th>
                        <th scope="col" id="thead1">상담제목</th>
                        <th scope="col" id="thead2">작성일</th>
                        <th scope="col" id="thead3">답변유무</th>
                        <th scope="col" id="thead4"></th>
                    </tr>
                </thead>
                <tfoot>
					<tr>
						<td colspan="8">
						<c:if test="${!empty lists }"><div class="paging">${pageStr}</div></c:if></td>
					</tr>
				</tfoot>
                <tbody id="tab">
                <c:if test="${empty lists }">
                	<tr>
                	<td colspan="5" align="center">
                		등록된 1:1문의가 없습니다.
                	</td>
                	</tr>
                </c:if>
                <c:forEach var="dto" items="${lists }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">
	                        <c:if test="${0==dto.inquiry_type }">문의</c:if>
	                        <c:if test="${1==dto.inquiry_type }">불만</c:if>
	                        <c:if test="${2==dto.inquiry_type }">칭찬</c:if>
	                        <c:if test="${3==dto.inquiry_type }">제안</c:if>
	                        <c:if test="${4==dto.inquiry_type }">분실물</c:if>
                        </td>
                        <td headers="thead1 row0" class="text_1">
                            <a  class="op" title="열림" aria-expanded="false">
                                <span>${dto.inquiry_subject }</span><strong class="txt_qna q">Q</strong>
                            </a>
                        </td>
                        <td headers="thead1 row0">
                        	<span>${dto.inquiry_writedate }</span>
                        </td>
                        <td headers="thead1 row0">
                        	<c:if test="${dto.inquiry_astatus eq 'y'}">
                        		<span class="okAnswer">답변완료</span>
                        	</c:if>
                        	<c:if test="${dto.inquiry_astatus eq 'n'}">
                        		<span class="waitAnswer">답변대기</span>
                        	</c:if>
                        </td>
                        <td headers="thead1 row0">
                        	<c:url var="delBtn" value="inquiryListDels.do">
                        		<c:param name="inquiry_idx">${dto.inquiry_idx }</c:param>
                        	</c:url>
                        	<a href="${delBtn }">
                        		<button type="button" title="1:1 문의 삭제" class="grayBtn">삭제</button>
                        	</a>
                        </td>
                    </tr>
                    <tr class="acc_body" role="region">
                        <td colspan="5" headers="thead1 row0">
                            <div class="2" headers="thead1 row0">
                                <div class="op">
                                    <strong class="txt_qna a">
                                        <span>${dto.inquiry_subject }</span>
                                    </strong>
                                    <div class="open">
                                   	<p><em>Q . </em><span class="inquiry_subject">${dto.inquiry_content }</span><br><br>
                                   		<img src="/amor/resources/upload/inquiry/${dto.inquiry_filename}" class="reviewImgView"  onError="this.style.visibility='hidden'">
                                   	</p><br><br>
                                   	<c:choose>
									    <c:when test="${dto.inquiry_astatus eq 'y'}">
									        <p><em>A . </em><span class="inquiry_answer">${dto.inquiry_answer}</span></p>
									    </c:when>
									    <c:otherwise>
									        -----------------------------------------------------------------
									        답변 대기중입니다.
									        ---------------------------------------------------------------
									    </c:otherwise>
									</c:choose>
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
</body>
<%@include file="../footer.jsp" %>
<script>
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