<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 상영관 수정</title>
</head>
<link rel = "stylesheet" href = "/amor/resources/css/admin/theaterAdd.css">
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">상영관 수정</label>
</div>
<div class="contentMain">
<span class = "controller">행 <input type = "number" id = "row" value = "${row}" min="4" max="8" onclick = "row(this.value)"></span>
<span class = "controller">열 <input type = "number" id = "column" value = "${col}" min="5" max="20" onclick = "column(this.value)"></span>
<span class = "controller">상영관명 <input type = "text" class = "nameAdd" id = "theaterName" value = "${theatername}" maxlength="6"></span><br>
<div id = "seats" class = "seate">${seats}</div>
<div class="tableDiv">
<input type = "button" value = "통로" class = "blockbutton1" onclick = "path()">
<input type = "button" value = "초기화" class = "blockbutton2" onclick = "resetseate()">
<input type = "button" value = "저장" class = "submit" onclick = "pushData()">
</div>
</div>
</div>
</body>
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>

let inputElement = document.getElementById('theaterName');

inputElement.addEventListener('input', function() {
    if (inputElement.value.length > 6) {
        inputElement.value = inputElement.value.slice(0, 6); // 6자 이상 입력을 자름
    }
});

// checkbox 2개이상 선택했을 경우 checked를 막음
function keyOnly(event) {
    
    let keyCode = event.keyCode;

    if (keyCode !== 38 && keyCode !== 40) {
        event.preventDefault();
    }
}


let checkboxes = document.querySelectorAll('input[name="seats"]');

//사용자가 checkbox를 클릭했을때 실행되는 함수 정의
checkboxes.forEach(checkbox => {
    checkbox.addEventListener('click', handleCheckboxChange);
});


