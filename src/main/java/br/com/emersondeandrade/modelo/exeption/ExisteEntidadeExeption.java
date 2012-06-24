package br.com.emersondeandrade.modelo.exeption;

public class ExisteEntidadeExeption extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExisteEntidadeExeption(String msg) {
		super(msg);
	}
	
	public ExisteEntidadeExeption() {
		
	}

}
