/**
 * 
 */
 alert('내 게시글')
 
 qview()
 
 function qview(){
	$.ajax({
		url : "/room/qview",
		async : false ,	/* 동기식 */
		success : function( re ){
			let q = JSON.parse(re)
			console.log(q)
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.bfile').innerHTML = board.bfile;
			document.querySelector('.mid').innerHTML = board.mid;
			//파일
			if( board.bfile !== null ){	// null , undefined , 0 , false
				let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
				// ' ' : 전체 문자열 처리
				// " " : 전체 문자열내 문자열 구분  
				document.querySelector('.bfile').innerHTML = filelink;
			}
		}
	})
}