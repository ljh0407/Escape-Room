rview();
// 게시글 출력
function rview(){
	$.ajax({
		url : '/room/rboard/rview',
		type : 'get',
		async : false ,	/* 동기식 */
		success : function(re){
			
			let rboard = JSON.parse(re)
			console.log("출력"+rboard)
			document.querySelector('.rno').innerHTML = rboard.rno;
			document.querySelector('.rtitle').innerHTML = rboard.rtitle;
			document.querySelector('.rcontent').innerHTML = rboard.rcontent;
			document.querySelector('.rscore').innerHTML = rboard.rscore;
			document.querySelector('.rfile').innerHTML = rboard.rfile;
			document.querySelector('.rcomment').innerHTML = rboard.rcomment;
			document.querySelector('.rdate').innerHTML = rboard.rdate;
			document.querySelector('.rview').innerHTML = rboard.rview;
			document.querySelector('.mno').innerHTML = rboard.mno;
			
			console.log( rboard.rfile )
			
			if(rboard.rfile !== null ){
				let filelink = '<a href="../rupload?rfile="'+rboard.rfile+'></a>'
				console.log(filelink)
				
				document.querySelector('.rfile').innerHTML = filelink;
			}
			
			console.log(rboard.btnaction)
			let btnbox = document.querySelector('.btnbox')
			
			if(rboard.btnaction == true ){
				
				
			}
		}
	})
}