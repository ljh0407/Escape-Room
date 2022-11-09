<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body>

		<%@include file="../admin/dashboard.jsp" %>
		
		<div class="webbox container">	
		<form>
		<h2> 공지사항 </h2>
			제목	<input type="text" name="ntitle" class="ntitle">
			<textarea id="summernote" name="ncontent" class="ncontent"></textarea>
		<button type="button" onclick="nwrite()">글쓰기</button>	
		
		</form>
		</div>	
			
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
				
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

	<script src="../nboard/njs/nwrite.js" type="text/javascript"></script>		

</body>
</html>