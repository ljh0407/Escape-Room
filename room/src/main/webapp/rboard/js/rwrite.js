

let pageinfo = {
	listsize : 3 , // 한페이지당 게시물 표시 개수
	page : 1, 		// 현재페이지
	key : '',		// 검색 키
	keyword : ''	// 검색 키워드
}


getrlist()


function setwrite(){   // 글쓰기 메소드 이종훈
	let form = document.querySelector("form")
	let formdata = new FormData(form)
	 // 2. 
   $.ajax({
      url : "/room/rboard/rwrite" ,
      // 3. * 첨부파일 일경우 
      type : "post" , 
      data : formdata , 
      processData : false ,
      contentType : false ,
      success : function(re){
		if( re == 'true'){ 
			alert('글등록 완료')
			location.href = location.href
	console.log(formdata)
		}else{alert('글등록 실패')}
	
		}
   })

	
} 



// 글 리스트

function getrlist(page){
	alert('dd')
	pageinfo.page = page; 
	
	$.ajax({
		url : '/room/rboard/rlist',
		data : pageinfo ,
		type : 'get',
		success : function(re){
			alert(pageinfo)
			let rboard = JSON.parse(re)
				
			let html = '<tr><td>게시글번호</td> <td onclick="rviewload()>제목</td> <td>작성일</td> <td>조회수</td> <th>회원번호</td></tr>'; 	
			
			for(let i = 0 ; i < rboard.length ; i++){
				let r = rboard[i]
				html += '<tr>'+
							'<td>'+r.rno+'</td>' + 		// 게시물번호
							'<td onclick="rviewload('+r.rno+')">'+r.rtitle+'</td>'+	// 제목
							'<td>'+r.rdate+'</td>'+		// 작성일
							'<td>'+r.rview+'</td>'+		// 조회수
							'<td>'+r.mno+'	</td>'+		// 회원번호
						'</tr>';
			}
			document.querySelector('.rlisttable').innerHTML += html
			
			let pagehtml = '';
			// 이전 버튼
				if(page <=1){pagehtml += '<button onclick="list('+(page)+')">이전</button>';}
				else{ pagehtml += '<button onclick="list('+(page-1)+')">이전</button>'; }
			// 4. 페이지번호 버튼 [ 시작버튼 ~ 마지막버튼 ]
				for( let page = r.startbtn ; page<= r.endbtn ; page++ ){
					pagehtml += '<button type="button" onclick="list('+page+')">'+page+'</button>' 
				}
				
				// 다음 버튼 만일 현재페이지가 마지막페이지면 다음페이지 불가
				if(page >= r.totalpage){pagehtml += '<button onclick="list('+(page)+')">다음</button>'; } 
				else{ pagehtml += '<button onclick="list('+(page+1)+')">다음</button>'; }
				
				document.querySelector('.pagebox').innerHTML = pagehtml
				
				document.querySelector('.totalsize').innerHTML = r.totalsize
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
			
			alert(re)
			location.href = "/room/rboard/rview.jsp"
		}
	})
}