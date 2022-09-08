package Eventos;

import java.util.ArrayList;
import java.util.List;

import Acessos.AcessoEvento;
import Exceptions.ObjetoNaoEncontradoException;

public class Evento {
	
	private List<AcessoEvento> acessoEventos = new ArrayList<AcessoEvento>();
	
	private String nomeEvento;
	private String dataHoraEventoInicio;
	private String dataHoraEventoFim;
	private float valorEvento;

	public void adicionarAcessoEvento(AcessoEvento acessoEvento) {
		acessoEventos.add(acessoEvento);
	}
	
	public void excluirAcessoEventoPelaPlaca(String placa) throws ObjetoNaoEncontradoException{
		for(int i=0; i<acessoEventos.size(); i++) {
			if(acessoEventos.get(i).getPlaca().equals(placa)) {
				acessoEventos.remove(i);
				break;
			} else if(i == acessoEventos.size() - 1) {
				throw new ObjetoNaoEncontradoException();
			}
		}
	}
	
	public AcessoEvento retornarAcessoEventoPelaPlaca(String placa) throws ObjetoNaoEncontradoException{
		for(int i=0; i<acessoEventos.size(); i++) {
			if(acessoEventos.get(i).getPlaca().equals(placa)) {
				return acessoEventos.get(i);
			} else if(i == acessoEventos.size() - 1) {
				throw new ObjetoNaoEncontradoException();
			}
		}
		return null;
	}
	
	public void listarAllAcessosEventos() throws ObjetoNaoEncontradoException{
		if(acessoEventos.size() == 0) {
			throw new ObjetoNaoEncontradoException();
		} else {
			for(int i=0; i<acessoEventos.size(); i++) {
				System.out.println(acessoEventos.get(i).getPlaca());
			}
		}
	}
	
	public void listarAllAtributtes() {
		System.out.printf("Nome do Enveto: %s\n", nomeEvento);
		System.out.printf("Data e Hora Inicio do Evento: %s\n", dataHoraEventoInicio);
		System.out.printf("Data e Hora Fim do Evento: %s\n", dataHoraEventoFim);
		System.out.printf("Valor do Enveto: %.2f\n", valorEvento);
	}
	
	public Evento(String nomeEvento, String dataHoraEventoInicio, String dataHoraEventoFim,
			float valorEvento) {
		this.nomeEvento = nomeEvento;
		this.dataHoraEventoInicio = dataHoraEventoInicio;
		this.dataHoraEventoFim = dataHoraEventoFim;
		this.valorEvento = valorEvento;
	}
	
	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDataHoraEventoInicio() {
		return dataHoraEventoInicio;
	}

	public void setDataHoraEventoInicio(String dataHoraEventoInicio) {
		this.dataHoraEventoInicio = dataHoraEventoInicio;
	}

	public String getDataHoraEventoFim() {
		return dataHoraEventoFim;
	}

	public void setDataHoraEventoFim(String dataHoraEventoFim) {
		this.dataHoraEventoFim = dataHoraEventoFim;
	}

	public float getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(float valorEvento) {
		this.valorEvento = valorEvento;
	}

	public List<AcessoEvento> getAcessoEventos() {
		return acessoEventos;
	}

	public void setAcessoEventos(List<AcessoEvento> acessoEventos) {
		this.acessoEventos = acessoEventos;
	}

}
