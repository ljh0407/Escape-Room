




nview() //  게시물 상세페이지가 열렸을때 실행되는 함수
// 1. 해당 게시물 출력
function nview(){
	$.ajax({
		url :"/room/nview",
		type : "get" , 
		success:function(re){
		let n = JSON.parse(re)
		console.log(n)
		
		document.querySelector('.nno').innerHTML =n.nno;
		document.querySelector('.ntitle').innerHTML =n.ntitle;
		document.querySelector('.ncontent').innerHTML = n.ncontent;
		document.querySelector('.mid').innerHTML = n.mid;
		
		console.log(n.btnaction)
		let btnbox = document.querySelector('.btnbox')
		if(n.btnaction == true){
		//삭제 버튼
		let deletebtn = '<button onclick="ndelete('+n.nno+')"> 삭제 </button>'	
		btnbox.innerHTML += deletebtn;	
		//수정버튼
		let updatebtn = '<button onclick="nupdate('+n.nno+')><a href="../nboard/nupdate.jsp">수정</a></button>'	
		btnbox.innerHTML += updatebtn;	
		}
	
		}
	})
}

