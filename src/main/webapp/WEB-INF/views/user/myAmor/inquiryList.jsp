<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 1:1 문의</title>
<style>
.inquiryQBtn{
	width: 1000px;
	height: 78px;
	margin: 0 auto;
	text-align: right;
	padding: 24px 0;
}
.inquiryQBtn input{
	border:none;
    padding: 2px 21px 6px 21px;
    width: 150px;
    height: 40px;
    border-radius: 3px;
    background: #1A2C82;
    color: #C7E3FF;
    cursor: pointer;
}
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="gray-section">
	<div class="body-inner">
<%@include file="../mypageHeader.jsp" %>
<div class="mypagetitle"><a href = "/amor/myAmor/memberInquiryList.do"><label class="title1">1:1 문의</label></a></div>
<div class="inquiryQBtn">
	<a href="/amor/myAmor/inquiryWrite.do"><input type="button" value="1:1문의 쓰기"></a>
</div>
        <div class="tab_wrap">
        <div class="tab_con">
            <table class="tb_wrap">
                <thead>
                    <tr>
                    	<th scrop="col" id="thead0">번호</th>
                        <th scope="col" id="thead1">상담제목</th>
                        <th scope="col" id="thead2">작성일</th>
                        <th scope="col" id="thead3">답변유무</th>
                        <th scope="col" id="thead4"></th>
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
                <!--<c:if test="${empty lists }">
                	<tr>
                	<td colspan="2" align="center">
                		등록된 1:1문의가 없습니다.
                	</td>
                	</tr>
                </c:if>-->
                <c:forEach var="dto" items="${lists }">
                    <tr class="acc_head" aria-expanded="false" role="button" title="닫기">
                        <td id="row0" headers="thead0">${dto.inquiry_subject }</td>
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
                                   	<p><em>Q . </em><span class="inquiry_subject">${dto.inquiry_content }</span></p>
                                   	<c:choose>
									    <c:when test="${dto.inquiry_astatus eq 'y'}">
									        <p><em>A . </em><span class="inquiry_answer">${dto.inquiry_answer}</span></p>
									    </c:when>
									    <c:otherwise>
									        -----------------------------------------------------------------
									        답변 대기중입니다.
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
</div>

<%@include file="../footer.jsp" %>
</body>

</html>