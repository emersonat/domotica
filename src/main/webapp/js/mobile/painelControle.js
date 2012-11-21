


function acionar(keyDispositivo){
		
	 desabilitaTodosBotoes();	
	 $.mobile.showPageLoadingMsg();
	
	
	$.ajax({
		  url: $('#contextPath').val() +  "/mobile/acionar.html",
		  context: document.body,
		  data: ( {keyDispositivo: keyDispositivo}   ),
		  dataType : "json",
		  type: "GET",	
		  success: function(data){
			 
			  habilitaTodosBotoes();
			  $.mobile.hidePageLoadingMsg();
			 
			  alert(data.msg );
		  },
		
		  error: function(){
		  	 
			  window.location =  $('#contextPath').val() + "/mobile/verificaKey.html"; 
		 
		  }
		  
	
	
		});
}





function habilitaTodosBotoes(){
	$(".botao_acionar_dispositivo").each(function(){
		 this.disabled="";
 });
}



function desabilitaTodosBotoes(){
	 $(".botao_acionar_dispositivo").each(function(){
		 this.disabled="disabled";
	 });
}



