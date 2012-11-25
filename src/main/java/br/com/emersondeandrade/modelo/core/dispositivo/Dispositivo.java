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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.eventos.TiposEvento;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
public class Dispositivo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(Dispositivo.class);
	
	
	private int id;
	
	
	@NotEmpty(message = "*")
	@Size(max=2,min=2,message = "*")
	private String numeroPorta;
	
	
	@NotNull(message = "*")
	private Casa casa; 	
	
	
	@NotNull(message = "*")
	private TipoComando tipoComando;
	
	
	@NotNull(message = "*")
	@NotEmpty(message = "*")
	@Size(max=50 , message = "*")
	private String nome;
	
	
	private String key;
	
	

	private List<TiposEvento> tiposEventos;
	
	
	
	private boolean ativo = true;
	
	private int duracaoClique;

		
	

	public void acionar() throws NotConectedExeption, ExecultarComandoExeption {
		
		switch (getTipoComando()) {
	
		case CLICK:
			
			getCasa().getArduino().click(getNumeroPorta(),getDuracaoClique()); 
			
			log.info("Acionando dispositivo....: " +  getNome()  +" (CLICK) ");
			
			break;
					
		case MANTER_LIGADO:
			
			getCasa().getArduino().ligarPorta(getNumeroPorta()); 
			
			log.info("Acionando dispositivo....: " +  getNome()  +" (LIGA) ");
			
			break;
				
		case MANTER_DESLIGADO:
		
			getCasa().getArduino().desligarPorta(getNumeroPorta()); 
			
			log.info("Acionando dispositivo....: " +  getNome()  +" (DESLIGA) ");
			
			break;
			
			
		case LIGAR_DESLIGAR:
			
			// TODO implementar
			
			
			break;	
			
			
			
		}	
		
			
			
				
		
		
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


		
		
	
	
	
	
	
	
}
