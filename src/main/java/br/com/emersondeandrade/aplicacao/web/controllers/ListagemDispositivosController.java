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
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.dispositivo.DispositivoFacade;


@Controller
@Scope("request")
@RequestMapping(value = "/web/dispositivo")
public class ListagemDispositivosController extends ControllerWeb {
	
	@Autowired
	Criptografia cript;
	
	@Autowired
	DispositivoFacade dispositivoFacade;
	
		
	@RequestMapping(value = "/listar")
	public String open(ModelMap mv){
				
		
		
		mv.addAttribute("dispositivos", getCasa().getArduinoPrincipal().getDispositivos()   );   
				
		return "web/listagens/dispositivos";
		
	}
	
	
	@RequestMapping(value = "/desativar/{idCript}")
	public String desativar(@PathVariable String idCript , ModelMap mv){
		
		int id = cript.decriptToInt(idCript);
		
		dispositivoFacade.desativarDispositivo(id);
						
		return  open(mv);
	}
	
	@RequestMapping(value = "/ativar/{idCript}")
	public String ativar(@PathVariable String idCript , ModelMap mv){
		
		int id = cript.decriptToInt(idCript);
		
		dispositivoFacade.ativarDispositivo(id);
						
		return  open(mv);
	}
	
	
	
	@RequestMapping(value = "/sort")
	public String sort(ModelMap mv,HttpServletRequest request){
		Casa casa = getCasa();
		
		List<Dispositivo> allDispositivos = casa.getAllDispositivos();
		
		String sortAttribute = getSortAtributeDisplayTag("dispositivos");
		
		Collections.sort(allDispositivos, getComparator(sortAttribute) );
		
		
		// TODO verificar ordenacao
		if(isOrderDisplayTagReverse("dispositivos"))
			Collections.reverse( allDispositivos   ); 		
		
			
		mv.addAttribute("dispositivos", allDispositivos );   
		
	
		return "web/listagens/dispositivos";
		
	}
	
	
	
	private Comparator<Dispositivo> getComparator( String sortAtribute){
				
		if("area".equals(sortAtribute)){
			
			return new Comparator<Dispositivo>() {
				public int compare(Dispositivo d1, Dispositivo d2) {
					return d1.getArea().getNome().compareTo(d2.getArea().getNome());
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
