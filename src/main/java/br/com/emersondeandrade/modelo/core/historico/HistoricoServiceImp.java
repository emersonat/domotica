package br.com.emersondeandrade.modelo.core.historico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.repositorio.HistoricoRepositorio;

@Service
public class HistoricoServiceImp implements HistoricoService {

	@Autowired
	HistoricoRepositorio repositorio;
	
	
	public List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem){
		return repositorio.buscaTodosHistoricos(casa, initresult, maxResult, atributo, ordem);
	}
	
	
	public void novoHistorico(Dispositivo disp) {
		
		Historico h = new Historico(disp.getNome(),disp.getArea().getNome(),disp.getCasa());
				
		repositorio.salvar(h);
		
	}

}
