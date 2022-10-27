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
	<!-- 비회원이 글쓰기를 할 수 있고 회원가입안해도 글쓰고 볼 수 있게 해보기 -->
	<%@include file="../../header.jsp" %>
	
	<div> <!-- 글조회 -->
		<h3>글조회</h3>
		<table>
			<tr> <td> 번호	</td>	<td class="bno">		</td> </tr>
			<tr> <td> 제목	</td>	<td class="btitle">		</td> </tr>
			<tr> <td> 내용	</td>	<td class="bcontent">	</td> </tr>
			<tr> <td> 작성자	</td>	<td class="mid">		<td> </tr>
			<tr> <td> 첨부파일	</td>	<td class="bfile">		<td> </tr>
		</table>
	</div>
	
	<div class="btnbox"> <!-- 목록으로 돌아가기 -->
		<a href="/room/qboard/qboardlist.jsp"><button>목록보기</button></a>	
	</div>
	
	<div class="replybox"> <!-- 관리자만 댓글 -->
	<%-- <!-- 관리자로그인 안되어 있으면 글 목록이동 -->
	<% if( loginid == null ) response.sendRedirect("/room/qboard/qlist.jsp");  %>
	<!-- 관리자로그인 되어있으면 댓글작성 -->
	<% if( loginid == "admin" ) response.sendRedirect("#");  %> --%>
		<textarea rows="" cols="" class="rcontent"></textarea>
		<button type="button" onclick="rwrite()">댓글작성</button>
	</div>
	
	<div class="replylist"> </div><!-- 댓글출력 -->
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../qboard/qjs/qview.js"></script>
	
</body>
</html>