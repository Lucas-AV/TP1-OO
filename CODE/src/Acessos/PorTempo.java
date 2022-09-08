package Acessos;

import Estacionamentos.Estacionamento;

public class PorTempo extends Acesso{
		
	private Estacionamento estacionamento = null;
	
	public float calcularFracaoQuinze(float minutos) {
		return minutos*60;
	}
	
	public float calcularHoraCheia(float minutos) {
		return minutos/60;
	}
	
	public float calcularValorTotal() { ////////////////
		float horasCompletas = calcularHoraCheia(this.minutosEstacionados);
		float valorFracaoQuinze = estacionamento.getValorFracaoQuinze();
		float PorcHoraCheia = estacionamento.getPorcHoraCheia();
		
		float valorHora = (horasCompletas*valorFracaoQuinze)-(horasCompletas*valorFracaoQuinze*PorcHoraCheia);
		
		if(horasCompletas != (int)horasCompletas) {
			@SuppressWarnings("unused")
			float valorMinutos = calcularFracaoQuinze(horasCompletas - (int)horasCompletas);
		} else {
			 
		}
		return valorHora;
	}

	public PorTempo(String placa, String dataHoraEntrada, String dataHoraSaida, Estacionamento estacionamento) {
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
