package br.com.emersondeandrade.aplicacao.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import br.com.emersondeandrade.modelo.core.usuario.Usuario;
import br.com.emersondeandrade.modelo.core.usuario.UsuarioFacade;


@Controller
@Scope("request")
@RequestMapping(value = "/web")
public class LoginController {
	
	

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
		} else {
			modelAndView.addObject("valid", false);
		}
		
		
		
		return modelAndView;
		
		
		
		
		
		
	}
	
	
	public static HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); 
	}

	
	
	
	

}
