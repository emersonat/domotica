package br.com.emersondeandrade.modelo.core.arduino;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.log4j.Logger;

import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
@DiscriminatorValue(value = "2")
public class ArduinoTeste extends Arduino {
		
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ArduinoTeste.class);
	
	private static HashMap<String, Boolean> status = new HashMap<String, Boolean>();
	static{
		status.put("06",false);
		status.put("07",false);
	}
	
	

	public ArduinoTeste() {
		setModelo(ModeloArduino.ARDUINO_TESTE);
	}
	

	@Override
	public void click(String numeroPorta, int segundosDuracao) throws NotConectedExeption, ExecultarComandoExeption {
		log.info("Ligando e desligando porta: " + numeroPorta +" do ARDUINO teste com duracao de " + segundosDuracao);
		
	}


	@Override
	public boolean isConected() {
		log.info("Verificando status ARDUINO teste") ;
		return true;
	}


	@Override
	public void ligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		status.put(numeroPorta, true);
		log.info("Ligando porta: " +  numeroPorta + " do ARDUINO teste") ;
		
	}


	@Override
	public void desligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		status.put(numeroPorta, false);
		log.info("Desligando porta: " +  numeroPorta + " do ARDUINO teste") ;
		
	}

	

	@Override
	public Map<String, Boolean> getStatusPortas() {
			
		return status;
	}
	
	
	

	

		
	


	

}
