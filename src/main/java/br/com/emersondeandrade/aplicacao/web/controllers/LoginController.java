package br.com.emersondeandrade.aplicacao.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView  login(@RequestParam String login, @RequestParam String pass){
		
		Usuario usuario = usuarioFacade.loadbyEmailSenha(login, pass);
			
		ModelAndView modelAndView = new ModelAndView(this.view);
		if(usuario != null){
			modelAndView.addObject("valid", true);
			modelAndView.addObject("redirect", "web/principal/open.html"); 
			session().setAttribute("user", usuario);
			session().setAttribute("casa", usuario.getCasas().get(0));
			log.info("Usuario: " + login + " logando..." );
		} else {
			log.info("Login invalido..: " + login);
			modelAndView.addObject("valid", false);
		}
		
				
		return modelAndView;
		
		
		
		
		
		
	}
	
	
	

	
	
	
	

}
