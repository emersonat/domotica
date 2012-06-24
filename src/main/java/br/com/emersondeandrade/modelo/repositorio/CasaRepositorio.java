package br.com.emersondeandrade.modelo.repositorio;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.exeption.ObjectNaoEncontradoExeption;

public interface CasaRepositorio extends RepositorioPadrao<Casa> {
	
	Casa getCasaByKeyArduino(String key) throws ObjectNaoEncontradoExeption;
	
	Casa getCasaByHashMobileAtivo(String hashMobile) throws ObjectNaoEncontradoExeption;

}
