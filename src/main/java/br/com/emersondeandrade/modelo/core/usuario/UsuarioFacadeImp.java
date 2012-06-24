package br.com.emersondeandrade.modelo.core.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.repositorio.UsuarioRepositorio;


@Service
public class UsuarioFacadeImp implements UsuarioFacade {

	
	@Autowired
	private UsuarioRepositorio repositorioUsuarios;
	
	@Autowired
	private Criptografia cript;
	
	
	public Usuario loadbyEmailSenha(String email, String senha) {
		
		return repositorioUsuarios.loadbyEmailSenha(email, cript.encodeMD5(senha));
	}

	
	
	
}
