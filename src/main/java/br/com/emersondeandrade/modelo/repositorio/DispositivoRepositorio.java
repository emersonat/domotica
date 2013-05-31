package br.com.emersondeandrade.modelo.repositorio;

import java.util.List;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;


public interface DispositivoRepositorio   extends RepositorioPadrao<Dispositivo>  {

	public List<Dispositivo> getAll(int idCasa);
	
	
	
	
	

}
