package br.com.emersondeandrade.modelo.core.mobile;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.exeption.ExisteEntidadeExeption;

public interface MobileFacade {
	
	
	
	public RegistroMobile registrarMobile(String userAgent,String nome,Casa casa) throws ExisteEntidadeExeption;
	
	public void desconectarMobile(String hash);
	

}
