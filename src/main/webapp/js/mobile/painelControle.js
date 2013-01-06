

function acionar(keyDispositivo){
	
	showLoading();
		
	$.ajax({
		  url: $('#contextPath').val() +  "/mobile/acionar/" + keyDispositivo +".html",
		  context: document.body,
		  dataType : "json",
		  type: "GET",	
		  success: function(data){
			 		 
			  hideLoading();
			 
			  
			  alert(data.msg );
		  	 
			  
			  
			  
			  
			  window.location =  $('#contextPath').val() + "/mobile/verificaKey.html"; 
		  },
		
		  error: function(){
		  	 
			  window.location =  $('#contextPath').val() + "/mobile/verificaKey.html"; 
		 
		  }
		  
	
	
		});
}












