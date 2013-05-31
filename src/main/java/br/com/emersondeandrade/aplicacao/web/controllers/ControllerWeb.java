package br.com.emersondeandrade.aplicacao.web.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.emersondeandrade.aplicacao.web.binders.TipoComandoBinder;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.casa.CasaFacade;
import br.com.emersondeandrade.modelo.core.dispositivo.TipoComando;
import br.com.emersondeandrade.modelo.core.usuario.Usuario;

public abstract class ControllerWeb {
	
	@Autowired
	CasaFacade casaFacade;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(TipoComando.class, new TipoComandoBinder() );
		
	}
	
	
	protected HttpSession session() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true); 
	}
	
	
	protected  HttpServletRequest request() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest();
	}
	
	
	protected String getSortAtributeDisplayTag(String idTable){
				
		String sortParameterName = (new ParamEncoder(idTable).encodeParameterName(TableTagParameters.PARAMETER_SORT));
		String sortAttribute = request().getParameter(sortParameterName);
				
		return sortAttribute;
	}
	
	protected boolean  isOrderDisplayTagReverse(String idTable){
		
		String order = (new ParamEncoder(idTable).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
		return "1".equals(request().getParameter(order));
			
	}
	
	protected Usuario getUsuarioLogado() {
	
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		
				
		return (Usuario) usuarioLogado;
		
	}
	
	
	
	protected Casa getCasa(){
		Casa casa = (Casa) session().getAttribute("casa");
		
		return casaFacade.getCasaById(casa.getId());
	}
	
	protected boolean hasErrors(BindingResult result, String... fields ){
		
		for(String f: fields){
			if(result.hasFieldErrors(f)){
				return true;
			}
		}
		
		return false;
		
	}

}
