<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 1:1 문의</title>
<style>
.body-inner{
  width: 1100px;
  margin: 0 auto;
  position: relative;
  padding-top: 200px;
}
.gray-section{
   width: 100%;
   height: 350px;
   background: #F8F8F8;

}
.mypagetitle .title1{
	color: #000;
	font-size: 20px;
	font-weight: 500;
	cursor: pointer;
}  
.mypagetitle .title2{
	color:#979797;
	font-size: 20px;
	font-weight: 500;
	cursor: pointer;
} 
.mypageContent{
	padding-top: 150px;
	margin: 0 auto;
	width: 1000px;
	margin-bottom: 50px;
}
#btn4{
    background: #1A2C82;
    color: #FFF;
    border: 1px solid #1A2C82;
    cursor: pointer;
}
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
body, h1, h2, p {
    margin: 0;
    padding: 0;
}
a a:active a:link{
	text-decoration: none;
	color: 333333;
}
button {
    background-color: transparent;
    border: none;
}
.paging {
	margin-top: 30px;
	text-align: center;
	font-size: 16px;
}

.paging a:hover{
	color: #2E90FF;
	font-weight: normal;
}

.nowPage {
	color: #2E90FF !important;
	font-weight: bold;
}
a:visited{
	color:#181818;
}
a:link{
	color:#181818;
	text-decoration: none;
}
.tab_wrap {
     position: relative;
     margin-left: 50px;
 }
.tab_wrap .li.active .tab_con {
    overflow: inherit;
    position: relative;
    width: auto;
    height: auto;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 1000px;
    border: 0;
}
colgroup {
    display: table-column-group;
}
ul,
ol {
    list-style: none;
}
li {
    display: list-item;
    text-align: center;
}
.tb_wrap thead th {
    border-bottom-color: #BBBBBB;
    font-weight: bold;
}
th {
    display: table-cell;
    vertical-align: inherit;
}
tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
}
.tb_wrap th,
.tb_wrap td {
    position: relative;
    border-bottom: 1px solid #EEEEEE;
    padding: 15px 0;
    font-size: 15px;
    text-align: center;
    line-height: 24px;
}
.tb_wrap tbody tr.acc_head {
    cursor: pointer;
}
.tb_wrap td.text_1 {
    padding: 20px;
}
.text_1 {
    text-align: left !important;
}
.tb_wrap tbody .ic_q {
    padding-left: 30px;
    text-align: left;
}
#thead0, #thead4{
	width: 200px;
}
a,
a:link,
a:visited,
a:active,
a:hover {
    color: #000000;
    text-decoration: none;
    cursor: pointer;
}
.txt_qna.q {
    background-color: #FF7787;
}
.tb_wrap .txt_qna {
    position: absolute;
    top: 20px;
    left: -25px;
}
.txt_qna {
    overflow: hidden;
    display: inline-block;
    width: 24px;
    height: 24px;
    line-height: 24px;
    border-radius: 50%;
    text-align: center;
    vertical-align: middle;
}
strong {
    font-weight: bold;
    color: white;
}
.txt_qna span {
    display: block;
    width: 400px;
}
.acc_body {
    display: none;
}
.acc_body.active {
    display: table-row;
    background: #F9FBFC;
    padding: 20px;
}
.faq_subject{
	font-weight: bold;
	font-size: 16px;
	padding-bottom: 24px;
}
.faq_content{
	font-weight: middle;
	font-size: 14px;
}
.open{
	text-align: left;
	padding: 34px;
}
#row0{
width: 300;
}
em{
	font-size: 24px;
	font-weight: bold;
	color: #333333;
}
.grayBtn {
   border:none;
   padding: 2px 21px 6px 21px;
   width: 70px;
   height: 40px;
   border-radius: 3px;
   background: #EEEEEE;
   color: #1A2C82;
   cursor: pointer;
}
.grayBtn a{
	font-size: 14px;
	font-weight: bold;
}
</style>
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
                		<td colspan="5" align="center">
                			<div class="paging">${pageStr }</div>
                		</td>
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
                        	<span>${dto.inquiry_astatus }</span>
                        </td>
                        <td headers="thead1 row0">
                        	<c:url var="delBtn" value="/amor/myAmor/inquiryListDel.do">
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
                                   	<p><em>Q . </em><span class="inquiry_subject">${dto.inquiry_content }</span></p>
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