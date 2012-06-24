package br.com.emersondeandrade.modelo.repositorio;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadeSistema;

public interface PropriedadeSistemaRepositorio extends RepositorioPadrao<PropriedadeSistema>  {

	PropriedadeSistema getByKey( String key );
	
}
