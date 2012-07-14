package br.com.emersondeandrade.modelo.core.arduino;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;


@Entity
@DiscriminatorValue(value = "2")
public class ArduinoTeste extends Arduino {
		
	private static final long serialVersionUID = 1L;
	private static List<Integer> portasDisponiveis;
	

	static{
		portasDisponiveis = new ArrayList<Integer>();
		portasDisponiveis.add(6);
		portasDisponiveis.add(13);
	}

	public ArduinoTeste() {
		setModelo(ModeloArduino.ARDUINO_TESTE);
	}
	

	@Override
	public void ligarDesligarPorta(String numeroPorta) throws NotConectedExeption, ExecultarComandoExeption {
		System.out.println("Ligando e desligando porta: " + numeroPorta +" do ARDUINO teste");
		
	}


	@Override
	public List<Integer> getPortasDisponiveis() {
		return portasDisponiveis;
	}

}
