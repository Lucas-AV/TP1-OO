package Acessos;

import Estacionamentos.Estacionamento;

public class Mensalista extends Acesso{

	private Estacionamento estacionamento = null;
	
	@Override
	public float calcularValorTotal() {
		return estacionamento.getValorMensalista();
	}

	public Mensalista(String placa, String dataHoraEntrada, String dataHoraSaida, Estacionamento estacionamento) {
		super(placa, dataHoraEntrada, dataHoraSaida);
		this.estacionamento = estacionamento;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

}
