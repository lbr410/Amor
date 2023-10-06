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
<div>${theater}</div>
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