<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<!-- 사용자 정의 css 호출  -->
		<link rel="stylesheet" href="/room/css/user/userid.css">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="findidbox">
		<h3 class="hdfind">Find ID</h3> <br>
		user name <input class="find" type="text" id="mname"  placeholder="What's your name?"> <br>
		phone number<input class="find" type="text" id="mphone" placeholder="Please phone number ?">
		<div id="findID"></div>  
		<br> <button type="button" onclick="IDfind()">let's go find !</button>
		
	</div>
	
	
	
	
	
	
	
	<!-- 푸터 연결 -->
	<%@include file="../Footer.jsp" %> 
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../user/ujs/userid.js"></script>
</body>
</html>