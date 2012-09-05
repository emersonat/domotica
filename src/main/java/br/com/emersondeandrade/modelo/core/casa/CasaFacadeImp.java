package br.com.emersondeandrade.modelo.core.casa;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.eventos.ProcessadorEventos;
import br.com.emersondeandrade.modelo.core.historico.Historico;
import br.com.emersondeandrade.modelo.core.historico.HistoricoService;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;
import br.com.emersondeandrade.modelo.repositorio.ArduinoRepositorio;
import br.com.emersondeandrade.modelo.repositorio.CasaRepositorio;
import br.com.emersondeandrade.modelo.repositorio.DispositivoRepositorio;


@Service
public class CasaFacadeImp implements CasaFacade {
	
		
	@Autowired
	DispositivoRepositorio dispositivoRepositorio;
		
	@Autowired
	CasaRepositorio casaRepositorio;
				
	@Autowired
	ProcessadorEventos processadorEventos;
	
	@Autowired
	HistoricoService historicoService;
	
	@Autowired
	Criptografia criptService;
	
	@Autowired
	ArduinoRepositorio arduinoRepositorio;
	
		
	
	public void acionar(Casa casa ,String keyDispositivo) throws NotConectedExeption, ExecultarComandoExeption,EntityNotFoundException  {
		
				
		Dispositivo dispositivo = dispositivoRepositorio.getDispositivoByKey(casa.getArduino().getKey() ,keyDispositivo);
		
		dispositivo.acionar();
		
		processadorEventos.processar( dispositivo );
		
		historicoService.novoHistorico(dispositivo);
					
	}
	
	
	
	
	
	

	public Dispositivo getDispositovoById(int idDispositivo) throws EntityNotFoundException {
		return dispositivoRepositorio.getById(idDispositivo);
	}
	

	public Casa getCasaByKeyArduino(String key)	throws EntityNotFoundException  {
			
		return casaRepositorio.getCasaByKeyArduino(key);
	}
	
	
	public Casa getCasaByHashMobile(String hashMobile) throws EntityNotFoundException   {
					
		return casaRepositorio.getCasaByHashMobileAtivo(hashMobile);
	}
	
	
	public List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem){
		
		return historicoService.buscaTodosHistoricos(casa.getArduino().getKey(), initresult, maxResult, atributo, ordem);
		
	}


	public void salvarArduino(Arduino arduino) {
				
		arduinoRepositorio.salvar(arduino);
			
		
	}







	public Casa getCasaById(int id) {
		return casaRepositorio.getById(id);
	}


	
	
	

}
