/**
 * [10/26]고은시
 */
 alert('문의사항 목록2')
 /* 전역변수 list 불러올 목록들 */
 
 list()
 function list(){
	$.ajax({
		url : "/eacape_room/board/misrQuestionslist",
		success : function(re){
			console.log(re)
			let boardlist = JSON.parse(re)
			console.log(boardlist)
			let html = ''
			for(let i = 0 ; i < boardlist.length ; i++){
				html += '<tr>'+
						'<th>'+boardlist[i].bno+'</th>'+
						'<th>'+boardlist[i].mno+'</th>'+
						'<th>'+boardlist[i].bdate+'</th>'+
						//'<th>'+boardlist[i].reply+'</th>'+
						'<tr>'
			}
			document.querySelector('table').innerHTML += html
			console.log(html)
		}
	})
}