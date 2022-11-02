
/*
	<a href="경로?변수명=데이터"> 
	<a href="/room/nboard/nview.jsp?nno = 3 ">
*/


list()
function list(){
	
	let listsize = 3;
	
	$.ajax({
		url: "/room/nlist",
		data: {"listsize":listsize},
		success:function(re){
			let json = JSON.parse(re)
			console.log(json)
			let html = '';
			for(let i = 0; i < json.length; i++){
				let n = json[i]
				console.log(n)
				html +=
					'<tr>'+
							'<td>'+n.nno+'</td>'+ 		//번호
							'<td onclick="viewload('+n.nno+')"> '+n.ntitle+'</a></td>'+ 	//제목
							'<td>'+n.mid+'</td>'+  		//작성자
							'<td>'+n.ndate+'</td>'+ 	// 작성일
							'<td>'+n.nview+'</td>'+ 	// 조회수
					'</tr>';
			}
		document.querySelector('.ntable').innerHTML += html
		
		//1. 페이징버튼 html 구성
		let pagehtml ='';
			
			// 2.이전버튼
			pagehtml +="<button>이전</button>"
			
			//4. 페이지번호 버튼
			for ( let i = 1; i<=10 ; i++){
				pagehtml += "<button>"+i+"</button>"
			}
				
			// 3.다음버튼
			pagehtml +="<button>다음</button>"
		
		document.querySelector('.pagebox').innerHTML = pagehtml	
		 
		}
	})
}


function viewload(nno){
	$.ajax({
		url: "/room/nviewload",
		type : "post", 
		data:{"nno":nno},
		success:function(re){
			location.href = "/room/nboard/nview.jsp"
		}
	})
}
