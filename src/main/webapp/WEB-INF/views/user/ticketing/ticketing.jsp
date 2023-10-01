<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르: 티켓팅</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/user/ticketing.css">
</head>

<body>
<%@include file="../header.jsp" %>
<div class="commonBack">
<div class="inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label class="label1">영화 선택</label><label class="label2">날짜</label>
		</div>
		<div class="commonMid">
			<div class="content1">
				<div class="selectboxdiv">
					<select name="ticketingList" class="ticketingOrderSelectBox">
						<option value="movie_Name">영화이름순 </option>
						<option value="movie_maxage">관람등급순</option>
					</select>
					<select name="ticketingListorder" class="ticketingOrderSelectBox">
						<option value="desc">내림차순 </option>
						<option value="asc">오름차순</option>
					</select>
				</div>
				<div class="playingmovieListBox">
					<div class="playingmovieList">
					<c:forEach var="dto" items="${lists }">
						<div class="playingmovie" onclick="selectMovie('${dto.movie_name}',${dto.movie_maxage})">
							<div class="playingmovie_imgDiv">
							<c:if test="${dto.movie_maxage == 0 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_all.png"></c:if>
							<c:if test="${dto.movie_maxage == 1 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_12.png"></c:if>
							<c:if test="${dto.movie_maxage == 2 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_15.png"></c:if>
							<c:if test="${dto.movie_maxage == 3 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_18.png"></c:if>
							
							</div>
							<div class="playingmovie_nameDiv"><div class="playingmovie_name">${dto.movie_name }</div></div>
						</div>
					</c:forEach>
					</div>
				</div>
			
			
			</div>
			<div class="content2">
				<div class="selectDateBox">
					<div class="selectDate">
						<div class="date0" onclick="selectDate(0)">
							<div>
								<table class="ta123">
									<tr><th id="datep0">123</th></tr>
									<tr><td id="weekp0">(오늘)</td></tr>
								</table>
							</div>
						</div>
						<div class="date1" onclick="selectDate(1)">
							<div>
								<table class="ta123">
									<tr><th id="datep1">일</th></tr>
									<tr><td id="weekp1">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date2" onclick="selectDate(2)">
							<div>
								<table class="ta123">
									<tr><th id="datep2">일</th></tr>
									<tr><td id="weekp2">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date3" onclick="selectDate(3)">
							<div>
								<table class="ta123">
									<tr><th id="datep3">일</th></tr>
									<tr><td id="weekp3">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date4" onclick="selectDate(4)">
							<div>
								<table class="ta123">
									<tr><th id="datep4">일</th></tr>
									<tr><td id="weekp4">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date5" onclick="selectDate(5)">
							<div>
								<table class="ta123">
									<tr><th id="datep5">일</th></tr>
									<tr><td id="weekp5">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date6">
							<div>
								<table class="ta123" onclick="selectDate(6)">
									<tr><th id="datep6">일</th></tr>
									<tr><td id="weekp6">(요일)</td></tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="selectDateToPlayingMovie">
				
					<div class="imgandmovietitle">
						<div class="selectimgDiv" id="ticketingMovieMaxage"></div>
						<div class="selectnameDiv"><div class="selectmovie_name" id="ticketingMovieTitle"></div></div>
					</div>
					<div class="movieTime">
						<div class="selectMovieTimeDiv" id="ticketingMovieTime"></div>
					
					</div>
				
				
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<script type="text/javascript" src="/amor/resources/js/httpRequest.js"></script>
<script type="text/javascript">

var today = new Date();
var year = today.getFullYear();
var month = today.getMonth()+1;
var date = today.getDate();
var weekday = today.getDay();
//window.alert('2');

const week = ['(일)','(월)','(화)','(수)','(목)','(금)','(토)'];

	//날짜 
	for(let i = 0 ; i< 7; i++){
		var plusDay= new Date(year,month-1,date+i);
		var plusDayminus1= new Date(year,month-1,date+i-1);
		
		var plusyear = plusDay.getFullYear();
		var plusmonth = plusDay.getMonth()+1;
		var plusdate = plusDay.getDate();
		
		var plusminus1year = plusDayminus1.getFullYear();
		var plusminus1month = plusDayminus1.getMonth()+1;
		var plusminus1date = plusDayminus1.getDate();
		
		var resultmonth = '';
		var resultyear = '';
		
		if(plusminus1month == plusmonth){
			
		}else{
			resultmonth = plusmonth;
		}
		
		if(plusminus1year == plusyear){
			
		}else{
			resultyear = plusyear;
		}	
			document.getElementById('datep'+i).innerHTML = plusdate;
	}
	
	//요일
	for(let i = 0; i<7 ;i++ ){
		let wday = 0+weekday+i;
		wday = (wday > 6)? wday-7 : wday;
		document.getElementById('weekp'+i).innerHTML = week[wday];
		
	}
	
	function selectMovie(movie_name,movie_maxage){
		let param = 'movie_name='+movie_name+'&movie_maxage='+movie_maxage;
		sendRequest('ticketingSelectMovie.do',param, selectMovieResult, 'POST');
	}
	
	function selectMovieResult(){
		if(XHR.readyState==4){
			if(XHR.status==200){
				var data = XHR.responseText;
				var objData = JSON.parse(data);
				var movie_name = objData.movie_name;
				var movie_maxage = objData.movie_maxage;
				var msg = objData.msg;
				var movie_maxage_img ='';
				
				switch(movie_maxage){
				case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
				case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
				case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
				case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
				}
				
				document.getElementById('ticketingMovieMaxage').innerHTML = movie_maxage_img;
				document.getElementById('ticketingMovieTitle').innerHTML = movie_name;
				document.getElementById('ticketingMovieTime').innerHTML = msg;
			}
		}
	}
	
	
	
	
	
	function selectDate(currentPlusDate,movie_name){
		var dayPost= new Date(year,month-1,date+currentPlusDate);
		let yearPost = dayPost.getFullYear();
		let monthPost = dayPost.getMonth()+1;
		let datePost = dayPost.getDate();
		let param = 'year='+yearPost+'&month='+monthPost+'&date='+datePost;
		sendRequest('ticketingSelectDate.do',param, null, 'POST');
		
	}

</script>
<%@include file="../footer.jsp" %>
</body>
</html>