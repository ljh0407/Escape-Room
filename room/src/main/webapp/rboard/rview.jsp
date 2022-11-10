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
		<h3 class="box_title title">review</h3>
		<table class="box_title table">
			<tr> <td>  <td> <td> <img alt="" src=""  class="rfile"> </td> </tr>
			<tr> <td> 게시물번호 <td> <td class="rno"> </td> </tr>
			<tr> <td > 제목 <td> <td class="rtitle"> </td> </tr>
			<tr> <td> 내용 <td> <td class="rcontent"> </td> </tr>
			<tr> <td> 리뷰점수 <td> <td class="rscore"> </td> </tr>
			<tr> <td> 작성일 <td> <td class="rdate"> </td> </tr>
			<tr> <td> 회원번호 <td> <td class="mno"> </td> </tr>
			<tr> <td> 댓글 <td> <td class="rcomment"> </td> </tr>
		</table>
		
		<div class="btnbox">
			<a href="rlist.jsp"><button class="btn btn-dark">글목록</button> </a>
		</div>
		
		<div class="rcommentbox"> 
		<!--  
		<input class="rcomment"> 
			<button type="button" onclick="rewrite()" class="btn btn-dark">댓글달기</button>
		</div>
		-->
	
	</div>
	
	<script type="text/javascript" src="/room/rboard/js/rview.js"></script>

</body>
</html>