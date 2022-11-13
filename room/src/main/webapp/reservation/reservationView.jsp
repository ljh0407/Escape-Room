<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">



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


</head>
<body>
	<%@include file="../header.jsp" %>
		<div class="container">
		
			<h1 class="box_title"> 예약하기 </h1>
			<div class="row my-5">
				<div class="col-md-4">
					<h6 class="box_title"> -테마- </h6>
					<select class="gname form-select" >
						<option>액자</option>
						<option>ball party</option>
						<option>504탈출</option>
						<option>비상탈출</option>
					</select>
				</div>
				<div class="col-md-4">
					<h6 class="box_title"> -날짜- </h6>
					<input class="gdate form-control" type="datetime-local">
				</div>
				<div class="col-md-3">
					<h6 class="box_title"> -신청- </h6>
					<button class="btn btn-dark form-control" onclick="review()">예약하기</button>
				</div>
			</div>
			
		</div>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
		
		<script src="../reservation/js/reservationView.js" type="text/javascript"></script>
		<%@include file="../Footer.jsp" %> 
</body>
</html>