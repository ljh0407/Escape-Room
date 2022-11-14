/**
 * 
 */
 
 qview()
 
 //고은시 수정[11/07]
 function qview(){
	$.ajax({
		url : "/room/qview",
	
		success : (re) =>{
			let qboard = JSON.parse(re)
			console.log( qboard )
			
			document.querySelector('.btitle').value = qboard.btitle
			document.querySelector('.bcontent').innerHTML = qboard.bcontent
			
			if(qboard.bfile !== null){
				let filedelete = qboard.bfile+'<button type="Button" onclick="bfiledelete()">삭제</button>'
				document.querySelector('.oldbfilebox').innerHTML = filedelete;
			}
			/* 썸머노트 실행 */
			$(document).ready(function() {
			  $('#summernote').summernote( {
				
					plasceholder : '내용 입력 해주세요' , 
					maxHeight : null , 
					minHeight : 300
				});
			}); 		
		}
	})
}

function bfiledelete(){
	if(confirm('삭제하겠습니까?')){//확인버튼누르면
		$.ajax({
			url : "/room/bfiledelete",
			type : "get",
			success : (re) =>{
				if(re === 'true'){
					alert('첨부파일삭제')
					document.querySelector('.oldbfilebox').innerHTML = ''//공백
					$("#oldbfilebox").load(location.reload+'#oldbfilebox')
				}else{alert('삭제 실패')}
			}
		})
	}
}
//게시물 수정[고은시 11/07]
 function qupdate(){
	
	let form = document.querySelector('form');
	let formdata = new FormData(form);
	console.log(formdata)
	
	$.ajax({
		url : "/room/bfiledelete",
		data : formdata,
		type : "POST" , 
		contentType : false,
		processData : false , 
		success : (re) => {
			console.log(re)
			if(re === 'true'){
				alert('수정성공')
				location.href = "qview.jsp"
			}else{
				alert('수정실패')
			}
		}
	})
}
