package br.com.emersondeandrade.modelo.core.mobile;

import javax.persistence.EntityNotFoundException;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.exeption.ExisteEntidadeExeption;

public interface MobileFacade {
	
	
	
	public RegistroMobile registrarMobile(String userAgent,String nome,Casa casa) throws ExisteEntidadeExeption;
	
	public void desconectarMobile(String hash);
	
	public void desconectarMobile(int id);
	
	public void desativarMobile(int id);
	
	public void ativarMobile(int id);
	
	public RegistroMobile getByHash(String hash) throws EntityNotFoundException ;
	
	

}
