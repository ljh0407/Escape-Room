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
			<h3> 공지사항</h3>
			<table class="ntable">
				<tr><td>번호</td><td class="nno"> </td></tr>
				<tr><td>제목</td><td class="ntitle"> </td></tr>
				<tr><td>내용</td><td class="ncontent"></td></tr>
				<tr><td>작성자</td><td class="mid"></td></tr>
			</table>
	
				<div class="btnbox">
				<a href="nlist.jsp"><button>목록보기</button></a>
				</div>	
		</div>
		
		
		<script type="text/javascript" src="../nboard/njs/nview.js"></script>

</body>
</html>