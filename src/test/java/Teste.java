import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.emersondeandrade.modelo.core.casa.CasaFacadeImp;
import br.com.emersondeandrade.modelo.core.dispositivo.Dispositivo;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;

public class Teste {
		
	public static final String PARAM_OPERACAO = "op";
	public static final String PARAM_PORTA = "port";
	public static final String PARAM_DELAY = "delay";
	public static final String PARAM_KEY = "key";
	public static final String PARAM_VALUE_OP_LIGA_DESLIGA = "01";
	
	
	
	
	public static final String IP= "xxx.xx.xxx.xxx";//TODO omitido por segurança
	
	
	public static final String KEY= "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";// chave 32 bits //TODO omitido por segurança
	public static final String PORTA= "xx";//TODO omitido por segurança
	
	
	public static void main(String[] args) throws Exception {
		
		Teste teste = new Teste();
		
		teste.ligarDesligarPorta("06");

	}
	
	
	public void ligarDesligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		Properties parametros = new Properties();
		
		parametros.setProperty("key", KEY);
		parametros.setProperty(PARAM_OPERACAO, PARAM_VALUE_OP_LIGA_DESLIGA);
		parametros.setProperty(PARAM_PORTA,  numeroPorta );
				
		requestHttp(parametros);
		
	}
		
		
	
	private String montaUrl(Properties parameters){
		
		String urlString = "http://" + IP + ":" + PORTA;
		  
		// o iterador, para criar a URL  
		Iterator i = parameters.keySet().iterator();  
		
		// o contador  
		int counter = 0;  
		  
		// enquanto ainda existir parametros  
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
	
	
	
	private  String requestHttp(Properties parameters){
			
			URL url = null;
									
			StringBuilder response = new StringBuilder();
			
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
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	        
		
		System.out.println("Arduino fazendo request para: " + this.montaUrl(parameters) );
		
		System.out.println(response.toString());
		
		return response.toString();
			
		
	}
	
	
	
	
	
	
	
	

	public static void teste1() throws Exception, Exception, Exception {
		ApplicationContext cx = new ClassPathXmlApplicationContext(
				"META-INF/spring/app-context.xml");

		CasaFacadeImp casaFacade = cx.getBean(CasaFacadeImp.class);

		Dispositivo disp = casaFacade.getDispositovoById(10);

		//casaFacade.acionar("d1");
	}

}