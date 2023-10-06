<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 상영시간표</title>
<link rel="styleSheet" type="text/css" href="/amor/resources/css/user/ticketingSchedule.css">
</head>

<body>
<%@include file="../header.jsp" %>
<div class="body-inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label id="selectDay">날짜</label>
		</div>
		<div class="commonMid">
			<div class="content">
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
						<div class="date7">
							<div>
								<table class="ta123" onclick="selectDate(7)">
									<tr><th id="datep7">일</th></tr>
									<tr><td id="weekp7">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date8">
							<div>
								<table class="ta123" onclick="selectDate(8)">
									<tr><th id="datep8">일</th></tr>
									<tr><td id="weekp8">(요일)</td></tr>
								</table>
							</div>
						</div>
						<div class="date9">
							<div>
								<table class="ta123" onclick="selectDate(9)">
									<tr><th id="datep9">일</th></tr>
									<tr><td id="weekp9">(요일)</td></tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="selectMovieBox" id="selectMovieBox">
				
				
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
var select_movie_name = '';

if(date < 10){
	date_s = '0'+date;
}else{
	date_s = date;
}
var cYMD = ''+year+''+month+''+date_s;


const week = ['(일)','(월)','(화)','(수)','(목)','(금)','(토)'];

document.getElementById('selectDay').innerHTML = year+'-'+month+'-'+date+' '+week[weekday];

//날짜 
for(let i = 0 ; i< 10; i++){
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
		document.getElementById('datep'+i).innerHTML = '<a class="cursorblack" href="#">'+plusdate+'</a>';
}

//요일
for(let i = 0; i<10 ;i++ ){
	let wday = 0+weekday+i;
	if (weekday == wday){
		document.getElementById('weekp'+i).innerHTML = '(오늘)';
	}else{
		wday = (wday > 6)? wday-7 : wday;
		document.getElementById('weekp'+i).innerHTML = week[wday];
	}
	
}

function selectDate(currentPlusDate){
	var dayPost= new Date(year,month-1,date+currentPlusDate);
	let yearPost = dayPost.getFullYear();
	let monthPost = dayPost.getMonth()+1;
	let datePost = dayPost.getDate();
	let wdayPost = dayPost.getDay();
	let param = 'year='+yearPost+'&month='+monthPost+'&date='+datePost;
	document.getElementById('selectDay').innerHTML = yearPost+'-'+monthPost+'-'+datePost+' '+week[wdayPost];
	sendRequest('ticketingScheduleSelectDate.do',param, selectDateResult, 'POST');
	
}

