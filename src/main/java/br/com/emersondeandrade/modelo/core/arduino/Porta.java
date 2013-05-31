package br.com.emersondeandrade.modelo.core.arduino;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;


@Entity
public class Porta {
	
	
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "porta_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_porta", unique = true, nullable = false)
	private int id;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Operacao operacao;
	
	@Column(nullable=false)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="id_dispositivo",nullable = true)
	private Dispositivo dispositivo;
	
	@ManyToOne
	@JoinColumn(name="arduino",nullable = false)
	private Arduino arduino;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Operacao getOperacao() {
		return operacao;
	}
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	public Arduino getArduino() {
		return arduino;
	}
	public void setArduino(Arduino arduino) {
		this.arduino = arduino;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}	
	
	

}
