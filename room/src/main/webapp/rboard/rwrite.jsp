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
		
		
		/* star css */
form fieldset{
    display: inline-block;
    direction: rtl;
    border:0;
}
form fieldset legend{
    text-align: right;
}
form input[type=radio]{
    display: none;
}
form label{
    font-size: 3em;
    color: transparent;
    text-shadow: 0 0 0 #f0f0f0;
}
form label:hover{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
form label:hover ~ label{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
form input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
#reviewContents {
    width: 100%;
    height: 150px;
    padding: 10px;
    box-sizing: border-box;
    border: solid 1.5px #D3D3D3;
    border-radius: 5px;
    font-size: 16px;
    resize: none;
}
		/* ------------- */
	
	</style>
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="../../header.jsp" %>
		
		<div class="webbox container">
		
		<h3 class="box_title">리뷰 게시판</h3>


			<form>
				<!--  star html   start -->
				<fieldset>
					<span class="text-bold">별점을 선택해주세요</span>
					<input type="radio" name="reviewStar" value="5" id="rate1" class="rate"><label
						for="rate1">★</label>
					<input type="radio" name="reviewStar" value="4" id="rate2" class="rate"><label
						for="rate2">★</label>
					<input type="radio" name="reviewStar" value="3" id="rate3" class="rate"><label
						for="rate3">★</label>
					<input type="radio" name="reviewStar" value="2" id="rate4" class="rate"><label
						for="rate4">★</label>
					<input type="radio" name="reviewStar" value="1" id="rate5" class="rate"><label
						for="rate5">★</label>
				</fieldset>
				<!--  star html end  -->
				<br>
	
				<input type="text" name="rtitle" class="rtitle" placeholder="제목을 적어주세요"><br>
				<textarea id="summernote" rows="" cols="" name="rcontent" class="rcontent" placeholder="리뷰내용작성 300자 내외"></textarea><br>		
				<input type="file" name="rfile" class="rfile">
				
				
				<button type="button" onclick="setwrite()">글등록</button>
				
			</form>
			<div> <!-- form에 등록된 첨부파일[이미지만 가능] 미리보기 -->
			<img alt="" src="" id="rfilepre">
			</div> 
			 
			
					
		</div>

		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

		<script type="text/javascript" src="/room/rboard/js/rwrite.js"></script>
</body>
</html>