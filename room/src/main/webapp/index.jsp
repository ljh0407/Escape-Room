<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방탈출카페</title>
		<!-- 사용자 정의 css 호출  -->
		<link rel="stylesheet" href="/room/css/main/index.css">
		 
</head>
<body>
		<%@include file="header.jsp" %>
		
		<!-- <ul class="hd_menu">
				<li class="one"> <a href="/room/qboard/qlist.jsp"><img class="img1" alt="" src="/room/img/문의사항.png"></a> </li>	문의사항
				<li class="two"> <a href="/room/nboard/nlist.jsp">공지사항</a> </li>
				<li class="three"> <a href="#">리뷰</a> </li>
				
		</ul> -->	<!-- 아래로 코드 변경 이상 무 -->
		
			<div class="hd_menu">
					<!-- div : poster -->
		<br><br> 	<div class="poster" >
						 <div class="thumbex">
						   <div class="thumbnail"><a href="/room/theme/theme01.jsp"> <img src="/room/img/Room1.jpg"/><span>액자</span></a></div>
						 </div>
						  
						 <div class="thumbex">    
						   <div class="thumbnail"><a href="/room/theme/theme02.jsp"><img src="/room/img/Room2.png"/><span>ball party</span></a></div>
						 </div>
						  
						 <div class="thumbex">
						   <div class="thumbnail"><a href="/room/theme/theme03.jsp"><img src="/room/img/Room3.png"/><span>504탈출</span></a></div>
						 </div>
						 
						 <div class="thumbex">
						   <div class="thumbnail"><a href="/room/theme/theme04.jsp"><img src="/room/img/Room4.jpg"/><span>비상탈출</span></a></div>
						 </div>
						
					</div>
					
					
					
					<!-- div : container -->
				<br>	<div class="container">
						 
						  <div class="thumbex">
						   <div class=thumbnail> <img alt="" src="/room/img/주의사항.png"></div>
						  </div>
						   
						 <div class="thumbex">
						   <div class="thumbnail"><a href="/room/qboard/qlist.jsp"> <img src="/room/img/문의사항.jpg"/><span>Questions</span></a></div>
						 </div>
						  
						 <div class="thumbex">    
						   <div class="thumbnail"><a href="/room/nboard/nlist.jsp"><img src="/room/img/공지사항.jpg"/><span>Notice</span></a></div>
						 </div>
						  
						 <div class="thumbex">
						   <div class="thumbnail"><a href="/room/rboard/rwrite.jsp"><img src="/room/img/리뷰.jpg"/><span>review</span></a></div>
						 </div>
					</div>
					
				
			</div>
		 <%@include file="Footer.jsp" %> 
		
</body>
</html>