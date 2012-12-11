package br.com.emersondeandrade.modelo.core.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.exeption.ExisteEntidadeExeption;
import br.com.emersondeandrade.modelo.repositorio.RegistroMobileRepositorio;


@Service
public class MobileFacadeImp implements MobileFacade {
	
	@Autowired
	Criptografia criptService;
	
	@Autowired
	RegistroMobileRepositorio registroMobileRepositorio;
	
	@Autowired
	RegistroMobileFactory factoryRegistroMobile;
	
		

	public RegistroMobile registrarMobile(String userAgent, String nome, Casa casa) throws ExisteEntidadeExeption {
				
		RegistroMobile registroMobile = null;
		if(registroMobileRepositorio.existe(nome,casa)){
			throw new ExisteEntidadeExeption();
		} else {
			registroMobile = factoryRegistroMobile.create(userAgent, nome, casa);
		}
		
		registroMobileRepositorio.salvar(registroMobile);
				
		return registroMobile;
	}
	
	public void desconectarMobile(String hash){
		registroMobileRepositorio.deletar(hash);
	}
	
	public void desconectarMobile(int id){
		RegistroMobile mobile = registroMobileRepositorio.getById(id);
		registroMobileRepositorio.delete(mobile);
	}

	public void desativarMobile(int id) {
		RegistroMobile mobile = registroMobileRepositorio.getById(id);
		mobile.setAtivo(false);
		registroMobileRepositorio.salvar(mobile);
	}

	public void ativarMobile(int id) {
		RegistroMobile mobile = registroMobileRepositorio.getById(id);
		mobile.setAtivo(true);
		registroMobileRepositorio.salvar(mobile);
		
	}
	
	public RegistroMobile getByHash(String hash)  {
		return registroMobileRepositorio.getByHash(hash);
		
	}
	

}
