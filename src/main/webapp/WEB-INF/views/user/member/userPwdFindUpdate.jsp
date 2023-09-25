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
                <form name="userPwdFindUpdate" action="userPwdFindUpdate.do" method="post" class="table-wrap">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>비밀번호 재설정</th>
                                <td colspan="2">
                                    <input type="text" name="member_name"  id="member-name" maxlength="20" type="text" placeholder="이름">
                                </td>
                            </tr>
                            <tr>
                                <th>비밀번호 확인</th>
                                <td>
                                    <input name="member_email" id="member-email" maxlength="30" type="text" placeholder="이메일">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="btn-bottom">
                        <button type="submit" id="btn-Search" class="blue-btn">
                            확인
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>