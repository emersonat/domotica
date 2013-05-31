package br.com.emersondeandrade.modelo.repositorio;

import java.util.List;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.historico.Historico;

public interface HistoricoRepositorio extends RepositorioPadrao<Historico> {
	
	List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem);
	
}
