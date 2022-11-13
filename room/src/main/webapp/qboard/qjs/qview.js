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
			//파일추가[고은시 11/07]
			if( q.bfile !== null ){	// null , undefined , 0 , false
				let filelink = '<a href="/room/qboard/qupload/'+q.bfile+'"download>'+q.bfile+'</a>'
				document.querySelector('.bfile').innerHTML = filelink;
			}
			console.log( q.btnaction )
			let btnbox = document.querySelector('.btnbox')
			
			if( q.btnaction == true ){
				alert('삭제')
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="qdelete('+q.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
				// 수정 버튼 활성화 [고은시 11/07 수정버튼]
				let updatebtn = '<button><a href="/room/qboard/upload.jsp">수정</a></button>'
				btnbox.innerHTML += updatebtn;
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

// 4. 댓글 출력 함수 
function rlist(){
	$.ajax({ // 댓글 호출 ajax
		url : "/jspweb/reply/rlist" ,
		data : { "type" : "reply" } , 	// type : reply    댓글용
		success : function(re){ // 댓글 호출이 성공했을떄
			let replylist = JSON.parse(re)
			let html = ''
			for( let i = 0 ; i<replylist.length ; i++){ // 댓글마다 반복문 
				let reply = replylist[i]
				$.ajax({ // 댓글마다 대댓글 호출 ajax 호출  = rno ----> rindex 
					url : "/jspweb/reply/rlist" ,
					data : { "type" : "rereply" , "rno" : reply } , // type : rereply    대댓글용
					async : false ,	/* 동기식 */ 
					success : function(re){ 
						let rereplylist = JSON.parse( re )
						/////// 상위 댓글 html 구성 
						html += '<div>'+
									'<span>'+reply.rcontent+'</sapn>'+
									'<span>'+reply.rdate+'</sapn>'+
									'<span>'+reply.mid+'</sapn>'+
									'<button type="button" onclick="rereplyview('+reply.rno+')">답글</button>'+
									'<div class="reply'+reply.rno+'"></div>';	
						////// 대댓글 html 구성 
						for( let j = 0 ; j<rereplylist.length ; j++ ){
							let rereply = rereplylist[j]
							html += '<div style="margin : 20px;">'+
										'<span>'+rereply.rcontent+'</sapn>'+
										'<span>'+rereply.rdate+'</sapn>'+
										'<span>'+rereply.mid+'</sapn>'+
									'</div>';
						} // 대댓글 반복문
						// 마지막 닫기 html 구성
						html += '</div>';
					 }
				})
			} // 댓글 반복문 end 
			document.querySelector('.replylist').innerHTML = html;
		}
	})
}