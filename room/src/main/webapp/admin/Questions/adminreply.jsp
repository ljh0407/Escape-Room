<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div  class="container"> <!-- 글조회 -->
		<h3>글조회</h3>
		<table>
			<tr> <td> 번호	</td>	<td class="bno">		</td> </tr>
			<tr> <td> 제목	</td>	<td class="btitle">		</td> </tr>
			<tr> <td> 내용	</td>	<td class="bcontent">	</td> </tr>
			<tr> <td> 작성자	</td>	<td class="mid">		<td> </tr>
			<tr> <td> 파일	</td>	<td class="bfile">		<td> </tr>
			<tr> <td> 댓글	</td>	<td class="reply">		<td> </tr>
		</table>
	</div>
	
	
	<div> <a href="/room/admin/adminqlist.jsp">목록돌아가기</a> </div>
	
	<div class="replybox"> <!-- 고은시[11/01] 관리자만 댓글 수정중 -->
		<textarea rows="" cols="" class="qrcontent"></textarea>
		<button type="button" onclick="rwrite()">댓글작성</button>
	</div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="js/adminqreply.js"></script>
	
</body>
</html>