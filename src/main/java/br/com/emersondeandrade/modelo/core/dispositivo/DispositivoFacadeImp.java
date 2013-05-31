package br.com.emersondeandrade.modelo.core.dispositivo;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.criptografia.Criptografia;
import br.com.emersondeandrade.modelo.core.casa.Casa;
import br.com.emersondeandrade.modelo.core.eventos.ProcessadorEventos;
import br.com.emersondeandrade.modelo.core.historico.HistoricoService;
import br.com.emersondeandrade.modelo.exeption.ExecultarComandoExeption;
import br.com.emersondeandrade.modelo.exeption.NotConectedExeption;
import br.com.emersondeandrade.modelo.repositorio.DispositivoRepositorio;

@Service
public class DispositivoFacadeImp implements DispositivoFacade {

	@Autowired
	DispositivoRepositorio dispRepositorio;

	@Autowired
	ProcessadorEventos processadorEventos;

	@Autowired
	DispositivoRepositorio dispositivoRepositorio;

	@Autowired
	HistoricoService historicoService;

	@Autowired
	Criptografia criptService;

	public void desativarDispositivo(int id) {

		Dispositivo d = dispRepositorio.getById(id);

		d.setAtivo(false);
		dispRepositorio.salvar(d);

	}

	public void ativarDispositivo(int id) {
		Dispositivo d = dispRepositorio.getById(id);
		d.setAtivo(true);
		dispRepositorio.salvar(d);

	}

	public void acionar(Casa casa, String keyDispositivoCript) throws NotConectedExeption, ExecultarComandoExeption, EntityNotFoundException {

		Dispositivo dispositivo = dispositivoRepositorio.getById(criptService.decriptToInt(keyDispositivoCript)  ); 
		
		dispositivo.acionar();

		processadorEventos.processar(dispositivo);

		historicoService.novoHistorico(dispositivo);

	}

	public Dispositivo getDispositovoById(int idDispositivo)
			throws EntityNotFoundException {
		return dispositivoRepositorio.getById(idDispositivo);
	}

	public void salvarDispositivo(Dispositivo disp) {
		// TODO implementar

	}

}
