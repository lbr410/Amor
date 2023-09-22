<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/userFind.css">
</head>
<%@ include file="../header.jsp" %>
<body>
    <div class="top">
        <div class="navigate"><a href="#"><img src="img/logo.png" alt="amor cinema"></a>
            <span class="txt-info">Home으로 돌아가기</span>
        </div>
    </div>
    <div class="body-inner">
        <div class="center">
            <div class="ci">
                <a href="#" title="메인 페이지로 이동">
                    <img src="#" alter="amor cinema">
                </a>
            </div>
            <div class="find-section">
                <span class="col">
                    아이디/비밀번호 찾기
                </span>
                <div class="tab-list">
                    <ul>
                        <li class="on">
                            <a href="#" title="아이디찾기">
                                아이디 찾기
                            </a>
                        </li>
                        <li>
                            <a href="#" title="비밀번호 찾기">
                                비밀번호 찾기
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="result-section">
                    <div class="txt-find">
                        아이디 찾기
                    </div>
                    <div class="id-result">
                        <span class="member_id">회원님의 아이디는 로 등록되어 있습니다.</span>
                    </div>
                    <div class="btn-bottom">
                        <input type="button" class="gray-btn" value="로그인">
                        <input type="button" class="blue-btn" value="비밀번호 찾기">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>