import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

import Acessos.Acesso;
import Acessos.AcessoEvento;
import Acessos.Diaria;
import Acessos.Mensalista;
import Acessos.PorTempo;
import Estacionamentos.Estacionamento;
import Eventos.Evento;
import Exceptions.DescricaoEmBrancoException;
import Exceptions.ObjetoNaoEncontradoException;
import Exceptions.ValorAcessoInvalidoException;

class Main {
	public static void verificarListEstacionamentos(List<Estacionamento> estacionamento) throws ObjetoNaoEncontradoException{
		if(estacionamento.size() == 0){
			throw new ObjetoNaoEncontradoException();
		}
	}

	public static void verificarListEstacionamentosPeloNome(List<Estacionamento> estacionamento, String nome) throws ObjetoNaoEncontradoException{
		for (int i = 0; i < estacionamento.size(); i++) {
			if (estacionamento.get(i).getNome().equals(nome)) {
				break;
			} 
			
			else if(i == estacionamento.size() - 1) {
				throw new ObjetoNaoEncontradoException();
			}
		}
	}
	
	public static void validarInputString (String s)throws DescricaoEmBrancoException{
	    if (s.equalsIgnoreCase("") || s.equalsIgnoreCase(" ")){
	      throw new DescricaoEmBrancoException();
	    }
	}
	
	public static void validarInputNum(float num) throws ValorAcessoInvalidoException {
	    if (num < 1){
	      throw new ValorAcessoInvalidoException();
	    }
	 }

