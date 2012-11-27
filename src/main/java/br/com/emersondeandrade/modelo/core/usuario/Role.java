package br.com.emersondeandrade.modelo.core.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements Serializable, GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "public.role_id_role_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_role", unique = true, nullable = false)
	private int id;
	
	@Column(nullable = false,length = 30)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable = false)
	private Usuario usuario;
	
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
	
	public String getAuthority() {
		return getNome();
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
