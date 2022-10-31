<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../../header.jsp" %>
		
		<div class="webbox">
		
		<h3>리뷰 게시판</h3>

			<form>
				<input type="text" name="rtitle" class="rtitle" placeholder="제목을 적어주세요"><br>
				<textarea rows="" cols="" name="rcontent" class="rcontent" placeholder="리뷰내용작성 300자 내외"></textarea><br>		
				<input type="file" name="rfile" class="rfile">
				<button type="button" onclick="setwrite()">글등록</button>
				<button type="button">점수주기</button>
			</form>

		</div>

		<script type="text/javascript" src="../js/rwrite.js"></script>
</body>
</html>