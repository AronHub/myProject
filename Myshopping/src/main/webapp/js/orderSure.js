var base = {
	domain : window.location.protocol + "//" + window.location.host
			+"/Myshopping/"
	
}; 
$(document).ready(function(){
	$("#return").click(function(){
		window.open("/Myshopping/getMyCart","_self");
	})
	
	$("#subOrder").click(function(){
		window.open("/Myshopping/goOrdreFinish","_self");
	})
	
})