//checkbox 2개이상 선택했을 경우 추가선택을 막음(checked는 계속 가능)
function handleCheckboxChange(e) {
	
let max = 2;
    
    let checkedCheckboxes = Array.from(checkboxes).filter(checkbox => checkbox.checked);
        
    if (checkedCheckboxes.length > max) {
        e.preventDefault();
        let box = document.getElementsByName('seats');
        box.forEach(function(checkbox){
     	  if(checkbox.checked){
     		  checkbox.checked = false;
     	  } 
        });
        alert('두개이상 선택이 불가합니다.');
    }
}




	//저장하기 요청함수
	function pushData(){		
		
		let seats = document.getElementsByName("seats");
		let rows = document.getElementById('row').value;
		let cols = document.getElementById('column').value;
		let theatername = document.getElementById('theaterName').value;
		let seatsData = new Array(rows);
		let setData = [];
		
		for(let i = 0 ; i < rows; i++){
			seatsData[i] = new Array(cols);
		}
		
		let totalseat = 0;
		
		seats.forEach(function(checkbox){		
			if(checkbox.value != 0){
				checkbox.value = 1;
				totalseat++;
			}
		});		
		
		let indexnum = 0;
		for(let i = 0 ; i < rows; i++){
			for(let j = 0 ; j < cols; j++){
				seatsData[i][j] = seats[indexnum++].value;
				console.log(seatsData[i][j]);
			}
		}
		
		for(let i = 0 ; i < rows; i++){
			setData.push(seatsData[i]);
		}
		
		let inputData = setData;
				
			let jsonData = JSON.stringify(inputData);			

			console.log(jsonData);
			let param = null;
			
		if(theatername != ''){
			param = 'seatsData='+encodeURI(jsonData)+'&totalseat='+totalseat+'&row='+rows+'&col='+cols+'&tidx='+${tidx}+'&theatername='+theatername;
		}else{
			param = 'seatsData='+encodeURI(jsonData)+'&totalseat='+totalseat+'&row='+rows+'&col='+cols+'&tidx='+${tidx}+'&theatername=none';
		}		
		sendRequest('/amor/admin/theater/updateSeate.do',param,pushSeateData,'GET');
	}
	
	//저장하기 응답함수
	function pushSeateData(){
		if(XHR.readyState == 4){
			if(XHR.status == 200){
				let data = XHR.responseText;
				let objData = JSON.parse(data);
				let msg = objData.alert;
				alert(msg);
				location.href = '/amor/admin/theater/theaterList.do';
			}
		}
	}
	
	//초기화 요청함수
	function resetseate(){
		let box = document.getElementsByName('seats');
		let row = document.getElementById('row').value;
		let col = document.getElementById('column').value;
		
		for(let i = 0 ; i < box.length; i++){
			box[i].disabled = false;			
		}
		
		let l = -1;
		for(let i = 0 ; i < row; i++){
			for(let j = 1 ; j <= col ; j++){
				l++;
				box[l].value = i+','+j;
			}
		}
		
		for(let i = 0; i <= row; i++){
			let rowbox = document.getElementsByName(i);
			for(let j = 0 ; j < rowbox.length; j++){				
			rowbox[j].style.display = '';
			rowbox[j].innerHTML = j+1;
			}
		}
		
		let param='row='+8+'&col='+20;
		sendRequest('/amor/admin/theater/seateInitialization.do',param,initializationResult,'GET');
	}
	
	// 초기화 응답함수
	function initializationResult() {
	    if (XHR.readyState == 4) {
	        if (XHR.status == 200) {
	        	
	            let data = XHR.responseText;
	            let objData = JSON.parse(data);
	            let seats = objData.seats;
	            document.getElementById('seats').innerHTML = seats;
	            document.getElementById('row').value = 8;
	            document.getElementById('column').value = 20;

				let checkboxes = document.querySelectorAll('input[name="seats"]');
				
	            // 기존에 등록된 이벤트 리스너 모두 제거
	            checkboxes.forEach(checkbox => {
	                checkbox.removeEventListener('click', handleCheckbox);
	            });

	            // 사용자가 checkbox를 클릭했을때 실행되는 함수 정의
	            checkboxes.forEach(checkbox => {
	                checkbox.addEventListener('click', handleCheckbox);
	            });

	            // checkbox 2개 이상 선택했을 경우 추가 선택을 막음(checked는 계속 가능)
	            function handleCheckbox(e) {
	                let max = 2;

	                let checkedCheckboxes = Array.from(checkboxes).filter(checkbox => checkbox.checked);

	                if (checkedCheckboxes.length > max) {
	                    e.preventDefault();
	                   let box = document.getElementsByName('seats');
	                   box.forEach(function(checkbox){
	                	  if(checkbox.checked){
	                		  checkbox.checked = false;
	                	  } 
	                   });
	                    alert('두 개 이상 선택이 불가합니다.');
	                }
	            }
	        }
	    }
	}

	
	//행증감 요청함수
	function row(row){
		let column = document.getElementById('column').value;
		
		let param='row='+row+'&col='+column+'&theateridx='+${tidx};
		sendRequest('/amor/admin/theater/addSeate.do',param,rowResult,'GET');
	}
	
	//행증감 응답함수
	function rowResult(){
		if(XHR.readyState == 4){
			if(XHR.status == 200){
				
				let data = XHR.responseText;
				let objData = JSON.parse(data);
				let seats = objData.seats;
				document.getElementById('seats').innerHTML = seats;
				
				let checkboxes = document.querySelectorAll('input[name="seats"]');
				
	            // 기존에 등록된 이벤트 리스너 모두 제거
	            checkboxes.forEach(checkbox => {
	                checkbox.removeEventListener('click', handleCheckbox);
	            });

	            // 사용자가 checkbox를 클릭했을때 실행되는 함수 정의
	            checkboxes.forEach(checkbox => {
	                checkbox.addEventListener('click', handleCheckbox);
	            });

	            // checkbox 2개 이상 선택했을 경우 추가 선택을 막음(checked는 계속 가능)
	            function handleCheckbox(e) {
	                let max = 2;

	                let checkedCheckboxes = Array.from(checkboxes).filter(checkbox => checkbox.checked);

	                if (checkedCheckboxes.length > max) {
	                    e.preventDefault();
	                   let box = document.getElementsByName('seats');
	                   box.forEach(function(checkbox){
	                	  if(checkbox.checked){
	                		  checkbox.checked = false;
	                	  } 
	                   });
	                    alert('두 개 이상 선택이 불가합니다.');
	                }
	            }
			}
		}
	}
	
	//열증감 요청함수
	function column(column){
		let row = document.getElementById('row').value;
		
		let param='row='+row+'&col='+column+'&theateridx='+${tidx};
		sendRequest('/amor/admin/theater/addSeate.do',param,columnResult,'GET');
	}
	
	//열증감 응답함수
	function columnResult(){
		if(XHR.readyState == 4){
			if(XHR.status == 200){
				
				let data = XHR.responseText;
				let objData = JSON.parse(data);
				let seats = objData.seats;
				document.getElementById('seats').innerHTML = seats;
				
				let checkboxes = document.querySelectorAll('input[name="seats"]');
				
	            // 기존에 등록된 이벤트 리스너 모두 제거
	            checkboxes.forEach(checkbox => {
	                checkbox.removeEventListener('click', handleCheckbox);
	            });

	            // 사용자가 checkbox를 클릭했을때 실행되는 함수 정의
	            checkboxes.forEach(checkbox => {
	                checkbox.addEventListener('click', handleCheckbox);
	            });

	            // checkbox 2개 이상 선택했을 경우 추가 선택을 막음(checked는 계속 가능)
	            function handleCheckbox(e) {
	                let max = 2;

	                let checkedCheckboxes = Array.from(checkboxes).filter(checkbox => checkbox.checked);

	                if (checkedCheckboxes.length > max) {
	                	
	                    e.preventDefault();
	                    
	                   let box = document.getElementsByName('seats');
	                   
	                   box.forEach(function(checkbox){
	                	  if(checkbox.checked){
	                		  checkbox.checked = false;
	                	  } 
	                   });
	                    alert('두 개 이상 선택이 불가합니다.');
	                }
	            }
			}
		}
	}
	
	//통로생성 함수
	function path(){
		
		let row = document.getElementById('row').value;
		let column = document.getElementById('column').value;	
		let box = document.getElementsByName('seats');
		
		let data = [];
						
		box.forEach(function(checkbox){ 		
			if(checkbox.checked){						
				data.push(checkbox.value);				
			}
		});
		
		// 클릭된 checkbox의 좌표값이 담긴 value를 split으로 나눠담음
		let datarowblock = data[0].split(',');
		let datacolblock = data[1].split(',');	
		
			
			let allrow_1 = parseInt(datarowblock[0]);
			let allrow_2 = parseInt(datacolblock[0]);
			let allcolumn_1 = parseInt(datarowblock[1]);
			let allcolumn_2 = parseInt(datacolblock[1]);
			
			let allrow = parseInt(allrow_1+allrow_2);
			let allcolumn = parseInt(allcolumn_1+allcolumn_2);
			
			//열 통로 2개생성 조건
			let doublerowblock = (parseInt(allrow_1-allrow_2) == 1) || (parseInt(allrow_1-allrow_2) == -1);
			
			//행통로 2개생성 조건
			let doublecolblock = (parseInt(allcolumn_1-allcolumn_2) == 1) || (parseInt(allcolumn_1-allcolumn_2) == -1);
			
			console.log(allrow+'<'+allcolumn);
			console.log(allrow < allcolumn);
			
		//행지우기	
		if(datarowblock[0] == datacolblock[0]){
			let rowbox = document.getElementsByName(datarowblock[0]);
			
			for(let i = 0 ; i < box.length; i++){
				if(box[i].value.slice(0,datarowblock[0].length) == datarowblock[0]){
					
					box[i].checked = false;
					box[i].value = 0;
					box[i].disabled = true;
					
					for(let j = 0 ; j < rowbox.length; j++){
						rowbox[j].style.display = 'none';
					}
				}
			}
		
		//열지우기
		}else if(datarowblock[1] == datacolblock[1]){
			
			
			
			for(let i = 1 ; i <= box.length; i++){
			let colbox = document.getElementById('boxnum'+i);
			
			let value=colbox.getAttribute('value');
			if(colbox){
				if(value == datacolblock[1]){
					colbox.style.display = 'none';
				}
			}
			
			if(parseInt(value)-1 >= parseInt(datacolblock[1]) || column == parseInt(datacolblock[1])){
				if(column != parseInt(datacolblock[1])){					
				colbox.innerHTML = colbox.innerHTML-1;
				}
				
			for(let j = 0 ; j < box.length; j++){
				
				let rowblock = box[j].value;
				let result = rowblock.split(',');
				
				if(result[1] == datacolblock[1]){
										
					box[j].checked = false;
					box[j].value = 0;
					box[j].disabled = true;
					
				}
			}
		}					
	}
			//행열 지우기(두행을합친것보다 열이더 크면 행을지운다)
		}else if(doublerowblock){
				
				let firstHideNum = document.getElementsByName(datarowblock[0]);
				let lastHideNum = document.getElementsByName(datacolblock[0]);
				
				let count = 0;
				
				for(let i = 0 ; i < box.length; i++){
					
				let firstblock = box[i].value.slice(0,datarowblock[0].length) == datarowblock[0];
				let lastblock = box[i].value.slice(0,datacolblock[0].length) == datacolblock[0];				
				
				if(firstblock || lastblock){
						
						box[i].checked = false;
						box[i].value = 0;           
						box[i].disabled = true;
						parseInt(count++);
						
						
					}
				}
						for(let j = 0 ; j < firstHideNum.length; j++){
							firstHideNum[j].style.display = 'none';
							lastHideNum[j].style.display = 'none';
						}
			//열 통로 만들기(두개의 열을 합친것보다 행이더 크면 열을 지운다)
			}else if(doublecolblock){
				
				for(let i = 1 ; i <= box.length; i++){
					
					let colbox = document.getElementById('boxnum'+i);
					let value=colbox.getAttribute('value');
					
					if(colbox){
						if(value == datarowblock[1] || value == datacolblock[1]){
							colbox.style.display = 'none';
						}
					}
					
				if(parseInt(value-1) >= parseInt(datarowblock[1]) || parseInt(value-1) >= parseInt(datacolblock[1])){
					
						colbox.innerHTML = colbox.innerHTML-2;
						
					for(let j = 0 ; j < box.length; j++){
						
						let firstblock = box[j].value.slice(datarowblock[0].length+1,box[j].length) == datarowblock[1];
						let lastblock = box[j].value.slice(datacolblock[0].length+1,box[j].length) == datacolblock[1];
						
						if(firstblock || lastblock){												
							box[j].checked = false;
							box[j].value = 0;
							box[j].disabled = true;
						}
						}
					}	
				}						
			}else{
				alert('통로는 2줄씩만 가능합니다.');
				for(let i = 0 ; i < box.length; i++){
					box[i].checked = false;
				}
			}		
		}
</script>
</html>