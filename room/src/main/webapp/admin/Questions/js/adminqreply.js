/**
 * 
 */
 alert('댓글달기') 
 
 // 3. 댓글 작성함수 
function rwrite(){
	let rcontent = document.querySelector(".rcontent").value;
	$.ajax({
		url : "/jspweb/reply/rwrite" ,
		data : {"rcontent" :  rcontent , "type" : "reply" } , 
		type : "POST" , /* HTTP 메소드 : 1.GET방식=기본값 2. POST방식 */
		success : function( re ){
			 if( re == 1 ){
				alert('댓글작성') // location.reload();
				rlist()
			}else if( re == 0){
				alert('로그인후 작성가능합니다.')
				location.href='/room/user/userlogin.jsp'
			}else{
				alert('댓글실패')
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
					data : { "type" : "rereply" , "rno" : reply.rno } , // type : rereply    대댓글용
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