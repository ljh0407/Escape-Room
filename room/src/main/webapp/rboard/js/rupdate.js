
rview();

// 수정할 게시글 불러오기
function rview(){
	$.ajax({
		url : '/jspweb/board/view',
		success : function(re){
			let rboard = JSON.parse(re)
			console.log(rboard)
			
			document.querySelector('.rtitle').value = rboard.rtitle;
			document.querySelector('rcontent').innerHTML = rboard.rcontent;
			
			if ( rboard.rfile !== null ){ // 첨부파일이 있으면
				let rfiledelete = rboard.rfile+'<button type="button" onclick="rfiledelete()">삭제</button>'
				document.querySelector('.oldrfile').innerHTML = rfiledelete;
			}
			
		}
		
	})
	
}