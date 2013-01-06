package br.com.emersondeandrade.modelo.core.dispositivo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.eventos.TiposEvento;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
public class Dispositivo implements Serializable, Comparable<Dispositivo> {

	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(Dispositivo.class);
	
	
	private int id;
	
	
	@NotEmpty(message = "*")
	@Size(max=2,min=1,message = "*")
	private String numeroPorta;
	
	
	@NotNull(message = "*")
	private Casa casa; 	
	
	
	@NotNull(message = "*")
	private TipoComando tipoComando;
	
	
	@NotNull(message = "*")
	@NotEmpty(message = "*")
	@Size(max=50 , message = "*")
	private String nome;
	
	
	@NotNull(message = "*")
	@NotEmpty(message = "*")
	@Size(max=150 , message = "*")
	private String imagenOn;
		
	
	@NotNull(message = "*")
	@NotEmpty(message = "*")
	@Size(max=150 , message = "*")
	private String imagenOff;
	
	
	@Column(name="imagen_on",length = 150,nullable = false)
	public String getImagenOn() {
		return imagenOn;
	}


	public void setImagenOn(String imagenON) {
		this.imagenOn = imagenON;
	}

	
	@Column(name="imagen_off", length = 150,nullable = false)
	public String getImagenOff() {
		return imagenOff;
	}


	public void setImagenOff(String imagenOFF) {
		this.imagenOff = imagenOFF;
	}











	private String key;
	
	

	private List<TiposEvento> tiposEventos;
		
	private boolean ativo = true;
	
	private int duracaoClique;

		
	

	public void acionar() throws NotConectedExeption, ExecultarComandoExeption {
		Arduino arduino = getCasa().getArduino();
		
		switch (getTipoComando()) {
	
		case CLICK:
			
			arduino.click(getNumeroPorta(),getDuracaoClique()); 
			
			log.info("Acionando dispositivo....: " +  getNome()  +" (CLICK) ");
			
			break;
			
			
		case LIGAR_DESLIGAR:
			
			if(arduino.isLigada(getNumeroPorta())){
				arduino.desligarPorta(getNumeroPorta());
				log.info("Desligando....: " +  getNome()  +" (LIGAR_DESLIGAR) ");
			} else {
				arduino.ligarPorta(getNumeroPorta());
				log.info("Ligando....: " +  getNome()  +" (LIGAR_DESLIGAR) ");
			}
			
			
			break;	
			
			
			
		}	
	
	}
	
	
	@Transient
	public boolean isLigado() throws NotConectedExeption, ExecultarComandoExeption {
		return getCasa().getArduino().isLigada(getNumeroPorta());
	}

	


	@Column(length =2, nullable = false)
	public String getNumeroPorta() {
		return numeroPorta;
	}


	public void setNumeroPorta(String numeroPorta) {
		this.numeroPorta = numeroPorta;
	}


	@Enumerated(EnumType.ORDINAL)
	public TipoComando getTipoComando() {
		return tipoComando;
	}


	public void setTipoComando(TipoComando tipoComando) {
		this.tipoComando = tipoComando;
	}

	
	//@JsonBackReference("dispositivo")
	@ManyToOne
	@JoinColumn(name = "id_casa",nullable = false)
	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Column(length = 50,nullable = false)
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
		
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "dispositivo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_dispositivo", unique = true, nullable = false)	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 32,nullable = false)
	public String getKey() {
		return key;
	}





	public void setKey(String key) {
		this.key = key;
	}




	@ElementCollection(targetClass=TiposEvento.class)
	@CollectionTable(name="TIPOS_EVENTOS")
	public List<TiposEvento> getTiposEventos() {
		return tiposEventos;
	}





	public void setTiposEventos(List<TiposEvento> tiposEventos) {
		this.tiposEventos = tiposEventos;
	}











	@Column(nullable = false)
	public boolean isAtivo() {
		return ativo;
	}












	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}










	@Column(nullable = true)
	public int getDuracaoClique() {
		return duracaoClique;
	}











	public void setDuracaoClique(int duracaoClique) {
		this.duracaoClique = duracaoClique;
	}











	public int compareTo(Dispositivo o) {
		return this.getNome().compareTo(o.getNome()) ;
	}


		
		
	
	
	
	
	
	
}
