package br.com.emersondeandrade.modelo.core.arduino;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
@DiscriminatorValue(value = "2")
public class ArduinoTeste extends Arduino {
		
	private static final long serialVersionUID = 1L;


	public ArduinoTeste() {
		setModelo(ModeloArduino.ARDUINO_TESTE);
	}
	

	@Override
	public void ligarDesligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		System.out.println("Ligando e desligando porta: " + numeroPorta +" do ARDUINO teste");
		
	}


	

}
