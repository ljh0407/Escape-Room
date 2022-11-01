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
			console.log(btnbox+'버튼')
			console.log(q.btnaction)
			if( q.btnaction == true ){
				alert('삭제')
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="qdelete('+q.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
				console.log(deletebtn)
			}
		}
	})
}
 //2.삭제고은시[11/01]완성
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
//3.댓글작성고은시[11/01]미완
function qrwrite(){
	let qrcontent = document.querySelector('.qrcontent').value
	$.ajax({
		url : "",
		data : {"qrcontent" : qrcontent , "type" : "reply"},
		type : "POST",
		success : function(re){
			console.log('함수'+re)
			if( re == 1 ){
				alert('답변완료')
				location.reload
			}else{
				alert('관리자만 이용가능합니다')
				location.href = "/room/user/userlogin.jsp"
			}
		}
	})
}