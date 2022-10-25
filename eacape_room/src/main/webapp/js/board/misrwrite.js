/**
 * 고은시[10/24]
 */
 alert('문의사항')
 function bwrite(){
	console.log('버튼확인')
	let inputs = document.querySelectorAll('input')
	let data = {
		btitle : inputs[0].value,
		bcontent : inputs[1].value
	}
	console.log(data)
	
	$.ajax({
		url : "/eacape_room/board/misrwrite",
		data : data,
		success : function(re){
			console.log(re)
			if(re == 'true'){
				alert('문의사항이 등록되었습니다')
				//고은시[10/25]
				location.href = "/eacape_room/board/misrQuestionslist.jsp"
			}else{
				alert('문의사항 등록이 실패했습니다')
			}
		}
	})
}