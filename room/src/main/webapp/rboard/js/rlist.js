
let pageinfo = { 	// js 객체선언
		listsize : 3, 	// 한페이지당 게시물 표시개수
		page : 1, 		// 현재페이지 
		key : '', 		// 검색 키
		keyword : '' 	// 검색 키워드
	}
	console.log(pageinfo)

alert('관리자페이지 연동확인')
// 전역변수


//  게시물 표시 개수 
function rlistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
   	list(1)
}

// 검색기능
function rsearch(){
	
	pageinfo.key = document.querySelector('.key').value
	pageinfo.keyword = document.querySelector('.keyword').value
	console.log(pageinfo.key)
	console.log(pageinfo.keyword)
	list(1)
	
}
// 11/ 08 강의보면서 한거
// 1. 게시물 출력함수
 // 메소드 1첫페이지
 list(1)
function list(page){
	
	pageinfo.page = page ; // 객체 정보 변경
	
	
	$.ajax({
		url : '/room/rboard/rlist',
		data : pageinfo,
		type : 'get',
		success : function(re){
			let boards = JSON.parse(re)
			console.log()
			// object내 게시물리스트 먼저 호출
			let boardlist = boards.data
			
			let html = '<tr>'+
					'<td width="10%">게시글번호</td><td>별점</td> <td>제목</td> <td width="10%">작성자</td> <td width="15%">작성일</td>'+
					   '</tr>';
			// 반복문 boardlist 하나씩 꺼내기
			for(let i = 0 ; i<boardlist.length ; i++){
				// i 번째 객체 호출
				let r = boardlist[i]
				console.log(r)
				// i번쨰 객체의 정보를 HTMl 형식으로 변환후 문자열에 저장
				
				let star = ''
				for( let s = 0 ; s< r.rscore ; s++ ){
					star += '⭐';
				}
				
				
				html += '<tr>' +
							'<td>'+r.rno+'</td>'+
							'<td>'+star+'</td>'+
							'<td onclick="rviewload('+r.rno+')">'+r.rtitle+'</td>'+
							'<td>'+r.mid+'</td>'+
							'<td>'+r.rdate+'</td>'+
						'</tr>';
				
			}// for end
			document.querySelector('.rlisttable').innerHTML = html
			console.log(html)
			
			// 페이징버튼 html 구성
			let pagehtml = '';
			// 이전 버튼
				if(page <= 1){pagehtml += '<li class="page-item"><button class="btn btn-primary" onclick="list('+(page)+')">이전</button></li>';}
				else{ pagehtml += '<li class="page-item"><button class="btn btn-primary" onclick="list('+(page-1)+')">이전</button></li>'; }
				
			// 4. 페이지번호 버튼 [ 시작버튼 ~ 마지막버튼 ]
				for( let page = boards.startbtn ; page<= boards.endbtn ; page++ ){
					pagehtml += '<li class="page-item"><button class="btn btn-primary" type="button" onclick="list('+page+')">'+page+'</button></li>' 
				}
				
				// 다음 버튼 만일 현재페이지가 마지막페이지면 다음페이지 불가
				if(page >= boards.totalpage){pagehtml += '<li class="page-item"><button class="btn btn-primary" onclick="list('+(page)+')">다음</button></li>'; } 
				else{ pagehtml += '<li class="page-item"><button class="btn btn-primary" onclick="list('+(page+1)+')">다음</button></li>'; }
				
				document.querySelector('.pagebox').innerHTML = pagehtml
				
				document.querySelector('.totalsize').innerHTML = boards.totalsize
		}
		
	})
}

// 상세페이지 이동 함수
function rviewload(rno){
	$.ajax({
		url : '/room/rboard/rview',
		data : { "rno" : rno },
		type : "post",
		success : function (re){
			console.log("문자")
			alert(re)
			location.href = "/room/rboard/rview.jsp"
		}
	})
}


//이종훈 모달창띄우기[11/09]
function replymodal(bno){ 
   alert('모달')
   document.querySelector(".replybtn").click() // 해당 버튼을 강제클릭하는 이벤트 실행
   //상세보기
   $.ajax({
      url : "/room/rboard/rview" , 
      type : "post",
      async : false ,   /* 동기식 */
      data : { "bno" : bno },
      success : function( re ){
         console.log(re)
      }
   })
   
   $.ajax({
      url : "/room/rboard/rview",
      async : false ,   /* 동기식 */
      success : function( re ){
         alert('모달2')
         let q = JSON.parse(re)
         //고은시[11/02] 순서 수정
         document.querySelector('.rno').innerHTML = q.bno;
         document.querySelector('.rtitle').innerHTML = q.btitle;
         document.querySelector('.rcontent').innerHTML = q.bcontent;
         document.querySelector('.mid').innerHTML = q.mid;
         document.querySelector('.rfile').innerHTML = q.bfile;
         document.querySelector('.rcomment').innerHTML = q.reply;
         console.log(reply)
      }
   })
}



