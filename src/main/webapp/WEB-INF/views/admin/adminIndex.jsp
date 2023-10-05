<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amor Cinema Admin</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/admin/adminIndex.css">
<script src="https://cdn.jsdelivr.net/npm/echarts@5.4.3/dist/echarts.min.js"></script>
<script>
	window.onload = function() {
		let salesChart = echarts.init(document.getElementById('salesChart'));
		let cntTicketingChart = echarts.init(document.getElementById('cntTicketingChart'));
		
		option1 = {
			title: {
				text: '일일 매출',
				left: 'left',
				textStyle: {
					fontSize: 18,
					fontWeight: 'bold',
				},
			},
			series: [
				{
					data: [
						{ name: '${chartData[0].ad}', value: ${chartData[0].a} },
						{ name: '${chartData[0].bd}', value: ${chartData[0].b} },
						{ name: '${chartData[0].cd}', value: ${chartData[0].c} },
						{ name: '${chartData[0].dd}', value: ${chartData[0].d} },
						{ name: '${chartData[0].ed}', value: ${chartData[0].e} },
						{ name: '${chartData[0].fd}', value: ${chartData[0].f} },
						{ name: '${chartData[0].gd}', value: ${chartData[0].g} }
					],
					type: 'pie',
					label: {
				        show: true,
				        formatter: function(params) {
				            return params.name + ': ' + params.value.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' });
				        },
				        fontSize: 12,
				    },
				    radius: ['40%', '70%']
				},
			],
		};
		
		option2 = {
			title: {
			text: '일일 예매수'
		},
			xAxis: {
				type: 'category',
				data: ['${chartData[1].gd}', '${chartData[1].fd}', '${chartData[1].ed}', '${chartData[1].dd}', '${chartData[1].cd}', '${chartData[1].bd}', '${chartData[1].ad}']
			},
			yAxis: {
				type: 'value'
			},
			legend: {
				data: ['예매수']
			},
			series: [
				{
					name: '예매수',
					type: 'line',
					areaStyle: {},
					data: [${chartData[1].g}, ${chartData[1].f}, ${chartData[1].e}, ${chartData[1].d}, ${chartData[1].c}, ${chartData[1].b}, ${chartData[1].a}]
				}
			]
		};
		salesChart.setOption(option1);
		cntTicketingChart.setOption(option2);
	}
</script>
</head>
<body>
<%@include file="admin_header.jsp" %>
<div class="content">
<div class="helloAdmin"><label>❤️ 관리자님 환영합니다. :) ❤️</label>
</div>
<div class="contentMain">
<!-- 여기에서 추가 -->
<div id="chart" class="chartDeco">
	<div id="salesChart" class="salesChartDeco"><!-- sales chart --></div>
	<div id="cntTicketingChart" class="cntTicketingChartDeco"><!-- cntTicketing chart --></div>
</div>

<div class="tableDiv1">
	<div class="table1Deco">
	<div class="tableDivs">
		<div><label class="tableMenu">신규회원</label>
		<a class="moreView" href="/amor/admin/member/memberList.do">더보기</a></div>
		<table class="commonTables">
			<thead>
				<tr>
					<th class="tabletd1">번호</th>
					<th class="tabletd2">아이디</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${memberResult}">
					<tr>
						<td>${member.a}</td>
						<td>${member.ad}</td>
						<td>${member.dates}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<div class="table2Deco">
	<div class="tableDivs">
		<div><label class="tableMenu">영화목록</label>
		<a class="moreView" href="/amor/admin/movie/movieList.do">더보기</a></div>
		<table class="commonTables">
			<thead>
				<tr>
					<th class="tabletd1">번호</th>
					<th class="tabletd2">영화제목</th>
					<th>개봉일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movie" items="${movieResult}">
					<tr>
						<td>${movie.a}</td>
						<td>${movie.ad}</td>
						<td>${movie.dates}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</div>
<div class="tableDiv2">
	<div class="table3Deco">
		<div class="tableDivs">
		<div><label class="tableMenu">공지사항</label>
		<a class="moreView" href="/amor/admin/notice/noticeList.do">더보기</a></div>
		<table class="commonTables">
			<thead>
				<tr>
					<th class="tabletd1">번호</th>
					<th class="tabletd2">제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${noticeResult}">
					<tr>
						<td>${notice.a}</td>
						<td>${notice.ad}</td>
						<td>${notice.dates}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<div class="table4Deco">
	<div class="tableDivs">
		<div><label class="tableMenu">1:1 문의</label>
		<a class="moreView" href="/amor/admin/inquiry/inquiryList.do">더보기</a></div>
		<table class="commonTables">
			<thead>
				<tr>
					<th class="tabletd11">번호</th>
					<th class="tabletd12">제목</th>
					<th class="tabletd13">작성일</th>
					<th class="tabletd14">답변여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="inquiry" items="${inquiryResult}">
					<tr>
						<td>${inquiry.inquiry_idx}</td>
						<td>${inquiry.inquiry_subject}</td>
						<td>${inquiry.inquiry_writedate}</td>
						<c:if test="${inquiry.inquiry_answer eq 'n'}">
							<td><label class="answerWait">답변대기</label></td>
						</c:if>
						<c:if test="${inquiry.inquiry_answer eq 'y'}">
							<td><label class="answerComplete">답변완료</label></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</div>
</div>
</div>
</body>
</html>