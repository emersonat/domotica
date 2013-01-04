package br.com.emersondeandrade.modelo.core.arduino;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hibernate.validator.util.privilegedactions.GetMethod;

import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
@DiscriminatorValue(value = "1")
public class ArduinoWIZNET_W5100 extends Arduino {

		
	private static Logger log = Logger.getLogger(ArduinoWIZNET_W5100.class);
	
	
	private static final long serialVersionUID = 1L;
	
	

	public ArduinoWIZNET_W5100() {
		setModelo( ModeloArduino.WIZNET_W5100 );
			
	}
	
		
	
	public void click(String numeroPorta, int segundosDuracao) throws NotConectedExeption, ExecultarComandoExeption {
		Properties parametros = new Properties();
		
		parametros.setProperty("key", this.getKey() );
		parametros.setProperty(PARAM_OPERACAO, PARAM_VALUE_OP_CLICK);
		
		String duracao =  String.valueOf(segundosDuracao);
		duracao = duracao.length() == 1 ? "0".concat(duracao) : duracao;
		
		
		parametros.setProperty(PARAM_TEMPO_CLIQUE,duracao);
		
		parametros.setProperty(PARAM_PORTA, numeroPorta );
				
		requestHttp(parametros);
			
	}
		
	@Override
	public void ligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		Properties parametros = new Properties();
		
		parametros.setProperty("key", this.getKey() );
		
		parametros.setProperty(PARAM_OPERACAO, PARAM_VALUE_OP_LIGA);
		
		parametros.setProperty(PARAM_PORTA, numeroPorta );
				
		requestHttp(parametros);
		
	}


	

	@Override
	public void desligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		Properties parametros = new Properties();
		
		parametros.setProperty("key", this.getKey() );
		
		parametros.setProperty(PARAM_OPERACAO, PARAM_VALUE_OP_DESLIGA);
		
		parametros.setProperty(PARAM_PORTA, numeroPorta);
				
		requestHttp(parametros);
		
	}

		
	
	@SuppressWarnings("rawtypes")
	private String montaUrl(Properties parameters){
		
		String urlString = "http://" + this.getIp() + ":" + this.getPorta();
				
		Iterator i = parameters.keySet().iterator();  
				 
		int counter = 0;  
		  		 
		while (i.hasNext()) {  
		  
		    // pega o nome  
		    String name = (String) i.next();  
		    // pega o valor  
		    String value = parameters.getProperty(name);  
		  
		    // adiciona com um conector (? ou &)  
		    // o primeiro é ?, depois são &  
		    urlString += (++counter == 1 ? "?" : "&")  
		        + name  
		        + "="  
		        + value;  
		}
		
		log.info("Preparando URL do arduino: " + urlString);
		return urlString;
	}
	
	
	
	
	
	private  void requestHttp(Properties parameters) throws NotConectedExeption, ExecultarComandoExeption {
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String response = null;
		
		log.info("Fazendo request para Arduino.... Casa: " + this.getCasa().getNome() );
		long  inicio = new Date().getTime();	
						
		try {
			HttpGet httpget = new HttpGet(this.montaUrl(parameters));	
			HttpResponse httpResponse = httpclient.execute(httpget);
			HttpEntity entity = httpResponse.getEntity();
			response = EntityUtils.toString(entity);
		        
		    if(response.toString().contains("<error>")){
		       	throw new ExecultarComandoExeption(response.toString());
		    }
		   		        
			} catch (MalformedURLException e) {
				log.error( e.getMessage() );
				e.printStackTrace();
				throw new ExecultarComandoExeption();
				
			} catch (IOException e) {
				log.error( e.getMessage() );
				e.printStackTrace();
				throw new NotConectedExeption();
			}
			
			
			long termino = new Date().getTime(); 
			int seg  = (int) (termino - inicio) / 1000;
			
			log.info("Resposta do arduino.: " + response + " em " + seg + " segundos" );
			
			
			
	
		
		
	}



	@Override
	public boolean isConected() {
		Properties parametros = new Properties();
		
		parametros.setProperty("key", this.getKey() );
		parametros.setProperty(PARAM_OPERACAO, PARAM_VALUE_OP_TESTE_CONEXAO);
		parametros.setProperty(PARAM_PORTA, "99");
				
		try {
			requestHttp(parametros);
		} catch (NotConectedExeption e) {
			e.printStackTrace();
			return false;
		} catch (ExecultarComandoExeption e) {
			e.printStackTrace();
			return false;
		}
		
				
		return true;
	}



	@Override
	public Map<String, Boolean> getStatusPortas() {
		// TODO Auto-generated method stub
		return null;
	}







	



	

	



	



	



	
	
	
	
	
	
	

	

	
	
	
}
