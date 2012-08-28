package br.com.emersondeandrade.aplicacao.web.binders;

import java.beans.PropertyEditorSupport;

import br.com.emersondeandrade.modelo.core.dispositivo.TipoComando;

public class TipoComandoBinder extends PropertyEditorSupport {

	
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		setValue( TipoComando.getById(Integer.parseInt(text)));
		
		
	}
	
	
	
	
	
}
