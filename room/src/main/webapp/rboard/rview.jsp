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
		<h3> 글 조회 </h3>
		<table>
			<tr> <td> 게시물번호 <td> <td class="rno"> </td> </tr>
			<tr> <td > 제목 <td> <td class="rtitle"> </td> </tr>
			<tr> <td> 내용 <td> <td class="rcontent"> </td> </tr>
			<tr> <td> 리뷰점수 <td> <td class="rscore"> </td> </tr>
			<tr> <td> 사진 <td> <td class="rfile"> </td> </tr>
			<tr> <td> 작성일 <td> <td class="rdate"> </td> </tr>
			<tr> <td> 조회수 <td> <td class="rview"> </td> </tr>
			<tr> <td> 회원번호 <td> <td class="mno"> </td> </tr>
		</table>
		
		<div class="rbtnbox">
			<a href="rwrite.jsp"><button>글목록</button> </a>
		</div>
		
		<div class="rcommentbox"> 
		<input class="rcomment"> <!-- 댓글창 -->
			<button type="button" onclick="rewrite()">댓글달기</button>
		
		</div>
	
	</div>
	
	<script type="text/javascript" src="/room/rboard/js/rview.js"></script>

</body>
</html>