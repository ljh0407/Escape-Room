<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<!-- 사용자 정의 css 호출  -->
		<link rel="stylesheet" href="/room/css/user/userPW.css">
</head>
<body>
	
	<%@include file="../header.jsp" %>
	
	<div class="passwordbox">
		<h3 class="hdpassword">Forgot your password</h3> <br>
		user ID <input class="passw" type="text" id="mid" placeholder="Please enter your ID"> <br>
		phone number <input class="passw" type="text" id="mphone" placeholder="Please phone number ?">
		<div id="findPW"></div> <!-- 결과메세지 -->
		<br><button type="button" onclick="finepw()">let's go find !</button>
	</div>
	
	
	<!-- 푸터 연결 -->
	<%@include file="../Footer.jsp" %> 
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../user/ujs/userpw.js"></script>
</body>
</html>