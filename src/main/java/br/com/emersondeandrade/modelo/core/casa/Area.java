package br.com.emersondeandrade.modelo.core.casa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;

@Entity
public class Area {
	
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "area_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_area", unique = true, nullable = false)
	private	 int id;
	
	
	@Column(length = 30,nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_casa", nullable = false)
	private Casa casa;
	
	@OneToMany(mappedBy="area", fetch = FetchType.LAZY)
	private List<Dispositivo> dispositivos;
		
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	
	
	
	

}
