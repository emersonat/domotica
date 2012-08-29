package br.com.emersondeandrade.modelo.repositorio;

import java.util.List;

import br.com.emersondeandrade.modelo.exeption.ObjectNaoEncontradoExeption;

public interface RepositorioPadrao<T> {
		
	
	public T  getById(int id);
	
	public List<T> listAll();
	
	public void salvar(T entity);
	
	
	
	
	

}
