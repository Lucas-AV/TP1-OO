package Acessos;

import Eventos.Evento;

public class AcessoEvento extends Acesso{
	
	private Evento evento = null;
	
	@Override
	public float calcularValorTotal() {
		float valorEvento = evento.getValorEvento();
		return valorEvento;
	}

	public AcessoEvento(String placa, String dataHoraEntrada, String dataHoraSaida, Evento evento) {
		super(placa, dataHoraEntrada, dataHoraSaida);
		this.evento = evento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
}
