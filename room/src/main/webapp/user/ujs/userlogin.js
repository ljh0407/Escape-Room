/**
 * 
 */
 alert('로그인해주세요')
 
  function login(){
	let mid = document.querySelector('#mid').value
	let mpw = document.querySelector('#mpw').value
	let loginbox = document.querySelector('#loginbox')
	
	$.ajax({
		url : "/room/userlogin",
		data : {"mid" : mid , "mpw" :mpw},
		success : function(re){
			console.log(re)
			if(re === '1'){
				//고은시[10/24]
				alert('성공')
				
				location.href = "/room/index.jsp";
				
			}else if(re === '2'){
				alert('비밀번호가 다릅니다')
				loginbox.innerHTML = "비밀번호가 다릅니다";
			}else if(re === '0'){
				alert('존재하지않는 아이디입니다')
				loginbox.innerHTML = "존재하지않는 아이디입니다";
			}
		}
	})
}