package br.com.emersondeandrade.modelo.core.mobile;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.com.emersondeandrade.modelo.core.casa.Casa;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome","id_casa"}))
public class RegistroMobile {
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "registro_mobile_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_registro_mobile", unique = true, nullable = false)	
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	private boolean ativo;
	
	@Column(length = 30,nullable = false)
	private String nome;
	
	
	@Column(nullable = false)
	private String userAgent;
	
	
	@Column(length = 32,nullable = false)
	private String hash;
	
	
	@ManyToOne
	@JoinColumn(name = "id_casa", nullable = false)
	private Casa casa;
	
	
		
	
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null){
			nome = nome.toUpperCase().trim();
		}
		
		this.nome = nome;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Casa getCasa() {
		return casa;
	}
	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
	
	
	
	
	

}
