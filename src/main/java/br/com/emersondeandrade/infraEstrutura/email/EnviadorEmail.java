package br.com.emersondeandrade.infraEstrutura.email;

import java.util.LinkedList;
import java.util.Properties;

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
							System.out.println("Email não enviado propiedade ENVIAR_EMAILS = false");
						}
						
					} else {
					
						try {
							listaEmails.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
			
			}
				
		}
		
	}
		
	
	private void atualizaMailSender() {
		String hostAtualizado = propsService.getValue(KeyPropriedade.EMAIL_HOST); 
		host = hostAtualizado.equals(host) ? host : hostAtualizado;
		
		String usernameAtualizado = propsService.getValue(KeyPropriedade.EMAIL_USENAME);
		userName = usernameAtualizado.equals(userName) ? userName : usernameAtualizado;
		
		String passwordAtualizado = propsService.getValue(KeyPropriedade.EMAIL_PASSWORD);
		password = passwordAtualizado.equals(password) ? password : passwordAtualizado;
		
		String protocoloAtualizado = propsService.getValue(KeyPropriedade.EMAIL_PROTOCOLO);
		protocoloEmail = protocoloAtualizado.equals(protocoloEmail) ? protocoloEmail : protocoloAtualizado;
		
		String portaEmailAtualizada = propsService.getValue(KeyPropriedade.EMAIL_PORTA);
		portEmail = portaEmailAtualizada.equals(portEmail) ? portEmail : portaEmailAtualizada;
		
		String authAtualizada = propsService.getValue(KeyPropriedade.EMAIL_AUTH);
		auth = authAtualizada.equals(auth) ? auth : authAtualizada;
		
		String ttlsAtualizada = propsService.getValue(KeyPropriedade.EMAIL_TTLS);
		ttls = ttlsAtualizada.equals(ttls) ? ttls : ttlsAtualizada;
		
		
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
