<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 : 좌석 선택</title>
<link rel="stylesheet" type="text/css" href="/amor/resources/css/user/seat.css">
<script type="text/javascript" src="../resources/js/httpRequest.js"></script>
<script>
	let personnelCnt = 0;
	let eightPersonMsg = '최대 8명까지 선택 가능합니다.';
	let totalPrice = 0;
	let totalPriceFormat = totalPrice.toLocaleString('ko-KR')+'원';
	let alphabet = 'ABCDEFGH';
	let seatCheckCnt = 0;
	/*let jsonArrTest = [
		['a1', 'a2', 'a3', 'a4', 'a5', 'a6', 'a7', 'a8', 'a9', 'a10', 'a11', 'a12', 'a13', 'a14', 'a15', 'a16', 'a17', 'a18', 'a19', 'a20'],
		['b1', 'b2', 'b3', 'b4', 'b5', 'b6', 'b7', 'b8', 'b9', 'b10', 'b11', 'b12', 'b13', 'b14', 'b15', 'b16', 'b17', 'b18', 'b19', 'b20'],
		['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7', 'c8', 'c9', 'c10', 'c11', 'c12', 'c13', 'c14', 'c15', 'c16', 'c17', 'c18', 'c19', 'c20'],
		['d1', 'd2', 'd3', 'd4', 'd5', 'd6', 'd7', 'd8', 'd9', 'd10', 'd11', 'd12', 'd13', 'd14', 'd15', 'd16', 'd17', 'd18', 'd19', 'd20'],
		['e1', 'e2', 'e3', 'e4', 'e5', 'e6', 'e7', 'e8', 'e9', 'e10', 'e11', 'e12', 'e13', 'e14', 'e15', 'e16', 'e17', 'e18', 'e19', 'e20'],
		['f1', 'f2', 'f3', 'f4', 'f5', 'f6', 'f7', 'f8', 'f9', 'f10', 'f11', 'f12', 'f13', 'f14', 'f15', 'f16', 'f17', 'f18', 'f19', 'f20'],
		['g1', 'g2', 'g3', 'g4', 'g5', 'g6', 'g7', 'g8', 'g9', 'g10', 'g11', 'g12', 'g13', 'g14', 'g15', 'g16', 'g17', 'g18', 'g19', 'g20'],
		['h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'h7', 'h8', 'h9', 'h10', 'h11', 'h12', 'h13', 'h14', 'h15', 'h16', 'h17', 'h18', 'h19', 'h20']
	]
	
	let tongroTest = [
		['a3', 'a18'],
		['b3', 'b18'],
		['c3', 'c18'],
		['d3', 'd18'],
		['e3', 'e18'],
		['f3', 'f18'],
		['g3', 'g18'],
		['h3', 'h18']
	]*/
	
	// 이미 예약된 좌석
	let alreadyBookedArr = '${playingMovieInfo.playing_movie_seat}'.split(',');
	
	window.onload = function() {
		let seatPlace = document.getElementById('seatPlace');
		//for(let i=0; i<jsonArrTest.length; i++) { // theater의 행
		for(let i=0; i<${theaterInfo.theater_row}; i++) {
			let alphabetRow = document.createElement('span');
			alphabetRow.textContent = alphabet.charAt(i);
			alphabetRow.className = 'alphabetRow';
			seatPlace.appendChild(alphabetRow);
			
			//for(let j=0; j<jsonArrTest[i].length; j++) {
			for(let j=0; j<${theaterInfo.theater_column}; j++) { // theater의 열
				let seatBox = document.createElement('input');
				seatBox.type = 'checkbox';
				seatBox.name = 'playing_movie_seat';
				seatBox.id = 'seatBox'+i+j; // 각 체크박스에 고유한 id 부여
				seatPlace.appendChild(seatBox);
				seatBox.value = alphabet.charAt(i)+(j+1);
				
				if(alreadyBookedArr.includes(seatBox.value)) { // 이미 예약된 좌석
					seatBox.className = 'alreadyBooked';
					seatBox.disabled = true;
				} else { // 예매 가능한 좌석
					seatBox.className = 'noBooked';
				}

				//seatBox.value = jsonArrTest[i][j];
				
				/*if(tongroTest[i].includes(seatBox.value)) {
					let tongro = document.createElement('span');
					tongro.className = 'tongroDeco';
					seatPlace.appendChild(tongro);
				} else {*/
					//console.log(tongroTest[i].includes(seatBox.value));
					//console.log(seatBox.value);
				
					let seatLabel = document.createElement('label');
					seatLabel.htmlFor = 'seatBox'+i+j;
					seatLabel.textContent = j+1;
					seatPlace.appendChild(seatLabel);
					
					/*seatBox.addEventListener('change', function() {
						if(seatBox.checked) {
							window.alert('value = '+seatBox.value);
						} else {
							window.alert('value = '+seatBox.value);
						}
					})*/ // value test Code!!!!
					
					seatBox.addEventListener('click', function() {
						if(personnelCnt == 0) {
							seatBox.checked = false;
							window.alert('인원을 선택해주세요.');
						} else {
							if(seatCheckCnt < personnelCnt) {
								if(seatBox.checked) {
									seatCheckCnt++;
								} else if(seatCheckCnt > 0) {
									seatCheckCnt--;
								}
							} else {
								if(!seatBox.checked) {
									seatCheckCnt--;
								} else {
									window.alert('더이상 선택하실 수 없습니다.');
									seatBox.checked = false;
								}
							}
						}
					}) // end function
				//} // end if
			} // end for
			let lineBreak = document.createElement('br');
			seatPlace.appendChild(lineBreak);
		}
	}
	
	// 연령대별 인원수 증감
	function adultMinusPlus(type) {
		let adultCnt = document.getElementById('adultCnt');
		let total = document.getElementById('totalPrice');
		if(type === 'minus') {
			if(!(seatCheckCnt == personnelCnt)) {
				if(adultCnt.value > 0) {
					let number = parseInt(adultCnt.value) - 1;
					adultCnt.value = number;
					personnelCnt--;
				}
			}
		} else if(type === 'plus') {
			if(personnelCnt < 8) {
				let number = parseInt(adultCnt.value) + 1;
				adultCnt.value = number;
				personnelCnt++;
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	
	function TeenagerMinusPlus(type) {
		let teenagerCnt = document.getElementById('teenagerCnt');
		let total = document.getElementById('totalPrice');
		if(!(seatCheckCnt == personnelCnt)) {
			if(type === 'minus') {
				if(teenagerCnt.value > 0) {
					let number = parseInt(teenagerCnt.value) - 1;
					teenagerCnt.value = number;
					personnelCnt--;
				}
			}
		} else if(type === 'plus') {
			if(personnelCnt < 8) {
				let number = parseInt(teenagerCnt.value) + 1;
				teenagerCnt.value = number;
				personnelCnt++;
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	
	function seniorMinusPlus(type) {
		let seniorCnt = document.getElementById('seniorCnt');
		let total = document.getElementById('totalPrice');
		if(!(seatCheckCnt == personnelCnt)) {
			if(type === 'minus') {
				if(seniorCnt.value > 0) {
					let number = parseInt(seniorCnt.value) - 1;
					seniorCnt.value = number;
					personnelCnt--;
				}
			}
		} else if(type === 'plus') {
			if(personnelCnt < 8) {
				let number = parseInt(seniorCnt.value) + 1;
				seniorCnt.value = number;
				personnelCnt++;
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	
	function disabledMinusPlus(type) {
		let disabledCnt = document.getElementById('disabledCnt');
		let total = document.getElementById('totalPrice');
		if(!(seatCheckCnt == personnelCnt)) {
			if(type === 'minus') {
				if(disabledCnt.value > 0) {
					let number = parseInt(disabledCnt.value) - 1;
					disabledCnt.value = number;
					personnelCnt--;
				}
			}
		} else if(type === 'plus') {
			if(personnelCnt < 8) {
				let number = parseInt(disabledCnt.value) + 1;
				disabledCnt.value = number;
				personnelCnt++;
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
</script>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="body-inner">
	<div class="commonDiv">
		<div class="commonTop">
			<label>인원/좌석 선택</label>
		</div>
		<div class="commonMid">
			<div class="personnelDiv">
				<div class="countDiv">
					성인&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="adultMinusPlus('minus')">&nbsp;
					<input type="text" value="0" class="countText" id="adultCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="adultMinusPlus('plus')">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					청소년&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="TeenagerMinusPlus('minus')">&nbsp;
					<input type="text" value="0" class="countText" id="teenagerCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="TeenagerMinusPlus('plus')">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					시니어&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="seniorMinusPlus('minus')">&nbsp;
					<input type="text" value="0" class="countText" id="seniorCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="seniorMinusPlus('plus')">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					장애인&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="disabledMinusPlus('minus')">&nbsp;
					<input type="text" value="0" class="countText" id="disabledCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="disabledMinusPlus('plus')">
					</span>
				</div>
			</div>
			<div class="seatDiv">
				<div class="seatSel">
				<div class="screenDiv">S &nbsp;&nbsp;C &nbsp;&nbsp;R &nbsp;&nbsp;E &nbsp;&nbsp;E &nbsp;&nbsp;N</div>
				<div id="seatPlace" class="seatPlaceDeco">				
					<!-- seat -->
				</div>
				</div>
				<div class="menual">
					<div class="menualDiv1"><div class="selectedSquare"></div>&nbsp;<span class="menualMenu">선택완료</span></div>
					<div class="menualDiv2"><div class="noSelectedSquare"></div>&nbsp;<span class="menualMenu">선택불가</span></div>
				</div>
			</div>
			<div class="infoDiv">
				<div class="movieInfo">
					<img src="/amor/resources/img/introImg.jpg" alt="영화 이미지" class="posterImg">
					<div class="movieName">
						<c:if test="${movieInfo.movie_maxage eq 0}">
							<img src="/amor/resources/img/maxage_all.png" class="ageImg">
						</c:if>
						<c:if test="${movieInfo.movie_maxage eq 1}">
							<img src="/amor/resources/img/maxage_12.png" class="ageImg">
						</c:if>
						<c:if test="${movieInfo.movie_maxage eq 2}">
							<img src="/amor/resources/img/maxage_15.png" class="ageImg">
						</c:if>
						<c:if test="${movieInfo.movie_maxage eq 3}">
							<img src="/amor/resources/img/maxage_18.png" class="ageImg">
						</c:if>
						&nbsp;${movieInfo.movie_name}
					</div>
					<div class="movieTime">${playingMovieInfo.playing_movie_date} | 
					${playingMovieInfo.playing_movie_start}~${playingMovieInfo.playing_movie_end}</div>
					<div class="theaterName">${theaterInfo.theater_name}</div>
				</div>
				<div class="priceInfo">총 합계 <span id="totalPrice"></span></div>
				<a href="#">
					<div class="payGo">결제하기</div>
				</a>
			</div>
		</div>
	</div>
</div>

</body>
<%@include file="../footer.jsp" %>
</html>