<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 비밀번호 찾기</title>
<link rel="stylesheet" href="/amor/resources/css/user/userIdFind.css">
</head>
<body>
<body>
    <div class="top">
        <div class="navigate"><a href="/amor/index.do"><img src="/amor/resources/img/white_b_logo.png"></a>
            <span class="txt-info">Home으로 돌아가기</span>
        </div>
    </div>
    <div class="body-inner"> 
        <div class="center">
            <div class="ci">
                <a href="/amor/index.do" title="메인 페이지로 이동">
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
                            <a href="userPwdFind.do" title="비밀번호 찾기">
                                비밀번호 찾기
                            </a>
                        </li>
                    </ul>
                </div>
                <span class="navi">
                    비밀번호를 찾고자 하는 아이디를 입력해주세요.
                </span>
				<form class="userPwdFind" action="userPwdFind.do" method="POST">
                    <table class="table">
                         <tbody>
                            <tr>
                                <th>아이디</th>
                                <td colspan="2">
                                    <input type="text" name="member_id"  id="member-name" maxlength="20" type="text" placeholder="아이디">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="btn-bottom">
                        <button id="btn-Search" type="submit" class="blue-btn">
                            다음
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>