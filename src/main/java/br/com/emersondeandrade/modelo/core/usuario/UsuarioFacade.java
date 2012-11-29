package br.com.emersondeandrade.modelo.core.usuario;



public interface UsuarioFacade {
	
	
	public Usuario loadbyEmailSenha(String email,String senha);
	
	public Usuario loadById(int id);
		
	

}
