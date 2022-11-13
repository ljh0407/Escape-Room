rview();
// 게시글 출력
function rview(){
	$.ajax({
		url : '/room/rboard/rview',
		type : 'get',
		async : false ,	/* 동기식 */
		success : function(re){
			console.log('게시글출력 : '+re)
			let rboard = JSON.parse(re)
			console.log("출력"+rboard)
			document.querySelector('.rno').innerHTML = rboard.rno;
			document.querySelector('.rtitle').innerHTML = rboard.rtitle;
			document.querySelector('.rcontent').innerHTML = rboard.rcontent;
			document.querySelector('.rscore').innerHTML = rboard.rscore;
			document.querySelector('.rdate').innerHTML = rboard.rdate;
			document.querySelector('.mno').innerHTML = rboard.mno;
			document.querySelector('.rcomment').innerHTML = rboard.rcomment;
			
			if(rboard.rfile !== null ){
				document.querySelector('.rfile').src = '/room/rboard/rupload/'+rboard.rfile;
			}
			
			console.log("btn : "+rboard.btnaction)
			let btnbox = document.querySelector('.btnbox')
			console.log("btnbox : "+btnbox)
			if(rboard.btnaction == true ){
				
			}
		}
	})
}
			



// 4. 댓글출력	
function relist(){
	$.ajax({
		url : "/room/rboard/rewrite",
		type : 'get',
		success : function(re){
			alert(re)
			let html = ''
			let rcomment = JSON.parse(re)
			
		}
	})
}
	