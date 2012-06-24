package br.com.emersondeandrade.modelo.core.arduino;

public enum ModeloArduino {
	
	ENC28J60, WIZNET_W5100,ARDUINO_TESTE;
	
	
		
	
	
	
	public String toString(){
		switch (this) {
		case ENC28J60:
			return "ENC 28J60";  
			
		case WIZNET_W5100:
			return "WIZNET W5100";  	
			
		case ARDUINO_TESTE:
			return "TESTE";  	
		
		default:
			return "Não definido";
		
		}
	}

}
