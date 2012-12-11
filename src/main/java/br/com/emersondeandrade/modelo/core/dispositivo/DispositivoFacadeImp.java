package br.com.emersondeandrade.modelo.core.dispositivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.modelo.repositorio.DispositivoRepositorio;


@Service
public class DispositivoFacadeImp implements DispositivoFacade {

	@Autowired
	DispositivoRepositorio dispRepositorio;
	
	
	public void desativarDispositivo(int id) {
		Dispositivo d = dispRepositorio.getById(id);
		
		System.out.println(d.getNome());
		System.out.println(d.getNumeroPorta());
		
		d.setAtivo(false);
		dispRepositorio.salvar(d);
		
		
	}
	
	
	public void ativarDispositivo(int id) {
		Dispositivo d = dispRepositorio.getById(id);
		d.setAtivo(true);
		dispRepositorio.salvar(d);
		
	}
	
	

}
