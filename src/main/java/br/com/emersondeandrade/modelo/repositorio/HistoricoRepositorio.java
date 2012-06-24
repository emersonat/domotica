package br.com.emersondeandrade.modelo.repositorio;

import java.util.List;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.historico.Historico;

public interface HistoricoRepositorio extends RepositorioPadrao<Historico> {
	
	List<Historico> buscaTodosHistoricos(String keyArduino,int initresult,int maxResult,String atributo, int ordem);
	
}
