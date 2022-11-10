
list()// 클릭시 보여줘야함
function list(){
	$.ajax({
		url:"/room/userlist",
		type:"post",
		success: function(re){
		let userlist =	JSON.parse(re)
		let html ='<th> 번호 </th> <th> 이름 </th>  <th> 아이디 </th><th> 핸드폰번호 </th><th> 비고 </th>';
		for(let i= 0; i<userlist.length; i++){
			let us = userlist[i]
			console.log(us)
			html +=
			'<tr>'+
				'<td>'+us.mno+'</td>'+
				'<td>'+us.mname+'</td>'+
				'<td>'+us.mid+'</td>'+
				'<td>'+us.mphone+'</td>'+
				'<td><button tpye="button" onclick="ndelete('+us.mno+')" >삭제</button></td>'+
			'</tr>';
		}
		document.querySelector('.ustable').innerHTML= html
		
		}
		
	})
}
// 회원삭제
function ndelete(mno){
	alert(mno)
	$.ajax({
		url:"/room/userDelete",
		data : {"mno":mno},
		success : function(re){
			if( re=='true'){
				alert('회원삭제 성공');
				location.href='/room/nboard/nadmin.jsp'
			}
			else{alert('회원삭제 실패')}
		}
	})
}