package br.com.emersondeandrade.modelo.repositorio;

import br.com.emersondeandrade.modelo.core.usuario.Usuario;

public interface UsuarioRepositorio extends RepositorioPadrao<Usuario> {
	
	
	public Usuario loadbyEmailSenha(String email, String senha);
	

}
