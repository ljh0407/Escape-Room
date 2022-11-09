
list()// 클릭시 보여줘야함
function list(){
	$.ajax({
		url:"/room/userlist",
		type:"post",
		success: function(re){
		let userlist =	JSON.parse(re)
		let html ='<th> 번호 </th> <th> 이름 </th>  <th> 아이디 </th><th> 핸드폰번호 </th>';
		for(let i= 0; i<userlist.length; i++){
			let us = userlist[i]
			console.log(us)
			html +=
			'<tr>'+
				'<td>'+us.mno+'</td>'+
				'<td>'+us.mname+'</td>'+
				'<td>'+us.mid+'</td>'+
				'<td>'+us.mphone+'</td>'+
			'</tr>';
		}
		document.querySelector('.ustable').innerHTML= html
		
		}
		
	})
}