package br.com.emersondeandrade.infraEstrutura.dao;

import org.apache.commons.dbcp.BasicDataSource;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSeguranca;

public class DataSource  extends BasicDataSource {
	
	
		
	public DataSource(PropriedadesSeguranca propsSeguranca) {
		
		setUrl(propsSeguranca.getURLBanco() == null ? "" : propsSeguranca.getURLBanco() );
		setUsername(propsSeguranca.getUsernameBanco() == null ? "" : propsSeguranca.getUsernameBanco() );
		setPassword(propsSeguranca.getSenhaBanco() == null ? "" : propsSeguranca.getSenhaBanco() );
		
		
	}
	
	
	
	

}
