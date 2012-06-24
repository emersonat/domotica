package br.com.emersondeandrade.infraEstrutura.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;
import br.com.emersondeandrade.modelo.exeption.ObjectNaoEncontradoExeption;
import br.com.emersondeandrade.modelo.repositorio.CasaRepositorio;


@Repository
public class CasaDao extends DaoPadrao<Casa> implements CasaRepositorio{
	
	
	@Autowired
	Criptografia criptService;
	
	
	
	public CasaDao() {
		super(Casa.class);
	}
	
	
	
	
	public Casa getCasaByKeyArduino(String key)	throws ObjectNaoEncontradoExeption {
				
				
		TypedQuery<Casa> query = entityManager.createQuery("from Casa c where c.arduino.key = :key", Casa.class);
		
		query.setParameter("key",  criptService.encodeMD5(key) );
				
		try{
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new ObjectNaoEncontradoExeption();
		}
		
		
		
	}

	
	public Casa getCasaByHashMobileAtivo(String hashMobile) throws ObjectNaoEncontradoExeption {
		
		TypedQuery<RegistroMobile> query = entityManager.createQuery("from RegistroMobile r where r.hash = :hash and r.ativo = true", RegistroMobile.class);
		
		query.setParameter("hash", hashMobile);
		
		
		try{
			 RegistroMobile registroMobile = query.getSingleResult();
			 return registroMobile.getCasa();
		} catch (NoResultException e) {
			throw new ObjectNaoEncontradoExeption();
		}
		
		
	}

}
