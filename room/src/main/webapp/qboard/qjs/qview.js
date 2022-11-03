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
			let q = JSON.parse(re)
			//고은시[11/02] 순서 수정
			document.querySelector('.bno').innerHTML = q.bno;
			document.querySelector('.btitle').innerHTML = q.btitle;
			document.querySelector('.bcontent').innerHTML = q.bcontent;
			document.querySelector('.mid').innerHTML = q.mid;
			document.querySelector('.bfile').innerHTML = q.bfile;
			document.querySelector('.reply').innerHTML = q.reply;
			
			//삭제고은시[11/02]완성 확인용코드 삭제
			let btnbox = document.querySelector('.btnbox')
			
			if( q.btnaction == true ){
				alert('삭제')
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="qdelete('+q.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
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

