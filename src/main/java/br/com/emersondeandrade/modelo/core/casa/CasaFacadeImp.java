package br.com.emersondeandrade.modelo.core.casa;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.historico.Historico;
import br.com.emersondeandrade.modelo.core.historico.HistoricoService;
import br.com.emersondeandrade.modelo.repositorio.ArduinoRepositorio;
import br.com.emersondeandrade.modelo.repositorio.CasaRepositorio;


@Service
public class CasaFacadeImp implements CasaFacade {
	
			
	@Autowired
	CasaRepositorio casaRepositorio;
		
	@Autowired
	HistoricoService historicoService;
		
	@Autowired
	ArduinoRepositorio arduinoRepositorio;
	
	

	

	public Casa getCasaByKeyArduino(String key)	throws EntityNotFoundException  {
			
		return casaRepositorio.getCasaByKeyArduino(key);
	}
	
	
	public Casa getCasaByHashMobileAtivo(String hashMobile) throws EntityNotFoundException   {
					
		return casaRepositorio.getCasaByHashMobileAtivo(hashMobile);
	}
	
	
	public List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem){
		
		return historicoService.buscaTodosHistoricos( casa , initresult, maxResult, atributo, ordem);
		
	}


	public void salvarArduino(Arduino arduino) {
				
		arduinoRepositorio.salvar(arduino);
			
		
	}
	
	
	public Casa getCasaById(int id) {
		return casaRepositorio.getById(id);
	}





	
	

	
	
	

}
