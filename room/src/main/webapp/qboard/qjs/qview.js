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
			//테이블에 담기[10/31]
			document.querySelector('table').innerHTML += html
			
			//삭제고은시[10/31]미완
			let btnbox = document.querySelector('.btnbox')
			console.log('버튼')
			if( q.btnaction == true ){
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="qdelete('+q.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
				console.log(deletebtn)
			}
		}
	})
}
 //2.삭제고은시[10/31]미완
 function qdelete(bno){
	console.log('삭제'+bno)
	$.ajax({
		url : "/room/qputdelete",
		data : {"bno" : bno},
		type : "Delete",
		success : function(re){
			console.log('삭제함수'+re)
			if(re == 'true'){
				alert('삭제성공')
				location.href = "/room/qboard/qlist.jsp"
			}else{
				alert('삭제실패')
				location.href = "/room/qboard/qlist.jsp"
			}
		}
	})
}