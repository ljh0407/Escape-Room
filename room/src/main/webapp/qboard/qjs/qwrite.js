/**
 * 
 */
 alert('문의사항')
 
 function bwrite(){
   alert('버튼')
   
   let form = document.querySelector('form')
   console.log(form)
   let formdata = new FormData(form);
   console.log(formdata)
   
   $.ajax({
      url : "/room/qwrite",
      data : formdata,
      contentType : false,
      processData : false,
      type : 'POST',
      success : function(re){
         console.log(re)
           if(re == 'true'){
            alert('문의사항이 등록되었습니다')
            location.href = "/room/qboard/qlist.jsp"
         }else{
            alert('문의사항 등록이 실패했습니다')
            location.href = location.href
         }
      }
   })
}