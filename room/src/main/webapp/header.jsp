<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		
</head>
<body>
	<h3>메인</h3>
	<!-- 고은시[10/25] -->
	<% String loginid = (String)session.getAttribute("mid"); %>
			
	<ul class="hd_sub">	<!-- 상단메뉴 -->
	<!-- 비로그인 메뉴 -->
	<% if(loginid == null){ %>
			<li> <a href="/room/user/usersingup.jsp">회원가입</a> </li>
			<li> <a href="/room/user/userlogin.jsp">로그인</a> </li>
	<%}else if(loginid.equals("admin")){//관리자로그인 햇다 %>
				<li> <a href="#">관리자페이지</a> </li>
		
	<%}else{//로그인 햇다 %>
			<li> <%= loginid %>님 안녕하세요 </li>
			<li> <a href="/room/header.jsp">로그아웃</a> </li>
	<% } %>
			<li> <a href="/room/user/userid.jsp">아이디 찾기</a> </li>
			<li> <a href="/room/user/userPW.jsp">비밀번호 찾기</a> </li>
		</ul>	<!-- 상단메뉴 끝 -->

	
	<div class="webbox">
		<ul class="hd_manu">
			<li> <a href="/room/qboard/qwrite.jsp">문의사항</a> </li>
			<li> <a href="#">공지사항</a> </li>
			<li> <a href="#">리뷰</a> </li>
		</ul>
	</div>
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
</body>
</html>