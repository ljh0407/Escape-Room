alert('asd')

function(){
	
	$.ajax({
		url:"/room/nlist",
		success: function(re){alert(re)}
		
	})
	
}