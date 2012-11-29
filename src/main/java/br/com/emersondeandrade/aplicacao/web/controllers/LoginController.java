package br.com.emersondeandrade.aplicacao.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.usuario.Usuario;
import br.com.emersondeandrade.modelo.core.usuario.UsuarioFacade;


@Controller
@Scope("request")
@RequestMapping(value = "/web")
public class LoginController extends ControllerWeb {
	
	private static Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	@Qualifier("jsonview")
	View view;
	
	
	@Autowired
	UsuarioFacade usuarioFacade;
	
	
	@RequestMapping(value = "/login")
	public String  login(){
			
		Usuario userLogged = usuarioFacade.loadById( getUsuarioLogado().getId() );
		
		
		
		if( userLogged.getCasas() != null && !userLogged.getCasas().isEmpty()){
			session().setAttribute("casa",   userLogged.getCasas().get(0));
									
			session().setAttribute("casas",  userLogged.getCasas() );
			
		}
				
		log.info("Usuario: " + userLogged.getUsername()  + " logando..." );
						
		return "redirect:/web/principal/open.html";
		
		
		
		
		
		
	}
	
	
	

	
	
	
	

}
