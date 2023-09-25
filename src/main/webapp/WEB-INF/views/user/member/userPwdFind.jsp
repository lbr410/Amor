<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/userFind.css">
</head>
<body>
<body>
    <div class="top">
        <div class="navigate"><a href="#"><img src="img/logo.png"></a>
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
                        <li>
                            <a href="userFind.do" title="아이디찾기">
                                아이디 찾기
                            </a>
                        </li>
                        <li class="on">
                            <a href="userPwdFind.do" title="비밀번호 찾기">
                                비밀번호 찾기
                            </a>
                        </li>
                    </ul>
                </div>
                <span class="navi">
                    비밀번호를 찾고자 하는 아이디를 입력해주세요.
                </span>
				<form class="userPwdForm" action="">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>아이디</th>
                                <td>
                                    <input type="text" name="member_name"  id="member-name" maxlength="20" type="text" placeholder="이름">
                                </td>
                            </tr>
                    </table>
                    <div class="btn-bottom">
                        <button id="btn-Search" type="button" class="blue-btn">
                            다음
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>