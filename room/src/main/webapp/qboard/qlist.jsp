<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 고은시 10/26 문의사항 목록 출력성공 -->
   <%@include file="../header.jsp" %>
   
   <div class="webbox">
      <table class="qtable">
         <tr>
            <th>번호</th> <th>제목</th> <th>아이디</th> <th>작성일</th> <th>댓글 수</th>
         </tr>
      </table>
      <div> <a href="/room/qboard/qwrite.jsp">글쓰기</a> </div>
   </div>
   
   <script type="text/javascript" src="../qboard/qjs/qlist.js"></script>
</body>
</html>