package br.com.emersondeandrade.modelo.repositorio;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;

public interface RegistroMobileRepositorio extends RepositorioPadrao<RegistroMobile>{
	
	boolean existe(String nome,Casa casa);
	
	boolean existe(String hash); 
	
	void deletar(String hash);
	
	

}
