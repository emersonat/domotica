
$(document).ready(function(){
	
	
	
	consultaStatusArduino();

	
});

function consultaStatusArduino() {
	
		
	$.ajax({
	
		  url: $('#contextPath').val() +  "/mobile/config/consultarStatus.html",
		  context: document.body,
		  dataType : "json",
		  type: "GET",	
		  success: function(data){
			  if(data.status == 'OK'){
				  
				  $('#statusArduino').html( $('#conectado').html() );
				  $('#statusArduino').css("color","blue");
			 
			  } else {
				  
				  $('#statusArduino').html( $('#desconectado').html() );
				  $('#statusArduino').css("color","red");
			  }
			  
			 
			 
		  },
		
		  error: function(){
			  
			  $('#statusArduino').html( $('#erroConectar').html() );
			  $('#statusArduino').css("color","red");
			
		 
		  }
		  
	
	
		});
	 
	 
	
}