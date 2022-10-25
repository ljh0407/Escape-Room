/**
 * 고은시 [10/25]
 */
 alert('문의사항 목록')
 /* 전역변수 list 불러올 목록들 */
 
 function list(){
	$.ajax({
		url : "/eacape_room/Questionslist",
		success : function(re){
			console.log(re)
			let boardlist = JSON.parse(re)
			//location.href = "/eacape_room/board/misrQuestionslist.jsp"
			console.log(boardlist)
		}
	})
}