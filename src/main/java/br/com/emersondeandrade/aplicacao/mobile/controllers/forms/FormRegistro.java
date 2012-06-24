package br.com.emersondeandrade.aplicacao.mobile.controllers.forms;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FormRegistro {
	
	
	@NotEmpty(message = "*")
	@Size(max= 50 ,message = "*")
	private String key;
	
	@NotEmpty(message = "*")
	@Size(max= 50 ,message = "*")
	private String nomeDispositivo;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}
	

}
