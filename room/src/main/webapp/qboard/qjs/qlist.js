 
 alert('문의사항 목록')
 
 let html = '';
 
 list()
 function list(){
	alert('ddd')
	$.ajax({
		url : "/room/qlist",
		success : function( re ){
			alert( re )
			let qboard = JSON.parse(re)
			
			
			console.log(qboard)
			
			
			for(let i = 0 ; i < qboard.length ; i++){
				let q = qboard[i]
				html += 
					'<tr>'+
						'<td>'+q.bno+'</td>'+ //게시물 번호
						'<td onclick="viewload('+q.bno+')">'+q.btitle+'</td>'+ //게시글 제목
						'<td>'+q.mid+'</td>'+ //게시글 작성자 아이디 
						'<td>'+q.bdate+'</td>'+ //게시글 날짜
						'<td>'+q.reply+'</td>'+ //댓글
					'<tr>';
			}
			document.querySelector('.qtable').innerHTML += html
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