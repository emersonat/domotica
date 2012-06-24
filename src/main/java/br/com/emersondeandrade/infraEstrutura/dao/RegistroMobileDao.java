
package br.com.emersondeandrade.infraEstrutura.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;
import br.com.emersondeandrade.modelo.repositorio.RegistroMobileRepositorio;

@Repository
public class RegistroMobileDao extends DaoPadrao<RegistroMobile> implements RegistroMobileRepositorio{

	@Autowired
	Criptografia cript;
	

	public boolean existe(String nome, Casa casa) {
		
		TypedQuery<RegistroMobile> query = entityManager.createQuery("from RegistroMobile r where r.nome = :nome and r.casa.id = :idCasa", RegistroMobile.class);
		
		query.setParameter("nome", nome);
		query.setParameter("idCasa", casa.getId());
		
		
		try{
			query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		
		return true;
		
	}
	


	public boolean existe(String hashCriptMD5) {
		
		TypedQuery<RegistroMobile> query = entityManager.createQuery("from RegistroMobile r where r.hash = :hash", RegistroMobile.class);
		
		query.setParameter("hash", hashCriptMD5);
			
		
		try{
			query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		
		return true;
				
	}


	@Transactional
	public void deletar(String hash) {
		
		Query query = entityManager.createQuery("delete from RegistroMobile r  where r.hash = :hash");
		
		query.setParameter("hash", hash);
		 
		query.executeUpdate();
		
	}

}
