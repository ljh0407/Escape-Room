<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@include file="../header.jsp" %>
		
		<h2> 후기 게시판 </h2>
		제목 : <input class="rbtitle" type="text"><br>
		<input type="text" class="rbcontent" placeholder="300자이내로 작성해주세요.">
		<input type="file" class="rbimg">파일첨부
		<button onclick="review()">평점주기</button>
		<button onclick="rbwrite()">글쓰기</button>
		
		
		<!-- jquery 라이브러리 (api)-->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="../js/board/rbboard.js"></script>

</body>
</html>