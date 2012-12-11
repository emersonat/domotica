package br.com.emersondeandrade.aplicacao.mobile.controllers;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.emersondeandrade.aplicacao.mobile.CookiesService;
import br.com.emersondeandrade.aplicacao.mobile.controllers.forms.FormRegistro;
import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSeguranca;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.mobile.MobileFacade;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;
import br.com.emersondeandrade.modelo.exeption.ExisteEntidadeExeption;


@Controller
@Scope("request")
@RequestMapping(value = "/mobile")
public class RegistrarMobileController  extends ControllerMobile {

	
	@Autowired
	CasaFacade casaFacade;
	
	@Autowired
	MobileFacade mobileFacade;
	
	@Autowired
	CookiesService cookieService;
	
	@Autowired
	PropriedadesSeguranca propSeg;
	
	
	@RequestMapping(value = "/registra",method = RequestMethod.POST)
	public String registraMobile(@Valid FormRegistro form ,BindingResult result,HttpServletResponse response, HttpServletRequest request,Model model){		
		
		if(result.hasErrors()){
			return "mobile/registrarMobile";
		} 
		
		Casa casa = null;
		try {
			 casa = casaFacade.getCasaByKeyArduino( form.getKey() );
		} catch (EntityNotFoundException e) {
			model.addAttribute("erro","Codigo invalido");
			return "mobile/registrarMobile";
			
		}
		 String userAgent = request.getHeader("user-agent");
		 
		 RegistroMobile registroMobile = null;
		 try {
			 registroMobile = mobileFacade.registrarMobile(userAgent, form.getNomeDispositivo(), casa);
		} catch (ExisteEntidadeExeption e) {
			model.addAttribute("erro","Já existe: " + form.getNomeDispositivo());
			return "mobile/registrarMobile";
		}
				
		// grava cookie com hash mobile
		Cookie cookie = new Cookie(propSeg.getCookieName(), registroMobile.getHash() );
		cookie.setMaxAge( 60*60*24*300 );// 1 ano para expirar
		response.addCookie(cookie);
		
		model.addAttribute("casa", casa );
		return "mobile/painelControle";
		
	}
		
		
	
	@RequestMapping(value = "/verificaKey",method = RequestMethod.GET)
	public String verificaKey(HttpServletRequest r,Model model){
		
		String hashMobile = cookieService.getValue(propSeg.getCookieName(), r.getCookies());
			
		RegistroMobile controleMobile = mobileFacade.getByHash(hashMobile);
		
		
		if(controleMobile == null){
			
			model.addAttribute(new FormRegistro());
			return "mobile/registrarMobile";
	
		} else if (!controleMobile.isAtivo()) {
			return "mobile/controleInativo";
			
		} else {
			
			model.addAttribute("casa", controleMobile.getCasa());
			return "mobile/painelControle";
			
		}
				
		
		
		
		
			
		
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public Casa getCasa() {
		throw new UnsupportedOperationException();
		
	}
	
	@Override
	public void setCasa(Casa casa) {
		throw new UnsupportedOperationException();
		
	}
	
	
}
