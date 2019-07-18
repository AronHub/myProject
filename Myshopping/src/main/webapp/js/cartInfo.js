var base = {
	domain : window.location.protocol + "//" + window.location.host
			+"/Myshopping/"
	
}; 

$(document).ready(function(){
	//删除所有
	$("#deltAll").click(function(){
		
		$(".deleAllView").css("display","inline-block");
		$(".mubu").css("display","inline-block");
		
		//取消
		$(".delAll_canl").click(function(){
			$(".deleAllView").css("display","none");
			$(".mubu").css("display","none");
			 
		})
		//确定
		$(".delAll_sure").click(function(){
			$.ajax({
				url:base.domain+"MyCartDeletAll",
				async:true,
				success:function(data){
					if(data=="success"){
						alert("删除所有成功！");
					}
					$(".mubu").css("display","none");
					$(".deleAllView").css("display","none");
					//
					window.open("/Myshopping/getMyCart","_self");
					
					
				},
				error:function(){
					alert("删除所有失败！")
				}
			})
		})
	})
	
})


	

