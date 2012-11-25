package br.com.emersondeandrade.aplicacao.mobile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.emersondeandrade.aplicacao.mobile.controllers.ControllerMobile;
import br.com.emersondeandrade.aplicacao.mobile.controllers.RegistrarMobileController;
import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSeguranca;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.mobile.MobileFacade;



@Component("filtroAutenticacaoMobile")
public class FiltroAutenticacaoMobile   extends HandlerInterceptorAdapter   {

	@Autowired
	CasaFacade casaFacade;
	
	@Autowired
	MobileFacade mobileFacade;
	
	@Autowired
	PropriedadesSeguranca propSeg;
	
	@Autowired
	CookiesService cookieservice;
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("Passando Filtro autenticacao Mobile");
		
		if(handler instanceof RegistrarMobileController){
			return true;
		}
		
		
		String hashMobile = cookieservice.getValue(propSeg.getCookieName(), request.getCookies());
			
		Casa casa = null;
		try {
			casa = casaFacade.getCasaByHashMobileAtivo(hashMobile);
			
			ControllerMobile controller = (ControllerMobile) handler;
			
			controller.setCasa(casa);
			controller.setHashMobile(hashMobile);
			
		}catch (EntityNotFoundException e) {
			
			response.sendRedirect("/domotica/index_mobile.jsp");
			
			return false;
		}
		
			
		return true;
	}

	

}
