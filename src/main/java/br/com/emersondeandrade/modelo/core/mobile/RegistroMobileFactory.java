package br.com.emersondeandrade.modelo.core.mobile;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.repositorio.RegistroMobileRepositorio;

@Service
public class RegistroMobileFactory {
	
	@Autowired
	RegistroMobileRepositorio registroMobileRepositorio;
	
	@Autowired
	Criptografia criptService;
	
	
	
	
		
	
	public RegistroMobile create(String userAgent, String nome, Casa casa){
		
		RegistroMobile registroMobile = new RegistroMobile();
		registroMobile.setAtivo(true);
		registroMobile.setCasa(casa);
		registroMobile.setData(new Date());
		registroMobile.setNome(nome);
		registroMobile.setUserAgent(userAgent);
				
		String hashMobile = null;
		do{
			hashMobile = geraHash(registroMobile);
		}while(registroMobileRepositorio.existe( criptService.encodeMD5(hashMobile)));
		
		registroMobile.setHash(hashMobile);
		
		return registroMobile;
			
	}
	
	
	
	
	
	private String geraHash(RegistroMobile registroMobile){
			
		String str = "" + new Date().getTime(); 
						
		return criptService.cript(str);
		
		
		
	}
	
	
	
	

}
