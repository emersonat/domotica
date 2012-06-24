package br.com.emersondeandrade.modelo.core.casa;

import java.util.List;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.historico.Historico;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;
import br.com.emersondeandrade.modelo.exeption.ObjectNaoEncontradoExeption;

public interface CasaFacade {
	
	
	
	public void acionar(Casa casa,String keyDispositivo) throws NotConectedExeption, ExecultarComandoExeption, ObjectNaoEncontradoExeption ;
	
	
	public Dispositivo getDispositovoById(int idDispositivo) throws ObjectNaoEncontradoExeption;

	
	public Casa getCasaByKeyArduino(String keyArduino) throws ObjectNaoEncontradoExeption;
	
	public Casa getCasaByHashMobile(String hashMobile) throws ObjectNaoEncontradoExeption;
	
	public List<Historico> buscaTodosHistoricos(Casa casa,int initresult,int maxResult,String atributo, int ordem);
	
	
	public void salvarArduino(Arduino arduino);
		
	
	
	
	
}
