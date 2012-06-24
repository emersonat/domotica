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

import org.codehaus.jackson.annotate.JsonBackReference;

import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.eventos.TiposEvento;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
public class Dispositivo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "dispositivo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_dispositivo", unique = true, nullable = false)	
	private int id;
	
	@Column(length =2, nullable = false)
	private String numeroPorta;
	
	@ManyToOne
	@JoinColumn(name = "id_casa",nullable = false)
	private Casa casa; 	
	
	@Enumerated(EnumType.ORDINAL)
	private TipoComando tipoComando;
	
	@Column(length = 50,nullable = false)
	private String nome;
	
	@Column(length = 32,nullable = false)
	private String key;
	
	
	@ElementCollection(targetClass=TiposEvento.class)
	@CollectionTable(name="TIPOS_EVENTOS")
	private List<TiposEvento> tiposEventos;
	
	@Column(nullable = false)
	private boolean ativo = true;
	
	

		
	

	public void acionar() throws NotConectedExeption, ExecultarComandoExeption {
		
		switch (getTipoComando()) {
	
		case LIGAR_DESLIGAR:
			
			getCasa().getArduino().ligarDesligarPorta(getNumeroPorta()); 
			
			System.out.println("Acionando dispositivo....: " +  getNome()  +" (LIGA E DESLIGA) ");
			break;
			
		
		}
		
	}
	
	
	








	
	public String getNumeroPorta() {
		return numeroPorta;
	}


	public void setNumeroPorta(String numeroPorta) {
		this.numeroPorta = numeroPorta;
	}



	public TipoComando getTipoComando() {
		return tipoComando;
	}


	public void setTipoComando(TipoComando tipoComando) {
		this.tipoComando = tipoComando;
	}

	
	@JsonBackReference("dispositivo")
	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
		
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getKey() {
		return key;
	}





	public void setKey(String key) {
		this.key = key;
	}





	public List<TiposEvento> getTiposEventos() {
		return tiposEventos;
	}





	public void setTiposEventos(List<TiposEvento> tiposEventos) {
		this.tiposEventos = tiposEventos;
	}












	public boolean isAtivo() {
		return ativo;
	}












	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


		
		
	
	
	
	
	
	
}
