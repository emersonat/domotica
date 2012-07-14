package br.com.emersondeandrade.modelo.core.dispositivo;




/**
 * Enum representa os comandos possiveis de serem enviados para as portas do arduino
 * @author eteixeira
 *
 */
public enum TipoComando {
	
	LIGAR_DESLIGAR(1,"comando.ligarDesligar"), 
	MANTER_LIGADO(2,"comando.manterLigado"),
	MANTER_DESLIGADO(3,"comando.manterDesligado");
	
	private int id;
	private String i18n;
	
	private TipoComando(int id,String i18n) {
		this.id = id;
		this.i18n = i18n;
	}
	
	public String getI18n() {
		return i18n;
	}

	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

	public int getId(){
		return this.id;
	}
	
	
	
	

}
