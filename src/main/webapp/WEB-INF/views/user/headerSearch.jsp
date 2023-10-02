<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp" %>
<style>
.frame-580,
.frame-580 * {
  box-sizing: border-box;
}
.frame-580 {
  display: flex;
  flex-direction: column;
  gap: 0px;
  align-items: flex-start;
  justify-content: flex-start;
  flex-shrink: 0;
  position: relative;
}
.frame-568 {
  display: flex;
  flex-direction: column;
  gap: 0px;
  align-items: flex-start;
  justify-content: flex-start;
  flex-shrink: 0;
  position: relative;
}
.frame-566 {
  display: flex;
  flex-direction: column;
  gap: 0px;
  align-items: flex-start;
  justify-content: flex-start;
  flex-shrink: 0;
  position: relative;
}
.frame-562 {
  display: flex;
  flex-direction: row;
  gap: 0px;
  align-items: flex-start;
  justify-content: flex-start;
  flex-shrink: 0;
  position: relative;
}
.movie-poster {
  border-radius: 5px;
  flex-shrink: 0;
  width: 259px;
  height: 337px;
  position: relative;
}
.frame-567 {
  display: flex;
  flex-direction: column;
  gap: 0px;
  align-items: flex-start;
  justify-content: flex-start;
  flex-shrink: 0;
  position: relative;
}
.frame-563 {
  padding: 18px 10px 10px 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  flex-shrink: 0;
  width: 259px;
  position: relative;
}
. {
  color: #000000;
  text-align: left;
  font: 400 24px "Inter", sans-serif;
  position: relative;
}
.frame-565 {
  padding: 10px 10px 14px 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  flex-shrink: 0;
  width: 259px;
  position: relative;
}
._8-3-2023-11-04 {
  color: #000000;
  text-align: left;
  font: 400 16px "Inter", sans-serif;
  position: relative;
}
.frame-569 {
  display: flex;
  flex-direction: column;
  gap: 0px;
  align-items: flex-start;
  justify-content: flex-start;
  flex-shrink: 0;
  position: relative;
}
.ticketing-button {
  background: #1a2c82;
  border-radius: 3px;
  padding: 5px 47px 5px 47px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
  width: 259px;
  height: 53px;
  position: relative;
  overflow: hidden;
}
.2 {
  color: #ffffff;
  text-align: left;
  font: 400 16px "Inter", sans-serif;
  position: relative;
}

</style>
<body>
<c:if test="${!empty lists}">
	<c:forEach var="temp" items="${lists}">
		<div class="frame-580">
		  <div class="frame-568">
		    <div class="frame-566">
		      <div class="frame-562">
		        <img class="movie-poster" src="movie-poster.png" />
		      </div>
		    </div>
		    <div class="frame-567">
		      <div class="frame-563">
		        <div class="">${movie_name}</div>
		      </div>
		      <div class="frame-565">
		        <div class="_8-3-2023-11-04">평점 8.3% | ${movie_opendate}</div>
		      </div>
		    </div>
		  </div>
		  <div class="frame-569">
		    <div class="ticketing-button">
		      <div class="2">예매하기</div>
		    </div>
		  </div>
		</div>
	</c:forEach>
</c:if>
<c:if test="${empty lists}">
<div>검색된 결과가 없습니다.</div>
</c:if>

</body>
<%@ include file="footer.jsp" %>
</html>