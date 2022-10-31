

function setwrite(){   // 글쓰기 메소드 이종훈
	let form = document.querySelector("form")
	let formdata = new FormData(form)
	console.log(formdata)
	 // 2. 
   $.ajax({
      url : "/room/rboard/rwrite" ,
      // 3. * 첨부파일 일경우 
      type : 'post' , 
      data : formdata , 
      processData : false ,
      contentType : false ,
      success : function(re){
		if( re == 'true'){ 
			alert('글등록 완료')
		}else{alert('글등록 실패')}
	
		}
   })

	
} 