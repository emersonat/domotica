package br.com.emersondeandrade.modelo.core.casa;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.historico.Historico;

public interface CasaFacade {
		
	
		
	public Casa getCasaByKeyArduino(String keyArduino) throws EntityNotFoundException;
	
	public Casa getCasaByHashMobileAtivo(String hashMobile) throws EntityNotFoundException;
	
	public List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem);
		
	public void salvarArduino(Arduino arduino);
	
	public Casa getCasaById(int id);
	
	
		
	
	
	
	
}
