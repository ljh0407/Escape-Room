 
 alert('문의사항 목록')
 
 list()
 function list(){
	$.ajax({
		url : "/room/qlist",
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