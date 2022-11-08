
/*
	<a href="경로?변수명=데이터"> 
	<a href="/room/nboard/nview.jsp?nno = 3 ">
*/

let pageinfo= {
	listsize : 5, //한페이지당 게시물 개수
	page : 1,
	key : '',
	keyword: '',
}


function bsearch(){
	//alert('검색확인')
	let key = document.querySelector('.key').value
	let keyword = document.querySelector('.keyword').value
	
	pageinfo.key = key
	pageinfo.keyword = keyword
	list(1) //검색후 첫페이지 
}



list(1)
function list(page){
	
	 pageinfo.page =page;
	
	//console.log(listsize)
	
	$.ajax({
		url: "/room/nlist",
		data : pageinfo,
		success:function(re){
			let boards =  JSON.parse(re)
			console.log(boards)
			
			// 1. 게시물리스트 호출
			let boardlist = boards.data
			
			console.log(boardlist)
			let html = ""
			for(let i = 0; i < boardlist.length; i++){
				let n = boardlist[i] // 보더리스트 n으로 변수값 바꿔줌 -주혁-
				console.log(n)
				html +=
					'<tr>'+
							'<td>'+n.nno+'</td>'+ 		//번호
							'<td onclick="viewload('+n.nno+')"> '+n.ntitle+'</a></td>'+ 	//제목
							'<td>'+n.mid+'</td>'+  		//작성자
							'<td>'+n.ndate+'</td>'+ 	// 작성일
							'<td>'+n.nview+'</td>'+ 	// 조회수
					'</tr>';
			}
		document.querySelector('.ntable').innerHTML = html
		// 페이징처리할때 누적더하기 하면 계속 나온다 그래서 누적더하기 안하고 그냥 대입으로바꿈
		// 2페이지 클릭시 1페이지와 함께 나옴 그리고 1페이지 다시누르면 1페이지 가 한번더 나옴 그래서 대입으로바꿈
		
		//1. 페이징버튼 html 구성
		let pagehtml ='';
		
			// - + 든 더이상 게시물이 없는데도 계속가기때문에 막아주는 코드 작성
			// 2.이전버튼
			if(page <= 1){pagehtml +='<button onclick="list('+(page)+')">이전</button>'}
			else{pagehtml +='<button onclick="list('+(page-1)+')">이전</button>'}
			
	
			//4. 페이지번호 버튼
			for ( let page = boards.starbtn; page<=boards.endbtn ; page++){
				pagehtml += '<button type="button" onclick="list('+page+')" >'+page+'</button>'
			}
			// - + 든 더이상 게시물이 없는데도 계속가기때문에 막아주는 코드 작성
			// 3.다음버튼
			if(page >= boards.totalpage){pagehtml +='<button onclick="list('+(page)+')">다음</button>'}
			else{pagehtml +='<button onclick="list('+(page+1)+')">다음</button>';}
		
		document.querySelector('.pagebox').innerHTML = pagehtml	
		 
		}
	})
}



function viewload(nno){
	$.ajax({
		url: "/room/nviewload",
		type : "post", 
		data:{"nno":nno},
		success:function(re){
			location.href = "/room/nboard/nview.jsp"
		}
	})
}
