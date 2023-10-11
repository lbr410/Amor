<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 티켓팅</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/user/ticketing.css">
<style type="text/css">

</style>
</head>
<c:if test="${!empty movieName && !empty movieMaxAge && !empty movieIdx}">
<body onload = "searchTicketing('${movieName}', ${movieMaxAge}, ${movieIdx})">
</c:if>
<c:if test="${empty movieName && empty movieMaxAge && empty movieIdx}">
<body>
</c:if>
<%@include file="../header.jsp" %>
<div class="body-inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label class="label1">영화 선택</label><label class="label2" id="selectDay">날짜</label>
		</div>
		<div class="commonMid">
			<div class="content1">
				<div class="playingmovieListBox">
					<div class="playingmovieList">
					<c:forEach var="dto" items="${lists }">
						<div class="playingmovie" id ="btnplayingmovie${dto.movie_idx}"  onclick="selectMovie('${dto.movie_name}',${dto.movie_maxage},${dto.movie_idx})">
							<div class="playingmovie_imgDiv">
							<c:if test="${dto.movie_maxage == 0 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_all.png"></c:if>
							<c:if test="${dto.movie_maxage == 1 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_12.png"></c:if>
							<c:if test="${dto.movie_maxage == 2 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_15.png"></c:if>
							<c:if test="${dto.movie_maxage == 3 }"><img class="playingmovie_img" src="/amor/resources/img/maxage_18.png"></c:if>
							
							</div>
							<div class="playingmovie_nameDiv"><div class="playingmovie_name"><a href="#" class="cursorblackmovie">${dto.movie_name }</a></div></div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
			<div class="content2">
				<div class="selectDateBox">
					<div class="selectDate">
						<div class="datecss" id="datebtn0" onclick="selectDate(0)">
							<div>
								<table class="ta123">
									<tr><th id="datep0">123</th></tr>
									<tr><td id="weekp0">(오늘)</td></tr>
								</table>
							</div>
						</div>
						<div class="datecss" id="datebtn1" onclick="selectDate(1)">
							<div>
								<table class="ta123">
									<tr><th id="datep1">일</th></tr>
									<tr><td id="weekp1">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="datecss" id="datebtn2" onclick="selectDate(2)">
							<div>
								<table class="ta123">
									<tr><th id="datep2">일</th></tr>
									<tr><td id="weekp2">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="datecss" id="datebtn3" onclick="selectDate(3)">
							<div>
								<table class="ta123">
									<tr><th id="datep3">일</th></tr>
									<tr><td id="weekp3">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="datecss" id="datebtn4" onclick="selectDate(4)">
							<div>
								<table class="ta123">
									<tr><th id="datep4">일</th></tr>
									<tr><td id="weekp4">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="datecss" id="datebtn5" onclick="selectDate(5)">
							<div>
								<table class="ta123">
									<tr><th id="datep5">일</th></tr>
									<tr><td id="weekp5">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="datecss" id="datebtn6" onclick="selectDate(6)">
							<div>
								<table class="ta123">
									<tr><th id="datep6">일</th></tr>
									<tr><td id="weekp6">(요일)</td></tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<hr class="hr_color"/>
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
			<form name = "ticketinghiddenForm" action="seat.do" method="post">
			<input type="hidden" name="playing_movie_idx">
			<input type="hidden" name="theater_idx">
			<input type="hidden" name="movie_idx">
			</form>
		</div>
	</div>
</div>

<script type="text/javascript" src="/amor/resources/js/httpRequest.js"></script>
<script type="text/javascript">
var datecss = document.getElementsByClassName("datecss");
var moviecss = document.getElementsByClassName("playingmovie");

var today = new Date();
var year = today.getFullYear();
var month = today.getMonth()+1;
var date = today.getDate();
var weekday = today.getDay();

var hours = today.getHours();
var minutes = today.getMinutes();
var cHHMM_s = ''+hours+minutes;
var cHHMM = parseInt(cHHMM_s);
var date_s = '';

if(date < 10){
	date_s = '0'+date;
}else{
	date_s = date;
}
var cYMD = ''+year+''+month+''+date_s;

var select_movie_name = '';


const week = ['(일)','(월)','(화)','(수)','(목)','(금)','(토)'];

