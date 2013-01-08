package br.com.emersondeandrade.modelo.core.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.email.EmailFactory;
import br.com.emersondeandrade.infraEstrutura.email.EnviadorEmail;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;



@Service
public class EventoEnviarEmailService implements Evento {


	
	@Autowired
	EnviadorEmail enviadorEmail;
	
	@Autowired
	EmailFactory emailFactory;
	
	public void execultar(Dispositivo dispositivo) {
		
		String emailTo = dispositivo.getCasa().getUsuario().getEmail();
		
		SimpleMailMessage email = emailFactory.geraEmailAcionamentoDispositivo(emailTo, dispositivo);
			
		enviadorEmail.addEmailFilaParaEnvio(email);
		

	}

}
