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
				
					<b>name</b>	<input type="text" id="mname" name="mname" onkeyup="mevent1()">
					<div class="col"></div>	<!-- class 없다고 생각하고 css 작업하기 -->
					<b>ID</b>	<input type="text" id="mid" name="mid" onkeyup="mevent2()">
					<div class="col"></div>
					<b>Password</b>	<input type="text" id="mpw" name="mpw" onkeyup="mevent3()">
					<div class="col"></div>
					<b>Phone number</b>	<input type="text" id="mphone" name="mphone" onkeyup="mevent4()">
					<div class="col"></div>
				
				<h3 class="parttitle">이용약관</h3>
					<span class="confirmbox ">
						<textarea readonly="readonly">room escape 서비스를 이용하시거나 room escape 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 
						운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.</textarea> <br>
						<input id="confirm1" type="checkbox"> <span>[필수] 이용약관 동의</span> <br>
						<br>
						<textarea readonly="readonly">개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 
						동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.</textarea> <br>
						
						<input id="confirm2" type="checkbox">  <span>[필수] 개인정보 수집 동의</span>
					</span>
					<br>
					<div class="singup_btn">
						<button class="find_btn1" type="button" onclick="formsubmit()">Sign Up Go!!</button> 	<!-- 회원가입 -->
						<button class="find_btn1" type="reset">cancellation</button> 	<!-- 취소 -->
					</div>
			</div>	<!-- 전체 div -->	
		</form>
	
	
	<!-- 푸터 연결 -->
	<%@include file="../Footer.jsp" %>  
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../user/ujs/usersingup.js"></script>
	
</body>
</html>