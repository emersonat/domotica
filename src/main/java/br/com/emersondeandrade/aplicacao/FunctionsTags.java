package br.com.emersondeandrade.aplicacao;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;

public class FunctionsTags {
	
	
		
	public static String cript(Integer id){
		
		Criptografia cript = SpringUtils.getBean(Criptografia.class);
				
		return cript.cript(id);
		
	}
	

}
