package br.com.emersondeandrade.infraEstrutura.propriedadesSistema;


/**
 *
 * Deve-se implementar essa interface para criar propriedades de seguranca especifica
 * @author emerson
 *
 */
public interface PropriedadesSeguranca {
	
		
	/**
	 * Nome do cookie que o sistema gravara 
	 * @return
	 */
	public String  getCookieName();
	
	/**
	 * SALT usado nos metodos de criptografia e descriptografia
	 * @return
	 */
	public String getSaltCriptografia();

	
	/**
	 * SALT usado nos metodos de criptografia com MD5
	 * @return
	 */
	public String getSaltMD5();
	

}
