package br.com.emersondeandrade.modelo.core.usuario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.emersondeandrade.modelo.core.casa.Casa;


@Entity
public class Usuario {
	
	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "usuario_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_usuario", unique = true, nullable = false)
	private int id;
	
	@Column(length = 100 ,nullable=false)
	private String email;
	
	
	@Column(length = 100,nullable = false)
	private String senha;
	
	@Column(length=50,nullable = false)
	private String nome;
	
	
	@OneToMany(mappedBy="usuario",fetch = FetchType.EAGER)
	private List<Casa> casas;
	
		
	
	public Casa getCasaDefault(){
		if(this.getCasas() != null && !this.getCasas().isEmpty() ){
			return this.getCasas().get(0);
		}
		return null;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
