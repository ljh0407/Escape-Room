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
			<h3>글 수정</h3>
			
			<form>
				제목  <input type="text" class="rtitle"> <br>
				내용  <textarea rows="" cols="" class="rcontent"></textarea>
				첨부파일 <input type="file" class="rfile"><br>
				
				<div class="oldrfile"></div><br>
				
				<button onclick="rupdate()">수정</button>
				
			</form>
		
		</div>
		
		<script type="text/javascript" src="/room/rboard/js/rupdate.js"></script>
</body>
</html>