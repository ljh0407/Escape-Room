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
			<table class="ntable">		
				<tr>
					<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> <th> 작성일 </th> <th> 조회수 </th>
				</tr>
			
			</table>	
			<div><a href="nwrite.jsp">글쓰기</a></div>
			<div class="pagebox"> <!--  페이징처리 -->
			
			</div>
			
			<div>
				<select class="key">
					<option value="n.ntitle">제목</option>
					<option value="n.content">내용</option>
				</select>
				<input class="keyword" type="text" placeholder="검색어">
				<button type="button" onclick="bsearch()">검색</button>
					
				
			</div>
			
	
			</div>
			
		<script src="../nboard/njs/nlist.js"  type="text/javascript"></script>
		
</body>
</html>