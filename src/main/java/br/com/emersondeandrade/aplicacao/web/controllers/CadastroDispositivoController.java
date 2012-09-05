package br.com.emersondeandrade.aplicacao.web.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.dispositivo.TipoComando;

@Controller
@Scope("request")
@RequestMapping(value = "/web/dispositivo")
public class CadastroDispositivoController extends ControllerWeb {
		
	@Autowired
	@Qualifier("jsonview")
	View jsonview;
	
	@Autowired
	MessageSource i18n;
	
	@Autowired
	CasaFacade casaFacade;
	
		
	
	@RequestMapping(value = "/open")
	public ModelAndView open(){
		
		ModelAndView modelAndView = new ModelAndView("web/cadastros/dispositivo");
		
		modelAndView.addObject("disp", new Dispositivo());
		modelAndView.addObject("casa", getCasa());
		modelAndView.addObject("listaPortas", getCasa().getArduino().getPortasLivres());
		
		return modelAndView;
		
	}
	
	
	
	
	@RequestMapping(value="/salvar")
	public ModelAndView salvar(@Valid  Dispositivo dispositivo,BindingResult result){
		
		if(result.hasErrors()){
			
			System.out.println("Erro validacao");
		}
		
		
				
		
		return null;
	}
	
	
	@RequestMapping(value = "/changeAtivo")
	public ModelAndView  changeAtivo(@RequestParam("ativo") boolean ativo, HttpServletRequest r){
						
		Locale locale = r.getLocale();
				
		Arduino arduino = getCasa().getArduino();
				
		ModelAndView modelAndView = new ModelAndView(this.jsonview);// resposta json
				
		List<Integer> listaPortas = ativo ? arduino.getPortasLivres(): arduino.getPortas();
						
		modelAndView.addObject(String.valueOf(-1) , i18n.getMessage("selecione" , null, locale));
				
		for (Integer porta: listaPortas){
			modelAndView.addObject(String.valueOf( porta ), porta );
			
		}
			
		
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(value = "/comandos")
	public ModelAndView  getComandos(@RequestParam("numeroPorta") int porta, HttpServletRequest r){
		
		Locale locale = r.getLocale();
		
				
		Arduino arduino = getCasa().getArduino();
		
		
		
		ModelAndView modelAndView = new ModelAndView(this.jsonview);// resposta json
		
		modelAndView.addObject(String.valueOf(-1) , i18n.getMessage("selecione" , null, locale));
		for (TipoComando c: arduino.getComandosPossiveis(porta)){
			modelAndView.addObject(String.valueOf( c.getId()), i18n.getMessage(c.getI18n() , null, locale) );
			
		}
		
		
		
		
		return modelAndView;
	}
	
	
	

}
