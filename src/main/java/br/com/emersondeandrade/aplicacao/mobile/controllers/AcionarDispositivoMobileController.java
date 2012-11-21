package br.com.emersondeandrade.aplicacao.mobile.controllers;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.aplicacao.ResponseStatus;
import br.com.emersondeandrade.modelo.core.arduino.ArduinoWIZNET_W5100;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Controller
@Scope("request")
@RequestMapping(value = "/mobile")
public class AcionarDispositivoMobileController extends ControllerMobile {

	private static Logger log = Logger.getLogger(AcionarDispositivoMobileController.class);
	
	@Autowired
	CasaFacade casaFacade;
	
	
	@Autowired
	@Qualifier("jsonview")
	View jsonview;
			
	
	
	
	@RequestMapping(value = "/acionar",method = RequestMethod.GET)	
	public ModelAndView acionar(@RequestParam("keyDispositivo") String keyDispositivo,HttpServletRequest r){
		
		ModelAndView modelAndView = new ModelAndView(this.jsonview);// resposta json
				
		try {
			 casaFacade.acionar( getCasa() ,keyDispositivo);
			 modelAndView.addObject("status", ResponseStatus.OK);
			 modelAndView.addObject("msg",  "Dispositivo acionado com sucesso!!");
	
		 } catch (NotConectedExeption e) {
			 modelAndView.addObject("status", ResponseStatus.ERRO_DISPOSITIVO_NAO_CONECTADO);
			 modelAndView.addObject("msg",  "Erro dispositivo não conectado!!");
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
