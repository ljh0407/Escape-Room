


list()
function list(){
	$.ajax({
		url: "/room/nlist",
		success:function(re){
			let json = JSON.parse(re)
			console.log(json)
			let html = '';
			alert('a1')
			for(let i = 0; i < json.length; i++){
				let n = json[i]
				console.log(n)
				html +=
					'<tr>'+
							'<td>'+n.nno+'</td>'+ 		//번호
							'<td>'+n.ntitle+'</td>'+ 	//제목
							'<td>'+n.mid+'</td>'+  		//작성자
							'<td>'+n.ndate+'</td>'+ 	// 작성일
							'<td>'+n.nview+'</td>'+ 	// 조회수
					'</tr>';
				
			}
		document.querySelector('.ntable').innerHTML += html
		}
	})
}