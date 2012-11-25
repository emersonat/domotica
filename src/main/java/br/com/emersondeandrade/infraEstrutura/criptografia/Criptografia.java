package br.com.emersondeandrade.infraEstrutura.criptografia;




public interface Criptografia {
	
	  String cript(String str);
	  
	  String cript(int n);
	  
	  int decriptToInt(String number);
	  	  
	  String decript(String str);
	  
	  String encodeMD5(String str);
	 	 

}
