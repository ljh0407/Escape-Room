
/*
let pageinfo = {
	listsize : 3 , // 한페이지당 게시물 표시 개수
	page : 1, 		// 현재페이지
	key : '',		// 검색 키
	keyword : ''	// 검색 키워드
}
*/

//getlist()


function setwrite(){   // 글쓰기 메소드 이종훈
	let form = document.querySelector("form")
	let formdata = new FormData(form)
	
		let star = 0;
		/* star js */
		let ratelist = document.querySelectorAll('.rate')
		
		ratelist.forEach( (e , i) =>{
			console.log( "e : "+ e )
			if( e.checked == true ){
				star = e.value; 
			}
		})
		
		formdata.set("star" , star );  //  formdata에 별점 추가
		console.log("폼데이터 : "+formdata)
		/* star js */
	
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
			console.log("re: "+re)
			alert('글등록 완료')
	console.log(formdata)
			location.href = "rlist.jsp";
		}else{alert('글등록 실패')}
	
		}
   })

} 
let rfile = document.querySelector('.rfile')
rfile.addEventListener( 'change' , function(e){ //  e : 첨부파일 input change 이벤트  e : event 객체 ( 이벤트정보[ target , data 등] )
	// 1. js 파일 클래스 [ FileReader() ]
	let file = new FileReader() // 객체 생성 
	// 2. 해당 첨부된 파일 경로 읽어오기 [ .readAsDataURL( 파일 ) ] // e.target.files[0] : 첨부파일의 등록된 이미지
	file.readAsDataURL( e.target.files[0] ) // readAsDataURL() : 해당 파일 읽어오기 
	// 3. 이미지 태그에 첨부된 이미지 대입
	file.onload =  function( e ){				//  e : file load 이벤트 
		document.querySelector('#rfilepre').src = e.target.result	// 서버는[ 사용자의 c드라이브 경로 요청X] 와 관련없음 
	}
})	



// 글 리스트
/*
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
			// 페이징 html 구성
			let pagehtml = '';
			// 이전 버튼
				if(page <= 1){pagehtml += '<button onclick="list('+(page)+')">이전</button>';}
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
*/		
						

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

$(document).ready(function() {
  $('#summernote').summernote({height: 300});
  
});



















