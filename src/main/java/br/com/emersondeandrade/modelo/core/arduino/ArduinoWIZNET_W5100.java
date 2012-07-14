package br.com.emersondeandrade.modelo.core.arduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
@DiscriminatorValue(value = "1")
public class ArduinoWIZNET_W5100 extends Arduino {

		

	private static final long serialVersionUID = 1L;

	

	public ArduinoWIZNET_W5100() {
		setModelo( ModeloArduino.WIZNET_W5100 );
			
	}
	
		
	
	public void ligarDesligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		Properties parametros = new Properties();
		
		parametros.setProperty("key", this.getKey() );
		parametros.setProperty(PARAM_OPERACAO, PARAM_VALUE_OP_LIGA_DESLIGA);
		
		parametros.setProperty(PARAM_PORTA, numeroPorta );
				
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
		
		return urlString;
	}
	
	
	
	
	private  void requestHttp(Properties parameters) throws NotConectedExeption, ExecultarComandoExeption {
			
			URL url = null;
									
			StringBuilder response = new StringBuilder();
			
			//TODO colocar log
			//System.out.println("Arduino fazendo request para: " + this.montaUrl(parameters) );
			
			try {
				
				url = new URL(this.montaUrl(parameters));
				
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				
				urlConnection.setRequestProperty("Request-Method", "PUT"); 
				
		        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		 				        		        
		        String s = "";
		        while (null != ((s = in.readLine()))) {
		        	response.append(s);
		        } 
		 
		        in.close();
		        urlConnection.disconnect();
		        
		        if(response.toString().contains("<error>")){
		        	throw new ExecultarComandoExeption(response.toString());
		        }
		        
		        
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new ExecultarComandoExeption();
			} catch (IOException e) {
				e.printStackTrace();
				throw new NotConectedExeption();
			}
			 
			
			// TODO colocar log
			System.out.println("Resposta do arduino.: " + response.toString());
			
			
	
			
		
	}



	



	



	
	
	
	
	
	
	

	

	
	
	
}
