<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<!-- 사용자 정의 css 호출  -->
		<link rel="stylesheet" href="/room/css/user/userlogin.css">
		
</head>
<body>
	
	<%@include file="../header.jsp" %>
	
	<div class="userlogin">
		<h3 class="login">Login</h3> <br>
		
			<div class="idbox">
				ID	<input class="mloginbox" type="text" id="mid" placeholder="Please enter your ID"><br>
				Password <input class="mloginbox" type="password" id="mpw" placeholder="Please enter a password"> <br>
				<input class="loginbutton" type="submit" onclick="login()" value="Login">	<br>
				<div class="singup_btn">
						<button class="find_btn1" type="button" onclick="formsubmit()"><a href="/room/user/userid.jsp">find ID</button> 	<!-- 아이디 찾기 -->
						<button class="find_btn1" type="reset"><a href="/room/user/userPW.jsp">Forgot your password</button> 	<!-- 비밀번호 찾기 -->
				</div>	
			</div>
		<div id="loginbox"></div> <!-- 결과 메세지  -->
	</div>	
	
	
	<!-- 푸터 연결 -->
	<%@include file="../Footer.jsp" %> 	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../user/ujs/userlogin.js"></script>
</body>
</html>