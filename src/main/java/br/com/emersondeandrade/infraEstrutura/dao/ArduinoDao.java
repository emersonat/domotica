package br.com.emersondeandrade.infraEstrutura.dao;

import org.springframework.stereotype.Repository;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.repositorio.ArduinoRepositorio;

@Repository
public class ArduinoDao  extends DaoPadrao<Arduino> implements ArduinoRepositorio{

}
