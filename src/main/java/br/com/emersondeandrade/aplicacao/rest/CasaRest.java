package br.com.emersondeandrade.aplicacao.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.aplicacao.ResponseStatus;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;
import br.com.emersondeandrade.modelo.exeption.ObjectNaoEncontradoExeption;



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
			
			
		} catch (ObjectNaoEncontradoExeption e) {
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
		
		 } catch (ObjectNaoEncontradoExeption e) {
			modelAndView.addObject("status", ResponseStatus.ERRO_EXECULTAR_COMANDO);
			e.printStackTrace();
		}  
		 		
	
		 return modelAndView;
	
	}
	*/
	
	

}
