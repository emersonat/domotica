package br.com.emersondeandrade.aplicacao.web.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String open(ModelMap modelAndView){
			
		modelAndView.addAttribute("disp", new Dispositivo());
		modelAndView.addAttribute("casa", getCasa());
		modelAndView.addAttribute("listaPortas", getCasa().getArduino().getPortasLivres());
		
		return "web/cadastros/dispositivo";
		
	}
	
	
	
	
	@RequestMapping(value="/salvar")
	public String salvar(@Valid Dispositivo dispositivo,BindingResult result,ModelMap mv){
				
		
		if(result.hasErrors()){
			result.rejectValue("numeroPorta","erro","erro");
			mv.addAttribute("casa", getCasa());
			mv.addAttribute("listaPortas", getCasa().getArduino().getPortasLivres());
			mv.addAttribute("disp", dispositivo);
			return "web/cadastros/dispositivo";
		}
		
		
				
		
		return "web/cadastros/dispositivo";
	}
	
	
	@RequestMapping(value = "/changeAtivo")
	public ModelAndView  changeAtivo(@RequestParam("ativo") boolean ativo, HttpServletRequest r){
						
		Locale locale = r.getLocale();
				
		Arduino arduino = getCasa().getArduino();
				
		ModelAndView modelAndView = new ModelAndView(this.jsonview);// resposta json
				
		List<Integer> listaPortas = ativo ? arduino.getPortasLivres(): arduino.getTodasPortas();
						
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
