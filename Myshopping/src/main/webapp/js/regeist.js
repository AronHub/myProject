var base = {
	domain : window.location.protocol + "//" + window.location.host
			+"/Myshopping/"
	
}; 

$(document).ready(function(){

  $("#userRegist").click(function(){
     		var userName=$("input[name='userName']").val();
     		var passwd=$("input[name='passwd']").val();
     		var email=$("input[name='email']").val();
     		var tel=$("input[name='tel']").val();
     		$.ajax({
     			async:true,
     			url:base.domain+"userRegesit",
     			data:{
     				userName:userName,
     				passwd:passwd,
     				email:email,
     				tel:tel
     			},
     			success:function(data){
     				if(data=="success"){
     					alert("注册成功!")
     				}
     			},
     			error:function(){
     				alert("注册失败！")
     			}
     			
     			
     		})
        
     	
     	})
         
         
         
         
     });
