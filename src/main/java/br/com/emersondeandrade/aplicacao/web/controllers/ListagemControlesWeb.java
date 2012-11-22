package br.com.emersondeandrade.aplicacao.web.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.mobile.MobileFacade;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;



@Controller
@Scope("request")
@RequestMapping(value = "/web/controleweb")
public class ListagemControlesWeb extends ControllerWeb {

	@Autowired
	Criptografia cript;
	
	@Autowired
	MobileFacade mobileFacade;
	
	
	@RequestMapping(value = "/listar")
	public String open(ModelMap mv){
		
		List<RegistroMobile> registrosMobile = getCasa().getRegistrosMobile();
		
		Collections.sort(registrosMobile);
		
		mv.addAttribute("controles", registrosMobile );   
		
		
		return "web/listagens/controlesweb";
		
	}
	
	@RequestMapping(value = "/deletar/{idCript}")
	public String deletar(@PathVariable String idCript , ModelMap mv){
		
		int id = cript.decriptToInt(idCript);
		
		mobileFacade.desconectarMobile(id);
		
		return  open(mv);
	}
	
	
	@RequestMapping(value = "/sort")
	public String sort(ModelMap mv,HttpServletRequest request){
		Casa casa = getCasa();
				
		String sortAttribute = getSortAtributeDisplayTag("controles");
				
		casa.ordenaRegistrosMobile( getComparator(sortAttribute) );
				
		if(isOrderDisplayTagReverse("controles"))
			Collections.reverse(casa.getRegistrosMobile()); 		
					
		mv.addAttribute("controles", casa.getRegistrosMobile() );   
			
		return "web/listagens/controlesweb";
		
	}
	
	
	
	
	
	
	
	
	
	
	private Comparator<RegistroMobile> getComparator(String sortAtribute){
		
		if("data".equals(sortAtribute)){
			
			return new Comparator<RegistroMobile>() {
				public int compare(RegistroMobile r1, RegistroMobile r2) {
					return r1.getData().compareTo(r2.getData());
				}
								
			};
		} else if("nome".equals(sortAtribute)){
			return new Comparator<RegistroMobile>() {		
				
				public int compare(RegistroMobile r1, RegistroMobile r2) {
					return r1.getNome().compareTo(r2.getNome());
				}
				
				
			};
		}
		
						
		throw new IllegalArgumentException("Atributos esperados : data ou nome ");
		
		
	}
	
	
	
	
}
