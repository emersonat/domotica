package br.com.emersondeandrade.modelo.core.historico;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;

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
	
	@OneToOne
	@JoinColumn(name = "id_dispositivo", nullable = false)	
	private Dispositivo dispositivo;
	
	
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


	public Dispositivo getDispositivo() {
		return dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}


	
	
	
	
	
}
