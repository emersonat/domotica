package br.com.emersondeandrade.modelo.core.dispositivo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import br.com.emersondeandrade.modelo.core.arduino.Arduino;
import br.com.emersondeandrade.modelo.core.arduino.Operacao;
import br.com.emersondeandrade.modelo.core.arduino.Porta;
import br.com.emersondeandrade.modelo.core.casa.Area;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.eventos.TiposEvento;
import br.com.emersondeandrade.modelo.core.historico.Historico;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;

@Entity
public class Dispositivo implements Serializable, Comparable<Dispositivo> {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(Dispositivo.class);

	@Id
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "dispositivo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name = "id_dispositivo", unique = true, nullable = false)
	private int id;

	@Enumerated(EnumType.ORDINAL)
	private TipoComando tipoComando;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(name = "imagen_on", length = 150, nullable = false)
	private String imagenOn;

	@Column(name = "imagen_off", length = 150, nullable = false)
	private String imagenOff;

	
	@Column(nullable = false)
	private boolean ativo = true;

	@ElementCollection(targetClass = TiposEvento.class)
	@CollectionTable(name = "TIPOS_EVENTOS")
	private List<TiposEvento> tiposEventos;

	@Column(nullable = true)
	private int duracaoClique;
	
	@OneToMany(mappedBy = "dispositivo",fetch = FetchType.LAZY)	
	private List<Porta> portas;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_area",nullable = false)
	private Area area;
	
	
	
	public String getImagenOn() {
		return imagenOn;
	}

	public void setImagenOn(String imagenON) {
		this.imagenOn = imagenON;
	}

	public String getImagenOff() {
		return imagenOff;
	}

	public void setImagenOff(String imagenOFF) {
		this.imagenOff = imagenOFF;
	}

	

	public void acionar() throws NotConectedExeption, ExecultarComandoExeption {
		Arduino arduino = getPortas().get(0).getArduino();

		switch (getTipoComando()) {

		case CLICK:

			arduino.click( getOutput().getNumero(), getDuracaoClique());

			log.info("Acionando dispositivo....: " + getNome() + " (CLICK) ");

			break;

		case LIGAR_DESLIGAR:

			if ( isLigado() ) {
				arduino.desligarPorta( getOutput().getNumero()  );
				log.info("Desligando....: " + getNome() + " (LIGAR_DESLIGAR) ");
			} else {
				arduino.ligarPorta( getOutput().getNumero() );
				log.info("Ligando....: " + getNome() + " (LIGAR_DESLIGAR) ");
			}

			break;

		}

	}
	
	@Transient
	public Arduino getArduino(){
		return getPortas().get(0).getArduino();
	}
	
		

	@Transient
	public boolean isLigado() throws NotConectedExeption, ExecultarComandoExeption {
		
		List<Porta> inputs = getInput();
		Porta p =null;
		if(inputs ==null || inputs.size() == 0){
			p = getOutput();
		} else {
			//TODO verificar esta pegando primeira porta de input melhorar essa logica
			p = getInput().get(0);
		}
		
		return getArduino().isLigada(p.getNumero());
		
	}
	
	@Transient
	public Porta getOutput(){
		for(Porta p : getPortas() ){
			if (Operacao.OUTPUT.equals(p.getOperacao())) return p;
		}
		return null;
	}

	@Transient
	public List<Porta> getInput(){
		List<Porta> result = new ArrayList<Porta>();
		for(Porta p : getPortas() ){
			if (Operacao.INPUT.equals(p.getOperacao()))  result.add(p);
		}
		return result;
	}

	@Transient
	public Casa getCasa(){
		return getArduino().getCasa();
	}
	
	public TipoComando getTipoComando() {
		return tipoComando;
	}

	public void setTipoComando(TipoComando tipoComando) {
		this.tipoComando = tipoComando;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public List<TiposEvento> getTiposEventos() {
		return tiposEventos;
	}

	public void setTiposEventos(List<TiposEvento> tiposEventos) {
		this.tiposEventos = tiposEventos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
	public int getDuracaoClique() {
		return duracaoClique;
	}

	public void setDuracaoClique(int duracaoClique) {
		this.duracaoClique = duracaoClique;
	}

	public int compareTo(Dispositivo o) {
		return this.getNome().compareTo(o.getNome());
	}

	public List<Porta> getPortas() {
		return portas;
	}
	
	@Transient
	public List<Porta> getPortasOutput() {
		ArrayList<Porta> out = new ArrayList<Porta>();
		for(Porta p : getPortas()){
			if(Operacao.OUTPUT.equals(p.getOperacao())) out.add(p);
		}
		
		return out;
	}
	
	@Transient
	public List<Porta> getPortasInput() {
		ArrayList<Porta> in = new ArrayList<Porta>();
		for(Porta p : getPortas()){
			if(Operacao.INPUT.equals(p.getOperacao())) in.add(p);
		}
		
		return in;
	}
	
	
	
	

	public void setPortas(List<Porta> portas) {
		this.portas = portas;
	}

			

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
	
	

}
