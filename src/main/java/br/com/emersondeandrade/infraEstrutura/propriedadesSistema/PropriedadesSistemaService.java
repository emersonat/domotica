package br.com.emersondeandrade.infraEstrutura.propriedadesSistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.infraEstrutura.dao.PropriedadesSistemaDao;
import br.com.emersondeandrade.modelo.repositorio.PropriedadeSistemaRepositorio;


@Service
public class PropriedadesSistemaService {
	
		
	
	@Autowired
	PropriedadeSistemaRepositorio propsDao;
	
	@Autowired
	Criptografia criptografia;
	
	public List<PropriedadeSistema> listAll(){
		return propsDao.listAll();
	}
	
	
	
	
	public String getValue(KeyPropriedade key){
		PropriedadeSistema prop = propsDao.getByKey( key.toString() );
		
		if(prop != null){
			
			if(prop.isCript()){
				return criptografia.decript(prop.getValue());
			} else { 
				return prop.getValue();
			}
			
			
		} else {
			return "";
		}
		
		
		
	}
	

}
