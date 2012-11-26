package br.com.emersondeandrade.infraEstrutura.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.modelo.core.usuario.Usuario;
import br.com.emersondeandrade.modelo.repositorio.UsuarioRepositorio;


@Repository
public class UsuarioDao  extends DaoPadrao<Usuario> implements UsuarioRepositorio{

	
	public Usuario loadbyEmailSenha(String email, String senha) {
		
		TypedQuery<Usuario> query = entityManager.createQuery("from Usuario u where u.email = :email and u.senha = :senha", Usuario.class);
		
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		
		
		try{
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
		
	}

	public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
		
		TypedQuery<Usuario> query = entityManager.createQuery("from Usuario u where u.email = :email", Usuario.class);
		query.setParameter("email", emailUsuario);
		
		try{
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("USuario: " + emailUsuario +" não encontrado");
		}
		
		
	
	}

}
