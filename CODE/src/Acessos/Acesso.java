package Acessos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public abstract class Acesso {

	protected String placa;
	
	protected int minutosEstacionados;
	
	protected String dataHoraEntrada, 
				     dataHoraSaida;
	
	public abstract float calcularValorTotal();
		
	
	public int calcularMinutos(String dataHoraEntrada, String dataHoraSaida){
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Date entrada = null,
		     saida = null;
		
		try {
			entrada = simpleDateFormat.parse(dataHoraEntrada);
			saida = simpleDateFormat.parse(dataHoraSaida);
		} catch (ParseException e) {
			
		}
		
		long diferenca = saida.getTime() - entrada.getTime(); 
		
		return (int) TimeUnit.MILLISECONDS.toMinutes(diferenca);
	}
	
	public void listAllAtributtes() {
		System.out.printf("Placa: %s\n", placa);
		System.out.printf("Minutos Estacionados: %s\n", minutosEstacionados);
		System.out.printf("Data Hora Entrada: %s\n", dataHoraEntrada);
		System.out.printf("Data Hora Saida: %s\n", dataHoraSaida);
	}

	public Acesso(String placa, String dataHoraEntrada, String dataHoraSaida){
		this.placa = placa;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		this.minutosEstacionados = calcularMinutos(dataHoraEntrada, dataHoraSaida);
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getMinutosEstacionados() {
		return minutosEstacionados;
	}

	public void setMinutosEstacionados(int minutosEstacionados) {
		this.minutosEstacionados = minutosEstacionados;
	}

	public String getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(String dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
		this.minutosEstacionados = calcularMinutos(dataHoraEntrada, this.dataHoraSaida);
	}

	public String getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(String dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
		this.minutosEstacionados = calcularMinutos(this.dataHoraEntrada, dataHoraSaida);
	}
			  
}
