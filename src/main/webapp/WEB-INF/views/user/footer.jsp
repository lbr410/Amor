<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style>
footer {
  background-color: #272727;
  border-top: 1px solid #333;
  bottom: 0;
}
footer .footer-inner {
  padding: 40px 0 60px 0;
}

footer .btn-group {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}
footer .btn-group .btn {
  font-size: 12px;
  margin-right: 10px;
  color: #bcbcbc;
}
footer .btn-group .btn:last-child {
  margin-right: 0;
}
footer .info {
  margin-top: 30px;
  text-align: center;
}
footer .info span {
  margin-right: 20px;
  color: #999;
  font-size: 12px;
}
footer .info span:last-child {
  margin-right: 0;
}
footer .copyright {
  color: #999;
  font-size: 12px;
  text-align: center;
  margin-top: 12px;
}
footer .footer-inner .logo {
  margin: 30px auto 0;
  width: 120px;
  height: auto;
}
  
  </style>
  </head>

  <!--FOOTER-->
  <footer>
    <div class="footer-inner">
      <div class="btn-group">
        <a href="#" class="btn">영화관소개</a>
        <a href="#" class="btn">공지사항</a>
        <a href="/amor/admin/adminLogin.do" class="btn">admin_page</a>
      </div>

      <div class="info">
        <span>통신판매업신고 제2023-전북보령-121호</span>
        <span>(주)아모르 영화관</span>
        <span>TEL : 02) 3484-2398 / FAX : 02) 2384-5885</span>
        <span>개인정보관리책임자 : 이보람</span>
      </div>

      <p class="copyright">
        &copy; <span class="this-year"></span> Amor Cinema. All Rights Reserved.
      </p>
      <img src="/amor/resources/img/gray_logo.png" alt="AmorCinema" class="logo" />
    </div>
  </footer>
</html>