package br.com.emersondeandrade.aplicacao.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
			
		Usuario userLogged = getUsuarioLogado();
		
		if( userLogged.getCasas()!= null && ! userLogged.getCasas().isEmpty()){
			session().setAttribute("casa",   userLogged.getCasas().get(0));
			
			//TODO colocar as casas na session
		}
				
		log.info("Usuario: " + userLogged.getUsername()  + " logando..." );
						
		return "redirect:/web/principal/open.html";
		
		
		
		
		
		
	}
	
	
	

	
	
	
	

}
