
function misrWrite(){

let info ={
	
		ntitle : document.querySelector('.ntitle').value,
		ncontent : document.querySelector('.ncontent').value
}
		
	$.ajax({
		url: "/eacape_room/misrNotice",
		data: info,
		type:"POST",
		success: function(re){
			if(re ==='true')
			{alert('글등록완료');
			
		}
		else{alert('글등록실패')}}
		
	})
	
}
