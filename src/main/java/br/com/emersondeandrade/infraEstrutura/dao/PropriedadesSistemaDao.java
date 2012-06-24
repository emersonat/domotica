package br.com.emersondeandrade.infraEstrutura.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadeSistema;
import br.com.emersondeandrade.modelo.repositorio.PropriedadeSistemaRepositorio;

@Repository
public class PropriedadesSistemaDao extends DaoPadrao<PropriedadeSistema> implements PropriedadeSistemaRepositorio {

	
	
	public PropriedadesSistemaDao() {
		super(PropriedadeSistema.class);
	}

	public PropriedadeSistema getById(int id) {
		throw new UnsupportedOperationException();
	}

	public PropriedadeSistema getByKey(String key) {
		Query createQuery = entityManager
				.createQuery("from PropriedadeSistema p where p.key = :key  ");
		createQuery.setParameter("key", key);
		try {
			return (PropriedadeSistema) createQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
