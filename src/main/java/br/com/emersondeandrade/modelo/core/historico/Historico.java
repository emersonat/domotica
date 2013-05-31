package br.com.emersondeandrade.modelo.core.historico;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.emersondeandrade.modelo.core.casa.Casa;

@Entity
public class Historico {
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "historico_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_historico", unique = true, nullable = false)
	private int id;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false,length = 50)
	private String nomeDispositivo;
	
	@Column(nullable = false,length = 50)
	private String nomeArea;
	
	
	@ManyToOne
	@JoinColumn(name = "id_casa",nullable = false)
	private Casa casa;
	
	public Historico() {}
	
	
	
	
	
	public Historico(String nomeDispositivo, String nomeArea, Casa casa) {
		this.nomeDispositivo = nomeDispositivo;
		this.nomeArea = nomeArea;
		this.casa = casa;
		this.data = new Date();
	}





	public String getNomeDispositivo() {
		return nomeDispositivo;
	}


	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}


	public String getNomeArea() {
		return nomeArea;
	}


	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}


	public Casa getCasa() {
		return casa;
	}


	public void setCasa(Casa casa) {
		this.casa = casa;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	


	
	
	
	
	
}
