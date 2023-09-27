<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 매출관리</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/sales.css">
<script src="https://cdn.jsdelivr.net/npm/echarts@5.4.3/dist/echarts.min.js"></script>
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>
	// 매출관리 메뉴(탭)
	document.addEventListener('DOMContentLoaded', function () {
	    const tabLinks = document.querySelectorAll('.tabnav a');
	    const tabContents = document.querySelectorAll('.tabcontent > div');
	
	    tabLinks.forEach(function (tabLink, index) {
	        tabLink.addEventListener('click', function (event) {
	            event.preventDefault();
	
	            // 모든 탭 콘텐츠를 숨김
	            tabContents.forEach(function (content) {
	                content.style.display = 'none';
	            });
	
	            // 클릭한 탭에 해당하는 콘텐츠를 표시
	            const targetId = tabLink.getAttribute('href').substring(1);
	            const targetContent = document.getElementById(targetId);
	            targetContent.style.display = 'block';
	
	            // 모든 탭 링크에서 'active' 클래스 제거
	            tabLinks.forEach(function (link) {
	                link.classList.remove('active');
	            });
	
	            // 클릭한 탭 링크에 'active' 클래스 추가
	            tabLink.classList.add('active');
	        });
	
	        // 초기에 첫 번째 탭을 활성화
	        if (index === 0) {
	            tabLink.click();
	        }
	    });
	});

	/* 차트 */
    window.onload = function() {
    	sixMonthChart();
		document.getElementById('sixMonthBtn').addEventListener('click', sixMonthChart);
		document.getElementById('weekBtn').addEventListener('click', weekChart);
	}
	
	// 최근 6개월 매출 차트
	function sixMonthChart () { 
		let xAxisData = ['a', 'b', 'c', 'd', 'e', 'f'];
	    let seriesData = [7000000, 10000000, 5000000, 3000000, 2000000, 1000000];
		let sixmonthchart = echarts.init(document.getElementById('chart'));
		
		option = {
			title: {	
				text: '최근 6개월 매출',
			},
			xAxis: {
				type: 'category',
				data: xAxisData
			},
			yAxis: {
				type: 'value'
			},
			series: [
				{
					data: seriesData,
					type: 'bar',
					color: [
				        '#eedd78'
					]
				}
			]
		};
	   
		sixmonthchart.setOption(option);
	}
	
	// 최근 일주일 매출 차트
	function weekChart () { 
		let xAxisData = ['1', '2', '3', '4', '5', '6', '7'];
	    let seriesData = [7000000, 10000000, 5000000, 3000000, 2000000, 1000000, 5000000];
		let weekchart = echarts.init(document.getElementById('chart'));
		
		option = {
			title: {	
				text: '최근 일주일 매출',
			},
			xAxis: {
				type: 'category',
				data: xAxisData
			},
			yAxis: {
				type: 'value'
			},
			series: [
				{
					data: seriesData,
					type: 'bar',
					color: [
				        '#eedd78'
					]
				}
			]
		};
		weekchart.setOption(option);
	}
	
	/* 조회 */
	// 전체 조회
	function allSel() {
		let start = document.getElementById('startd1');
		let end = document.getElementById('endd1');
		let startDate = new Date(start.value);
		let endDate = new Date(end.value);
		
		if(((endDate - startDate) / (1000 * 60 * 60 * 24)) > 365) {
			window.alert('365일의 기간만 조회 가능합니다.');
			return;
		}
		
		let category = document.querySelector('input[name="category1"]:checked').value;
		
		if(start.valueAsDate > end.valueAsDate) {
			window.alert('시작 날짜가 끝나는 날짜보다 클 수 없습니다.');
		} else {
			let startd = start.value;
			let endd = end.value;
			
			let param = 'startd='+startd+'&endd='+endd+'&category='+category+'&kind=a';
			sendRequest('sales.do', param, allSelCallback, 'POST');
		}
	}
	
	function allSelCallback() {
		
	}
	
	// 일자별 조회
	function daySel() {
		let start = document.getElementById('startd2');
		let end = document.getElementById('endd2');
		let startDate = new Date(start.value);
		let endDate = new Date(end.value);
		
		if(((endDate - startDate) / (1000 * 60 * 60 * 24)) > 7) {
			window.alert('일주일의 기간만 조회 가능합니다.');
			return;
		}
		
		let category = document.querySelector('input[name="category2"]:checked').value;
		
		if(start.valueAsDate > end.valueAsDate) {
			window.alert('시작 날짜가 끝나는 날짜보다 클 수 없습니다.');
		} else {
			let startd = start.value;
			let endd = end.value;
			
			let param = 'startd='+startd+'&endd='+endd+'&category='+category+'&kind=d';
			sendRequest('sales.do', param, daySelCallback, 'POST');
		}
	}
	
	function daySelCallback() {
		
	}
	
	// 월별 조회
	function monthSel() {
		let start = document.getElementById('startd3');
		let end = document.getElementById('endd3');
		let startDate = new Date(start.value);
		let endDate = new Date(end.value);
		
		let startYear = startDate.getFullYear();
		let startMonth = startDate.getMonth()+1;
		let endYear = endDate.getFullYear();
		let endMonth = endDate.getMonth()+1;
		
		let yearDiff = endYear - startYear;
		let monthDiff = endMonth - startMonth;
		
		let totalMonthDiff = yearDiff * 12 + monthDiff;
		
		if(totalMonthDiff > 12) {
			window.alert('1년의 기간만 조회 가능합니다.');
			return;
		}
		
		let category = document.querySelector('input[name="category3"]:checked').value;
		
		if(start.valueAsDate > end.valueAsDate) {
			window.alert('시작 월이 끝나는 월보다 클 수 없습니다.');
		} else {
			let startd = start.value;
			let endd = end.value;
			
			let param = 'startd='+startd+'&endd='+endd+'&category='+category+'&kind=m';
			sendRequest('sales.do', param, daySelCallback, 'POST');
		}
	}
	
	function monthSelCallback() {
		
	}
