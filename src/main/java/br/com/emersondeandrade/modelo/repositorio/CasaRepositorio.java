package br.com.emersondeandrade.modelo.repositorio;

import javax.persistence.EntityNotFoundException;

import br.com.emersondeandrade.modelo.core.casa.Casa;

public interface CasaRepositorio extends RepositorioPadrao<Casa> {
	
	Casa getCasaByKeyArduino(String key) throws EntityNotFoundException;
	
	Casa getCasaByHashMobileAtivo(String hashMobile) throws EntityNotFoundException;

}
