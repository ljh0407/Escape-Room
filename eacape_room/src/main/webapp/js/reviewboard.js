// 10/24 이종훈
function rbwrite(){
	let rbcontetnt = document.querySelector('.rbcontetnt').value
	alert('확인')
	$.ajax({
		url : '/eacape_room/rbboard',
		success : function(re){alert(re)}
		
	})
	
	
	console.log(rbcontetnt) // rbcontetnt : 후기 게시물내용
	if ( rbcontetnt != null ){ alert('글등록성공') 
	}else{ alert('글등록실패')}
 
}