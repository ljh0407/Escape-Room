alert('asd')

function review(){	
	
	let info= {
		gname : document.querySelector('.gname').value,
		gdate: document.querySelector('.gdate').value
	}
	
	$.ajax({
		url:"/room/reservationView",
		data:info,
		success: function(re){
			if(re == 'true'){
				alert('예약완료 현장결제')
				location.href="/room/index.jsp"
			}else{
				alert('예약실패')
			}
		}
	})
}