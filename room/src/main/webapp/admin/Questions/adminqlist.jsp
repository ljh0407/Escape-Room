<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@include file="../../admin/dashboard.jsp" %>
	
	<div>
		<table>
			<tr>
				 <th>번호</th> <th>제목</th> <th>아이디</th> <th>작성일</th> <th>답변확인</th>
			</tr>
		</table>
		<div> <a href="/room/admin/Questions/adminreply.jsp" >답변하기</a> </div>
	</div>	
	
	<script type="text/javascript" src="/room/qboard/qjs/qlist.js"></script>
	
</body>
</html>