document.getElementById('selectDay').innerHTML = year+'-'+month+'-'+date+' '+week[weekday];

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
		if (weekday == wday){
			document.getElementById('weekp'+i).innerHTML = '(오늘)';
		}else{
			wday = (wday % 7);
			document.getElementById('weekp'+i).innerHTML = week[wday];
		}
		
	}
	
	function searchTicketing(movie_name,movie_maxage,movie_idx){
		   let movieCurrentDiv = document.getElementById('btnplayingmovie'+movie_idx);
		   if (movieCurrentDiv.classList[1] === "clicked") {
		      //다시 클릭시 바뀜
		      //movieCurrentDiv.classList.remove("clicked");
		   }else{
		      for (let i = 0; i < moviecss.length; i++) {
		         moviecss[i].classList.remove("clicked");
		      }
		      movieCurrentDiv.classList.add("clicked");
		   }
		   
		   
		   select_movie_name = movie_name;
		   let param = 'movie_name='+movie_name+'&movie_maxage='+movie_maxage;
		   sendRequest('ticketingSelectMovie.do',param, selectMovieResult, 'POST');
		}
	
	function selectMovie(movie_name,movie_maxage,movie_idx){
		let movieCurrentDiv = document.getElementById('btnplayingmovie'+movie_idx);
		
		if (movieCurrentDiv.classList[1] === "clicked") {
			//다시 클릭시 바뀜
			//movieCurrentDiv.classList.remove("clicked");
		}else{
			for (var i = 0; i < moviecss.length; i++) {
				moviecss[i].classList.remove("clicked");
			}
			movieCurrentDiv.classList.add("clicked");
		}
		
		
		select_movie_name = movie_name;
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
	
	
	
	
	
	function selectDate(currentPlusDate){
		
		const currentDiv = document.getElementById('datebtn'+currentPlusDate); 	
		 
		if (currentDiv.classList[1] === "clicked1") {
			//다시 클릭시 바뀜
			//currentDiv.classList.remove("clicked1");
		}else{
			for (var i = 0; i < datecss.length; i++) {
				datecss[i].classList.remove("clicked1");
			}
			currentDiv.classList.add("clicked1");
		}
		
		var dayPost= new Date(year,month-1,date+currentPlusDate);
		let yearPost = dayPost.getFullYear();
		let monthPost = dayPost.getMonth()+1;
		let datePost = dayPost.getDate();
		let wdayPost = dayPost.getDay();
		let param = 'year='+yearPost+'&month='+monthPost+'&date='+datePost+'&movie_name='+select_movie_name;
		
		document.getElementById('selectDay').innerHTML = yearPost+'-'+monthPost+'-'+datePost+' '+week[wdayPost];
		
		sendRequest('ticketingSelectDate.do',param, selectDateResult, 'POST');
		
	}
	
	function selectDateResult(){
		
		if(XHR.readyState==4){
			if(XHR.status==200){
				var data = XHR.responseText;
				var objData = JSON.parse(data);
				var movieTimeLists = objData.movieTimeLists;
				var noselectmovie = objData.msg1;
				var msg ='';
				
				if (noselectmovie == 'noselm') {
					msg = '영화를 선택해주세요.';
				}else{
					if (movieTimeLists == null || movieTimeLists == ''){
						msg = '선택된 날짜에 상영시간이 없습니다';
					}else{
						//movieTimeLists.length
						for(var i = 0 ; i < movieTimeLists.length; i++){
							let fYMD = ''+movieTimeLists[i].playing_movie_date+'';
							
							let time = ''+movieTimeLists[i].playing_movie_start+'';
							let timeHHandMM = time.substring(11,16);
							
							let soldOut = movieTimeLists[i].playing_movie_remain_seats;
							
							if(soldOut == 0 || soldOut=='0'){
								msg += '<div class="sTimeC" ><div><a href="#" class="cursorblackM">'+ timeHHandMM +'</a></div><div class="sTimeC_2line"><a href="#" class="cursorblack">매진'+'&nbsp;&nbsp;'+movieTimeLists[i].theater_name+'</a></div></div>';
							}else{
								msg += '<div class="sTimeC" onclick="selectresult('+movieTimeLists[i].playing_movie_idx+','+movieTimeLists[i].theater_idx+','+movieTimeLists[i].movie_idx+')"><div><a href="#" class="cursorblackM">'+ timeHHandMM +'</a></div><div class="sTimeC_2line"><a href="#" class="cursorblack">'+ (movieTimeLists[i].playing_movie_remain_seats)+'/'+ movieTimeLists[i].theater_totalseat +'&nbsp;&nbsp;'+movieTimeLists[i].theater_name+'</a></div></div>';
								
							}
							
						}
					}
				}
				document.getElementById('ticketingMovieTime').innerHTML = msg;
			}
		}
		
	}
	
	function selectresult(playing_movie_idx, theater_idx, movie_idx){
		let pidx = playing_movie_idx;
		let tidx = theater_idx;
		let midx = movie_idx;
		
		document.ticketinghiddenForm.playing_movie_idx.value = pidx;
		document.ticketinghiddenForm.theater_idx.value = tidx;
		document.ticketinghiddenForm.movie_idx.value = midx;
		document.ticketinghiddenForm.submit();
	}
</script>

</body>
<%@include file="../footer.jsp" %>
</html>