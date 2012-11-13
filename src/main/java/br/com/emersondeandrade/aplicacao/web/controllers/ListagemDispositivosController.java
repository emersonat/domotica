package br.com.emersondeandrade.aplicacao.web.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Scope("request")
@RequestMapping(value = "/web/dispositivo")
public class ListagemDispositivosController extends ControllerWeb {
	
	
		
	@RequestMapping(value = "/listar")
	public String open(ModelMap mv){
				
		mv.addAttribute("dispositivos",  getCasa().getDispositivos() );   
				
		return "web/listagens/dispositivos";
		
	}
	
	
	
	

}
