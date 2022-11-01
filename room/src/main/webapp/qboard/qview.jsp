<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 고은시[10/27] 개별 글조회 -->
	<!-- [11/01]회원가입안해도 글쓰고 볼 수 있게 해보기 -->
	<%@include file="../../header.jsp" %>
	
	<div> <!-- 글조회 -->
		<h3>글조회</h3>
		<table>
			<tr> <td> 번호	</td>	<td class="bno">		</td> </tr>
			<tr> <td> 제목	</td>	<td class="btitle">		</td> </tr>
			<tr> <td> 내용	</td>	<td class="bcontent">	</td> </tr>
			<tr> <td> 댓글 	</td>	<td class="reply">		<td> </tr>
			<tr> <td> 작성자	</td>	<td class="mid">		<td> </tr>
			<tr> <td> 파일	</td>	<td class="bfile">		<td> </tr>
		</table>
	</div>
	
	<div class="btnbox"> <!-- 목록으로 돌아가기 -->
		<a href="/room/qboard/qlist.jsp"><button>목록보기</button></a>	
	</div>
	
	<div class="replybox"> <!-- 고은시[11/01] 관리자만 댓글 수정중 -->
	<%	
		// 세션은 오브젝트로 들어가기때문에 형변환 필수
		String mid = (String)session.getAttribute("mid");
		if(mid == null || !mid.equals("admin")){
			response.sendRedirect("/room/user/userlogin.jsp");
		}
	%>
									<!-- 고은시[11/01] 클래스명 수정 -->
		<textarea rows="" cols="" class="qrcontent"></textarea>
		<button type="button" onclick="rwrite()">댓글작성</button>
	</div>
	
	<div class="replylist"> </div><!-- 댓글출력 -->
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../qboard/qjs/qview.js"></script>
	
</body>
</html>