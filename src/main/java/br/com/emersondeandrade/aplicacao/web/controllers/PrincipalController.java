package br.com.emersondeandrade.aplicacao.web.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@Scope("request")
@RequestMapping(value = "/web/principal")
public class PrincipalController {
	
		
	@RequestMapping(value = "/open")
	public ModelAndView open(){
		
		return new ModelAndView("web/principal");
		
		
		
	}
	

}
