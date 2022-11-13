list()
function list(){
	$.ajax({
		url:"/room/reservationlist",
		success:function(re){
			let relist= JSON.parse(re)
			let html ='<th> 테마 </th> <th> 예약날짜 </th>  <th> 아이디 </th>';
			for (let i=0; i<relist.length; i++){
				let re= relist[i]
				console.log(re)
				html +=
				'<tr>'+
				'<td>'+re.gname+'</td>'+
				'<td>'+re.gdate+'</td>'+
				'<td>'+re.mid+'</td>'+
				'</tr>';
			}
			document.querySelector('.retable').innerHTML = html;
		}
	})
}