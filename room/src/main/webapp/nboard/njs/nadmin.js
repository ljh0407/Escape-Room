

/* ------------------------------ 게시물 호출 ---------------------------- */

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
			let html = '<tr> <th width="5%"> 번호 </th> <th > 제목 </th> <th width="10%"> 작성자 </th> <th width="15%"> 작성일 </th> <th width="5%"> 조회수 </th><th width="15%"> 비고 </th> </tr>'
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
							'<td><button type="bytton" class="btn-dark" onclick="updatechoi('+n.nno+')" >수정</button><button class="btn-dark" onclick="ndelete('+n.nno+')" >삭제</button></td>'+
					'</tr>';
			}
		document.querySelector('.ntable').innerHTML = html
		// 페이징처리할때 누적더하기 하면 계속 나온다 그래서 누적더하기 안하고 그냥 대입으로바꿈
		// 2페이지 클릭시 1페이지와 함께 나옴 그리고 1페이지 다시누르면 1페이지 가 한번더 나옴 그래서 대입으로바꿈
		
		//1. 페이징버튼 html 구성
		let pagehtml ='';
		
			// - + 든 더이상 게시물이 없는데도 계속가기때문에 막아주는 코드 작성
			// 2.이전버튼
			if(page <= 1){pagehtml +='<li class="page-item"><button class="page-link" onclick="list('+(page)+')">이전</button><li>'}
			else{pagehtml +='<li class="page-item"><button class="page-link" onclick="list('+(page-1)+')">이전</button><li>'}
			
	
			//4. 페이지번호 버튼
			for ( let page = boards.starbtn; page<=boards.endbtn ; page++){
				pagehtml += '<li class="page-item"><button class="page-link" type="button" onclick="list('+page+')" >'+page+'</button><li>'
			}
			// - + 든 더이상 게시물이 없는데도 계속가기때문에 막아주는 코드 작성
			// 3.다음버튼
			if(page >= boards.totalpage){pagehtml +='<li class="page-item"><button class="page-link" onclick="list('+(page)+')">다음</button><li>'}
			else{pagehtml +='<li class="page-item"><button class="page-link" onclick="list('+(page+1)+')">다음</button><li>';}
		
		document.querySelector('.pagebox').innerHTML = pagehtml	
		 
		}
	})
}





function viewload(nno){
	$.ajax({
		url: "/room/nviewload",
		type : "get", 
		data:{"nno":nno},
		success:function(re){
			location.href = "/room/nboard/nview.jsp"
		}
	})
}


// 2. 게시물 삭제 함수
function ndelete(nno){
	$.ajax({
		url:"/room/ndelete",
		data : {"nno":nno},
		success : function(re){
			if( re==='true'){
				alert('글삭제 성공');
				location.href='/room/nboard/nadmin.jsp'
			}
			else{alert('글삭제 실패')}
		}
	})
}


// 수정처리함수
function updatechoi(nno){
	
	$.ajax({
		url: "/room/nview",
		type : "post", 
		data:{ "nno":nno },
		success:function(){		
			$(document).ready(function() {
			  $('#summernote').summernote( {height: 300} );
			});
			updatemodal();
		}
	})
}

function updatemodal(){
	
		document.querySelector('.updatemodalhtn').click() // 해당 버튼을 강제클릭하는 이벤트 실행	

		$.ajax({
			url:"/room/nview",
			success:function(re){
			let n = JSON.parse(re)
			console.log( n )
			document.querySelector('.ntitle').value = n.ntitle;
			document.querySelector('.summernote').innerHTML = n.ncontent;
		}
	})
	
}


 

function nupdate(){
	
	let info ={
		ntitle : document.querySelector('.ntitle').value,
		ncontent: document.querySelector('.ncontent').value
		
	}
	
	console.log(info)
	
	$.ajax({
		url:"/room/nupdate",
		type:"post",
		data: info,
		success:function(re){
			
			if( re == 'true'){alert('수정성공');
			location.href='/room/nboard/nadmin.jsp'}
			else{alert('수정실패')}
		}
		
	})
	
}





