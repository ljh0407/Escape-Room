<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자 정의 css 호출  -->
	<link rel="stylesheet" href="/room/css/header.css">

		
</head>
<body>
	
	<!-- <img alt="" src="/room/img/로고.png"> 로고 늘까 말까 고민중 -->
		
	<div class="webbox">	<!-- 웹 박스권 -->
		<div class="hd_top">	<!-- 상단 헤더 -->
			<div> <!-- 로고 -->
				<span class="hd_title">
					<a href="/room/index.jsp">room escape</a>	
				</span>	
			</div>
			
		<!-- 고은시[10/25] -->
		<% String loginid = (String)session.getAttribute("mid"); %>	
			
		<ul class="hd_sub">	<!-- 상단메뉴 -->
		<!-- 비로그인 메뉴 -->
		<% if(loginid == null){ %>
				<li> <a href="/room/user/usersingup.jsp">Sign Up</a> </li>	<!-- 회원가입 -->
				<li> <a href="/room/user/userlogin.jsp">login</a> </li>		<!-- 로그인 -->
		<%}else if(loginid.equals("admin")){//관리자로그인 햇다 %>
					<li> <a href="#">관리자페이지</a> </li>
		
		<%}else{//로그인 햇다 %>
				<li> <%= loginid %>님 안녕하세요 </li>
				<li> <a href="/room/header.jsp">Log out</a> </li>			<!-- 로그아웃 -->
		<% } %>
				<li> <a href="/room/user/userid.jsp">find ID</a> </li>		<!-- 아이디 찾기 -->
				<li> <a href="/room/user/userPW.jsp">Forgot your password</a> </li>	<!-- 비밀번호 찾기 -->
			</ul>	<!-- 상단메뉴 끝 -->
			
		</div>	<!-- 상단 헤더 div end -->
			<!-- <ul class="hd_menu">
				<li class="one"> <a href="/room/qboard/qwrite.jsp">문의사항</a> </li>
				<li class="two"> <a href="#">공지사항</a> </li>
				<li class="three"> <a href="#">리뷰</a> </li>
			</ul> -->	<!-- index로 이동 -->
	</div>	<!-- webbox div end -->
	
		
		
		
		<!-- jquery 라이브러리 (api)-->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
		
	
</body>
</html>