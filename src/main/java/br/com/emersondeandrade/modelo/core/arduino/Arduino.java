package br.com.emersondeandrade.modelo.core.arduino;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.dispositivo.TipoComando;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"key"}))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "modelo", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "")
public abstract class Arduino implements Serializable {
		
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "arduino_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_arduino", unique = true, nullable = false)
	private int id;
	
	@Column(length= 20,nullable = false)
	private String ip;
	
	
	@Column(length = 2, nullable = false )
	private String porta;
	
	
	@Column(length = 32,nullable = false)
	private String key;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="modelo",	insertable = false, updatable = false)
	private ModeloArduino modelo;
	
	@OneToOne(mappedBy = "casa")
	private Casa casa;
	
	
	@Column(nullable = false)
	private String portas;
	
	@Transient
	private List<Integer> listaPortas = new ArrayList<Integer>();
	
	
	
	

	/**
	 * codigo da operacao do arduino
	 * 01 = liga e desliga porta
	 * 
	 */
	@Transient
	public static final String PARAM_OPERACAO = "op";
	
	/**
	 * Porta que sera acionada
	 * Exemplo: 06 ou 13
	 */
	@Transient
	public static final String PARAM_PORTA = "port";
	
	/**
	 * chave do arduino
	 */
	@Transient
	public static final String PARAM_KEY = "key";
	
	
	/**
	 * valor para parametro de operação
	 */
	@Transient	
	public static final String PARAM_VALUE_OP_LIGA_DESLIGA = "01";
		
			
	
	
	
	
	public abstract void  ligarDesligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption;

	
	
	public  List<Integer> getPortasDisponiveis(){
		for(Dispositivo d :getCasa().getDispositivos() ){
			if( d.isAtivo()  ){
				
			}
		}
	}
	
	
	
	
	public List<Integer> getPortas() {
		if(listaPortas.isEmpty()){
			String[] split = portas.split(";");
			for(String s : split){
				listaPortas.add(Integer.parseInt(s)  );
			}
		}
		return listaPortas;
	
	}
	
	
		
	
	
	public List<TipoComando> getComandosPossiveis(int porta) {
	    List<TipoComando> list = new ArrayList<TipoComando>();
		if(porta == 6 || porta == 13){
			list.add(TipoComando.LIGAR_DESLIGAR);
			list.add(TipoComando.MANTER_DESLIGADO);
			list.add(TipoComando.MANTER_LIGADO);
		}
		
		return list;
	}
	
	
	
	
	
	
	

	public int getId() {
		
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getPorta() {
		return porta;
	}



	public void setPorta(String porta) {
		this.porta = porta;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}

	

	public ModeloArduino getModelo() {
		return modelo;
	}


	public void setModelo(ModeloArduino modelo) {
		this.modelo = modelo;
	}
	
	public Casa getCasa() {
		return casa;
	}



	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	
	








	




		
	
	
	
	
	
	
		
	
	
	

	




	






	
	
	
	
	
	

}
