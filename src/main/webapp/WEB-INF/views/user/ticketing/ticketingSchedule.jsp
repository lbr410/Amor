<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르: 상영시간표</title>
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
				<div class="">
				
				
				
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
		document.getElementById('datep'+i).innerHTML = plusdate;
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

		}
	}
	
}




</script>
</body>
<%@include file="../footer.jsp" %>
</html>