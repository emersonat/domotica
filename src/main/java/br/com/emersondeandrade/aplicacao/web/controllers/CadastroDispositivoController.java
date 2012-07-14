package br.com.emersondeandrade.aplicacao.web.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.emersondeandrade.modelo.core.casa.Casa;

@Controller
@Scope("request")
@RequestMapping(value = "/web/dispositivo")
public class CadastroDispositivoController extends ControllerWeb{
		
	
	@RequestMapping(value = "/open")
	public ModelAndView open(){
		
		Casa casa =  (Casa) session().getAttribute("casa");
		
		
		
		return new ModelAndView("web/cadastros/dispositivo");
		
		
		
	}
	
	

}
