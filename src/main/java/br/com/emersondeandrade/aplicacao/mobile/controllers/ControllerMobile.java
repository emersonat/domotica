package br.com.emersondeandrade.aplicacao.mobile.controllers;

import br.com.emersondeandrade.modelo.core.casa.Casa;

public abstract class ControllerMobile {
		
	private Casa casa;
	private String hashMobile;
	
	
	
	public void setCasa(Casa casa){
		this.casa = casa;
	}
	
	public Casa  getCasa(){
		return casa;
	}

	public String getHashMobile() {
		return hashMobile;
	}

	
	public void setHashMobile(String hashMobile) {
		this.hashMobile = hashMobile;
	}
	
	
}
