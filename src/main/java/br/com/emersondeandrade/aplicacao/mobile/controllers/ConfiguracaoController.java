package br.com.emersondeandrade.aplicacao.mobile.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.aplicacao.ResponseStatus;
import br.com.emersondeandrade.aplicacao.mobile.controllers.forms.FormConfig;
import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.mobile.MobileFacade;


@Controller
@Scope("request")
@RequestMapping(value = "/mobile/config")
public class ConfiguracaoController  extends ControllerMobile {
		
	
	
	@Autowired
	CasaFacade casaFacade;
	
	@Autowired
	MobileFacade mobileFacade;
	
	
	@Autowired
	@Qualifier("jsonview")
	View jsonview;
	
	
	
	@RequestMapping(value = "/open", method = RequestMethod.GET)	
	public String open(HttpServletRequest r, Model model){
		
		Arduino a = getCasa().getArduinoPrincipal();
		
		model.addAttribute( new FormConfig( a.getIp(), a.getPorta()) );	
		model.addAttribute("arduino", a);
		
		return "mobile/config";
		
		
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)	
	public String salvar(@Valid FormConfig form, BindingResult result,Model model){
				
		if(result.hasErrors()){
			model.addAttribute("arduino", getCasa().getArduinoPrincipal());
			return "mobile/config";
		} 
			
		Arduino arduino = getCasa().getArduinoPrincipal();	
		arduino.setIp( form.getIp()  );
		arduino.setPorta(form.getPorta());
		
		casaFacade.salvarArduino(arduino);
			
		return "redirect:/mobile/verificaKey.html"; 
				
		
	}

	@RequestMapping(value = "/desconectar")	
	public String desconectar(){
		
		mobileFacade.desconectarMobile(getHashMobile());
		
		return "redirect:/mobile/verificaKey.html";
		
	}
	
	@RequestMapping(value = "/consultarStatus",method = RequestMethod.GET)	
	public ModelAndView consultarStatus(){
		ModelAndView mv = new ModelAndView(this.jsonview);// resposta json
		
		
		if( getCasa().getArduinoPrincipal().isConected() ){
			mv.addObject("status", ResponseStatus.OK);
		} else {
			mv.addObject("status", ResponseStatus.ERRO_DISPOSITIVO_NAO_CONECTADO);
		}
			
		
		return mv;
	}
	
	
	
	


	
	
	

}
