<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 
</head>
<body>
   
   <%@include file="../../admin/dashboard.jsp" %>
   
   <div class="container">      
      
      <nav>
        <ul class=" pagebox pagination justify-content-center">
        </ul>
      </nav>
   </div>   

   
      <!-- Button trigger modal -->
      <button style="display: none;" type="button" class="replybtn btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        Launch static backdrop modal
      </button>
      
      <!-- Modal -->
            <div class="modal-body">
              <div> <!-- 글조회 -->
               <h3>글조회</h3>
               <table>
                  <tr> <td> 번호   </td>   <td class="rno">      </td> </tr>
                  <tr> <td> 제목   </td>   <td class="rtitle">      </td> </tr>
                  <tr> <td> 내용   </td>   <td class="rcontent">   </td> </tr>
                  <tr> <td> 작성자  </td>   <td class="mid">      </td> </tr>
                  <tr> <td> 파일   </td>   <td class="rfile">      </td> </tr>
                  <tr> <td> 댓글   </td>   <td class="rcomment">      </td> </tr>
               </table>
            </div>
            </div>
		  
           <div class="rcommentbox"> 
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
              <button type="button" class="btn btn-primary" onclick="replywrite()" id="replybox">댓글작성</button>
			  <button type="button" onclick="rewrite()" class="btn btn-dark">댓글달기</button>
			  <input class="rcomment"> 
			</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript" src="/room/rboard/js/rlist.js"></script>
   
</body>
</html>