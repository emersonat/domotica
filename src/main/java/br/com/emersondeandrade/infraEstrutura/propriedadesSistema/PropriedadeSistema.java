package br.com.emersondeandrade.infraEstrutura.propriedadesSistema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PropriedadeSistema  {
	
	
	
	@Id
	@Column(length = 30,nullable = false)
	private String key;

	@Column(nullable = false)
	private String value;
	
	@SuppressWarnings("unused")
	@Column
	private String descricao;
	
	@Column(nullable = false)
	private boolean cript = false;

	
	public void put(String key,String value) {
		this.key = key;
		this.value = value;
	}

	

	
	public String getKey() {
		return key;
	}


	
	public String getValue() {
		return value;
		
		
		
	}




	public boolean isCript() {
		return cript;
	}




	public void setCript(boolean cript) {
		this.cript = cript;
	}





	


	
	
	

}
