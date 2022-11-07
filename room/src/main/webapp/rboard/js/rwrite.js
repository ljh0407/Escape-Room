
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

function getrlist(rno){
	alert('리스트')
	$.ajax({
		url : '/room/rboard/rlist',
		data : {"rno":rno},
		type : 'get',
		success : function(re){
			alert('리스트 :'+rno)
			let rboard = JSON.parse(re)
			console.log(rboard)
			
			let html = ''; 	
						
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