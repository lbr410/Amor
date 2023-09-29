<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
						<option value="movie_desc">내림차순 </option>
						<option value="movie_asc">오름차순</option>
					</select>
				</div>
				<div class="playingmovieListBox">
					<div class="playingmovieList">
					
						<div class="playingmovie">
							<div class="playingmovie_imgDiv"><img class="playingmovie_img" src="/amor/resources/img/maxage_12.png"></div>
							<div class="playingmovie_nameDiv"><div class="playingmovie_name">오펜하이머</div></div>
						</div>
					
					</div>
					
				
				</div>
			
			
			</div>
			<div class="content2">
				<div class="selectDateBox">
					<div class="selectDate"> 
						<div class="date0">
							<div>
								<table>
									<tr><th id="datep0">123</th></tr>
									<tr><td id="weekp0">(오늘)</td></tr>
								</table>
							</div>
						</div>
						<div class="date1">
							<div>
								<table id="dateandweek1">
									<tr><th id="datep1">일</th></tr>
									<tr><td id="weekp1">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date2">
							<div>
								<table id="dateandweek2">
									<tr><th id="datep2">일</th></tr>
									<tr><td id="weekp2">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date3">
							<div>
								<table id="dateandweek3">
									<tr><th id="datep3">일</th></tr>
									<tr><td id="weekp3">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date4">
							<div>
								<table id="dateandweek4">
									<tr><th id="datep4">일</th></tr>
									<tr><td id="weekp4">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date5">
							<div>
								<table id="dateandweek5">
									<tr><th id="datep5">일</th></tr>
									<tr><td id="weekp5">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date6">
							<div>
								<table id="dateandweek6">
									<tr><th id="datep6">일</th></tr>
									<tr><td id="weekp6">(요일)</td></tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="selectDateToPlayingMovie"></div>
			</div>
		</div>
	</div>
</div>
</div>
<script>

var today = new Date();
var year = today.getFullYear();
var month = today.getMonth()+1;
var date = today.getDate();
var weekday = today.getDay();

const date30 = [4,6,9,11];
const date31 = [1,3,5,7,8,10,12];

const week = ['(일)','(월)','(화)','(수)','(목)','(금)','(토)'];

//해당 년도 2월 윤년 계산 
if (year % 400 == 0) {window.alert('윤년');}
else if (year % 100 == 0 && year % 4 ==0) {window.alert('NO윤년');}
else if (year % 4 ==0) {window.alert('윤년');}
else {window.alert('NO윤년');}


for(let i = 0 ; i<date30.length; i++){
	//if(month)
}

if(month == date[]){
	
}else{
	
}



	//날짜 
	for(let i = 0 ; i< 7; i++){
		document.getElementById('datep'+i).innerHTML = 0+date+i;
	}
	
	//요일
	for(let i = 1 ; i<7 ;i++ ){
		let wday = 0+weekday+i;
		wday = (wday > 6)? wday-7 : wday;
		document.getElementById('weekp'+i).innerHTML = week[wday];
		
	}
</script>
<%@include file="../footer.jsp" %>
</body>
</html>