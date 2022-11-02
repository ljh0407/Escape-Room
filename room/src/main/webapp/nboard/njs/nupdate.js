


nview()
function nview(){
	$.ajax({
		url:"/room/nview",
		success:function(re){
		let n = JSON.parse(re)
		
		document.querySelector('.ntitle').value=n.ntitle;
		document.querySelector('.ncontent').innerHTML=n.ncontent;
		
				/*썸머노트*/
			$(document).ready(function() {
			  $('#summernote').summernote({
	
		  placeholder : '내용 입력 해주세요',
  			maxHeight : null,
	  		minHeight : 300
		});
		
	});
		
		}
	})
}


function nupdate(){
	
	let info ={
		ntitle : document.querySelector('.ntitle').value,
		ncontent: document.querySelector('.ncontent').value
		
	}
	
	console.log(info)
	
	$.ajax({
		url:"/room/nupdate",
		type:"post",
		data: info,
		success:function(re){
			if( re==='true'){alert('수정성공');
			location.href='nview.jsp'}
			else{alert('수정실패')}
		}
	})
	
}





	