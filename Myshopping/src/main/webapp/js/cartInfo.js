var base = {
	domain : window.location.protocol + "//" + window.location.host
			+"/Myshopping/"
	
}; 

$(document).ready(function(){
	//修改数量
	$("#updtaCount").click(function(){
		var sum=$("#sum").val();
		var arraysId= new Array();
		var arraysAcount= new Array();
		for(var i=0;i<sum;i++){
			var bookID=$("#bookID"+i).val();
			var acount=$("#acount"+i).val();
			arraysId.push(bookID);
			arraysAcount.push(acount);
		}
		$.ajax({
			url:base.domain+"updatMyCart",
			async:true,
			data:{
				acounts:JSON.stringify(arraysAcount),
				bookIds:JSON.stringify(arraysId)
			},
			success:function(data){
				if(data=="success"){
					alert("更新成功！");
					window.open("/Myshopping/getMyCart","_self");
				}
			},
			error:function(){
				alert("更新数量失败！")
			}
		})
	})
	
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


	

