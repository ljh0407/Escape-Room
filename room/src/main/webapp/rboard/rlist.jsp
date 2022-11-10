<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<style type="text/css">
	
		.box_title{
			font-family: 'yg-jalnan';
			text-align: center;	/* 내용물 가운데 배치 */
			margin: 0 auto;		/* 레이아웃 가운데 배치 */
			width: 20%;	/* 가로사이즈 */
			border-bottom: 2px #999999 solid; /* 테두리 길이[ width ] -> 경계선 */
			padding-top: 10%;
			padding-bottom: 1%;
			font-family: 'GangwonEduPowerExtraBoldA';
		}
		
		@font-face {
		    font-family: 'GangwonEduPowerExtraBoldA';
		    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduPowerExtraBoldA.woff') format('woff');
		    font-weight: normal;
		    font-style: normal;
		}
	
	</style>


<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	
	<%@include file="../../header.jsp" %>
		
	<div class="webbox container">
	
		<h1 class="box_title">Review</h1>
		<!-- 모든글 출력 -->
		<table class="rlisttable table my-3">
			<!--  
				<tr>
					<th>게시글번호</th> <th>제목</th> <th>회원번호</th> <th>작성일</th> 
				</tr>
				-->
			</table>
							
		
		
		
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
		
		  
		
		     			
			
		
		<div class="pagebox pagination justify-content-center"> <!-- 3.페이징처리 -->
		
		</div>
		<div> <!-- 4.검색처리 -->
			<select class="key">
				<option value="r.rtitle">제목</option>
				<option value="r.rcontent">내용</option>
				<option value="r.mid">작성자</option>
			</select>
			
			<input class="keyword" type="text" placeholder="검색어">
			<button type="button" onclick="rsearch()" class="btn btn-dark">검색</button>
			<a href="rwrite.jsp"><button class="btn btn-dark">글쓰기</button></a>
			<a href="/room/rboard/rlist.jsp"><button type="button" class="btn btn-dark">글목록</button></a>		
			
			<nav >
			  <ul class=" pagebox pagination justify-content-center">
			   	
			  </ul>
			</nav>
			
			
		</div>
		
	</div>
		
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
		<script type="text/javascript" src="js/rlist.js"></script>

</body>
</html>