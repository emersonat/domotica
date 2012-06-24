package br.com.emersondeandrade.modelo.core.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;


@Component
public class ProcessadorEventos {
	
	
	@Autowired
	@Qualifier("eventoEnviarEmailService")
	Evento eventoEmail;
	
		
	
	public void processar(Dispositivo dispositivo){
				
		for(TiposEvento tipoEvento : dispositivo.getTiposEventos() ){
			getEventoByTipo(tipoEvento).execultar(dispositivo);
		}
		
		
	}
	
	
	
	
	private Evento getEventoByTipo(TiposEvento tipoEvento){
		
		if (tipoEvento.equals(TiposEvento.ENVIAR_EMAIL)){
			return eventoEmail;
		}
				
		return null;
		
	}
	

}
