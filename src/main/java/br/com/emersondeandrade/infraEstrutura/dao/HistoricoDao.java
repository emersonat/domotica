package br.com.emersondeandrade.infraEstrutura.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.historico.Historico;
import br.com.emersondeandrade.modelo.repositorio.HistoricoRepositorio;

@Repository
public class HistoricoDao extends DaoPadrao<Historico> implements HistoricoRepositorio {

	
	public HistoricoDao() {
		super(Historico.class);
	}
	
	
	
	public List<Historico> buscaTodosHistoricos(Casa casa,int initResult,int maxResult,String atributo, int ordem) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();// builder 
		CriteriaQuery<Historico> query = builder.createQuery(Historico.class);// retorno da query
		Root<Historico> historico = query.from(Historico.class);// classe base onde será feito o select	
		
		
		
			
		Order order = null;
		if(ordem > 0){
			order = builder.asc( historico.get(atributo) );//ordem crescente
		} else {
			order = builder.desc(historico.get(atributo) );// ordem decrescente
		}
		
		
		
		TypedQuery<Historico> typedQuery = entityManager.createQuery(
			query.select(historico)
				.where( 
					builder.equal(historico.get("casa").get("id")  , casa.getId())	
				 ).orderBy(order)
		);
		
		
		
		typedQuery.setFirstResult(initResult);
		typedQuery.setMaxResults(maxResult);
		
		
		return typedQuery.getResultList();
		
		
		
	}
	
	
	

	

}
