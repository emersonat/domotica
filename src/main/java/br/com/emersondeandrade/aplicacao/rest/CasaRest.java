package br.com.emersondeandrade.aplicacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.modelo.core.casa.CasaFacade;



@Controller
@RequestMapping(value = "/casa")
public class CasaRest {
	
	
	@Autowired
	@Qualifier("jsonview")
	View view;
	
	
	@Autowired
	CasaFacade casaFacade;
		
	
	/**
	@RequestMapping(value = "/listar/{keyArduino}",method = RequestMethod.GET)
	public ModelAndView listarDispositivos(@PathVariable("keyArduino") String keyArduino){
		ModelAndView modelAndView = new ModelAndView(this.view);
			
		try {
			Casa casa = casaFacade.getCasaByKeyArduino(keyArduino);
			Map<String , List<Dispositivo>> map = new HashMap<String , List<Dispositivo> >();
			map.put("disp", casa.getDispositivos());
			modelAndView.addAllObjects( map );
			
			
		} catch (EntityNotFoundException e) {
			 modelAndView.addObject("status", ResponseStatus.ERRO_EXECULTAR_COMANDO);
			e.printStackTrace();
		}
		
		return modelAndView;
		
	}
	*/	
	/*
	@RequestMapping(value = "/acionar/{keyDisp}",method = RequestMethod.PUT)
	public ModelAndView acionar(@PathVariable("keyDisp") String keyDisp){
		ModelAndView modelAndView = new ModelAndView(this.view);
		
		 try {
			 casaFacade.acionar(keyDisp);
			 modelAndView.addObject("status", ResponseStatus.OK);
	
		 } catch (NotConectedExeption e) {
			 modelAndView.addObject("status", ResponseStatus.ERRO_DISPOSITIVO_NAO_CONECTADO);
			e.printStackTrace();
		
		 } catch (ExecultarComandoExeption e) {
			 modelAndView.addObject("status", ResponseStatus.ERRO_EXECULTAR_COMANDO);
			e.printStackTrace();
		
		 } catch (EntityNotFoundException e) {
			modelAndView.addObject("status", ResponseStatus.ERRO_EXECULTAR_COMANDO);
			e.printStackTrace();
		}  
		 		
	
		 return modelAndView;
	
	}
	*/
	
	

}
