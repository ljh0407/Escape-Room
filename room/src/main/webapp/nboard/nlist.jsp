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
			<div class= "webbox">
			
			<a href="nwrite.jsp">글쓰기</a>
			<table>		
				<tr>
					<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> <!-- 2. 제목클릭시 상세페이지 -->
					<th> 작성일 </th> <th> 조회수 </th>
				</tr>
			
			</table>	
			</div>
			
		<script src="../nboard/njs/nlist.js"  type="text/javascript"></script>
		
</body>
</html>