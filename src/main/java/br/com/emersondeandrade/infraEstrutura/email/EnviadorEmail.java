package br.com.emersondeandrade.infraEstrutura.email;

import java.util.LinkedList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.KeyPropriedade;
import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSistemaService;


@Service
@Scope("singleton")
public class EnviadorEmail {

	private static Logger log = Logger.getLogger(EnviadorEmail.class);
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	LinkedList<SimpleMailMessage> listaEmails = new LinkedList<SimpleMailMessage>();
	
	ThreadEnviaEmail threadEmail = new ThreadEnviaEmail();
	
	@Autowired
	private PropriedadesSistemaService propsService;
			
	private static String host;
	private static String auth;
	private static String password;
	private static String userName;
	private static String protocoloEmail;
	private static String portEmail;
	private static String ttls;
	private static boolean enviarEmails;
	
	
	
	public EnviadorEmail() {
		threadEmail.setName("THREAD ENVIADOR EMAIL");
	}
	
	
	
	/**
	 * Thread para enviar emais de modo assincrono
	 * @author Emerson
	 *
	 */
	private class ThreadEnviaEmail extends Thread{
		
		public  void run(){
			while(true){
				
				synchronized(listaEmails){
						
					if(!listaEmails.isEmpty()){
						
						atualizaMailSender();
						atualizaAtributos();
												
						if(enviarEmails){
							mailSender.send(listaEmails.removeFirst());
						} else {
							listaEmails.removeFirst();
							log.info("Email não enviado propiedade ENVIAR_EMAILS = false");
						}
						
					} else {
					
						try {
							listaEmails.wait();
						} catch (InterruptedException e) {
							log.error(e.getMessage());  
							e.printStackTrace();
						}
						
					}
				}
			
			}
				
		}
		
	}
		
	
	private void atualizaMailSender() {
		
		host = propsService.getValue(KeyPropriedade.EMAIL_HOST); 
		
		userName = propsService.getValue(KeyPropriedade.EMAIL_USENAME);
		
		password = propsService.getValue(KeyPropriedade.EMAIL_PASSWORD);
					
		protocoloEmail = propsService.getValue(KeyPropriedade.EMAIL_PROTOCOLO);
				
		portEmail = propsService.getValue(KeyPropriedade.EMAIL_PORTA);
			
		auth = propsService.getValue(KeyPropriedade.EMAIL_AUTH);
				
		ttls = propsService.getValue(KeyPropriedade.EMAIL_TTLS);
			
		Properties p = new Properties();
		p.put("mail.smtps.auth", Boolean.parseBoolean(auth));
		p.put("mail.smtps.starttls.enable", Boolean.parseBoolean(ttls));
		
		mailSender.setJavaMailProperties(p);
		mailSender.setPort(Integer.parseInt(portEmail));
		mailSender.setProtocol(protocoloEmail);
		mailSender.setPassword(password);
		mailSender.setUsername(userName);
		mailSender.setHost(host);
		
		
		
	}
	
	
	public void atualizaAtributos() {
		boolean enviarEmailAtualizado =  Boolean.parseBoolean(propsService.getValue(KeyPropriedade.ENVIAR_EMAILS));
		enviarEmails = enviarEmailAtualizado != enviarEmails ? enviarEmailAtualizado : enviarEmails;
		
	}


	public void addEmailFilaParaEnvio(SimpleMailMessage email){
		if(!threadEmail.isAlive()){
			threadEmail.start();
		}
			
		listaEmails.add(email);
		synchronized(listaEmails){
			listaEmails.notifyAll();
		}
		
		
	}

	

	
	
	
	
	
	
	
	
	
	
	
}
