/**
 * 
 */
 alert('내 게시글')
 
 qview()
 function qview(){
	alert('조회')
	$.ajax({
		url : "/room/qview",
		async : false ,	/* 동기식 */
		success : function( re ){
			console.log(re)
			let q = JSON.parse(re)
			console.log(q.bno)
			alert('선택')
			let html = ''
			document.querySelector('.bno').innerHTML = q.bno;
			document.querySelector('.btitle').innerHTML = q.btitle;
			document.querySelector('.bcontent').innerHTML = q.bcontent;
			document.querySelector('.reply').innerHTML = q.reply;
			document.querySelector('.mid').innerHTML = q.mid;
			document.querySelector('.bfile').innerHTML = q.bfile;
			
			document.querySelector('table').innerHTML += html
		}
	})
}
 //상세페이지로 이동
 function viewload( bno ){
	console.log(bno)
	$.ajax({
		url : "/room/qview" , 
		data : { "bno" : bno },
		success : function( re ){
			console.log(re)
			location.href = "/room/qboard/qview.jsp"
		}
	})
}