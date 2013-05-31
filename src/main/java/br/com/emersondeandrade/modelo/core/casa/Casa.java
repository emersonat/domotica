package br.com.emersondeandrade.modelo.core.casa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
import javax.persistence.SequenceGenerator;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.core.historico.Historico;
import br.com.emersondeandrade.modelo.core.mobile.RegistroMobile;
import br.com.emersondeandrade.modelo.core.usuario.Usuario;

@Entity
public class Casa implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
			

	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "casa_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_casa", unique = true, nullable = false)
	private	 int id;
	
	
		
	@OneToMany(mappedBy="casa",fetch = FetchType.LAZY)
	private List<Arduino> arduinos;
	
	
	@OneToMany(mappedBy="casa",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RegistroMobile> registrosMobile;
	
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable = false)
	private Usuario usuario;
	
	@Column(nullable = false,length = 30)
	private String nome;
	
	@OneToMany(mappedBy = "casa", fetch = FetchType.LAZY)
	private List<Area> areas;
		
	
	@OneToMany(mappedBy="casa",fetch = FetchType.LAZY)
	private List<Historico> historicos;

	

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
	

	public List<Arduino> getArduinos() {
		return arduinos;
	}

	public void setArduino(List<Arduino> arduinos) {
		this.arduinos = arduinos;
	}
	
	public Arduino getArduinoPrincipal(){
		for (Arduino arduino : getArduinos()){
			if(arduino.isPrincipal() ) return arduino;
		}
		
		throw new RuntimeException("Casa " + getNome() + " não possui um arduino principal..");
	}
	
	public List<Dispositivo> getDispositivosAtivos(){
				
		Set<Dispositivo> result = new TreeSet<Dispositivo>();
		
		for(Dispositivo d : getAllDispositivos()){
			if(d.isAtivo()) result.add(d);
		}
		
		return new ArrayList<Dispositivo>(result);
	}
	
	public List<Dispositivo> getAllDispositivos(){
		
		Set<Dispositivo> result = new TreeSet<Dispositivo>();
		for(Arduino a: getArduinos()){
			
			result.addAll(a.getDispositivos());
			
		}
		
		return new ArrayList<Dispositivo>(result);  
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	
	
	
	

}
