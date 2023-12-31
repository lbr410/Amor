<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아모르 관리자 : 상영관 생성</title>
<link rel="stylesheet" href="/amor/resources/css/admin/theaterList.css" />
</head>
<body>
<%@include file="../admin_header.jsp" %>
<div class="content">
<div class="content-title"><label class="titletext">상영관 목록</label>
</div>

<input type = "button" value = "상영관 추가" class = "button" onclick = "theaterAdd()">
<c:if test="${!empty lists}">
<div class = "container">
<c:forEach var="temp" items="${lists}">
<div class="theater" id = "${temp.theater_idx}">
  <div class="theaterbox">
    <div class="theatername"></div>
    <div class="name">${temp.theater_name}</div>
  </div>
  <c:url var="seateSelect" value="/admin/theater/seateSelect.do">
  	<c:param name="theateridx">${temp.theater_idx}</c:param>
  	<c:param name="theatername">${temp.theater_name}</c:param>
  	<c:param name="row">${temp.theater_row}</c:param>
  	<c:param name="col">${temp.theater_column}</c:param>
  </c:url>
  <a href = "${seateSelect}"><div class="addbox">
    <svg
      class="addimg"
      width="29"
      height="29"
      viewBox="0 0 29 29"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M0 -0.5H-0.5V0V29V29.5H0H29H29.5V29V0V-0.5H29H0Z"
        fill="white"
        stroke="black"
      />
    </svg>

    <svg
      class="wright"
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        fill-rule="evenodd"
        clip-rule="evenodd"
        d="M19.4142 2.41421C18.6332 1.63317 17.3668 1.63316 16.5858 2.41421L3.39881 15.6012L3.058 20.0996L7.55644 19.7588L20.7434 6.57184C21.5245 5.79079 21.5245 4.52446 20.7434 3.74341L19.4142 2.41421ZM16.8121 8.12734L15.0303 6.3455L5.13114 16.2446L4.81017 18.3474L6.91298 18.0265L16.8121 8.12734Z"
        fill="#1A2C82"
      />
    </svg>
  </div></a>
  <div class="delbox" onclick = "theaterDel(${temp.theater_idx})">
    <div class="delimg"></div>
    <svg
      class="bin"
      width="24"
      height="26"
      viewBox="0 0 24 26"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        fill-rule="evenodd"
        clip-rule="evenodd"
        d="M15 2.34473H9V4.48266H3V7.68955L5 7.68955V21.5861C5 22.7669 5.89543 23.724 7 23.724H17C18.1046 23.724 19 22.7669 19 21.5861V7.68955L21 7.68955V4.48266H15V2.34473ZM7 7.68955H17V21.5861H7V7.68955ZM9 10.8965H11V18.3792H9V10.8965ZM15 10.8965H13V18.3792H15V10.8965Z"
        fill="#666666"
      />
    </svg>
  </div>
</div>
</c:forEach>
</div>
</c:if>
</div>
</body>
<script type="text/javascript" src="../../resources/js/httpRequest.js"></script>
<script>
	
	function theaterAdd(){
		sendRequest('/amor/admin/theater/createTheater.do',null,showResult,'GET');
	}
	
	function showResult(){
		if(XHR.readyState == 4){
			if(XHR.status == 200){
				let data = XHR.responseText;
				let objData = JSON.parse(data);
				let msg = objData.alert;
					if(msg == null){					
						location.reload();
					}else {					
						alert(msg);
					}
				}
			}
		}
	
	function theaterDel(tidx){
		let delcheck = window.confirm("상영관을 삭제하시겠습니까?");
		if(delcheck){
			let param = 'tidx='+tidx;
			sendRequest('/amor/admin/theater/theaterDelete.do',param,delResult,'GET')
		}
	}
	
	function delResult(){
		if(XHR.readyState == 4){
			if(XHR.status == 200){
				let data = XHR.responseText;
				let objData = JSON.parse(data);
				let tidx = objData.tidx;
				let msg = objData.alert;
			if(msg == null){					
				let getNode = document.getElementById(tidx);
				let parentNode = getNode.parentNode; 
				parentNode.removeChild(getNode);
			}else{
				alert(msg);
			}
		}
	}
}

</script>
</html>