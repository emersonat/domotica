package br.com.emersondeandrade.aplicacao.mobile.controllers;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.aplicacao.ResponseStatus;
import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.dispositivo.DispositivoFacade;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Controller
@Scope("request")
@RequestMapping(value = "/mobile")
public class AcionarDispositivoMobileController extends ControllerMobile {

	private static Logger log = Logger.getLogger(AcionarDispositivoMobileController.class);
	
	@Autowired
	DispositivoFacade dispFacade;
	
	@Autowired
	Criptografia cript;
	
	
	@Autowired
	@Qualifier("jsonview")
	View jsonview;
			
	
	
	
	@RequestMapping(value = "/acionar/{idDispositivoCript}",method = RequestMethod.GET)	
	public ModelAndView acionar(@PathVariable String idDispositivoCript,HttpServletRequest r){
		
		ModelAndView modelAndView = new ModelAndView(this.jsonview);// resposta json
				
		try {
			 
			 dispFacade.acionar( getCasa() ,idDispositivoCript);
			 modelAndView.addObject("status", ResponseStatus.OK);
			 modelAndView.addObject("msg",  "Dispositivo acionado com sucesso!!");
	
		 } catch (NotConectedExeption e) {
			 modelAndView.addObject("status", ResponseStatus.ERRO_DISPOSITIVO_NAO_CONECTADO);
			 modelAndView.addObject("msg",  "Erro dispositivo n�o conectado!!");
			 log.error(e.getMessage());
			 e.printStackTrace();
		
		 } catch (ExecultarComandoExeption e) {
			 modelAndView.addObject("status", ResponseStatus.ERRO_EXECULTAR_COMANDO);
			 modelAndView.addObject("msg",  "Erro ao execultar comando!! ");
			 log.error(e.getMessage());
			 e.printStackTrace();
		
		 } catch (EntityNotFoundException e) {
			modelAndView.addObject("status", ResponseStatus.ERRO_EXECULTAR_COMANDO);
			modelAndView.addObject("msg",  "Erro ao execultar comando!! ");
			log.error(e.getMessage());
			e.printStackTrace();
		}  
					
		return modelAndView;
	}




	
	
	
	
	
}
