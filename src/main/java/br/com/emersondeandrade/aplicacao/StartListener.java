package br.com.emersondeandrade.aplicacao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSeguranca;



public class StartListener implements ServletContextListener{

	
	@Autowired
	PropriedadesSeguranca ps;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		SpringUtils.autowiredThisBean(this, servletContextEvent);
		
		System.out.println("******************************** Iniciando Domotica ******************************** ");
		System.out.println("Versão: XX\n");
		System.out.println("Propriedades de seguranca:");
		System.out.println("Implementação: " + ps.getClass().getName());
		System.out.println("Nome cookie = " + ps.getCookieName()  );
		System.out.println("Salt criptografia = " + ps.getSaltCriptografia() );
		System.out.println("Salt MD5= " + ps.getSaltMD5() +"\n" );
				
		System.out.println("URL banco dados= " + ps.getURLBanco() );
		System.out.println("Usuario banco dados= " + ps.getUsernameBanco() );
		System.out.println("Senha banco= " +  ps.getSenhaBanco() );
		
		System.out.println("************************************************************************************** ");
		
		
	}
	

}