</script>
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">매출 관리</label>
</div>
<div class="contentMain">
<div class="tab">
	<ul class="tabnav">
		<li><a href="#tab1" class="active">전체</a></li>
		<li><a href="#tab2">일자별조회</a></li>
		<li><a href="#tab3">월별조회</a></li>
	</ul>
	<div class="tabcontent">
		
		<div id="tab1">
			<!-- 전체 -->
			<div class="selDiv">
			<label class="menus">기간</label>
			<input type="date" name="startDate" id="startd1" class="timeDeco"> ~ <input type="date" name="endDate" id="endd1" class="timeDeco">
			<script>
				const offset = 1000 * 60 * 60 * 9;
				document.getElementById('startd1').valueAsDate = new Date((new Date()).getTime() + offset);
				document.getElementById('endd1').valueAsDate = new Date((new Date()).getTime() + offset);
			</script>
		
			<label class="menus2">구분</label>
			<span class="category">
				<input type="radio" name="category1" value="all" checked>전체&nbsp;&nbsp;
				<input type="radio" name="category1" value="movie">영화&nbsp;&nbsp;
				<input type="radio" name="category1" value="store">스토어
			</span>
			<input type="button" value="조회" class="chkBtn" onclick="allSel()">
			</div>
			<div class="result">
				<div class="columns">
					<div class="td1">조회일자</div><div class="td2">구분</div><div class="td3">매출액</div>
				</div>
				<form class="resForm">
					<table class="resultTable">
						<tr>
							<td>d</td>
							<td>aa</td>
							<td>dd</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="result2">
				<div><label class="sumDeco">총합계</label><span class="sumResult">원</span></div>
			</div>
		</div>
		
		<div id="tab2">
			<!-- 일자별조회 -->
			<div class="selDiv">
			<label class="menus">기간</label>
			<input type="date" name="startDate" id="startd2" class="timeDeco"> ~ <input type="date" name="endDate" id="endd2" class="timeDeco">
			<script>
				document.getElementById('startd2').valueAsDate = new Date((new Date()).getTime() + offset);
				document.getElementById('endd2').valueAsDate = new Date((new Date()).getTime() + offset);
			</script>
		
			<label class="menus2">구분</label>
			<span class="category">
				<input type="radio" name="category2" value="all" checked>전체&nbsp;&nbsp;
				<input type="radio" name="category2" value="movie">영화&nbsp;&nbsp;
				<input type="radio" name="category2" value="store">스토어
			</span>
			<input type="button" value="조회" class="chkBtn" onclick="daySel()">
			</div>
			<div class="result">
				<div class="columns">
					<div class="td1">조회일자</div><div class="td2">구분</div><div class="td3">매출액</div>
				</div>
				<form class="resForm">
					<table class="resultTable">
						<tr>
							<td>d</td>
							<td>aa</td>
							<td>dd</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="result2">
				<div><label class="sumDeco">총합계</label><span class="sumResult">원</span></div>
			</div>
		</div>
		
		<div id="tab3">
			<!-- 월별조회 -->
			<div class="selDiv">
			<label class="menus">기간</label>
			<input type="month" name="startDate" id="startd3" class="timeDeco"> ~ <input type="month" name="endDate" id="endd3" class="timeDeco">
			<script>
				document.getElementById('startd3').valueAsDate = new Date((new Date()).getTime() + offset);
				document.getElementById('endd3').valueAsDate = new Date((new Date()).getTime() + offset);
			</script>
		
			<label class="menus2">구분</label>
			<span class="category">
				<input type="radio" name="category3" value="all" checked>전체&nbsp;&nbsp;
				<input type="radio" name="category3" value="movie">영화&nbsp;&nbsp;
				<input type="radio" name="category3" value="store">스토어
			</span>
			<input type="button" value="조회" class="chkBtn" onclick="monthSel()">
			</div>
			<div class="result">
				<div class="columns">
					<div class="td1">조회일자</div><div class="td2">구분</div><div class="td3">매출액</div>
				</div>
				<form class="resForm">
					<table class="resultTable" style="width:930px;">
						<tr>
							<td>d</td>
							<td>aa</td>
							<td>dd</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="result2">
				<div><label class="sumDeco">총합계</label><span class="sumResult">원</span></div>
			</div>
		</div>
	</div>
	<div id="chartDiv">
		<div id="chart" class="chartView"><!-- chart --></div>
		<div id="chartBtnDiv" class="chartBtnView">
			<input type="button" value="최근 6개월 매출" id="sixMonthBtn" class="chartBtnDeco"><br>
			<input type="button" value="최근 일주일 매출" id="weekBtn" class="chartBtnDeco">
		</div>
	</div>
</div>
</div>
</div>
</body>
</html>