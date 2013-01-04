

function acionar(keyDispositivo){
		
	showLoading();
		
	$.ajax({
		  url: $('#contextPath').val() +  "/mobile/acionar.html",
		  context: document.body,
		  data: ( {keyDispositivo: keyDispositivo}   ),
		  dataType : "json",
		  type: "GET",	
		  success: function(data){
			 		 
			  hideLoading();
			 
			  alert(data.msg );
		  },
		
		  error: function(){
		  	 
			  window.location =  $('#contextPath').val() + "/mobile/verificaKey.html"; 
		 
		  }
		  
	
	
		});
}












