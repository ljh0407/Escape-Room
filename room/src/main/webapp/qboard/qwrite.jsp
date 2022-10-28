<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>

   <!-- 고은시[10/26] form태그 추가 , 글목록 링크추가 -->

   <div class="webbox">
      <h3>문의사항</h3>
      <form>
         제목   <input type="text" class="btitle" id="btitle" name="btitle">   <br>
         내용   <input type="text" class="bcontent" id="bcontent" name="bcontent"> <br>
         첨부파일 <input type="file" class="bfile" id="bfile" name="bfile">
         <button type="button" onclick="bwrite()">등록하기</button>
      </form>
      <a href="/room/qboard/qlist.jsp">목록</a>
   </div>

   <!-- jquery 라이브러리 (api)-->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript" src="../qboard/qjs/qwrite.js"></script>
</body>
</html>