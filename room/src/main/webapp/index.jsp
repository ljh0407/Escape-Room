<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<!-- 사용자 정의 css 호출  -->
		<link rel="stylesheet" href="/room/css/index.css">
</head>
<body>
		<%@include file="header.jsp" %>
		
		<ul class="hd_menu">
				<li class="one"> <a href="/room/qboard/qlist.jsp"><img class="img1" alt="" src="/room/img/문의사항.png"></a> </li>	<!-- 문의사항 -->
				<li class="two"> <a href="/room/nboard/nlist.jsp">공지사항</a> </li>
				<li class="three"> <a href="#">리뷰</a> </li>
				
		</ul>
		
		
		 <%@include file="Footer.jsp" %> 
		
</body>
</html>