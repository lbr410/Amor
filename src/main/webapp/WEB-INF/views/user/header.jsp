<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amor Cinemae</title>
</head>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!--브라우저 스타일 초기화-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <link rel="stylesheet" href="/amor/resources/css/user/header.css" />
</head>


  <!--HEADER-->
  <header>
    <div class="inner">
      <a href="/amor/index.do" class="logo">
        <img src="/amor/resources/img/main_logo.png" alt="amor_cinema" />
      </a>

      <div class="sub-menu">
        <ul class="menu">
          <li>
            <a href="/amor/myAmor/ticketingHistory.do">MY AMOR</a>
          </li> 
          <li> 
            <a href="/amor/customer/noticeList.do">고객센터</a>
          </li>
          
         <c:if test="${empty sessionScope.sid}">
            <li>
               <a href="/amor/member/terms.do">회원가입</a>
            </li>
            <li class="login">
               <a href="/amor/member/login.do"><input type="button" value="로그인"></a>
            </li>
         </c:if>
         <c:if test="${!empty sessionScope.sid}">
            <li class="logout"><a href="/amor/member/logout.do"><input type="button" value="로그아웃"></a></li>
         </c:if>
        </ul>
      </div>
       <ul class="main-menu">
        <li class="item">
          <div class="item__name">예매</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <ul>
                    <li class="ticketing"><a href="/amor/ticketing/ticketing.do">예매하기</a></li>
                  </ul>
                </li>
                <li>
                  <ul>
                     <li class="ticketingSchedule"><a href="/amor/ticketing/ticketingSchedule.do">상영시간표</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            </div>
        </li>
        <li class="item">
          <div class="item__name">영화</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <ul>
                    <li class="movie"><a href="/amor/movie/movie.do">현재상영작</a></li>
                  </ul>
                </li>
                <li>
                  <ul>
                     <li class="movieCome"><a href="/amor/movie/movieCome.do">상영예정작</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </li>
       <li class="item">
          <div class="item__name">스토어</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <ul>
                    <li class="store"><a href="/amor/store.do">스낵/음료/관람권</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </li>
      <li class="item">
          <div class="item__name">영화관 소개</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <ul>
                    <li class="movieIntro"><a href="/amor/intro/intro.do">영화관 소개</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </li>
      <li>
      <form name = "headSearch" class="headSearch" action="/amor/movie/movieSearch.do">
            <input type="text" maxlength="30" name="search" id="search" placeholder="영화명을 입력해주세요.">
                <div id="searchButton" onclick="userSearch()">
                    <img id="searchIcon" src="/amor/resources/img/icon_search.png" alt="movieSearch">
                </div>
        </form>
        <span class="top-right"> </span>
      </li>
      </ul>
    </div>
</header>
<script>
	function userSearch(){
		let search = document.getElementById('search').value;
		location.href = '/amor/movie/movieSearch.do?search='+search;
	}
</script>
