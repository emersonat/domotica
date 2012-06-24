package br.com.emersondeandrade.infraEstrutura.email;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSistemaService;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;

@Service
public class EmailFactory {

	@Autowired
	PropriedadesSistemaService props;
	
	public SimpleMailMessage geraEmailAcionamentoDispositivo(String emailTo,Dispositivo dispositivo){
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(emailTo);
		email.setSubject(dispositivo.getNome() + " acionado!!");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		email.setText(
		"\n" +		
		"* Sistema Domotica * \n" + 
		dispositivo.getNome() + " acionado as: " + df.format(new Date()));
		
		return email;
	}
	
	
	
}
