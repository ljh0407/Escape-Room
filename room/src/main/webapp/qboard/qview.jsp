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

</head>
<body>
	<!-- 고은시[10/27] 개별 글조회 -->
	<!-- [11/01]회원가입안해도 글쓰고 볼 수 있게 해보기 -->
	<%@include file="../../header.jsp" %>
	
	<div class="webbox container"> <!-- 글조회 -->
		<h3 class="box_title">글조회</h3>
		<table class="box_title table">
			<tr> <td> 번호	</td>	<td class="bno">		</td> </tr>
			<tr> <td> 제목	</td>	<td class="btitle">		</td> </tr>
			<tr> <td> 내용	</td>	<td class="bcontent">	</td> </tr>
			<tr> <td> 작성자	</td>	<td class="mid">		<td> </tr>
			<tr> <td> 파일	</td>	<td class="bfile">		<td> </tr>
			<tr> <td> 댓글	</td>	<td class="reply">		<td> </tr>
		</table>
	</div>
	
	<div class="btnbox"> <!-- 목록으로 돌아가기 -->
		<a href="/room/qboard/qlist.jsp"><button>목록보기</button></a>	
	</div>
	
	<div class="replylist"> </div><!-- 댓글출력 -->
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../qboard/qjs/qview.js"></script>
	
</body>
</html>