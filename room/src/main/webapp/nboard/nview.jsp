<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

.box_title{
	font-family: 'yg-jalnan';
	text-align: center;	/* 내용물 가운데 배치 */
	margin: 0 auto;		/* 레이아웃 가운데 배치 */
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
.ncontent{
	font-family: 'yg-jalnan';
	text-align: left;	/* 내용물 가운데 배치 */
	margin: 0 auto;		/* 레이아웃 가운데 배치 */
	padding-top: 50px;
	width: 70%;	/* 가로사이즈 */
	
}

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<%@include file="../../header.jsp" %>
		
		<div class="webbox container">
			<h1 class="box_title ntitle"> Notice <span class="nno" ></span> </h1>
			<div class="ncontent" >
			
			</div>
			<a href="nlist.jsp"><button class="btn btn-dark">목록보기</button></a>
		</div>
		
		
		<script type="text/javascript" src="../nboard/njs/nview.js"></script>

</body>
</html>