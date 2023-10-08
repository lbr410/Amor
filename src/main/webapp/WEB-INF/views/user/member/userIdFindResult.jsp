<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 아이디 찾기</title>
<link rel="stylesheet" href="/amor/resources/css/user/userIdFind.css">
<script>
document.addEventListener('DOMContentLoaded', function() {
    // 데이터 속성을 이용하여 아이디 가져오기
    var members = document.querySelectorAll('.member_id');
    
    // 아이디 마스킹 처리 함수
    function maskUserId(userId) {
        return userId.substring(0, 3) + '**' + userId.substring(5);
    }
    
    // 모든 회원 아이디에 대해 반복 처리
    members.forEach(function(member) {
        var memberId = member.dataset.memberId;
        // 마스킹된 아이디로 교체
        var maskedId = maskUserId(memberId);
        member.innerText = '일치하는 아이디는 ' + maskedId + '로 등록되어 있습니다.';
    });
});

</script>
</head>
<body>
    <div class="top">
        <div class="navigate"><a href="/amor/index.do"><img src="/amor/resources/img/white_b_logo.png"></a>
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
                        <li class="on"><a href="userIdFindForm.do" title="아이디찾기">아이디 찾기</a></li>
                        <li><a href="userPwdFindForm.do" title="비밀번호 찾기">비밀번호 찾기</a></li>
                    </ul>
                </div>
                <div class="result-section"> 
                   
                    <c:forEach var="dto" items="${member_id}">
                        <div class="id-result">
                            <span class="member_id" data-member-id="${dto}">일치하는 아이디는 ${dto}로 등록되어 있습니다.</span>
                        </div>
                    </c:forEach>
                    <div class="btn-bottom">
                        <a href="login.do">
                            <input type="button" class="gray-btn" value="로그인">
                        </a>
                        <a href="userPwdFindForm.do">
                            <input type="button" class="blue-btn" value="비밀번호 찾기">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
