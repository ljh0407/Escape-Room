<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<!-- 사용자 정의 css 호출  -->
		<link rel="stylesheet" href="/room/css/user/usersingup.css">
</head>
<body>
	
	<%@include file="../header.jsp" %>
	
		<form action="/room/usersingup" method="post" class="signupform">
		
			<div class="singup"> <!-- 전체 div css용-->
				<h3 class="pagetitle">Sign Up</h3><br>	<!-- 회원가입 -->
				
					<b>name</b><br>	<input type="text" id="mname" name="mname" onkeyup="mevent1()">
					<div class="col"></div>	<!-- class 없다고 생각하고 css 작업하기 -->
					<b>ID</b><br>	<input type="text" id="mid" name="mid" onkeyup="mevent2()">
					<div class="col"></div>
					<b>Password</b><br>	<input type="text" id="mpw" name="mpw" onkeyup="mevent3()">
					<div class="col"></div>
					<b>Phone number</b><br>	<input type="text" id="mphone" name="mphone" onkeyup="mevent4()">
					<div class="col"></div>
				
				<h3 class="parttitle">이용약관</h3> 
					<span class="confirmbox ">
						<textarea readonly="readonly"></textarea> <br>
						<input id="confirm1" type="checkbox"> <span>[필수] 이용약관 동의</span> <br>
						
						<textarea readonly="readonly"></textarea> <br>
						
						<input id="confirm2" type="checkbox"> <span>[필수] 개인정보 수집 동의</span>
					</span>
			
			
					<button class="signupbtnbox" type="button" onclick="formsubmit()">Sign Up Go!!</button> <br>	<!-- 회원가입 -->
					<button class="signupbtnbox" type="reset">cancellation</button> 	<!-- 취소 -->
				
			</div>	<!-- 전체 div -->	
		</form>
	
	
	<!-- 푸터 연결 -->
	<%@include file="../Footer.jsp" %>  
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../user/ujs/usersingup.js"></script>
	
</body>
</html>