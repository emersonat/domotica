package br.com.emersondeandrade.modelo.core.arduino;

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
	

	public ArduinoTeste() {
		setModelo(ModeloArduino.ARDUINO_TESTE);
	}
	

	@Override
	public void ligarDesligarPorta(String numeroPorta, int segundosDuracao) throws NotConectedExeption, ExecultarComandoExeption {
		log.info("Ligando e desligando porta: " + numeroPorta +" do ARDUINO teste com duracao de " + segundosDuracao);
		
	}


	@Override
	public boolean isConected() {
		log.info("Verificando status ARDUINO teste") ;
		return true;
	}


	@Override
	public void ligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		log.info("Ligando porta: " +  numeroPorta + " do ARDUINO teste") ;
		
	}


	@Override
	public void desligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		log.info("Desligando porta: " +  numeroPorta + " do ARDUINO teste") ;
		
	}



	

		
	


	

}
