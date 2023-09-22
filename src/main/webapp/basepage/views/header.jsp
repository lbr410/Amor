<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <title>Amor Cinema</title>
  <!--브라우저 스타일 초기화-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <link rel="stylesheet" href="/amor/basepage/views/header.css" />
</head>


  <!--HEADER-->
  <header>
    <div class="inner">
      <a href="#" class="logo">
        <img src="/amor/resources/img/main_logo.png" alt="amor_cinema" />
      </a>

      <div class="sub-menu">
        <ul class="menu">
          <li>
            <a href="javascript:void(0)">MY AMOR</a>
          </li>
          <li>
            <a href="javascript:void(0)">고객센터</a>
          </li>
          <li>
            <a href="javascript:void(0)">회원가입</a>
          </li>
          <li>
          	<div class="login">
            <a href="#"><input type="button" value="로그인"></a>
          	</div>
          </li>
        </ul>
      </div>
       <ul class="main-menu">
        <li class="item">
          <div class="item__name">예매</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
              <li></li>
              <li></li>
                <li>
                  <ul>
                    <li>예매하기</li>
                  </ul>
                </li>
                <li>
                  <ul>
                  	<li>상영시간표</li>
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
              <li></li>
              <li></li>
                <li>
                  <ul>
                    <li>현재상영작</li>
                  </ul>
                </li>
                <li>
                  <ul>
                  	<li>상영예정작</li>
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
              <li></li>
              <li></li>
              <li></li>
                <li>
                  <ul>
                    <li>스낵/음료</li>
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
              <li></li>
              <li></li>
              <li></li>
              <li></li>
                <li>
                  <ul>
                    <li>영화관 소개</li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </li>
		<li>
		<form name = "headSearch" class="headSearch">
            <input type="text" maxlength="30" name="search" id="search" placeholder="영화명을 입력해주세요.">
                <div id="searchButton" onclick="userSearch()">
                    <img id="searchIcon" src="image/searchIcon.png" alt="movieSearch">
                </div>
        </form>
        <span class="top-right"> </span>

		</li>
      </ul>
    </div>
</header>

