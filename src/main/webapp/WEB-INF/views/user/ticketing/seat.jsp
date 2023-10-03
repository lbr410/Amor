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
	let personnelCnt = 0; // 전체 인원 선택 수
	let adultC = 0; // 성인 수
	let teenagerC = 0; // 청소년 수
	let seniorC = 0; // 시니어 수
	let disabledC = 0; // 장애인 수
	let eightPersonMsg = '최대 8명까지 선택 가능합니다.';
	let totalPrice = 0; // 전체 가격
	let priceArr = []; // 가격 배열
	let priceStack = []; // 가격 스택 배열
	let alphabet = 'ABCDEFGH'; // 행
	let seatCheckCnt = 0; // 좌석 체크 갯수

	// 이미 예약된 좌석
	let alreadyBookedArr = '${playingMovieInfo.playing_movie_seat}'.split(',');
	
	// 전체 좌석
	let seats = '${theaterInfo.theater_seat}';
	let seatsArr = JSON.parse(seats); // 좌석을 배열로 변환
	
	window.onload = function() {
		let seatPlace = document.getElementById('seatPlace'); 
		
		// 좌석 생성
		for(let i=0; i<${theaterInfo.theater_row}; i++) { // theater의 행
			let alphabetRow = document.createElement('span');
			alphabetRow.textContent = alphabet.charAt(i);
			alphabetRow.className = 'alphabetRow';
			seatPlace.appendChild(alphabetRow);
			
			let jNum = 0; 
			for(let j=0; j<${theaterInfo.theater_column}; j++) { // theater의 열
				if(seatsArr[i][j] == 0) { // 0일때 통로 만들기
					let tongroSpan = document.createElement('span');
					tongroSpan.className = 'tongroDeco';
					seatPlace.appendChild(tongroSpan);
				} else { // 아니면(1이면) 좌석 만들기
					let seatBox = document.createElement('input');
					seatBox.type = 'checkbox'; 
					seatBox.name = 'playing_movie_seat'; // name 
					seatBox.id = 'seatBox'+i+jNum; // 각 체크박스에 고유한 id 부여
					seatPlace.appendChild(seatBox);
					seatBox.value = alphabet.charAt(i)+(jNum+1); // 체크박스에 value 부여
					
					if(alreadyBookedArr.includes(seatBox.value)) { // 이미 예약된 좌석
						seatBox.className = 'alreadyBooked';
						seatBox.disabled = true;
					} else { // 예매 가능한 좌석
						seatBox.className = 'noBooked';
					}
					
					let seatLabel = document.createElement('label');
					seatLabel.htmlFor = 'seatBox'+i+jNum;
					seatLabel.textContent = jNum+1;
					seatPlace.appendChild(seatLabel);
					jNum++;
					
					/*seatBox.addEventListener('change', function() {
						if(seatBox.checked) {
							window.alert('value = '+seatBox.value);
						}
					})*/ // value test Code!! 나중에 지울 예정
					
					let totalPriceSpan = document.getElementById('totalPrice');
					
					// 체크박스 클릭 시 이벤트 추가
					seatBox.addEventListener('click', function() {
						if(personnelCnt == 0) {
							seatBox.checked = false;
							window.alert('인원을 선택해주세요.');
						} else {
							if(seatCheckCnt < personnelCnt) {
								if(seatBox.checked) {
									seatCheckCnt++;

									if(priceArr.length > 0) {
									    let price = priceArr.shift();
									    totalPrice += price;
									
									    priceStack.push(price);
									
									    totalPriceSpan.innerHTML = totalPrice.toLocaleString('ko-KR') + '원';
									}
								} else if(seatCheckCnt > 0) {
									seatCheckCnt--;

									if(priceStack.length > 0) {
										let lastAddedPrice = priceStack.pop();
										totalPrice -= lastAddedPrice;
										priceArr.unshift(lastAddedPrice);
										
										totalPriceSpan.innerHTML = totalPrice.toLocaleString('ko-KR') + '원';
									}
								}
							} else { // seatCheckCnt와 personnelCnt가 같아도 seatCheckCnt가 마이너스 되게함
								if(!seatBox.checked) {
									seatCheckCnt--;

									if(priceStack.length > 0) {
										let lastAddedPrice = priceStack.pop();
										totalPrice -= lastAddedPrice;
										priceArr.unshift(lastAddedPrice);
										
										totalPriceSpan.innerHTML = totalPrice.toLocaleString('ko-KR') + '원';
									}
								} else {
									window.alert('더이상 선택하실 수 없습니다.');
									seatBox.checked = false;
								}
							}
						}
					}) // seatBox event
				} // 통로, 통로 아닌 것 여부 if
			} // 안쪽 for
			let lineBreak = document.createElement('br');
			seatPlace.appendChild(lineBreak);
		} // 바깥 for
	} // onload
	
	// 연령대별 인원수 증감
	// 성인 - +
	function adultMinus() {
		let adultCnt = document.getElementById('adultCnt');
		
		if(seatCheckCnt == 0) {
			if(!(seatCheckCnt == personnelCnt)) {
				if(adultCnt.value > 0) {
					let number = parseInt(adultCnt.value) - 1;
					adultCnt.value = number;
					personnelCnt--;
					adultC--;
					
					let priceIdx = priceArr.indexOf(15000);
					if(priceIdx !== -1) {
						priceArr.splice(priceIdx, 1);
					}
				}
			}
		}
	}
	
	function adultPlus() {
		let adultCnt = document.getElementById('adultCnt');
		
		if(seatCheckCnt == 0) {
			if(personnelCnt < 8) {
				let number = parseInt(adultCnt.value) + 1;
				adultCnt.value = number;
				personnelCnt++;
				adultC++;
				
				priceArr.push(15000);
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	

	// 청소년 - +	
	function TeenagerMinus() {
		let teenagerCnt = document.getElementById('teenagerCnt');
		
		if(seatCheckCnt == 0) {
			if(!(seatCheckCnt == personnelCnt)) {
				if(teenagerCnt.value > 0) {
					let number = parseInt(teenagerCnt.value) - 1;
					teenagerCnt.value = number;
					personnelCnt--;
					teenagerC--;
					
					let priceIdx = priceArr.indexOf(12000);
					if(priceIdx !== -1) {
						priceArr.splice(priceIdx, 1);
					}
				}
			}
		}
	}
	
	function TeenagerPlus() {
		let teenagerCnt = document.getElementById('teenagerCnt');
		
		if(seatCheckCnt == 0) {
			if(personnelCnt < 8) {
				let number = parseInt(teenagerCnt.value) + 1;
				teenagerCnt.value = number;
				personnelCnt++;
				teenagerC++;
				
				priceArr.push(12000);
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	
	// 시니어 - +
	function seniorMinus() {
		let seniorCnt = document.getElementById('seniorCnt');
		
		if(seatCheckCnt == 0) {
			if(!(seatCheckCnt == personnelCnt)) {
				if(seniorCnt.value > 0) {
					let number = parseInt(seniorCnt.value) - 1;
					seniorCnt.value = number;
					personnelCnt--;
					seniorC--;
					
					let priceIdx = priceArr.indexOf(5000);
					if(priceIdx !== -1) {
						priceArr.splice(priceIdx, 1);
					}
				}
			}
		}
	}
	
	function seniorPlus() {
		let seniorCnt = document.getElementById('seniorCnt');
		
		if(seatCheckCnt == 0) {
			if(personnelCnt < 8) {
				let number = parseInt(seniorCnt.value) + 1;
				seniorCnt.value = number;
				personnelCnt++;
				seniorC++;
				
				priceArr.push(5000);
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	
	// 장애인 - +
	function disabledMinus() {
		let disabledCnt = document.getElementById('disabledCnt');
		
		if(seatCheckCnt == 0) {
			if(!(seatCheckCnt == personnelCnt)) {
				if(disabledCnt.value > 0) {
					let number = parseInt(disabledCnt.value) - 1;
					disabledCnt.value = number;
					personnelCnt--;
					disabledC--;
					
					let priceIdx = priceArr.indexOf(5000);
					if(priceIdx !== -1) {
						priceArr.splice(priceIdx, 1);
					}
				}
			}
		}
	}
	
	function disabledPlus() {
		let disabledCnt = document.getElementById('disabledCnt');
		
		if(seatCheckCnt == 0) {
			if(personnelCnt < 8) {
				let number = parseInt(disabledCnt.value) + 1;
				disabledCnt.value = number;
				personnelCnt++;
				disabledC++;
				
				priceArr.push(5000);
			} else {
				window.alert(eightPersonMsg);
			}
		}
	}
	
	// submit
	function seatSubmit() {
		document.seatForm.adultC.value = adultC;
		document.seatForm.teenagerC.value = teenagerC;
		document.seatForm.seniorC.value = seniorC;
		document.seatForm.disabledC.value = disabledC;
		document.seatForm.ticketing_personnel.value = personnelCnt;
		document.seatForm.ticketing_price.value = totalPrice;
		
		if(personnelCnt > 0 && personnelCnt == seatCheckCnt) {
			document.seatForm.submit();
		} else {
			window.alert('좌석을 모두 선택해주세요.');
			return false;
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
		<form name="seatForm" action="ticketingPayment.do" method="post">
		<div class="commonMid">
			<div class="personnelDiv">
				<div class="countDiv">
					성인&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="adultMinus()">&nbsp;
					<input type="text" value="0" class="countText" id="adultCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="adultPlus()">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					
					청소년&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="TeenagerMinus()">&nbsp;
					<input type="text" value="0" class="countText" id="teenagerCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="TeenagerPlus()">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					시니어&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="seniorMinus()">&nbsp;
					<input type="text" value="0" class="countText" id="seniorCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="seniorPlus()">
					</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 
					장애인&nbsp;
					<span class="countSpan">
					<input type="button" value="-" class="countBtn" onclick="disabledMinus()">&nbsp;
					<input type="text" value="0" class="countText" id="disabledCnt">&nbsp;
					<input type="button" value="+" class="countBtn2" onclick="disabledPlus()">
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
					<img src="/amor/resources/upload/movie/${movieInfo.movie_poster}" alt="영화 이미지" class="posterImg">
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
				<a href="#" onclick="javascript: seatSubmit()">
					<div class="payGo">결제하기</div>
				</a>
			</div>
		</div>
		<input type="hidden" name="movie_idx" value="${movieInfo.movie_idx}">
		<input type="hidden" name="theater_idx" value="${theaterInfo.theater_idx}">
		<input type="hidden" name="playing_movie_idx" value="${playingMovieInfo.playing_movie_idx}">
		<input type="hidden" name="adultC" value="">
		<input type="hidden" name="teenagerC" value="">
		<input type="hidden" name="seniorC" value="">
		<input type="hidden" name="disabledC" value="">
		<input type="hidden" name="ticketing_personnel" value="">
		<input type="hidden" name="ticketing_price" value="">
		</form>
	</div>
</div>

</body>
<%@include file="../footer.jsp" %>
</html>