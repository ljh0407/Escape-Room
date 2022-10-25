

function list(){
	
	$.ajax({
		url : "/eacape_room/misrNoticeList",
		success:function(re){alert(re)}
		
	})
	
}