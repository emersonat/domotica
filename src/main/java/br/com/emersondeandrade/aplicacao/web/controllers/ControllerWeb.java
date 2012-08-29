package br.com.emersondeandrade.aplicacao.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.emersondeandrade.aplicacao.web.binders.TipoComandoBinder;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.dispositivo.TipoComando;

public abstract class ControllerWeb {
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(TipoComando.class, new TipoComandoBinder() );
		
	}
	
	
	public  HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); 
	}
	
	
	public Casa getCasa(){
		return (Casa) session().getAttribute("casa");
	}

}
