package br.com.emersondeandrade.modelo.repositorio;

import java.util.List;

public interface RepositorioPadrao<T> {
		
	
	public T  getById(int id);
	
	public List<T> listAll();
	
	public void salvar(T entity);
	
	public void delete(T entity);
	
	
	
	
	

}
