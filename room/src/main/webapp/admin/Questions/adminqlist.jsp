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
	
	<div>
		<table class="qtable">
			<tr>
				 <th>번호</th> <th>제목</th> <th>아이디</th> <th>작성일</th> <th>답변확인</th> 
			</tr>
		</table>
		
		<nav>
		  <ul class=" pagebox pagination justify-content-center">
		  </ul>
		</nav>
		<div> <a href="/room/admin/Questions/adminreply.jsp" >답변하기</a> </div>
	</div>	

	
		<!-- Button trigger modal -->
		<button style="display: none;" type="button" class="replybtn btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  Launch static backdrop modal
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="staticBackdropLabel">문의사항 답글달기</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <div> <!-- 글조회 -->
					<h3>글조회</h3>
					<table>
						<tr> <td> 번호	</td>	<td class="bno">		</td> </tr>
						<tr> <td> 제목	</td>	<td class="btitle">		</td> </tr>
						<tr> <td> 내용	</td>	<td class="bcontent">	</td> </tr>
						<tr> <td> 작성자	</td>	<td class="mid">		<td> </tr>
						<tr> <td> 파일	</td>	<td class="bfile">		<td> </tr>
						<tr> <td> 댓글	</td>	<td class="reply">		<td> </tr>
					</table>
				</div>
		      </div>
		      <div class="modal-footer">
		      	<textarea rows="" cols=""> </textarea>
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		        <button type="button" class="btn btn-primary" onclick="replywrite()">댓글작성</button>
		      </div>
		    </div>
		  </div>
		</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/room/qboard/qjs/qlist.js"></script>
	
</body>
</html>