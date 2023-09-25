<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/amor/resources/css/user/userIdFind.css">
</head>
<body>
    <div class="top">
        <div class="navigate"><a href="index.do"><img src="/amor/resources/img/white_b_logo.png"></a>
            <span class="txt-info">Home으로 돌아가기</span>
        </div>
    </div>
    <div class="body-inner">
        <div class="center">
            <div class="ci">
                <a href="index.do" title="메인 페이지로 이동">
                    <img src="/amor/resources/img/main_logo.png" alt="amor cinema">
                </a>
            </div>
            <div class="find-section">
                <span class="col">
                    아이디/비밀번호 찾기
                </span>
                <div class="tab-list">
                    <ul>
                        <li>
                            <a href="userIdFindForm.do" title="아이디찾기">
                                아이디 찾기
                            </a>
                        </li>
                        <li class="on">
                            <a href="userPwdFindForm.do" title="비밀번호 찾기">
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
                        <span class="member_id">회원님의 아이디는 ${member_id} 로 등록되어 있습니다.</span>
                    </div>
                    <form class="table-wrap">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th class="signUpMenu">이메일 주소</th>
                                <td>
                                    <input type="text" name="member_emial" id="member-email" maxlength="50" placeholder="이메일">
                                </td>
                                <td>
                                    <input type="button" class="gray-btn" value="인증번호 받기"> 
                                </td>
                            </tr>
                            <tr>
                                <th class="signUpMenu">인증번호</th>
                                <td colspan="2">
                                    <input type="text" name="authNum" id="answer-num" maxlength="6" placeholder="인증번호">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="navi-info">
                        본인확인 이메일 주소와 입력한 이메일 주소가 같아야<br>
                        인증번호를 받을 수 있습니다.
                    </div>
                    <div class="btn-bottom">
                    <a href="userPwdFindForm.do">
                        <input type="button" class="blue-btn" value="확인">
                    </a>
                    </div>
                </form>
                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>