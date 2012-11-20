package br.com.emersondeandrade.aplicacao.web.controllers;

import java.util.Collections;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;


@Controller
@Scope("request")
@RequestMapping(value = "/web/dispositivo")
public class ListagemDispositivosController extends ControllerWeb {
	
	
		
	@RequestMapping(value = "/listar")
	public String open(ModelMap mv){
				
		mv.addAttribute("dispositivos",  getCasa().getDispositivos() );   
				
		return "web/listagens/dispositivos";
		
	}
	
	@RequestMapping(value = "/sort")
	public String sort(ModelMap mv,HttpServletRequest request){
		Casa casa = getCasa();
				
		String sortAttribute = getSortAtributeDisplayTag("dispositivos");
		
		
		casa.ordenaDispositivos( getComparator(sortAttribute) );
		
		
		if(isOrderDisplayTagReverse("dispositivos"))
			Collections.reverse(casa.getDispositivos()); 		
		
			
		mv.addAttribute("dispositivos", casa.getDispositivos() );   
		
	
		return "web/listagens/dispositivos";
		
	}
	
	
	
	private Comparator<Dispositivo> getComparator( String sortAtribute){
				
		if("numeroPorta".equals(sortAtribute)){
			
			return new Comparator<Dispositivo>() {
				public int compare(Dispositivo d1, Dispositivo d2) {
					return d1.getNumeroPorta().compareTo(d2.getNumeroPorta());
				}
								
			};
		} else if("nome".equals(sortAtribute)){
			return new Comparator<Dispositivo>() {		
				
				public int compare(Dispositivo d1, Dispositivo d2) {
					return d1.getNome().compareTo(d2.getNome());
				}
				
				
			};
		}
		
						
		throw new IllegalArgumentException("Atributos esperados : numeroPorta ou nome ");
		
		
	}
	

}
