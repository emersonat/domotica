package br.com.emersondeandrade.aplicacao.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.dispositivo.TipoComando;

@Controller
@Scope("request")
@RequestMapping(value = "/web/dispositivo")
public class CadastroDispositivoController extends ControllerWeb {
		
	@Autowired
	@Qualifier("jsonview")
	View jsonview;
	
		
	
	@RequestMapping(value = "/open")
	public ModelAndView open(){
			
		return new ModelAndView("web/cadastros/dispositivo");
		
		
		
	}
	
	
	@RequestMapping(value = "/comandos")
	public ModelAndView  getComandos(@RequestParam("numeroPorta") int porta){
	
		Arduino arduino = getCasa().getArduino();
		
		ModelAndView modelAndView = new ModelAndView(this.jsonview);// resposta json
		
		for (TipoComando c: arduino.getComandosPossiveis(porta)){
			modelAndView.addObject(String.valueOf( c.getId()),  c.getI18n()  );
		}
			
		return modelAndView;
	}
	
	
	

}
