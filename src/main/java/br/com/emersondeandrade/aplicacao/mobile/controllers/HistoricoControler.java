package br.com.emersondeandrade.aplicacao.mobile.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.historico.Historico;



@Controller
@Scope("request")
@RequestMapping(value = "/mobile")
public class HistoricoControler  extends ControllerMobile {
	
	@Autowired
	CasaFacade casaFacade;
	
	
	@RequestMapping(value = "/listarHistorico",method = RequestMethod.GET)	
	public ModelAndView listarHistoricos(HttpServletRequest r){
		
			
		List<Historico> listaHistoricos = casaFacade.buscaTodosHistoricos( getCasa() , 0, 50, "data" , -1 );
		
		
		return new ModelAndView("mobile/historico", "historicos" , listaHistoricos );
		
	}

}
