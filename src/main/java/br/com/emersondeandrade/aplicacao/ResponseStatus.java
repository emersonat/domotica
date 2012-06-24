package br.com.emersondeandrade.aplicacao;


public enum ResponseStatus  {
		
		 OK(1,"Comando Realizado com sucesso"), 
		 ERRO_DESCONHECIDO(2,"Erro deconhecido"),
		 ERRO_EXECULTAR_COMANDO(3,"Erro na execulcao do comando"),
		 ERRO_DISPOSITIVO_NAO_CONECTADO(4,"Dispositivo nao conectado");
		 
		 ResponseStatus(int cod,String descricao){
			 this.cod = cod;
			 this.descricao = descricao;
		 }
		 
		public int getCod() {
			return cod;
		}
		
		public String getDescricao() {
			return descricao;
		}

		private int cod;
		private String descricao;
		 
		
		
	
	


	
	
}	



	
	
	
	
	
	
	
	
	

	 


	
	
	
	

