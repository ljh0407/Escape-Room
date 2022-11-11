<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
      .box_title{
         font-family: 'yg-jalnan';
         text-align: center;   /* 내용물 가운데 배치 */
         margin: 0 auto;      /* 레이아웃 가운데 배치 */
         width: 20%;   /* 가로사이즈 */
         border-bottom: 2px #999999 solid; /* 테두리 길이[ width ] -> 경계선 */
         padding-top: 10%;
         padding-bottom: 1%;
         font-family: 'GangwonEduPowerExtraBoldA';
      }
      @font-face {
          font-family: 'GangwonEduPowerExtraBoldA';
          src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduPowerExtraBoldA.woff') format('woff');
          font-weight: normal;
          font-style: normal;
      }
   </style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
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
		<h1 class="box_title">관리자메뉴</h1>
		<ul class="side_menu"> 
			<li class="side_item"> <a href="/room/admin/Questions/adminqlist.jsp">문의사항</a> </li>
			<li class="side_item"> <a href="/room/admin/rboard/radminrewrite.jsp">리뷰</a> </li>
			<li class="side_item"> <a href = "/room/nboard/nadmin.jsp">공지사항</a> </li>
			<li class="side_item"> <a href = "#">회원관리[회원 목록(탈퇴) ]</a> </li>
			<li class="side_item"> <a href="/room/user/userlogout.jsp">로그아웃</a> </li>
		</ul>
	</div>	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript" src="../rboard/js/adminrlist.js"></script>
	
</body>
</html>