	public static void main(String[] args) {
		String global_decor = "-=-";
		int global_decor_size = 15;

		int opcao;
		List<Estacionamento> estacionamento = new ArrayList<Estacionamento>();
		String[] itemsPrincipal = {
			"Ver estacionamentos",
			"Ver acessos",
			"Ver eventos",
			"Sair"
		};
		String[] itemsEstacionamento = {
			"Cadastrar estacionamento",
			"Excluir estacionamento",
			"Listar estacionamentos",
			"Editar estacionamento",
			"Pesquisar estacionamento",
			"Voltar"
		};
		String[] itemsEdicao = {
			"Nome",
			"Capacidade",
			"Valor da Diaria Diurna",
			"Porcentagem Diaria Noturna",
			"Valor da Fracao Quinze",
			"Porcentagem Hora Cheia",
			"Valor Mensalidade",
			"Voltar"
		};	
		String[] itemsCadastroAcesso = {
			"Cadastrar acesso Diario",
			"Cadastrar acesso Por Tempo",
			"Cadastrar acesso Evento",
			"Cadastrar acesso Mensalista",
			"voltar"
		};
		String[] itemsAcesso = {
			"Cadastrar acesso",
			"Excluir acesso",
			"Listar acesso",
			"Editar acesso",
			"Pesquisar acesso",
			"Editar acesso Evento",
			"Pesquisar acesso Evento",
			"Excluir acesso Evento",
			"Voltar"
		};
		String[] itemsAcessoEdicao = {
			"Placa",
			"Data Hora Entrada",
			"Data Hora Saida"
		};
		String[] itemsEventoEdicao = {
			"Nome Evento",
			"Data e Hora Evento Inicio",
			"Data e Hora Evento Fim",
			"Valor do Evento",
			"Voltar",
		};
		String[] itemsEvento = {
			"Cadastrar evento",
			"Excluir evento",
			"Listar evento",
			"Editar evento",
			"Pesquisar evento",
			"Voltar"
		};
		
		while (true){
			while (true) {
				opcao = inputMenu("Menu Principal", global_decor, global_decor_size, itemsPrincipal);
				// Estacionamento
				if (opcao == 0) { 
					int opcaoEstacionamento = -1;
					while(opcaoEstacionamento != 5){
						opcaoEstacionamento = inputMenu("Estacionamentos", global_decor, global_decor_size, itemsEstacionamento);
						
						// "Cadastrar estacionamento",
						if (opcaoEstacionamento == 0) { 
							float porcDiariaNoturna, valorDiariaDiurna, valorFracaoQuinze, porcHoraCheia, valorMensalista;
							Map<String,String> estacItems = new HashMap<>();
							boolean unique = false;
							String nome = "";
							int capacidade;
	
							while(nome.equalsIgnoreCase(" ") || nome.isEmpty() || !unique){
								cls();
								title("Estacionamento", global_decor, global_decor_size);
								nome = input("Insira o nome do estacionamento\n> ");
								if(raiseError((nome.equalsIgnoreCase(" ") || nome.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size)){
									continue;
								}
								unique = unique_string(nome, get_nomes(estacionamento));
								raiseError(!unique,"JÁ EXISTE UM ESTACIONAMENTO COM ESSE NOME", global_decor, global_decor_size);
							}
							estacItems.put("Nome", nome);
							
							capacidade = input_int_view_cad("Insira a capacidade do estacionamento\n> ","Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							estacItems.put("Capacidade", int_str(capacidade));
	
							valorDiariaDiurna = input_float_view_cad("Insira o valor da diaria\n> ","Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							estacItems.put("Diaria diurna", float_str(valorDiariaDiurna));
	
							porcDiariaNoturna = input_float_view_cad("Insira a porcentagem da diária noturna\n> ","Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							estacItems.put("Diaria noturna", float_str(porcDiariaNoturna));
	
							valorFracaoQuinze = input_float_view_cad("Insira o valor da Fração de Quinze minutos:\n> ","Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							estacItems.put("Fração quinze", float_str(valorFracaoQuinze));
	
							porcHoraCheia = input_float_view_cad("Insira o valor do desconto da hora cheia\n> ","Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							estacItems.put("Hora cheia", float_str(porcHoraCheia));
	
							valorMensalista = input_float_view_cad("Insira o valor Mensalista\n> ","Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							estacItems.put("Valor mensalista", float_str(valorMensalista));
							
							view_cad("Cadastrando estacionamento", global_decor, global_decor_size, estacItems);
							Estacionamento novoEstacionamento = new Estacionamento(
								nome, 
								capacidade, 
								valorDiariaDiurna, 
								porcDiariaNoturna,
								valorFracaoQuinze, 
								porcHoraCheia, 
								valorMensalista
							);
							estacionamento.add(novoEstacionamento);
							ok();
						} 
						
						// "Excluir estacionamento",
						else if (opcaoEstacionamento == 1) { 
							int index = index_of_estacionamento("Excluir Estacionamento",estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							title("ESTACIONAMENTO " + estacionamento.get(index).getNome() + " EXCLUIDO", global_decor, global_decor_size);
							estacionamento.remove(index);
							ok();
						} 
						
						// "Listar estacionamentos",
						else if (opcaoEstacionamento == 2) { 
							if(!title_for_estacionamentos("Estacionamentos Disponiveis", estacionamento, global_decor, global_decor_size)){
								continue;
							}
							ok();
						} 
						
						// "Editar estacionamento",
						else if (opcaoEstacionamento == 3) {
							int index = index_of_estacionamento("Editando Estacionamento", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							boolean unique;
							String objeto2edit = estacionamento.get(index).getNome();
							int opcaoEdicao = -1;
							while(opcaoEdicao != itemsEdicao.length - 1){
								opcaoEdicao = inputMenu("Estacionamentos Edicao", global_decor, global_decor_size, itemsEdicao);
								switch (opcaoEdicao) {
									case 0:
										String nomeedit = "";
										unique = false;
										while(!unique){
											cls();
											title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
											nomeedit = input("Novo nome\n> ");
											if(empty_str(nomeedit,"-=-",15)){
												continue;
											}
											unique = unique_string(nomeedit,get_nomes(estacionamento));
										}
										decor(global_decor, global_decor_size);
										println("Editado: " + estacionamento.get(index).getNome() + " >>> " + nomeedit);
										estacionamento.get(index).setNome(nomeedit);
										break;
										
									case 1:
										int capacidadeedit = 0;
										while(capacidadeedit <= 0){
											try{
												cls();
												title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
												capacidadeedit = int_input("Nova capacidade\n> ");
												raiseError(capacidadeedit <= 0, "O NÚMERO PRECISAR SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
											} catch (Exception e){
												raiseError(true, "O VALOR PRECISA SER UM NUMERO", global_decor, global_decor_size);
											}
										}
										println("Editado: " + estacionamento.get(index).getCapacidade() + " >>> " + capacidadeedit);
										estacionamento.get(index).setCapacidade(capacidadeedit);
										break;
		
									case 2:
										float valorDiariaDiurna2edit = 0;
										while(valorDiariaDiurna2edit <= 0){
											try{
												cls();
												title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
												valorDiariaDiurna2edit = float_input("Novo Valor da Diaria Diurna:\n> ");
												raiseError(valorDiariaDiurna2edit <= 0, "O NÚMERO PRECISAR SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
											} catch (Exception e){
												raiseError(true, "O VALOR PRECISA SER UM NUMERO", global_decor, global_decor_size);
											}
										}
										println("Editado: " + estacionamento.get(index).getValorDiariaDiurna() + " >>> " + valorDiariaDiurna2edit);
										estacionamento.get(index).setValorDiariaDiurna(valorDiariaDiurna2edit);
										break;
		
									case 3:
										float porcDiariaNoturna2edit = 0;
										while(porcDiariaNoturna2edit <= 0){
											try{
												cls();
												title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
												porcDiariaNoturna2edit = float_input("Nova Porcentagem Diaria Noturna:\n> ");
												raiseError(porcDiariaNoturna2edit <= 0, "O NÚMERO PRECISAR SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
											} catch (Exception e){
												raiseError(true, "O VALOR PRECISA SER UM NUMERO", global_decor, global_decor_size);
											}
										}
										println("Editado: " + estacionamento.get(index).getPorcDiariaNoturna() + " >>> " + porcDiariaNoturna2edit);
										estacionamento.get(index).setPorcDiariaNoturna(porcDiariaNoturna2edit);
										break;
		
									case 4:
										float valorFracaoQuinzeedit = 0;
										while(valorFracaoQuinzeedit <= 0){
											try{
												cls();
												title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
												valorFracaoQuinzeedit = float_input("Novo Valor da Fracao Quinze:\n> ");
												raiseError(valorFracaoQuinzeedit <= 0, "O NÚMERO PRECISAR SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
											} catch (Exception e){
												raiseError(true, "O VALOR PRECISA SER UM NUMERO", global_decor, global_decor_size);
											}
										}
										println("Editado: " + estacionamento.get(index).getValorFracaoQuinze() + " >>> " + valorFracaoQuinzeedit);
										estacionamento.get(index).setValorFracaoQuinze(valorFracaoQuinzeedit);
										break;
		
									case 5:
										float porcHoraCheia2edit = 0;
										while(porcHoraCheia2edit <= 0){
											try{
												cls();
												title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
												porcHoraCheia2edit = float_input("Nova Porcentagem Hora Cheia:\n> ");
												raiseError(porcHoraCheia2edit <= 0, "O NÚMERO PRECISAR SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
											} catch (Exception e){
												raiseError(true, "O VALOR PRECISA SER UM NUMERO", global_decor, global_decor_size);
											}
										}
										println("Editado: " + estacionamento.get(index).getPorcHoraCheia() + " >>> " + porcHoraCheia2edit);
										estacionamento.get(index).setPorcHoraCheia(porcHoraCheia2edit);
										break;
		
									case 6:
										float valorMensalista2edit = 0;
										while(valorMensalista2edit <= 0){
											try{
												cls();
												title("EDITANDO ESTACIONAMENTO: " + objeto2edit, global_decor, global_decor_size);
												valorMensalista2edit = float_input("Novo valor mensalista:\n> ");
												raiseError(valorMensalista2edit <= 0, "O NÚMERO PRECISAR SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
											} catch (Exception e){
												raiseError(true, "O VALOR PRECISA SER UM NUMERO", global_decor, global_decor_size);
											}
										}
										println("Editado: " + estacionamento.get(index).getValorMensalista() + " >>> " + valorMensalista2edit);
										estacionamento.get(index).setValorMensalista(valorMensalista2edit);
										break;
										
									case 7:
										break;
								}
							}
							finish(global_decor, global_decor_size);
						} 
						
						// "Pesquisar estacionamento",
						else if (opcaoEstacionamento == 4) { 
							int index = index_of_estacionamento("Estacionamentos Disponiveis", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							cls();
							title("Estacionamento " + estacionamento.get(index).getNome(), global_decor, global_decor_size);
							estacionamento.get(index).listarAllAtributtes();
							finish(global_decor, global_decor_size);
						} 
						
						// "Voltar"
						else if(opcaoEstacionamento == 5) { 
							continue;
						}
					}
				} 

				// Acesso
				else if (opcao == 1) { 
					int opcaoAcesso = -1;
					while(opcaoAcesso != 8){
						opcaoAcesso = inputMenu("Acessos", global_decor, global_decor_size, itemsAcesso);
						
						// "Cadastrar acesso",
						if (opcaoAcesso == 0) { 
							int tipoAcesso = inputMenu("Cadastro de acesso", global_decor, global_decor_size, itemsCadastroAcesso);
							if(tipoAcesso == 4){
								continue;
							}
	
							int index = index_of_estacionamento("Estacionamento", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							String nomeEstacionamento = estacionamento.get(index).getNome();
	
							Map<String,String> acessItems = new HashMap<>();
							String placa = "",dataHoraEntrada,horaHoraSaida;
							while(placa.equalsIgnoreCase(" ") || placa.isEmpty()){
								cls();
								title("Cadastro de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
								placa = input("Insira a placa\n> ");
								raiseError((placa.equalsIgnoreCase(" ") || placa.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
							}
							acessItems.put("Placa", placa);
							
							dataHoraEntrada = input_str_view_cad("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ","Cadastro de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size, acessItems);
							acessItems.put("Entrada", dataHoraEntrada);
	
							horaHoraSaida = input_str_view_cad("Nova Data Hora Saida (dd/MM/yyyy HH:mm):\n> ","Cadastro de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size, acessItems);
							acessItems.put("Saida", horaHoraSaida);
							view_cad("Cadastro de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size, acessItems);
	
							switch (tipoAcesso) {
								case 0:
									Diaria novoAcessoDiario = new Diaria(placa, dataHoraEntrada, horaHoraSaida, estacionamento.get(index));
									estacionamento.get(index).adicionarAcesso(novoAcessoDiario);
									break;
	
								case 1:
									PorTempo novoAcessoPorTempo = new PorTempo(placa, dataHoraEntrada, horaHoraSaida, estacionamento.get(index));
									estacionamento.get(index).adicionarAcesso(novoAcessoPorTempo);
									break;
	
								case 2:
									int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
									if(ev_index == -1){
										break;
									}
									String evento2search = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
									List<Evento> evnts = estacionamento.get(index).getEventos();
									Evento evento = evnts.get(eventoIndex(evnts,evento2search));
									if(evento == null){
										raiseError((evento == null), "O EVENTO "+ evento2search +" NÃO EXISTE", global_decor, global_decor_size);
										break;
									}

									AcessoEvento novoAcessoEvento = new AcessoEvento(placa, dataHoraEntrada, horaHoraSaida, evento);
									evento.adicionarAcessoEvento(novoAcessoEvento);
									break;
								case 3:
									Mensalista novoAcessoMensalista = new Mensalista(placa, dataHoraEntrada, horaHoraSaida, estacionamento.get(index));
									estacionamento.get(index).adicionarAcesso(novoAcessoMensalista);
									break;
							}
							ok();
						} 
						
						// "Excluir acesso",
						else if (opcaoAcesso == 1) { 
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ac_index = index_of_acesso(index, estacionamento, global_decor, global_decor_size);
							if(ac_index == -1){
								continue;
							}
							estacionamento.get(index).getAcessos().remove(ac_index);
							finish(global_decor, global_decor_size);
						} 
						
						// "Listar acesso",
						else if (opcaoAcesso == 2) { 
							int count = 0;
							if(!title_for_estacionamentos("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size)){
								continue;
							}
							for(Estacionamento i: estacionamento){
								if(i.getAcessos().size() > 0){
									println("Estacionamento: " + i.getNome());
									view_acessos_details(i.getAcessos());
									count++;
								}
							}
							if(count > 0){
								finish(global_decor, global_decor_size);
							} else {
								title("NENHUM ACESSO CADASTRADO", global_decor, global_decor_size);
								ok();
							}
						} 
						
						// "Editar acesso",
						else if (opcaoAcesso == 3) { 
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ac_index = index_of_acesso(index, estacionamento, global_decor, global_decor_size);
							if(ac_index == -1){
								continue;
							}
							Acesso acesso = estacionamento.get(index).getAcessos().get(ac_index);
							String nomeEstacionamento = estacionamento.get(index).getNome();

							int opcaoEdicao = -1;
							while(opcaoEdicao != 3){
								opcaoEdicao = inputMenu("Acessos Edicao", global_decor, global_decor_size, itemsAcessoEdicao);
								if(opcaoEdicao == 0){
									String placa = "";
									while(placa.equalsIgnoreCase(" ") || placa.isEmpty()){
										cls();
										title("Edicao de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
										placa = input("Insira a nova placa\n> ");
										raiseError((placa.equalsIgnoreCase(" ") || placa.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
									}
									acesso.setPlaca(placa);
								} 
								
								else if(opcaoEdicao == 1) {
									String dataHoraEntrada = "";
									while(dataHoraEntrada.equalsIgnoreCase(" ") || dataHoraEntrada.isEmpty()){
										cls();
										title("Edicao de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
										dataHoraEntrada = input("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ");
										raiseError((dataHoraEntrada.equalsIgnoreCase(" ") || dataHoraEntrada.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
									}
									acesso.setDataHoraEntrada(dataHoraEntrada);
								} 
								
								else if(opcaoEdicao == 2) {
									String horaHoraSaida = "";
									while(horaHoraSaida.equalsIgnoreCase(" ") || horaHoraSaida.isEmpty()){
										cls();
										title("Edicao de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
										horaHoraSaida = input("Nova Data Hora Saida (dd/MM/yyyy HH:mm):\n> ");
										raiseError((horaHoraSaida.equalsIgnoreCase(" ") || horaHoraSaida.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
									}
									acesso.setDataHoraSaida(horaHoraSaida);
								} 
								
								else {
									raiseError(true, "Entrada Invalida!!!", global_decor, global_decor_size);
									continue;
								}
							} 
							finish(global_decor, global_decor_size);
						} 
						
						// "Pesquisar acesso",
						else if (opcaoAcesso == 4) { 
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ac_index = index_of_acesso(index, estacionamento, global_decor, global_decor_size);
							if(ac_index == -1){
								continue;
							}
							Acesso acesso = estacionamento.get(index).getAcessos().get(ac_index);
							view_acesso(acesso);
							finish(global_decor, global_decor_size);
						} 
						
						// "Editar acesso Evento",
						else if (opcaoAcesso == 5) {  
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento,global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							String nomeEstacionamento = estacionamento.get(index).getNome();
							int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
							if(ev_index == -1){
								continue;
							}
							String eventoEscolha = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
							List<Evento> evnts = estacionamento.get(index).getEventos();
							Evento evento = evnts.get(eventoIndex(evnts,eventoEscolha));
							if(evento == null){
								raiseError((evento == null), "O EVENTO "+ eventoEscolha +" NÃO EXISTE", global_decor, global_decor_size);
								continue;
							}
							int aec_index = index_of_acesso_evento(evento, global_decor, global_decor_size);
							if(aec_index == -1){
								continue;
							}
							// String placa2edit = evento.getAcessoEventos().get(aec_index).getPlaca();
							AcessoEvento acessoEvento = evento.getAcessoEventos().get(aec_index);
							
							int escolha = inputMenu("Acessos Edicao", global_decor, global_decor_size, itemsAcessoEdicao);
							if(escolha == 0) {
								String placa = "";
								while(placa.equalsIgnoreCase(" ") || placa.isEmpty()){
									cls();
									title("Edicao de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
									placa = input("Insira a nova placa\n> ");
									raiseError((placa.equalsIgnoreCase(" ") || placa.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
								}
								acessoEvento.setPlaca(placa);
							} 
							
							else if(escolha == 1) {
								String dataHoraEntrada = input("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ");
								while(dataHoraEntrada.equalsIgnoreCase(" ") || dataHoraEntrada.isEmpty()){
									cls();
									title("Edicao de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
									dataHoraEntrada = input("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ");
									raiseError((dataHoraEntrada.equalsIgnoreCase(" ") || dataHoraEntrada.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
								}
								acessoEvento.setDataHoraEntrada(dataHoraEntrada);
							} 
							
							else if(escolha == 2) {
								String dataHoraSaida = "";
								while(dataHoraSaida.equalsIgnoreCase(" ") || dataHoraSaida.isEmpty()){
									cls();
									title("Edicao de Acesso [ESTACIONAMENTO: " + nomeEstacionamento + "]", global_decor, global_decor_size);
									dataHoraSaida = input("Nova Data Hora Saida (dd/MM/yyyy HH:mm):\n> ");
									raiseError((dataHoraSaida.equalsIgnoreCase(" ") || dataHoraSaida.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
								}
								acessoEvento.setDataHoraSaida(dataHoraSaida);
							}
							finish(global_decor, global_decor_size);
						} 
						
						// "Pesquisar acesso Evento",
						else if (opcaoAcesso == 6) { 
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
							if(ev_index == -1){
								continue;
							}
							String eventoEscolha = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
							List<Evento> evnts = estacionamento.get(index).getEventos();
							Evento evento = evnts.get(eventoIndex(evnts,eventoEscolha));
							if(evento == null){
								raiseError((evento == null), "O EVENTO "+ eventoEscolha +" NÃO EXISTE", global_decor, global_decor_size);
								continue;
							}
							
							int aec_index = index_of_acesso_evento(evento, global_decor, global_decor_size);
							if(aec_index == -1){
								continue;
							}
							// String placa2edit = evento.getAcessoEventos().get(aec_index).getPlaca();
							
							AcessoEvento acessoEvento = evento.getAcessoEventos().get(aec_index);
							view_acessoevento(acessoEvento);
							finish(global_decor, global_decor_size);
							break;
						} 
						
						// "Excluir acesso Evento",
						else if (opcaoAcesso == 7) { 
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
							if(ev_index == -1){
								continue;
							}
							String eventoEscolha = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
							List<Evento> evnts = estacionamento.get(index).getEventos();
							Evento evento = evnts.get(eventoIndex(evnts,eventoEscolha));
							if(evento == null){
								raiseError((evento == null), "O EVENTO "+ eventoEscolha +" NÃO EXISTE", global_decor, global_decor_size);
								continue;
							}
							int aec_index = index_of_acesso_evento(evento, global_decor, global_decor_size);
							if(aec_index == -1){
								continue;
							}
							// String placa2edit = evento.getAcessoEventos().get(aec_index).getPlaca();
							
							AcessoEvento acessoEvento = evento.getAcessoEventos().get(aec_index);
							evento.getAcessoEventos().remove(acessoEvento);
							finish(global_decor, global_decor_size);
							continue;
						} 
						
						// "Voltar"
						else if(opcaoAcesso == 8) {
							continue;
						}
					}
				} 
				
				// Eventos
				else if (opcao == 2) { 
					int opcaoEvento = -1;
					while(opcaoEvento != 5){
						opcaoEvento = inputMenu("Eventos", global_decor, global_decor_size, itemsEvento);
						// "Cadastrar evento",
						if(opcaoEvento == 0){
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							// String nomeEstacionamento = estacionamento.get(index).getNome();
							
							String nomeEvento = "",dataHoraEventoInicio,dataHoraEventoFim;
							Map<String,String> eventItems = new HashMap<>();
							float valorEvento;
							
							while(nomeEvento.equalsIgnoreCase(" ") || nomeEvento.isEmpty()){
								cls();
								title("Cadastro de Evento", global_decor, global_decor_size);
								nomeEvento = input("Insira o nome do Evento\n> ");
								raiseError((nomeEvento.equalsIgnoreCase(" ") || nomeEvento.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
							}
							eventItems.put("Nome", nomeEvento);
							dataHoraEventoInicio = input_str_view_cad("Data e Hora do inicio do Evento (dd/MM/yyyy HH:mm):\n> ","Cadastrando Evento", global_decor, global_decor_size, eventItems);
							eventItems.put("Inicio", dataHoraEventoInicio);
	
							dataHoraEventoFim = input_str_view_cad("Data e Hora do fim do Evento (dd/MM/yyyy HH:mm):\n> ","Cadastrando Evento", global_decor, global_decor_size, eventItems);
							eventItems.put("Fim", dataHoraEventoFim);
							view_cad("Cadastrando Evento", global_decor, global_decor_size, eventItems);

							valorEvento = input_float_view_cad("Valor do Evento:\n> ","Cadastrando Evento", global_decor, global_decor_size, eventItems);
							eventItems.put("Valor", float_str(valorEvento));
							view_cad("Cadastrando Evento", global_decor, global_decor_size, eventItems);
							
							estacionamento.get(index).cadastrarEvento(nomeEvento, dataHoraEventoInicio, dataHoraEventoFim, valorEvento);
							ok();
							continue;
						}
						
						// "Excluir evento",
						else if(opcaoEvento == 1){
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Acessos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							String nomeEstacionamento = estacionamento.get(index).getNome();
							int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
							if(ev_index == -1){
								continue;
							}
							String eventoEscolha = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
							estacionamento.get(index).getEventos().remove(ev_index);
							raiseError(true, "O EVENTO "+eventoEscolha+" foi apagado [ESTACIONAMENTO "+nomeEstacionamento+"]", global_decor, global_decor_size);
							continue;
						}
						
						// "Listar evento",
						else if(opcaoEvento == 2){ 
							cls();
							title("Listar eventos", global_decor, global_decor_size);
							int count = 0;
							for(int i = 0; i < estacionamento.size(); i++){
								if(estacionamento.get(i).getEventos().size() > 0){
									println("Estacionamento: "+estacionamento.get(i).getNome());
									view_eventos_details(estacionamento.get(i).getEventos());
									if(i < estacionamento.size()){
										println("");
									}
									count++;
								}
							}
							if(estacionamento.size() == 0){
								raiseError(true, "NÃO EXISTEM ESTACIONAMENTOS CADASTRADOS", global_decor, global_decor_size);
							}
							else if(count > 0){
								finish(global_decor, global_decor_size);
							} else {
								raiseError(true,"NÃO EXISTEM EVENTOS CADASTRADOS", global_decor, global_decor_size);
							}
							continue;
						}
						
						// "Editar evento",
						else if(opcaoEvento == 3){ 
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Eventos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
							if(ev_index == -1){
								continue;
							}
							String evento2edit = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
							List<Evento> evnts = estacionamento.get(index).getEventos();
							Evento evento = evnts.get(eventoIndex(evnts,evento2edit));
							if(evento == null){
								raiseError((evento == null), "O EVENTO "+ evento2edit +" NÃO EXISTE", global_decor, global_decor_size);
								continue;
							}
	
							int opcaoEdicao = -1;
							while(opcaoEdicao != 4){
								opcaoEdicao = inputMenu("Evento Edicao", global_decor, global_decor_size, itemsEventoEdicao);
								switch (opcaoEdicao) {
									case 0:
										String nomeedit = "";
										while(nomeedit.equalsIgnoreCase(" ") || nomeedit.isEmpty()){
											cls();
											title("Cadastro de Evento", global_decor, global_decor_size);
											nomeedit = input("Insira o nome do Evento\n> ");
											raiseError((nomeedit.equalsIgnoreCase(" ") || nomeedit.isEmpty()), "A STRING NÃO PODE ESTAR VAZIA", global_decor, global_decor_size);
											if(raiseError(unique_string(nomeedit, get_nomes_eventos(evnts)), "ESTE NOME JÁ ESTÁ CADASTRADO NO SISTEMA!", global_decor, global_decor_size)){
												continue;
											}
										}
										evento.setNomeEvento(nomeedit);
										continue;
	
									case 1:
										String dataHoraInicio = input("Nova Data e Hora inicial do Evento (dd/MM/yyyy HH:mm)\n> ");
										try {
											validarInputString(dataHoraInicio);
										} catch (DescricaoEmBrancoException e) {
											raiseError(true, "Entrada Invalida!!!", global_decor, global_decor_size);
											continue;
										}
										evento.setDataHoraEventoInicio(dataHoraInicio);
										continue;
	
									case 2:
										String dataHoraFim = input("Nova Data e Hora final do Evento (dd/MM/yyyy HH:mm)\n> ");
										try {
											validarInputString(dataHoraFim);
										} catch (DescricaoEmBrancoException e) {
											raiseError(true, "Entrada Invalida!!!", global_decor, global_decor_size);
											continue;
										}
										evento.setDataHoraEventoFim(dataHoraFim);
										continue;
	
									case 3:
										float novoValorEvento = float_input("Novo Valor do Evento\n> ");
										try {
											validarInputString(String.valueOf(novoValorEvento));
										} catch (DescricaoEmBrancoException e) {
											raiseError(true, "Entrada Invalida!!!", global_decor, global_decor_size);
											continue;
										}
										evento.setValorEvento(novoValorEvento);
										continue;
	
									case 4:
										break;
								}
							}
							finish(global_decor, global_decor_size);
							continue;
						}
						
						// "Pesquisar evento",
						else if(opcaoEvento == 4){
							int index = index_of_estacionamento("Estacionamentos Disponiveis [Eventos]", estacionamento, global_decor, global_decor_size);
							if(index == -1){
								continue;
							}
							int ev_index = index_of_evento(index, estacionamento, global_decor, global_decor_size);
							if(ev_index == -1){
								continue;
							}
							String eventoToSearch = estacionamento.get(index).getEventos().get(ev_index).getNomeEvento();
							List<Evento> evnts = estacionamento.get(index).getEventos();
							Evento evento = evnts.get(eventoIndex(evnts,eventoToSearch));
							if(evento == null){
								raiseError((evento == null), "O EVENTO "+ eventoToSearch +" NÃO EXISTE", global_decor, global_decor_size);
								continue;
							}
							view_evento(evento);
							finish(global_decor, global_decor_size);
							continue;
						}
					}
				} 

				// Sair
				else if (opcao == 3) { 
					println("Saindo do sistema!!!");
					System.exit(0);
					break;
				}
			}
		}

	}
	
	// Print mais curto
	public static void print(String msg) {
		System.out.print(msg);
	}

	public static void println(String msg) {
		System.out.println(msg);
	}

	// Limpeza de tela
	public static void cls() {
		for(int i = 0; i < 4; i++){
			print("\033[H\033[2J");
			System.out.flush();
		}
	}

	// Input de confirmação
	public static void ok() {
		input("Aperte ENTER para continuar! ");
	}

	// Leitura de entrada de dados por parte do usuário (INPUT)
	public static String input(String msg) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // Cria um objeto Scanner
		print(msg); // Escreve a mensagem inserida na mensagem de input
		String result = sc.nextLine(); // Retorna a ultima linha lida
		return result; // Retorna o resultado do input
	} // Ex: String nome = sy.input("Insira seu nome\n> ");

	public static Float float_input(String msg) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		print(msg);
		Float result;
		result = sc.nextFloat();
		return result;
	}

	public static int int_input(String msg) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		print(msg);
		int result;
		result = sc.nextInt();
		return result;
	}

	// Linha de decoração
	public static void decor(String global_decor, int global_decor_size) {
		for (int i = 0; i < global_decor_size; i++) { // Imprime uma quantidade de strings igual ao valor global_decor_size
			print(global_decor);
		}
		println(""); // Quebra a linha
	} // Ex: sy.decor(global_decor,9) >>> "-=--=--=-" (Total de 9 digitos)

	// Centralizador de texto
	public static void centralize(String msg, String global_decor, int global_decor_size) {
		// calcula a quantidade de espaços necessária para centralizar a
		int center = (global_decor_size * global_decor.length()) - msg.length(); 
		
		// Verifica se o valor do centro é impar, caso seja aumenta o valor uma vez
		if (center % 2 != 0) { 				
			center++;
		}
		// Imprime uma quantidade de espaços vazios igual ao valor do centro divido
		for (int i = 0; i < center / 2; i++) { 
			print(" ");
		}
		println(msg); // Quebra a linha
	} // Ex: sy.title("Teste",global_decor,9)

	// Criador de títulos
	public static void title(String msg, String global_decor, int global_decor_size) {
		decor(global_decor, global_decor_size); // Cria um decorador
		centralize(msg, global_decor, global_decor_size); // Centraliza um texto
		decor(global_decor, global_decor_size); // Cria outro decorador
	}

	// Interagindo com menus
	public static void printMenu(String msg, String global_decor, int global_decor_size, String[] items) {
		title(msg, global_decor, global_decor_size);
		for (int i = 0; i < items.length; i++) {
			println(i + " - " + items[i]);
		}
		decor(global_decor, global_decor_size);
	}

	public static int inputMenu(String msg, String global_decor, int global_decor_size, String[] items) {
		int result = -1; // Inicializa uma variável que representa um valor que vai armazenar o resultado escolhido pelo usuário
		do {
			cls(); // Limpa tela
			printMenu(msg, global_decor, global_decor_size, items); // Printa um menu
			try{
				result = int_input("> "); // Solicita o input de um usuário
				raiseError(
					(result > items.length - 1 || result < 0),
					"OPÇÃO INVÁLIDA",
					global_decor,
					global_decor_size
				);
				break;
			} catch (Exception  e){
				raiseError(true, "O VALOR PRECISA SER UM NÚMERO INTEIRO", global_decor, global_decor_size);
				continue;
			}
			// Cria algo parecido com uma Exception
		} while (result > items.length - 1 || result < 0); // Enquanto o input for maior que a quantidade de items ou menor do que 0 o loop vai continuar
		return result; // Retorna o resultado da função como um valor inteiro para ser utilizado em um switch case ou qualquer outra coisa.
	}

	public static Boolean raiseError(Boolean condition, String msg, String global_decor, int global_decor_size) {
		if (condition) {
			title(msg, global_decor, global_decor_size);
			ok();
		}
		return condition;
	}
	
	public static boolean printAllEstacionamentos(List<Estacionamento> list, String global_decor, int global_decor_size){
		if(list.isEmpty()/*raiseError(list.isEmpty(), "Nenhum Estacionamento foi criado!!!", global_decor, global_decor_size)*/){
			return false;
		} else {
			for (int i = 0; i < list.size(); i++) {
				println("> " + list.get(i).getNome());
			}
			return true;
		}
	}

	public static int estacionamentoIndex(List<Estacionamento> estacionamento,String nome){
		int index = -1;
		for (int i = 0; i < estacionamento.size(); i++) {
			if (estacionamento.get(i).getNome().equals(nome)) {
				index = i;
			}
		}
		return index;
	}

	public static int eventoIndex(List<Evento> evento,String nome){
		int index = -1;
		for (int i = 0; i < evento.size(); i++) {
			if (evento.get(i).getNomeEvento().equals(nome)) {
				index = i;
			}
		}
		return index;
	}

	public static int acessoIndex(List<Acesso> acesso,String nome){
		int index = -1;
		for (int i = 0; i < acesso.size(); i++) {
			if (acesso.get(i).getPlaca().equals(nome)) {
				index = i;
			}
		}
		return index;
	}

	public static int acessoEventoIndex(List<AcessoEvento> acesso,String nome){
		int index = -1;
		for (int i = 0; i < acesso.size(); i++) {
			if (acesso.get(i).getPlaca().equals(nome)) {
				index = i;
			}
		}
		return index;
	}

	public static void finish(String global_decor, int global_decor_size){
		decor(global_decor, global_decor_size);
		ok();
	}

	public static void view_cad(String msg,String global_decor, int global_decor_size, Map<String,String> items){
		cls();
		title("Estacionamento", global_decor, global_decor_size);
		for(Map.Entry<String, String> item : items.entrySet()){
			println("> " + item.getKey() + ": " + item.getValue());
		}
		decor(global_decor, global_decor_size);
	}

	public static String input_str_view_cad(String input_msg, String msg,String global_decor, int global_decor_size, Map<String,String> items){
		String result;
		while(true){
			view_cad(msg,global_decor, global_decor_size, items);
			result = input(input_msg);
			if(empty_str(result,"-=-",15)){
				continue;
			}
			break;
		}	
		return result;
	}

	public static int input_int_view_cad(String input_msg, String msg,String global_decor, int global_decor_size, Map<String,String> items){
		int result;
		while(true){
			try{
				view_cad(msg,global_decor, global_decor_size, items);
				result = int_input(input_msg);
				if(result <= 0){
					raiseError((result <= 0),"O VALOR PRECISA SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
					continue;
				}
				break;
			} catch (Exception e) {
				raiseError(true, "O VALOR PRECISA SER UM NÚMERO INTEIRO!", global_decor, global_decor_size);
			}
		}	
		return result;
	}

	public static float input_float_view_cad(String input_msg, String msg, String global_decor, int global_decor_size, Map<String,String> items){
		float result;
		while(true){
			try{
				view_cad(msg,global_decor, global_decor_size, items);
				result = float_input(input_msg);
				if(result <= 0){
					raiseError((result <= 0),"O VALOR PRECISA SER MAIOR DO QUE ZERO", global_decor, global_decor_size);
					continue;
				}
				break;
			} catch (Exception e) {
				raiseError(true, "O VALOR PRECISA SER UM NÚMERO!", global_decor, global_decor_size);
			}
		}	
		return result;
	}

	public static String int_str(int num){
		return String.valueOf(num);
	}

	public static String float_str(float num){
		return String.valueOf(num);
	}

	public static boolean unique_string(String str,List<String> list){
		boolean unique = true;
		for(String i:list){
			if(str.equalsIgnoreCase(i)){
				return false;
			}
		}
		return unique;
	}

	public static List<String> get_nomes(List<Estacionamento> estacionamento){
		List<String> nomes = new ArrayList<String>();
		for(int i = 0; i < estacionamento.size(); i++){
			nomes.add(estacionamento.get(i).getNome());
		}
		return nomes;
	}

	public static List<String> get_nomes_eventos(List<Evento> eventos){
		List<String> nomes = new ArrayList<String>();
		for(int i = 0; i < eventos.size(); i++){
			nomes.add(eventos.get(i).getNomeEvento());
		}
		return nomes;
	}

	public static List<String> get_nomes_acessos(List<Acesso> acessos){
		List<String> nomes = new ArrayList<String>();
		for(int i = 0; i < acessos.size(); i++){
			nomes.add(acessos.get(i).getPlaca());
		}
		return nomes;
	}

	public static List<String> get_nomes_acessoseventos(List<AcessoEvento> acessos){
		List<String> nomes = new ArrayList<String>();
		for(int i = 0; i < acessos.size(); i++){
			nomes.add(acessos.get(i).getPlaca());
		}
		return nomes;
	}

	public static void view_acesso(Acesso acesso){
		println("Placa: " + acesso.getPlaca());
		println("Começo: " + acesso.getDataHoraEntrada());
		println("Fim: " + acesso.getDataHoraSaida());
		println("Estacionado: " + acesso.getMinutosEstacionados());
	}

	public static void view_evento(Evento evento){
		println("Nome: " + evento.getNomeEvento());
		println("Começo: " + evento.getDataHoraEventoInicio());
		println("Fim: " + evento.getDataHoraEventoFim());
		println("Valor: " + evento.getValorEvento());
	}

	public static void view_acessoevento(AcessoEvento acessoEventos){
		println("Acesso");
		println("Placa: " + acessoEventos.getPlaca());
		println("Começo: " + acessoEventos.getDataHoraEntrada());
		println("Fim: " + acessoEventos.getDataHoraSaida());
		println("Estacionado: " + acessoEventos.getMinutosEstacionados());
		println("Evento");
		view_evento(acessoEventos.getEvento());
	}

	public static boolean view_eventos_details(List<Evento> eventos){
		if(eventos.size() == 0){
			return false;
		}
		for(Evento i: eventos){
			view_evento(i);
			println("");
		}
		return true;
	}

	public static boolean view_acessos_details(List<Acesso> acessos){
		if(acessos.size() == 0){
			return false;
		}
		for(Acesso i: acessos){
			view_acesso(i);
			println("");
		}
		return true;
	}

	public static boolean view_acessoevento_details(List<AcessoEvento> acessosEventos){
		if(acessosEventos.size() == 0){
			return false;
		}
		for(AcessoEvento i: acessosEventos){
			view_acessoevento(i);
			println("");
		}
		return true;
	}

	public static boolean empty_str(String str,String global_decor,int global_decor_size){
		return raiseError(str.equalsIgnoreCase(" ") || str.isEmpty(),"ESTE CAMPO NÃO PODE SER VAZIO",global_decor,global_decor_size);
	}

	public static boolean title_for_estacionamentos(String msg,List<Estacionamento> estacionamento, String global_decor, int global_decor_size){
		cls();
		title(msg, global_decor, global_decor_size);
		boolean result = printAllEstacionamentos(estacionamento, global_decor, global_decor_size);
		if(result){
			decor(global_decor, global_decor_size);
		}
		raiseError(!result, "Nenhum estacionamento cadastrado", global_decor, global_decor_size);
		return result;
	}

	public static int index_of_estacionamento(String msg,List<Estacionamento> estacionamento, String global_decor, int global_decor_size){
		String search = "";
		boolean unique = true;
		int index;
		while(unique){
			if(!title_for_estacionamentos(msg, estacionamento, global_decor, global_decor_size)){
				return -1;
			}
			search = input("Insira o nome do estacionamento\n> ");
			unique = unique_string(search, get_nomes(estacionamento));
			raiseError(unique, "O ESTACIONAMENTO DIGITADO NÃO EXISTE", global_decor, global_decor_size);
		}
		decor(global_decor, global_decor_size);
		index = estacionamentoIndex(estacionamento, search);
		return index;
	}

	public static int index_of_evento(int index, List<Estacionamento> estacionamento, String global_decor, int global_decor_size){
		List<Evento> eventos = estacionamento.get(index).getEventos();
		int len = eventos.size();
		boolean unique = true;
		String search = "";
		int ev_index;
		while(unique){
			if(len == 0){
				raiseError(true,"Nenhum Evento foi criado!!!",global_decor,global_decor_size);
				return -1;
			}
			cls();
			title("Eventos disponiveis [Estacionamento: " + estacionamento.get(index).getNome() + "]", global_decor, global_decor_size);
			if(!view_eventos_details(eventos)){
				return -1;
			}
			decor(global_decor, global_decor_size);
			search = input("Insira o nome do evento\n> ");
			unique = unique_string(search, get_nomes_eventos(eventos));
		}
		finish(global_decor, global_decor_size);
		ev_index = eventoIndex(eventos,search);
		return ev_index;
	}

	public static int index_of_acesso(int index, List<Estacionamento> estacionamento, String global_decor, int global_decor_size){
		List<Acesso> acessos = estacionamento.get(index).getAcessos();
		int len = acessos.size();
		boolean unique = true;
		String search = "";
		int ac_index;
		while(unique){
			if(len == 0){
				raiseError(true,"Nenhum Acesso foi criado!!!",global_decor,global_decor_size);
				return -1;
			}
			cls();
			title("Acessos disponiveis [Estacionamento: " + estacionamento.get(index).getNome() + "]", global_decor, global_decor_size);
			if(!view_acessos_details(acessos)){
				return -1;
			}
			decor(global_decor, global_decor_size);
			search = input("Insira a placa do acesso\n> ");
			unique = unique_string(search, get_nomes_acessos(acessos));
		}
		finish(global_decor, global_decor_size);
		ac_index = acessoIndex(acessos,search);
		return ac_index;
	}

	public static int index_of_acesso_evento(Evento evento, String global_decor, int global_decor_size){
		List<AcessoEvento> acessos = evento.getAcessoEventos();
		boolean unique = true;
		String search = "";
		int ac_index;
		while(unique){
			if(raiseError(acessos.size() == 0, "NÃO EXISTEM ACESSOS CADASTRADOS", global_decor, global_decor_size)){
				return -1;
			}
			cls();
			title("ACESSOS EVENTOS DISPONÍVEIS", global_decor, global_decor_size);
			if(!view_acessoevento_details(acessos)){
				return -1;
			}
			decor(global_decor, global_decor_size);
			search = input("Insira a placa do acesso\n> ");
			unique = unique_string(search, get_nomes_acessoseventos(acessos));
		}
		finish(global_decor, global_decor_size);
		ac_index = acessoEventoIndex(acessos,search);
		return ac_index;
	}

	public static Evento get_evento(Estacionamento estacionamento, String nome){
		List<Evento> eventos = estacionamento.getEventos();
		for(int i = 0; i < eventos.size(); i++){
			if(nome.equals(eventos.get(i).getNomeEvento())){
				return eventos.get(i);
			}
		}
		return null;
	}

	public static String unique_valid_string(boolean condition,String title, String msg,String global_decor, int global_decor_size){
		String str = "";
		while(condition){
			cls();
			title(title, global_decor, global_decor_size);
			str = input(msg);
			if(empty_str(str,global_decor,global_decor_size)){
				continue;
			}
			break;
		}
		return str;
	}
}