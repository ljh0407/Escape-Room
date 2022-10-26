/**
 * 
 */
 alert('문의사항')
 //[10/26]고은시 인풋에서 폼데이터로 전송방식 변경

 function bwrite(){
	
	let form = document.querySelector('form')
	console.log(form)
	let formdata = new FormData(form)
	
	console.log(formdata)
	alert('버튼')
	$.ajax({
		url : "/eacape_room/board/misrwrite",
		data : formdata,
		//[10/26]고은시
		contentType : false,
		processData : false,
		type : 'POST',
		success : function(re){
			console.log(re)
			if(re == 'true'){
				alert('문의사항이 등록되었습니다')
				location.href = "/eacape_room/board/misrQuestionslist.jsp"
			}else{
				alert('문의사항 등록이 실패했습니다')
				location.href = location.href
			}
		}
	})
}