package Acessos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Estacionamentos.Estacionamento;

public class Diaria extends Acesso{
	
	private Estacionamento estacionamento = null;
	
	public boolean mais9horas() {
		if(this.minutosEstacionados > 540) {
			return true;
		} else {
			return false;
		}
	}
	
	public float calcularDiariaDiurna() {
		if(mais9horas()) {
			return estacionamento.getValorDiariaDiurna();
		} else {
			return -1;
		}
	}
	
	private boolean verificarDiariaNoturna() {
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		String[] arrEntrada = dataHoraEntrada.split(" ");
		String[] arrSaida = dataHoraSaida.split(" ");
		
		String strInicioNoite = arrEntrada[0]+" 17:59";
		String strFimNoite = arrSaida[0]+" 06:00";
		
		Date entrada = null;
		Date saida = null;
		
		Date horarioInicioNoite = null;
		Date horarioFimNoite = null;
		
		
		try {
			horarioInicioNoite = simpleDateFormat.parse(strInicioNoite);
			horarioFimNoite = simpleDateFormat.parse(strFimNoite);
			entrada = simpleDateFormat.parse(this.dataHoraEntrada);
			saida = simpleDateFormat.parse(this.dataHoraSaida);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(entrada.after(horarioInicioNoite) && saida.before(horarioFimNoite)) {
			return true;
		} else {
			return false;
		}
	}
	
	public float calcularDiariaNoturna() {
		float valorDiariaDiurna = estacionamento.getValorDiariaDiurna();
		float porcDiariaNoturna = estacionamento.getPorcDiariaNoturna();
		if(verificarDiariaNoturna()) {
			return (valorDiariaDiurna*porcDiariaNoturna)+valorDiariaDiurna;
		} else {
			return -1;
		}
	}
	
	@Override
	public float calcularValorTotal() {
		return 0;
	}

	public Diaria(String placa, String dataHoraEntrada, String dataHoraSaida, Estacionamento estacionamento) {
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
