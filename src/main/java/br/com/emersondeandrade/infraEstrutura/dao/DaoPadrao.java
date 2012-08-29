package br.com.emersondeandrade.infraEstrutura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.com.emersondeandrade.modelo.repositorio.RepositorioPadrao;


public abstract class DaoPadrao<T>  implements RepositorioPadrao<T>   {

	public static final int ORDEM_CRESCENTE = 1;
	public static final int ORDEM_DECRESCENTE = -1;
	
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<T> klass;
	
	
	public DaoPadrao() {
		
	}
	
	public DaoPadrao(Class<T> klass) {
		this.klass = klass;
		
	}
	
	
	public T getById(int id)  {
		
		return (T) entityManager.getReference(klass , id); 
		  
		
	}

	
	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		Query query = entityManager.createQuery("from " + klass.getName());
		return query.getResultList();
		
	}

	
	
	

	@Transactional
	public void salvar(T entity) {
		
		entityManager.persist(entity);
		
		
	}

	
	

}
