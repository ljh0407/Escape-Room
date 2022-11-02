<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 관리자 댓글창 -->
	<%@include file="../../header.jsp" %>
	
	<%   
      // 세션은 오브젝트로 들어가기때문에 형변환 필수
      String mid = (String)session.getAttribute("mid");
      if(mid == null || !mid.equals("admin")){
         response.sendRedirect("/room/user/userlogin.jsp");
      }
   %>
   <!-- 관리자만 댓글쓰기 가능 -->
   	<div class="replybox"> <!-- 고은시[11/01] 관리자만 댓글 수정중 -->
									<!-- 고은시[11/01] 클래스명 수정 -->
		<textarea rows="" cols="" class="qrcontent"></textarea>
		<button type="button" onclick="rwrite()">댓글작성</button>
	</div>
   
	<script type="text/javascript" src="../qboard/qjs/qview.js"></script>
</body>
</html>