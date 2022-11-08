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
	<a href="rwrite.jsp"> 글쓰기 </a>
		<!-- 모든글 출력 -->
		<table class="rlisttable">
				<tr>
					<th>게시글번호</th> <th>제목</th> <th>작성일</th> <th>조회수</th> <th>회원번호</th>
				</tr>
			</table>
				<button type="button" onclick="list()">글목록</button>			
		
		
		
		<!-- 5.게시물 표시 개수 -->
		<div> 게시물 수 : <span class="totalsize"></span> </div>
		<!-- 6.화면에 표시할 게시물 수 -->
		<div>
			<select class="listsize" onchange="rlistsize()">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
			</select>
		
		</div>
		
		<table class="rtable table">
		<tr><!-- 2.제목 클릭시 상세페이지 -->
			<th> 번호  </th><th>  제목  </th> <th> 작성자 </th>
			<th>  작성일  </th>  <th> 조회수 </th> 
		</tr>
				
			
		</table>
		
		<div class="pagebox"> <!-- 3.페이징처리 -->
		
		</div>
		<div> <!-- 4.검색처리 -->
			<select class="key">
				<option value="r.rtitle">제목</option>
				<option value="r.rcontent">내용</option>
				<option value="r.mno">작성자</option>
			</select>
			
			<input class="keyword" type="text" placeholder="검색어">
			<button type="button" onclick="rsearch()">검색</button>
			
		</div>
		
	</div>
		
		<script type="text/javascript" src="js/rlist.js"></script>

</body>
</html>