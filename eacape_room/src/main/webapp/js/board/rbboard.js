// 10/24 이종훈

function rbwrite(){
	
	let info = {
		rbtitle : document.querySelector('.rbtitle').value,
		rbcontetnt : document.querySelector('.rbcontent').value
	}
	console.log(info)
	$.ajax({
		url : "/eacape_room/board/rbboard",
		data : info,
		success : function(re){
			if( re === 'true'){
				alert('글등록성공')
				alert('gd')
				location.lreload(); 
			}else{alert('글등록실패')}alert('gd')
			
		}
		
	})
	
	
	
	
/*	console.log(rbcontetnt) // rbcontetnt : 후기 게시물내용
	if ( rbcontetnt != null ){ alert('글등록성공') 
	}else{ alert('글등록실패')}  */
 
}