package br.com.emersondeandrade.infraEstrutura.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.repositorio.DispositivoRepositorio;


@Repository
public class DispositivoDao extends DaoPadrao<Dispositivo> implements DispositivoRepositorio {

		
	
		
	public DispositivoDao() {
		super(Dispositivo.class);
		
	}
		
		

	@SuppressWarnings("unchecked")
	public List<Dispositivo> getAll(int idCasa) {
	
		Query query = entityManager.createQuery("from Dispositivo");
		
		return query.getResultList();
		
		
	}


	
	
	
	
	
	
}
