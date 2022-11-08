
rview();
// 전역변수
let pageinfo = {
	listsize : 5, 	// 한페이지당 게시물 표시개수
	page : 1, 		// 현재페이지 
	key : '', 		// 검색 키
	keyword : '' 	// 검색 키워드
}
list(1)
//  게시물 표시 개수 
function rlistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
	
	
}

// 검색기능
function rsearch(){
	
	pageinfo.key = document.querySelector('.key').value
	pageinfo.keyword = document.querySelector('.keyword').value
	
	console.log(pageinfo)
	list(1)
}
/*
// 1. 게시물 출력함수
list(1) // 메소드 1번 실행
function list(page){
	alert('제발')
	pageinfo.page = page ; // 객체 정보 변경
	
	$.ajax({
		url : '/room/rboard/rlist',
		data : pageinfo,
		type : 'get',
		success : function(re){
			let boards = JSON.parse(re)
			console.log(boards)
			
			// object내 게시물리스트 먼저 호출

			let boardlist = boards.data
			
			console.log(re)
			
			let html = '';
			// 반복문 boardlist 하나씩 꺼내기
			for(let i = 0 ; i<boardlist.length ; i++){
				// i 번째 객체 호출
				let r = boardlist[i]
				alert(r)
				// i번쨰 객체의 정보를 HTMl 형식으로 변환후 문자열에 저장
				html += '<tr>' +
							'<td>'+r.rno+'</td>'+
							'<td on></td>'+
							'<td onclick="rviewload('+r.rno+')">'+r.rtitle+'</td>'+
							'<td>'+r.mno+'</td>'+
							'<td>'+r.rdate+'</td>'+
							'<td>'+r.rview+'</td>'+
						'</tr>';
				
			}// for end
			console.log(html)
			document.querySelector('.rlisttable').innerHTML = html
			
			let pagehtml = '';
			// 이전 버튼
				if(page <=1){pagehtml += '<button onclick="list('+(page)+')">이전</button>';}
				else{ pagehtml += '<button onclick="list('+(page-1)+')">이전</button>'; }
			// 4. 페이지번호 버튼 [ 시작버튼 ~ 마지막버튼 ]
				for( let page = boards.startbtn ; page<= boards.endbtn ; page++ ){
					pagehtml += '<button type="button" onclick="list('+page+')">'+page+'</button>' 
				}
				
				// 다음 버튼 만일 현재페이지가 마지막페이지면 다음페이지 불가
				if(page >= boards.totalpage){pagehtml += '<button onclick="list('+(page)+')">다음</button>'; } 
				else{ pagehtml += '<button onclick="list('+(page+1)+')">다음</button>'; }
				
				document.querySelector('.pagebox').innerHTML = pagehtml
				
				document.querySelector('.totalsize').innerHTML = boards.totalsize
		}
		
	})
}
*/
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

