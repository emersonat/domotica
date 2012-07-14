package br.com.emersondeandrade.aplicacao.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.emersondeandrade.modelo.core.casa.Casa;

public abstract class ControllerWeb {
	
	public  HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); 
	}
	
	
	public Casa getCasa(){
		return (Casa) session().getAttribute("casa");
	}

}
