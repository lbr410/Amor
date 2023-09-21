<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르: 영화관 소개</title>
 <!-- 브라우저 스타일 초기화 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" type="text/css" href="/amor/resources/css/user/intro.css">
</head>
<body>
<%@include file="../header.jsp" %>
<!-- GRAY BAR -->
<div class="gray-bar">
  <div class="navigate">
    <div class="navigate-msg">홈 > 영화관 소개</div>
  </div>
</div>
<!-- BORDER BAR-->
<div class="border-bar">
 	<div class="border-title">아모르 극장 소개</div>
</div>
<!-- 이 밑으로 작업 -->
<br>
<br>
<div id="container">

<div id="box1" class="amorTheater" >
<img class="amorTheaterImg" src="/amor/resources/img/introImg.jpg">
</div>

<div id="box2" class="amorIntro">
아모르는 극장 부재 지역에 영화 향유권 격차 해소를 위해 국가와 
지방자치단체가조성하는 상설 영화관으로 지역민의 문화생활 증진을 
위한 공공적 목적으로 조성되는 공공 문화 시설이다. 수익성이 없어서 
폐관되거나 극장 시설이들어서지 않는 지방 중소 도시에 지역민의 
영화문화향유권을 보장하기 위해 조성된 것이 아모르이다.
<br>
<br>
아모르 조성의 시작은 2010 전북 장수군 한누리시네마 개관부터라고 
할 수 있다. 이후 현재 10개 아모르가 운영 중에 있다. 전라북도 7개, 
강원도 2개, 인천광역시 1개 아모르이 활발하게 운영 중이다. 극장 부재 
지역에 조성된 아모르는 개봉영화관으로 총 좌석 수 100석 내외 규모로 
1~2개관으로 만들어져서 3D 관람 시설까지 갖추고 있다. 작년까지 
개관하여 운영 중인 전북의 7개 아모르에 24만 명의 관객이 영화를 
관람했다. 작년 4월부터 운영한 강원도 홍천시네마는 매월 평균 
6500명의 관객이 영화관을 찾았다. 작은 규모의 영화관이지만 지역민의
관심과 참여가 높은 것을 알 수 있다.
</div>

</div>
<%@include file="../footer.jsp" %>
</body>
</html>