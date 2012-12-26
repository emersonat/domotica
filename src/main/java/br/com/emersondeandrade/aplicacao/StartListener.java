package br.com.emersondeandrade.aplicacao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		System.out.println("******************************** Iniciando Domotica ******************************** ");
		System.out.println("Versão: XX\n");
		System.out.println("Variaveis de Ambiente:");
		System.out.println("DOMOTICA_COOKIE_NAME = " + System.getenv("DOMOTICA_COOKIE_NAME")  );
		System.out.println("DOMOTICA_SALT_CRIPTOGRAFIA = " + System.getenv("DOMOTICA_SALT_CRIPTOGRAFIA")  );
		System.out.println("DOMOTICA_SALT_MD5 = " + System.getenv("DOMOTICA_SALT_MD5")  );
		
		
		
		
		
	}
	

}
