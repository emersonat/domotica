package br.com.emersondeandrade.infraEstrutura.propriedadesSistema;



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

	@Override
	public String getURLBanco() {
		return System.getenv("DOMOTICA_URL_BANCO");
	}

	@Override
	public String getUsernameBanco() {
		return System.getenv("DOMOTICA_USER_BANCO");
		
	}

	@Override
	public String getSenhaBanco() {
		return System.getenv("DOMOTICA_SENHA_BANCO");
		
	}

}
