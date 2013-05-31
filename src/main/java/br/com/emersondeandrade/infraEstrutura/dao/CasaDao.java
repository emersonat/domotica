package br.com.emersondeandrade.infraEstrutura.dao;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;
import br.com.emersondeandrade.modelo.repositorio.CasaRepositorio;


@Repository
public class CasaDao extends DaoPadrao<Casa> implements CasaRepositorio{
	
	
	@Autowired
	Criptografia criptService;
	
	
	
	public CasaDao() {
		super(Casa.class);
	}
	
	
	
	
	public Casa getCasaByKeyArduino(String key)	throws EntityNotFoundException {
				
				
		TypedQuery<Arduino> query = entityManager.createQuery("from Arduino a where a.key = :key", Arduino.class);
		
		query.setParameter("key",  criptService.encodeMD5(key) );
				
		try{
			Arduino a = query.getSingleResult();
			return  a.getCasa();
		} catch (NoResultException e) {
			throw new EntityNotFoundException();
		}
		
		
		
	}

	
	public Casa getCasaByHashMobileAtivo(String hashMobile) throws EntityNotFoundException {
		
		TypedQuery<RegistroMobile> query = entityManager.createQuery("from RegistroMobile r where r.hash = :hash and r.ativo = true", RegistroMobile.class);
		
		query.setParameter("hash", hashMobile);
		
		
		try{
			 RegistroMobile registroMobile = query.getSingleResult();
			 return registroMobile.getCasa();
		} catch (NoResultException e) {
			throw new EntityNotFoundException();
		}
		
		
	}

}
