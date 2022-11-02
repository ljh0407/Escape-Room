
//10.27 글쓰기 주혁
function nwrite(){

	let info = {
		ntitle : document.querySelector('.ntitle').value ,
		ncontent : document.querySelector('.ncontent').value
	}

$.ajax({
	url:"/room/nwrite",
	type: 'post',
	data : info ,
	success: function(re){
		if(re == 'true'){
			alert('글등록')
			location.href = "/room/nboard/nlist.jsp"
	}else{
		alert('글등록실패')
         }
      }
   })
}

$(document).ready(function() {
  $('#summernote').summernote();
  
});