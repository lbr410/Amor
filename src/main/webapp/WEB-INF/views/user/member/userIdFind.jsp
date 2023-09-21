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
				<li class="on">
					<a href="#" title="아이디찾기">아이디 찾기</a>
				</li>
				<li>
					<a href="#" title="비밀번호 찾기">비밀번호 찾기</a>
				</li>
			</ul>
		</div>
		<form name="userIdFind" action="userIdFind.do" method="post" class="table-wrap">
			<table class="table">
				<tbody>
					<tr>
						<th>이름</th>
						<td colspan="2">
							<input name="name" id="member-name" maxlength="20" type="text" placeholder="이름">
						</td>
					</tr>
					<tr>
						<th>이메일 주소</th>
						<td>
							<input name="email" id="member-email" maxlength="30" type="text" placeholder="이메일">
						</td>
						<td>
                			<input type="button" class="email-submit" value="목록"> 
            			</td>
        			</tr>
					<tr>
					<th>인증번호</th>
						<td colspan="2">
							<input name="submitNum" id="answer-num" maxlength="6" type="text" placeholder="인증번호">
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navi-info">
		    	본인확인 이메일 주소와 입력한 이메일 주소가 같아야<br>
		    	인증번호를 받을 수 있습니다.
			</div>
			<div class="btn-bottom">
				<button id="btn-Search" type="button" class="gray-btn">
					아이디 찾기
				</button>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>