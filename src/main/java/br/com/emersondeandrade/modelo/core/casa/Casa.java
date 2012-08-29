package br.com.emersondeandrade.modelo.core.casa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;
import br.com.emersondeandrade.modelo.core.usuario.Usuario;

@Entity
public class Casa implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy="casa",fetch = FetchType.LAZY)
	private List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
	
	
	

	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "casa_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_casa", unique = true, nullable = false)
	private	 int id;
	
	
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_arduino",nullable = false)
	private Arduino arduino;
	
	
	@OneToMany(mappedBy="casa",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RegistroMobile> registrosMobile;
	
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable = false)
	private Usuario usuario;
	
	@Column(nullable = false,length = 30)
	private String nome;
		
	
	
	
	//@JsonManagedReference("dispositivo")
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}
	

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Arduino getArduino() {
		return arduino;
	}

	public void setArduino(Arduino arduino) {
		this.arduino = arduino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<RegistroMobile> getRegistrosMobile() {
		return registrosMobile;
	}


	public void setRegistrosMobile(List<RegistroMobile> registrosMobile) {
		this.registrosMobile = registrosMobile;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public List<Dispositivo> getDispositivosAtivos(){
		List<Dispositivo> result = new ArrayList<Dispositivo>();
		
		for(Dispositivo d : getDispositivos()){
			if(d.isAtivo())
				result.add(d);
		}
		
		return result;
		
		
		
	}
	

}
