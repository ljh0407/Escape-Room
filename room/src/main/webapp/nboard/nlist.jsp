<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
		<%@include file="../header.jsp" %>
			<div class= "webbox container">
			
			<h1 class="box_title"> Notice </h1>
			
			<table class="ntable table my-3" >		
				
			</table>	
			
			<nav >
			  <ul class=" pagebox pagination justify-content-center">
			   
			  </ul>
			</nav>
			
			<div class="row justify-content-center g-0">
				<div class="col-md-1">
					<select class="key form-select">
						<option value="n.ntitle">제목</option>
						<option value="n.content">내용</option>
						<option value="m.mid">작성자</option>
					</select>
				</div>
				<div class="col-md-2">
					<input class="keyword form-control" type="text" placeholder="검색어">
				</div>
				<div class="col-md-1">
					<button type="button" class="btn btn-dark form-control" onclick="bsearch()">검색</button>
				</div>
				
			</div>
			</div>
			
		<script src="../nboard/njs/nlist.js"  type="text/javascript"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>