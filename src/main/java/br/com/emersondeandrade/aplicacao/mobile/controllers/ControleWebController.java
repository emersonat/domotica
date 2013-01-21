package br.com.emersondeandrade.aplicacao.mobile.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@Scope("request")
@RequestMapping(value = "/controleweb")
public class ControleWebController extends ControllerMobile {
	
	
	@RequestMapping(method = RequestMethod.GET)	
	public String init(){
			
		return "redirect:/mobile/verificaKey.html";
	}
	
	
	
	

}
