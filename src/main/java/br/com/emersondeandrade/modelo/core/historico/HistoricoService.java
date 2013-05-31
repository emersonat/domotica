package br.com.emersondeandrade.modelo.core.historico;

import java.util.List;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;



public interface HistoricoService {
	
	
	public void novoHistorico(Dispositivo disp);
		
	List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem);

	
	

}
