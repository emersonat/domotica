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
		
		System.out.println("\n=============================================== Iniciando Domotica =============================================== ");
		System.out.println("Versão: XX\n");
		
		imprimirVariaveisAmbiente();
		imprimirPropriedadesSegurancaUsadas();				
		
		
		System.out.println("======================================================================================================================\n ");
		
		
	}
	
	
	private void imprimirVariaveisAmbiente(){
		System.out.println("\nVariaveis de ambiente:");
		System.out.println("-------------------------------");
		String[] var = {"DOMOTICA_COOKIE_NAME","DOMOTICA_SALT_CRIPTOGRAFIA","DOMOTICA_SALT_MD5","DOMOTICA_URL_BANCO","DOMOTICA_USER_BANCO","DOMOTICA_SENHA_BANCO"};
		
		for(String v : var){
			System.out.println(v + " --> "  + System.getenv(v) );
		}
	}
	
	private void imprimirPropriedadesSegurancaUsadas(){
		
		System.out.println("\nPropriedades de seguranca que estao sendo usadas:");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Implementação: " + ps.getClass().getName());
		System.out.println("Nome cookie = " + ps.getCookieName()  );
		System.out.println("Salt criptografia = " + ps.getSaltCriptografia() );
		System.out.println("Salt MD5= " + ps.getSaltMD5() );
				
		System.out.println("URL banco dados= " + ps.getURLBanco() );
		System.out.println("Usuario banco dados= " + ps.getUsernameBanco() );
		System.out.println("Senha banco= " +  ps.getSenhaBanco() );
	}
	

}
