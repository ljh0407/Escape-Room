<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 관리자 페이지 -->

	<!-- [11/03]고은시 관리자 페이지 -->
	<%	 //관리자만 이용가능 아이디 세션에 저장
		// 세션은 오브젝트로 들어가기때문에 형변환 필수
		String mid = (String)session.getAttribute("mid");
		if(mid == null || !mid.equals("admin")){
			response.sendRedirect("/room/user/userlogout.jsp");
		}
	%>
	<div class="sidebar">
		<h1>관리자메뉴</h1>
		<ul class="side_menu"> 
			<li class="side_item"> <a href="/room/admin/Questions/adminqlist.jsp">문의사항</a> </li>
			<li class="side_item"> <a onclick="pagechange('.jsp')">리뷰</a> </li>
			<li class="side_item"> <a onclick="pagechange('.jsp')">공지사항</a> </li>
			<li class="side_item"> <a href="/room/user/userlogout.jsp">로그아웃</a> </li>
		</ul>
	</div>	
	
	<!-- [11/03]고은시 만약 css하게되면 사용하세요 본문페이지가 보이는 구역 -->
	<div id="mainbox">
		<!-- 사이드바에서 메뉴 클릭 시 jsp가 표시되는 구역 -->
	</div>
</body>
</html>