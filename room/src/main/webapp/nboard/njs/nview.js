




nview() //  게시물 상세페이지가 열렸을때 실행되는 함수
// 1. 해당 게시물 출력
function nview(){
	alert('asd')
	$.ajax({
		url :"/room/nview",
		type : "get" , 
		success:function(re){
		let n = JSON.parse(re)
		console.log(n)
		let html = ''
		document.querySelector('.nno').innerHTML =n.nno;
		document.querySelector('.ntitle').innerHTML =n.ntitle;
		document.querySelector('.ncontent').innerHTML = n.ncontent;
		document.querySelector('.mid').innerHTML = n.mid;
		
		document.querySelector('.ntable').innerHTML += html
		}
		
	})
}