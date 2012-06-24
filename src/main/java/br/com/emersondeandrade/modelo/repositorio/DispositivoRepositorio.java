package br.com.emersondeandrade.modelo.repositorio;

import java.util.List;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.exeption.ObjectNaoEncontradoExeption;


public interface DispositivoRepositorio   extends RepositorioPadrao<Dispositivo>  {

	public List<Dispositivo> getAll(int idCasa);
	
	public Dispositivo getDispositivoByKey(String keyArduino,String keyDispositivo) throws ObjectNaoEncontradoExeption;
	
	
	

}
