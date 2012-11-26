package br.com.emersondeandrade.modelo.repositorio;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.emersondeandrade.modelo.core.usuario.Usuario;

public interface UsuarioRepositorio extends RepositorioPadrao<Usuario>,UserDetailsService {
	
	
	public Usuario loadbyEmailSenha(String email, String senha);
	

}
