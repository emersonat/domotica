package br.com.emersondeandrade.modelo.core.dispositivo;

import javax.persistence.EntityNotFoundException;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;

public interface DispositivoFacade {
	
	void desativarDispositivo(int id);
	void ativarDispositivo(int id);
	void acionar(Casa casa,String keyDispositivo) throws NotConectedExeption, ExecultarComandoExeption, EntityNotFoundException; 
	Dispositivo getDispositovoById(int idDispositivo) throws EntityNotFoundException;
	void salvarDispositivo(Dispositivo disp);
	
}
