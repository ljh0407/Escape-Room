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
		<textarea class="rbcontetnt" rows="20px;" cols="40px;" placeholder="300자이내로 작성해주세요."></textarea>
		<button onclick="review()">평점주기</button>
		<button onclick="rbwrite()">글쓰기</button>
		
		
		
		<!-- jquery 라이브러리 (api)-->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="../js/reviewboard.js"></script>

</body>
</html>