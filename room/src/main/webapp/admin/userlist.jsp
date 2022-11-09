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
			
		<div class="webbox container">
			
			<h1>회원 목록</h1>
				<table class="ustable">
					  <tr>
					  <th> 번호 </th> <th> 이름 </th>  <th> 아이디 </th><th> 핸드폰번호 </th>
					  </tr> 
				</table>
					
		</div>
			
			<script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
		<script  src="/room/admin/js/userlist.js" type="text/javascript"></script>

</body>
</html>