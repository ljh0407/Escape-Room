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
	<%@include file="../header.jsp" %>

   <!-- 고은시[10/26] form태그 추가 , 글목록 링크추가 -->

   <div class="webbox container">
      <h3>문의사항</h3>
      <form>
         제목   <input type="text" class="btitle" id="btitle" name="btitle">   <br>
         내용   <input type="text" class="bcontent" id="summernote" name="bcontent"> <br>
         첨부파일 <input type="file" class="bfile" id="bfile" name="bfile">
         <button type="button" class="btn btn-dark" onclick="bwrite()">등록하기</button>
      </form>
      <a href="/room/qboard/qlist.jsp"><button type="button" class="btn btn-dark">목록</button></a>
   </div>

   <!-- jquery 라이브러리 (api)-->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
   
   <script type="text/javascript" src="../qboard/qjs/qwrite.js"></script>
</body>
</html>