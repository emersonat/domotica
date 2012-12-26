package br.com.emersondeandrade.infraEstrutura.propriedadesSistema;

import org.springframework.stereotype.Component;

@Component
public class PropriedadeSegurancaVariaveisAmbiente implements PropriedadesSeguranca {

	
	public String getCookieName() {
		return System.getenv("DOMOTICA_COOKIE_NAME");
		
	}

	public String getSaltCriptografia() {
		return System.getenv("DOMOTICA_SALT_CRIPTOGRAFIA");
		
	}

	public String getSaltMD5() {
		return System.getenv("DOMOTICA_SALT_MD5");
		
	}

}
