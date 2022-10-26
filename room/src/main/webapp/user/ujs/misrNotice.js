alert('dd')
function misrWrite(){

let info ={
	
		ntitle : document.querySelector('.ntitle').value,
		ncontent : document.querySelector('.ncontent').value
}
		console.log(info)
	$.ajax({
		url: "/eacape_room/misrNotice",
		data: info,
		success: function(re){
			console.log(re)
			if(re ==='true')
			{alert('글등록완료');
			
		}
		else{alert('글등록실패')}}
		
	})
	
}
