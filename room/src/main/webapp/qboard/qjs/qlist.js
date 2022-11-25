 
 let html = '';
 let pageinfo = {//js객체
	listsize :5,	// 한페이지당 게시물 표시 개수
	page : 1	// 현재 페이지 번호 
}

 //화면에 표시할 표시 갯수
function blistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
	list(1)
}

 list(1)
 
 

 function list(page){
	pageinfo.page = page
	
	$.ajax({
		url : "/room/qlist",
		data : pageinfo,
		success : function( re ){
			let qboard = JSON.parse(re)
			console.log(qboard)
			//object내 게시물리스트 먼저 호출
			let boardlist = qboard.data
			html = '<tr> <th width="5%"> 번호 </th> <th > 제목 </th> <th width="10%"> 작성자 </th> <th width="15%"> 작성일 </th> <th width="5%"> 답변상태 </th>'
			for(let i = 0 ; i < boardlist.length ; i++){
				let q = boardlist[i]
				 html += 
					'<tr>'+
						'<td>'+q.bno+'</td>'+ //게시물 번호
						'<td onclick="viewload('+q.bno+')">'+q.btitle+'</td>'+ //게시글 제목
						'<td>'+q.mid+'</td>'+ //게시글 작성자 아이디 
						'<td>'+q.bdate+'</td>'+ //게시글 날짜
						'<td>'+q.reply+'</td>'+ // 답변상태
					'<tr>';
			}
			//테이블에 list담기[고은시 11/4]
			document.querySelector('.qtable').innerHTML = html
			
			//페이징처리 [고은시 11/04]
			let pagehtml = ''
				//이전버튼
				if(page <= 1){ 
					pagehtml += '<li class="page-item"><button class="btn btn-dark" onclick="list('+(page)+')">이전</button></li>'
				}else{
					pagehtml += '<li class="page-item"><button class="btn btn-dark" onclick="list('+(page-1)+')">이전</button></li>'
				}
				
				//페이지 번호
				for(let page = qboard.startbtn ; page <= qboard.endbtn ; page++){
					pagehtml += '<li class="page-item"><button type="button" class="btn btn-dark" onclick="list('+page+')">'+page+'</button></li>'
				}
				console.log(page)
				//다음
				if(page >= qboard.totalpage){
					pagehtml += '<li class="page-item"><button class="btn btn-dark" onclick="list('+page+')">다음</button></li>'
				}else{
					pagehtml += '<li class="page-item"><button class="btn btn-dark" onclick="list('+page+1+')">다음</button></li>'
				}
			//전체
			document.querySelector('.pagebox').innerHTML = pagehtml;
		}
	})
}
//상세페이지로 이동
 function viewload( bno ){
	$.ajax({
		url : "/room/qview" , 
		type : "post",
		data : { "bno" : bno },
		success : function( re ){
			console.log(re)
			location.href = "/room/qboard/qview.jsp"
		}
	})
}
