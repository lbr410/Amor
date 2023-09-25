<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/amor/resources/css/user/userIdFind.css">
</head>
<body>
    <div class="top">
        <div class="navigate"><a href="/amor/index.jsp"><img src="/amor/resources/img/white_b_logo.png"></a>
            <span class="txt-info">Home으로 돌아가기</span>
        </div>
    </div>
    <div class="body-inner">
        <div class="center">
            <div class="ci">
                <a href="#" title="메인 페이지로 이동">
                    <img src="/amor/resources/img/main_logo.png" alt="amor cinema">
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
                <div class="navi">
                        아이디는 가입시 입력하신 이메일을 통해 찾을 수 있습니다.
                    </div>
                <form name="userIdFind" action="userIdFindSubmit.do" method="post" class="table-wrap">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>이름</th>
                                <td colspan="2">
                                    <input type="text" name="member_name"  id="member-name" maxlength="20" type="text" placeholder="이름">
                                </td>
                            </tr>
                            <tr>
                                <th>이메일 주소</th>
                                <td>
                                    <input name="member_emial" id="member-email" maxlength="30" type="text" placeholder="이메일">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="btn-bottom">
                        <button type="submit" id="btn-Search" class="blue-btn">
                            아이디 찾기
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>