package br.com.emersondeandrade.infraEstrutura.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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


	public Dispositivo getDispositivoByKey(String keyArduino,String key)	throws EntityNotFoundException {
				
		TypedQuery<Dispositivo> query = entityManager.createQuery("from Dispositivo d where d.key = :key and d.casa.arduino.key = :keyArduino", Dispositivo.class);
		
		query.setParameter("key", key);
		query.setParameter("keyArduino", keyArduino);
				
		try{
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new EntityNotFoundException();
		}
		
	
	}
	
	
	
	
	
}
