package br.com.emersondeandrade.aplicacao.mobile.controllers.forms;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



public class FormConfig {
	
	@NotEmpty(message = "*")
	@Size(max=20,min=6,message = "*")
	private String ip;
	
	
	@NotEmpty(message = "*")
	@Size(max=4,min=2,message = "*")
	private String porta;
	
	
	
	public FormConfig() {
		
	}
	
	public FormConfig(String ip, String porta){
		this.ip = ip;
		this.porta = porta;
		
	}
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}

	

}
