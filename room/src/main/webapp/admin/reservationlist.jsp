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
			color: black;
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
		<div class="container" >
			<h3 class="box_title"> 예약 목록 </h3>
			<table class="retable  table my-5">
				<tr>
					<th>아이디</th>
				</tr>
			
			</table>
			</div>

			<script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
		<script  src="/room/admin/js/reservationlist.js" type="text/javascript"></script>			
</body>
</html>