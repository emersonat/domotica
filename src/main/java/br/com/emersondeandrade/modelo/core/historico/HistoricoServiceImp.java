package br.com.emersondeandrade.modelo.core.historico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.repositorio.HistoricoRepositorio;

@Service
public class HistoricoServiceImp implements HistoricoService {

	@Autowired
	HistoricoRepositorio repositorio;
	
	
	public List<Historico> buscaTodosHistoricos(String keyArduinoCript,int initresult,int maxResult,String atributo, int ordem){
		return repositorio.buscaTodosHistoricos(keyArduinoCript, initresult, maxResult, atributo, ordem);
	}
	
	public void novoHistorico(Dispositivo disp) {
		Historico h = new Historico();
		h.setData(new Date());
		h.setDispositivo(disp);
		
		repositorio.salvar(h);
		
	}

}