function selectDateResult(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data = XHR.responseText;
			var objData = JSON.parse(data);
			var timetoMovieList = objData.timetoMovieLists;
			var msg ='';
			var movie_maxage_img ='';
			
			//데이터가 없을 때 
			if(timetoMovieList.length == 0){
				msg = '<div class = "allPlayingMovieBoxDiv"> 해당 날짜에는 상영영화가 없습니다.</div>'
			}
			
			//index : 0 ~  timetoMovieList.length-1 까지
			for(var i=0 ; i< timetoMovieList.length ; i++){
				let fYMD = ''+timetoMovieList[i].playing_movie_date+'';
				let vsYearAndMonthAndDate = ''+fYMD.substring(0,4)+''+fYMD.substring(5,7)+''+fYMD.substring(8,10)+'';

				let time = ''+timetoMovieList[i].playing_movie_start+'';
				let vsHHMM_s = ''+time.substring(11,13)+time.substring(14,16);
				let vsHHMM = parseInt(vsHHMM_s);
				
				if(vsYearAndMonthAndDate == cYMD && cHHMM > vsHHMM){
					continue;
				}else{
					let timeHHandMM = time.substring(11,16);
					//(영화가 한개일 때)
					if(timetoMovieList.length == 1){
						switch(timetoMovieList[i].movie_maxage){
						case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
						case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
						case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
						case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
						}
						//msg += ~;
						msg = msg + '<div class="playingMovieBoxDiv"><div class="playingMovieImgAndTitle"><div class="playingMovieImg">'+movie_maxage_img+'</div><div class="playingMovieTitle">'+timetoMovieList[i].movie_name+'</div></div><div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div></div>';
					}else{
						//이부분에 아래코드 추가
						//index : 0 (영화가 여러개 일때)
						if(i == 0){
							//다음 영화와 같은 경우 
							if(timetoMovieList[0].movie_idx == timetoMovieList[1].movie_idx){
								switch(timetoMovieList[i].movie_maxage){
								case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
								case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
								case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
								case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
								}
								
								msg = msg + '<div class="playingMovieBoxDiv"><div class="playingMovieImgAndTitle"><div class="playingMovieImg">'+movie_maxage_img+'</div><div class="playingMovieTitle">'+timetoMovieList[i].movie_name+'</div></div><div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div>';
							//다음 영화와 같지 않은 경우
							}else{
								switch(timetoMovieList[i].movie_maxage){
								case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
								case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
								case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
								case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
								}
								
								//msg += ~;
								msg = msg + '<div class="playingMovieBoxDiv"><div class="playingMovieImgAndTitle"><div class="playingMovieImg">'+movie_maxage_img+'</div><div class="playingMovieTitle">'+timetoMovieList[i].movie_name+'</div></div><div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div></div>';
							}
							
						//index : 1 ~ timetoMovieList.length-2 까지
						}else if(i > 0 && i < timetoMovieList.length-1){
							//다음 영화와 같은 경우
							if(timetoMovieList[i].movie_idx == timetoMovieList[i+1].movie_idx){
								//그전 영화와 같은 경우
								if(timetoMovieList[i].movie_idx == timetoMovieList[i-1].movie_idx){
									msg = msg + '<div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div>';
								//그전 영화와 같지 않은 경우
								}else{
									switch(timetoMovieList[i].movie_maxage){
									case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
									case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
									case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
									case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
									}
									msg = msg + '<div class="playingMovieBoxDiv"><div class="playingMovieImgAndTitle"><div class="playingMovieImg">'+movie_maxage_img+'</div><div class="playingMovieTitle">'+timetoMovieList[i].movie_name+'</div></div><div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div>';
								}
							
							//다음 영화와 같지 않은 경우
							}else{
								//그전 영화와 같은 경우
								if(timetoMovieList[i].movie_idx == timetoMovieList[i-1].movie_idx){
									msg = msg + '<div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div></div>';
									
								//그전 영화와 같지 않은 경우	
								}else{
									switch(timetoMovieList[i].movie_maxage){
									case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
									case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
									case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
									case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
									}
									msg = msg + '<div class="playingMovieBoxDiv"><div class="playingMovieImgAndTitle"><div class="playingMovieImg">'+movie_maxage_img+'</div><div class="playingMovieTitle">'+timetoMovieList[i].movie_name+'</div></div><div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div></div>';
									
								}
							}
							
						//index : timetoMovieList.length-1
						}else if(i == timetoMovieList.length-1){
							//그전 영화와 같은 경우
							if(timetoMovieList[i].movie_idx == timetoMovieList[i-1].movie_idx){
								msg = msg + '<div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div></div>';
								
							//그전 영화와 같지 않은 경우
							}else{
								switch(timetoMovieList[i].movie_maxage){
								case 0 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_all.png">';break;
								case 1 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_12.png">';break;
								case 2 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_15.png">';break;
								case 3 : movie_maxage_img = '<img class="selectmovie_img" src="/amor/resources/img/maxage_18.png">';break;
								}
								msg = msg + '<div class="playingMovieBoxDiv"><div class="playingMovieImgAndTitle"><div class="playingMovieImg">'+movie_maxage_img+'</div><div class="playingMovieTitle">'+timetoMovieList[i].movie_name+'</div></div><div class="sTimeC" onclick="selectresult('+timetoMovieList[i].playing_movie_idx+','+timetoMovieList[i].theater_idx+','+timetoMovieList[i].movie_idx+')"><div><a href="#" class="cursorblack">'+ timeHHandMM +'</div><div class="sTimeC_2line">'+ (timetoMovieList[i].theater_totalseat - timetoMovieList[i].playing_movie_remain_seats)+'/'+ timetoMovieList[i].theater_totalseat +'&nbsp;&nbsp;'+timetoMovieList[i].theater_name+'</a></div></div></div>';
								
							}
						}
					}
				}

			}
		
			document.getElementById('selectMovieBox').innerHTML = '<div class="allPlayingMovieBoxDiv">'+ msg +'</div>';
	
		}
	}
}

function selectresult(playing_movie_idx, theater_idx, movie_idx){
	location.href='seat.do?movie_idx='+movie_idx+'&theater_idx='+theater_idx+'&playing_movie_idx='+playing_movie_idx;
}



</script>
</body>
<%@include file="../footer.jsp" %>
</html>