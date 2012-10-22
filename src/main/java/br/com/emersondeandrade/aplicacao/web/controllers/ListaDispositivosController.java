package br.com.emersondeandrade.aplicacao.web.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Scope("request")
@RequestMapping(value = "/web/listarDispositivo")
public class ListaDispositivosController extends ControllerWeb {

	
	@RequestMapping(value = "/open")
	public String open(ModelMap modelAndView){
		
				
		return "web/listagens/lista_dispositivo.jsp";
		
		
	}
	
	
	
}
