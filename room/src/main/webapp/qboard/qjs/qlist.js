 
 let html = '';
 let pageinfo = {//js객체
	listsize :5,	// 한페이지당 게시물 표시 개수
	page : 1	// 현재 페이지 번호 
}
 console.log(pageinfo)
 

 //화면에 표시할 표시 갯수
function blistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
	list(1)
}

 list(1)

 function list(page){
	
	pageinfo.page = page
	console.log(pageinfo)
	
	$.ajax({
		url : "/room/qlist",
		data : pageinfo,
		success : function( re ){
			let qboard = JSON.parse(re)
			console.log(qboard)
			//object내 게시물리스트 먼저 호출
			let boardlist = qboard.data
			console.log( boardlist )
			html = '<tr> <th width="5%"> 번호 </th> <th > 제목 </th> <th width="10%"> 작성자 </th> <th width="15%"> 작성일 </th> <th width="5%"> 답변상태 </th> <th width="5%"> 비고 </th> </tr>'
			for(let i = 0 ; i < boardlist.length ; i++){
				let q = boardlist[i]
				 html += 
					'<tr>'+
						'<td>'+q.bno+'</td>'+ //게시물 번호
						'<td onclick="viewload('+q.bno+')">'+q.btitle+'</td>'+ //게시글 제목
						'<td>'+q.mid+'</td>'+ //게시글 작성자 아이디 
						'<td>'+q.bdate+'</td>'+ //게시글 날짜
						'<td>'+q.reply+'</td>'+ // 답변상태
						'<td><button onclick="replymodal('+q.bno+')">답변달기</button></td>'+ //댓글
					'<tr>';
			}
			//테이블에 list담기[고은시 11/4]
			document.querySelector('.qtable').innerHTML = html
			
			//페이징처리 [고은시 11/04]
			let pagehtml = ''
				//이전버튼
				if(page <= 1){ 
					pagehtml += '<li class="page-item"><button onclick="list('+(page)+')">이전</button></li>'
				}else{
					pagehtml += '<li class="page-item"><button onclick="list('+(page-1)+')">이전</button></li>'
				}
				
				//페이지 번호
				for(let page = qboard.startbtn ; page <= qboard.endbtn ; page++){
					pagehtml += '<li class="page-item"><button type="button" onclick="list('+page+')">'+page+'</button></li>'
				}
				console.log(page)
				//다음
				if(page >= qboard.totalpage){
					pagehtml += '<li class="page-item"><button onclick="list('+page+')">다음</button></li>'
				}else{
					pagehtml += '<li class="page-item"><button onclick="list('+page+1+')">다음</button></li>'
				}
			//전체
			console.log(page)
			document.querySelector('.pagebox').innerHTML = pagehtml;
			console.log(pagehtml)
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

//고은시 모달창띄우기[11/09]
function replymodal(bno){ 
	document.querySelector(".replybtn").click() // 해당 버튼을 강제클릭하는 이벤트 실행
	//상세조회를 불러오면 댓글 등록이 안됨
	$.ajax({
      url : "/room/qview" , 
      type : "post",
      async : false ,   /* 동기식 */
      data : { "bno" : bno },
      success : function( re ){
         console.log(re)
      }
   })
	
	$.ajax({
		url : "/room/qview",
		async : false ,	/* 동기식 */
		success : function( re ){
			let q = JSON.parse(re)
			//고은시[11/02] 순서 수정
			document.querySelector('.bno').innerHTML = q.bno;
			document.querySelector('.btitle').innerHTML = q.btitle;
			document.querySelector('.bcontent').innerHTML = q.bcontent;
			document.querySelector('.mid').innerHTML = q.mid;
			document.querySelector('.bfile').innerHTML = q.bfile;
			document.querySelector('.reply').innerHTML = q.reply;
			
			//삭제고은시[11/02]완성 확인용코드 삭제
			//파일추가[고은시 11/07]
			if( q.bfile !== null ){	// null , undefined , 0 , false
				let filelink = '<a href="../qboard/filedown?bfile='+q.bfile+'">'+q.bfile+'</a>'
				document.querySelector('.bfile').innerHTML = filelink;
			}
	
		}
	})
}

function replywrite(){
	let rcontent = document.querySelector(".reply").value;
	$.ajax({
		url : "/room/qrwrite" ,
		data : {"rcontent" :  rcontent , "type" : "reply" } , 
		type : "POST" , /* HTTP 메소드 : 1.GET방식=기본값 2. POST방식 */
		success : function( re ){
			 if( re == 1 ){
				alert('댓글작성') // location.reload();
			}else if( re == 0){
				alert('로그인후 작성가능합니다.')
				location.href='../member/login.jsp'
			}else{
				alert('댓글실패')
			}
		}
	})
}






























