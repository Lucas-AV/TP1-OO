import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			} else if(i == estacionamento.size() - 1) {
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
			"Valor do Evento"
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
				opcao = inputMenu("Menu Principal", "-=-", 15, itemsPrincipal);
				// Estacionamento
				if (opcao == 0) { 
					int opcaoEstacionamento = inputMenu("Estacionamentos", "-=-", 15, itemsEstacionamento);
					
					if (opcaoEstacionamento == 0) { 
						float porcDiariaNoturna, valorDiariaDiurna, valorFracaoQuinze, porcHoraCheia, valorMensalista;
						int capacidade;
						String nome;

						cls();
						title("Estacionamento", "-=-", 15);
						nome = input("Insira o nome do estacionamento\n> ");
						try {
							validarInputString(nome);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						}
						
						capacidade = int_input("Insira a capacidade do estacionamento\n> ");
						try {
							validarInputString(String.valueOf(capacidade));
							validarInputNum(capacidade);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (ValorAcessoInvalidoException e2) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (NumberFormatException e1) {
							println("A entrada deve ser um número!!!");
							break;
						} 
						
						valorDiariaDiurna = float_input("Insira o valor da diaria\n> ");
						try {
							validarInputString(String.valueOf(valorDiariaDiurna));
							validarInputNum(valorDiariaDiurna);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (ValorAcessoInvalidoException e2) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (NumberFormatException e1) {
							raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
							break;
						} 
						
						porcDiariaNoturna = float_input("Insira a porcentagem da diária noturna\n> ");
						try {
							validarInputString(String.valueOf(porcDiariaNoturna));
							validarInputNum(porcDiariaNoturna);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (ValorAcessoInvalidoException e2) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (NumberFormatException e1) {
							println("A entrada deve ser um número!!!");
							break;
						} 
						
						valorFracaoQuinze = float_input("Insira o valor da Fração de Quinze minutos:\n> ");
						try {
							validarInputString(String.valueOf(valorFracaoQuinze));
							validarInputNum(valorFracaoQuinze);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (ValorAcessoInvalidoException e2) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (NumberFormatException e1) {
							println("A entrada deve ser um número!!!");
							break;
						} 
						
						porcHoraCheia = float_input("Insira o valor do desconto da hora cheia\n> ");
						try {
							validarInputString(String.valueOf(porcHoraCheia));
							validarInputNum(valorFracaoQuinze);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (ValorAcessoInvalidoException e2) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (NumberFormatException e1) {
							println("A entrada deve ser um número!!!");
							break;
						} 
						
						valorMensalista = float_input("Insira o valor Mensalista\n> ");
						try {
							validarInputString(String.valueOf(valorMensalista));
							validarInputNum(valorFracaoQuinze);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (ValorAcessoInvalidoException e2) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						} catch (NumberFormatException e1) {
							raiseError(true,"A entrada deve ser um número!!!","-=-", 15);
							break;
						} 
						
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
	
						decor("-=-", 15);
						ok();
					} else if (opcaoEstacionamento == 1) { 
						cls();
						title("Estacionamento", "-=-", 15);
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
							
						decor("-=-", 15);
						
						String nome2exclude = input("Insira o nome do estacionamento\n> ");
	
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nome2exclude);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
						
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nome2exclude)) {
								estacionamento.remove(i);
								break;
							}
						}
	
						decor("-=-", 15);
						ok();
					} else if (opcaoEstacionamento == 2) { 
						cls();
						title("Listando Estacionamento", "-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);

							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
						ok();
					} else if (opcaoEstacionamento == 3) { 
						cls();
						title("Editando Estacionamento", "-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
						String objeto2edit = input("Insira o nome do estacionamento\n> ");
						
						try {
							verificarListEstacionamentosPeloNome(estacionamento, objeto2edit);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
	
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(objeto2edit)) {
								index = i;
								estacionamento.get(i).listarAllAtributtes();
								break;
							}
						}
	
						cls();
						
	
						printMenu("Estacionamentos Edicao", "-=-", 15, itemsEdicao);
						int opcaoEdicao = int_input("O que deseja editar\n> ");
						switch (opcaoEdicao) {
							case 0:
								try {
									String nome2edit = input("Novo nome\n> ");
									validarInputString(nome2edit);
									estacionamento.get(index).setNome(nome2edit);
								} catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								}
								
								break;
							case 1:
							
								try {
									int capacidade2edit = int_input("Nova capacidade\n> ");
									validarInputString(String.valueOf(capacidade2edit));
									validarInputNum(capacidade2edit);
									estacionamento.get(index).setCapacidade(capacidade2edit);
								} catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (ValorAcessoInvalidoException e2) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (NumberFormatException e1) {
									raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
									break;
								} 
								
								break;
							case 2:
								float valorDiariaDiurna2edit = float_input("Novo Valor da Diaria Diurna: ");
								
								try {
									validarInputString(String.valueOf(valorDiariaDiurna2edit));
									validarInputNum(valorDiariaDiurna2edit);
								} catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (ValorAcessoInvalidoException e2) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (NumberFormatException e1) {
									raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
									break;
								} 
								
								estacionamento.get(index).setValorDiariaDiurna(valorDiariaDiurna2edit);
								break;
							case 3:
								float porcDiariaNoturna2edit = float_input("Nova Porcentagem Diaria Noturna: ");
								
								try {
									validarInputString(String.valueOf(porcDiariaNoturna2edit));
									validarInputNum(porcDiariaNoturna2edit);
								} catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (ValorAcessoInvalidoException e2) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);

									break;
								} catch (NumberFormatException e1) {
									raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
									break;
								} 
								
								estacionamento.get(index).setPorcDiariaNoturna(porcDiariaNoturna2edit);
								break;
							case 4:
								float valorFracaoQuinze2edit = float_input("Novo Valor da Fracao Quinze: ");
								
								try {
									validarInputString(String.valueOf(valorFracaoQuinze2edit));
									validarInputNum(valorFracaoQuinze2edit);
								}catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (ValorAcessoInvalidoException e2) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (NumberFormatException e1) {
									raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
									break;
								} 
								
								estacionamento.get(index).setValorFracaoQuinze(valorFracaoQuinze2edit);
								break;
							case 5:
								float porcHoraCheia2edit = float_input("Nova Porcentagem Hora Cheia: ");
								
								try {
									validarInputString(String.valueOf(porcHoraCheia2edit));
									validarInputNum(porcHoraCheia2edit);
								} catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (ValorAcessoInvalidoException e2) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (NumberFormatException e1) {
									raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
									break;
								} 
								
								estacionamento.get(index).setPorcHoraCheia(porcHoraCheia2edit);
								break;
							case 6:
								float valorMensalista2edit = float_input("Novo Valor Mensalidade: ");
								
								try {
									validarInputString(String.valueOf(valorMensalista2edit));
									validarInputNum(valorMensalista2edit);
								} catch (DescricaoEmBrancoException e) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (ValorAcessoInvalidoException e2) {
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
								} catch (NumberFormatException e1) {
									raiseError(true, "A entrada deve ser um número!!!", "-=-", 15);
									break;
								} 
								
								estacionamento.get(index).setValorMensalista(valorMensalista2edit);
								break;
							default:
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
						}
	
						decor("-=-", 15);
						ok();
					} else if (opcaoEstacionamento == 4) { 
						cls();
						title("Estacionamento", "-=-", 15);
						
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nome2search = input("Insira o nome do estacionamento\n> ");
	
						decor("-=-", 15);
						
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nome2search);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
	
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nome2search)) {
								estacionamento.get(i).listarAllAtributtes();
								break;
							}
						}
	
						decor("-=-", 15);
						ok();
					} else if(opcaoEstacionamento == 5) { 
						break;
					}
				} else if (opcao == 1) { // Acesso
					int opcaoAcesso = inputMenu("Acessos", "-=-", 15, itemsAcesso);
					if (opcaoAcesso == 0) {  // Cadastro
						int tipoAcesso = inputMenu("Cadastro de acesso", "-=-", 15, itemsCadastroAcesso);
						if(tipoAcesso == 4){
							break;
						}
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						
						decor("-=-", 15);
						
						String nomeEstacionamento = input("Deseja alocar em qual estacionamento?\n> ");
						
						decor("-=-", 15);
						
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
	
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
	
						String placa = input("Insira a placa\n> ");
						
						try {
							validarInputString(placa);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						}
						
						String dataHoraEntrada = input("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ");
						
						try {
							validarInputString(dataHoraEntrada);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						}
						
						String horaHoraSaida = input("Nova Data Hora Saida (dd/MM/yyyy HH:mm):\n> ");
						
						try {
							validarInputString(horaHoraSaida);
						} catch (DescricaoEmBrancoException e) {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						}
						
						decor("-=-", 15);
	
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
								try {
									estacionamento.get(index).listarAllEventos();
								} catch (ObjetoNaoEncontradoException e) {
									println("Nenhum Evento Cadastrado!!!");
									decor("-=-", 15);
									ok();
									break;
								}
								
								decor("-=-", 15);
								
								String evento2search = input("Insira o nome do Evento\n> ");
								
								Evento evento = null;
								try {
									evento = estacionamento.get(index).retornarEvento(evento2search);
								} catch (ObjetoNaoEncontradoException e) {
									println("O Evento digitado não existe!!!");
									decor("-=-", 15);
									ok();
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
						
						decor("-=-", 15);
						ok();
					} else if (opcaoAcesso == 1) { 
						cls();
						title("Acessos", "-=-", 15);
	
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
						
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nomeEstacionamento = input("Deseja escolher qual estacionamento?\n> ");
						
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
						
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
						
						decor("-=-", 15);
	
						try {
							estacionamento.get(index).listarAllAcessos();
						} catch (ObjetoNaoEncontradoException e1) {
							println("Nenhum Acesso Cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
	
						String placa2exclude = input("Deseja excluir qual Placa?\n> ");
						
						try {
							estacionamento.get(index).excluirAcessoPelaPlaca(placa2exclude);
						} catch (ObjetoNaoEncontradoException e) {
							println("A placa digitada não existe!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						ok();
					} else if (opcaoAcesso == 2) { 
						cls();
						title("Acessos", "-=-", 15);
						
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						for (int i = 0; i < estacionamento.size(); i++) {
							try {
								estacionamento.get(i).listarAllAcessos();
							} catch (ObjetoNaoEncontradoException e) {
								println("Nenhum Acesso Cadastrado!!!");
								decor("-=-", 15);
								ok();
								break;
							}
						}
						
						decor("-=-", 15);
						ok();
					} else if (opcaoAcesso == 3) { 
						cls();
						title("Acessos", "-=-", 15);
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nomeEstacionamento = input("Deseja escolher qual estacionamento?\n> ");
						
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
						
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
						
						try {
							estacionamento.get(index).listarAllAcessos();
						} catch (ObjetoNaoEncontradoException e1) {
							raiseError(true, "Nenhum Acesso Cadastrado!!!", "-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
	
						String placa2edit = input("Deseja editar qual Placa?\n> ");
	
						
	
						printMenu("Acessos Edicao", "-=-", 15, itemsAcessoEdicao);
						
						Acesso acesso;
						
						try {
							acesso = estacionamento.get(index).retornarAcesso(placa2edit);
						} catch (ObjetoNaoEncontradoException e) {
							println("A Placa digitado não existe!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						int opcaoEdicao = int_input("Deseja editar o que?\n> ");
	
						
						if(opcaoEdicao == 0){
							String placa = input("Nova Placa:\n> ");
							
							try {
								validarInputString(placa);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							acesso.setPlaca(placa);
						} else if(opcaoEdicao == 1) {
							String dataHoraEntrada = input("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ");
							
							try {
								validarInputString(dataHoraEntrada);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							acesso.setDataHoraEntrada(dataHoraEntrada);
						} else if(opcaoEdicao == 2) {
							String horaHoraSaida = input("Nova Data Hora Saida (dd/MM/yyyy HH:mm):\n> ");
							
							try {
								validarInputString(horaHoraSaida);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							acesso.setDataHoraSaida(horaHoraSaida);
						} else {
							raiseError(true, "Entrada Invalida!!!", "-=-", 15);
							break;
						}
						
						decor("-=-", 15);
						ok();
					} else if (opcaoAcesso == 4) { 
						cls();
						title("Acessos", "-=-", 15);
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nomeEstacionamento = input("Deseja escolher qual estacionamento?\n> ");
						
						decor("-=-", 15);
						
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
	
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
						
						try {
							estacionamento.get(index).listarAllAcessos();
						} catch (ObjetoNaoEncontradoException e1) {
							println("Nenhum Acesso Cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
	
						String placa2search = input("Deseja pesquisar qual Placa?\n> ");
	
						try {
							estacionamento.get(index).exibirAcessoPelaPlaca(placa2search);
						} catch (ObjetoNaoEncontradoException e) {
							println("A Placa digitado não existe!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						ok();
					} else if (opcaoAcesso == 5) {  
						cls();
						title("Acessos", "-=-", 15);
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nomeEstacionamento = input("Deseja escolher qual estacionamento?\n> ");
						
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
						
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
						
						try {
							println("Eventos disponiveis: ");
							estacionamento.get(index).listarAllEventos();
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum Evento foi criado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						
						String eventoEscolha = input("Deseja escolher qual evento?\n> ");
						
						decor("-=-", 15);
						
						Evento evento = null;
						try {
							evento = estacionamento.get(index).retornarEvento(eventoEscolha);
						} catch (ObjetoNaoEncontradoException e) {
							println("Evento digitado ainda nao foi cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						try {
							println("Acessos Evento disponiveis: ");
							evento.listarAllAcessosEventos();
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum acesso evento cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						String placa2edit = input("Deseja editar qual placa?\n> ");
						
						decor("-=-", 15);
						
						AcessoEvento acessoEvento = null;
						try {
							acessoEvento = evento.retornarAcessoEventoPelaPlaca(placa2edit);
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum acesso evento com essa placa foi cadastrada!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						printMenu("Acessos Edicao", "-=-", 15, itemsAcessoEdicao);
						
						int escolha = int_input("O que deseja editar?\n> ");
						
						if(escolha == 0) {
							String placa = input("Nova Placa:\n> ");
							
							try {
								validarInputString(placa);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							acessoEvento.setPlaca(placa);
						} else if(escolha == 1) {
							String dataHoraEntrada = input("Nova Data Hora Entrada (dd/MM/yyyy HH:mm):\n> ");
							
							try {
								validarInputString(dataHoraEntrada);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							acessoEvento.setDataHoraEntrada(dataHoraEntrada);
						} else if(escolha == 2) {
							String dataHoraSaida = input("Nova Data Hora Saida (dd/MM/yyyy HH:mm):\n> ");
							
							try {
								validarInputString(dataHoraSaida);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							acessoEvento.setDataHoraSaida(dataHoraSaida);
						}
						
						decor("-=-", 15);
						ok();
					} else if (opcaoAcesso == 6) { 
						cls();
						title("Acessos", "-=-", 15);
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nomeEstacionamento = input("Deseja escolher qual estacionamento?\n> ");
						
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
						
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
						
						try {
							println("Eventos disponiveis: ");
							estacionamento.get(index).listarAllEventos();
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum Evento foi criado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						
						String eventoEscolha = input("Deseja escolher qual evento?\n> ");
						
						decor("-=-", 15);
						
						Evento evento = null;
						try {
							evento = estacionamento.get(index).retornarEvento(eventoEscolha);
						} catch (ObjetoNaoEncontradoException e) {
							println("Evento digitado ainda nao foi cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						try {
							println("Acessos Evento disponiveis: ");
							evento.listarAllAcessosEventos();
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum acesso evento cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						String placa2edit = input("Deseja editar qual placa?\n> ");
						
						decor("-=-", 15);
						
						AcessoEvento acessoEvento = null;
						try {
							acessoEvento = evento.retornarAcessoEventoPelaPlaca(placa2edit);
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum acesso evento com essa placa foi cadastrada!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						acessoEvento.listAllAtributtes();
						
						decor("-=-", 15);
						ok();
						break;
					} else if (opcaoAcesso == 7) { 
						cls();
						title("Acessos", "-=-", 15);
						println("Estacionamentos Disponiveis:");
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentos(estacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "Nenhum Estacionamento foi criado", "-=-", 15);
							break;
						}
						
						printAllEstacionamentos(estacionamento);
						
						decor("-=-", 15);
	
						String nomeEstacionamento = input("Deseja escolher qual estacionamento?\n> ");
						
						decor("-=-", 15);
	
						try {
							verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
						} catch (ObjetoNaoEncontradoException e) {
							raiseError(true, "O Estacionamento digitado não existe!!!", "-=-", 15);
							break;
						}
						
						int index = 0;
						for (int i = 0; i < estacionamento.size(); i++) {
							if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
								index = i;
								break;
							}
						}
						
						try {
							println("Eventos disponiveis: ");
							estacionamento.get(index).listarAllEventos();
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum Evento foi criado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						
						String eventoEscolha = input("Deseja escolher qual evento?\n> ");
						
						decor("-=-", 15);
						
						Evento evento = null;
						try {
							evento = estacionamento.get(index).retornarEvento(eventoEscolha);
						} catch (ObjetoNaoEncontradoException e) {
							println("Evento digitado ainda nao foi cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						try {
							println("Acessos Evento disponiveis: ");
							evento.listarAllAcessosEventos();
						} catch (ObjetoNaoEncontradoException e) {
							println("Nenhum acesso evento cadastrado!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						
						String placa2exclude = input("Deseja editar qual placa?\n> ");
						
						decor("-=-", 15);
						
						try {
							evento.excluirAcessoEventoPelaPlaca(placa2exclude);
						} catch (ObjetoNaoEncontradoException e) {
							println("Essa placa ainda nao foi cadastrada!!!");
							decor("-=-", 15);
							ok();
							break;
						}
						
						decor("-=-", 15);
						ok();
					} else if(opcaoAcesso == 8) {
						break;
					}
					
				} else if (opcao == 2) { // Eventos
					int opcaoEvento = inputMenu("Eventos", "-=-", 15, itemsEvento);
					switch (opcaoEvento) {
						case 0: 
							cls();
							title("Eventos", "-=-", 15);
							println("Estacionamentos Disponiveis:");
							decor("-=-", 15);
							
							try {
								verificarListEstacionamentos(estacionamento);
							} catch (ObjetoNaoEncontradoException e) {
								raiseError(true, "Nenhum Estacionamento foi criado!!!", "-=-", 15);
								break;
							}
							
							printAllEstacionamentos(estacionamento);
				
							
							decor("-=-", 15);
							
							String nomeEstacionamento = input("Deseja alocar em qual estacionamento?\n> ");
							
							decor("-=-", 15);
		
							try {
								verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
							} catch (ObjetoNaoEncontradoException e1) {
								println("O Estacionamento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
							
							int index = 0;
							for (int i = 0; i < estacionamento.size(); i++) {
								if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
									index = i;
									break;
								}
							}
							
							String nomeEvento = input("Insira o nome do Evento\n> ");
							
							try {
								validarInputString(nomeEvento);
							} catch (DescricaoEmBrancoException e3) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							String dataHoraEventoInicio = input("Data e Hora do inicio do Evento (dd/MM/yyyy HH:mm):\n> ");
							
							try {
								validarInputString(dataHoraEventoInicio);
							} catch (DescricaoEmBrancoException e3) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							String dataHoraEventoFim = input("Data e Hora do fim do Evento (dd/MM/yyyy HH:mm):\n> ");
							
							try {
								validarInputString(dataHoraEventoFim);
							} catch (DescricaoEmBrancoException e3) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							}
							
							float valorEvento = float_input("Valor do Evento:\n> ");
							
							try {
								validarInputString(String.valueOf(valorEvento));
								validarInputNum(valorEvento);
							} catch (DescricaoEmBrancoException e) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								decor("-=-", 15);
								ok();
								break;
							} catch (ValorAcessoInvalidoException e2) {
								raiseError(true, "Entrada Invalida!!!", "-=-", 15);
								break;
							} catch (NumberFormatException e1) {
								println("A entrada deve ser um número!!!");
								break;
							} 
							
							estacionamento.get(index).cadastrarEvento(nomeEvento, dataHoraEventoInicio, dataHoraEventoFim, valorEvento);
							
							decor("-=-", 15);
							ok();
							break;
	
						case 1: 
							cls();
							title("Eventos", "-=-", 15);
							println("Estacionamentos Disponiveis:");
							decor("-=-", 15);
							
							try {
								verificarListEstacionamentos(estacionamento);
							} catch (ObjetoNaoEncontradoException e) {
								raiseError(true, "Nenhum Estacionamento foi criado!!!", "-=-", 15);
								break;
							}
							
							printAllEstacionamentos(estacionamento);
							
							decor("-=-", 15);
							
							nomeEstacionamento = input("Deseja alocar em qual estacionamento?\n> ");
							
							decor("-=-", 15);
							
							try {
								verificarListEstacionamentosPeloNome(estacionamento, nomeEstacionamento);
							} catch (ObjetoNaoEncontradoException e1) {
								println("O Estacionamento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
		
							index = 0;
							for (int i = 0; i < estacionamento.size(); i++) {
								if (estacionamento.get(i).getNome().equals(nomeEstacionamento)) {
									index = i;
									break;
								}
							}
							
							try {
								estacionamento.get(index).listarAllEventos();
							} catch (ObjetoNaoEncontradoException e1) {
								println("Nenhum Evento Cadastrado!!!");
								decor("-=-", 15);
								ok();
								break;
							}
							
							decor("-=-", 15);
							
							String nome2delete = input("Digite o Evento a ser apagado:\n> ");
	
							try {
								estacionamento.get(index).apagarEventoPeloNome(nome2delete);
							} catch (ObjetoNaoEncontradoException e2) {
								println("O Evento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
							
							ok();
							break;
	
						case 2: 
							cls();
							title("Evento", "-=-", 15);
							
							for (int i = 0; i < estacionamento.size(); i++) {
								try {
									estacionamento.get(i).listarAllEventos();
								} catch (ObjetoNaoEncontradoException e1) {
									println("Nenhum Evento Cadastrado!!!");
									decor("-=-", 15);
									ok();
									break;
								}
							}
							
							decor("-=-", 15);
							ok();
							break;
	
						case 3: 
							cls();
							title("Editando Evento", "-=-", 15);
	
							try {
								verificarListEstacionamentos(estacionamento);
							} catch (ObjetoNaoEncontradoException e) {
								raiseError(true, "Nenhum Estacionamento foi criado!!!", "-=-", 15);
								break;
							}
		
							printAllEstacionamentos(estacionamento);
		
							decor("-=-", 15);
							String objeto2edit = input("Insira o nome do estacionamento\n> ");
							
							try {
								verificarListEstacionamentosPeloNome(estacionamento, objeto2edit);
							} catch (ObjetoNaoEncontradoException e1) {
								println("O Estacionamento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
			
							index = 0;
							for (int i = 0; i < estacionamento.size(); i++) {
								if (estacionamento.get(i).getNome().equals(objeto2edit)) {
									index = i;
									try {
										estacionamento.get(i).listarAllEventos();
									} catch (ObjetoNaoEncontradoException e) {
										println("Nenhum Evento Cadastrado!!!");
										decor("-=-", 15);
										ok();
										break;
									}
									break;
								}
							}
		
							String evento2edit = input("Nome do evento a ser editado\n> ");
							
							cls();
							
							Evento evento;
							try {
								evento = estacionamento.get(index).retornarEvento(evento2edit);
							} catch (ObjetoNaoEncontradoException e1) {
								println("O Evento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
							
							
	
							printMenu("Evento Edicao", "-=-", 15, itemsEventoEdicao);
							int opcaoEdicao = int_input("O que deseja editar\n> ");
							switch (opcaoEdicao) {
								case 0:
									String nome2edit = input("Novo Nome Evento\n> ");
									
									try {
										validarInputString(nome2edit);
									} catch (DescricaoEmBrancoException e2) {
										raiseError(true, "Entrada Invalida!!!", "-=-", 15);
										break;
									}
									
									evento.setNomeEvento(nome2edit);
									break;
								case 1:
									String dataHoraInicio = input("Nova Data e Hora inicial do Evento (dd/MM/yyyy HH:mm)\n> ");
									
									try {
										validarInputString(dataHoraInicio);
									} catch (DescricaoEmBrancoException e2) {
										raiseError(true, "Entrada Invalida!!!", "-=-", 15);
										break;
									}
									
									evento.setDataHoraEventoInicio(dataHoraInicio);
									break;
								case 2:
									String dataHoraFim = input("Nova Data e Hora inicial do Evento (dd/MM/yyyy HH:mm)\n> ");
									
									try {
										validarInputString(dataHoraFim);
									} catch (DescricaoEmBrancoException e2) {
										raiseError(true, "Entrada Invalida!!!", "-=-", 15);
										decor("-=-", 15);
										ok();
										break;
									}
									
									evento.setDataHoraEventoFim(dataHoraFim);
									break;
								case 3:
									float novoValorEvento = float_input("Novo Valor do Evento\n>");
									
									try {
										validarInputString(String.valueOf(novoValorEvento));
									} catch (DescricaoEmBrancoException e2) {
										raiseError(true, "Entrada Invalida!!!", "-=-", 15);
										break;
									}
									
									evento.setValorEvento(novoValorEvento);
									break;
								default:
									raiseError(true, "Entrada Invalida!!!", "-=-", 15);
									break;
							}
		
							decor("-=-", 15);
							ok();
							break;
	
						case 4: 
							cls();
							title("Evento", "-=-", 15);
	
							try {
								verificarListEstacionamentos(estacionamento);
							} catch (ObjetoNaoEncontradoException e) {
								raiseError(true, "Nenhum Estacionamento foi criado!!!", "-=-", 15);
								break;
							}
							
							printAllEstacionamentos(estacionamento);
		
							decor("-=-", 15);
							
							String estacionamento2search = input("Insira o nome do estacionamento\n> ");
		
							decor("-=-", 15);
							
							try {
								verificarListEstacionamentosPeloNome(estacionamento, estacionamento2search);
							} catch (ObjetoNaoEncontradoException e1) {
								println("O Estacionamento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
							
							index = 0;
							for (int i = 0; i < estacionamento.size(); i++) {
								if (estacionamento.get(i).getNome().equals(estacionamento2search)) {
									index = i;
									try {
										estacionamento.get(i).listarAllEventos();
									} catch (ObjetoNaoEncontradoException e) {
										println("Nenhum Evento Cadastrado!!!");
										decor("-=-", 15);
										ok();
										break;
									}
									break;
								}
							}
		
							decor("-=-", 15);
							
							String evento2search = input("Nome do evento a pesquisar:\n> ");
							
							try {
								evento = estacionamento.get(index).retornarEvento(evento2search);
							} catch (ObjetoNaoEncontradoException e) {
								println("O Evento digitado não existe!!!");
								decor("-=-", 15);
								ok();
								break;
							}
							
							evento.listarAllAtributtes();
							
							decor("-=-", 15);
							ok();
							break;
	
						default:
							break;
					}
				} else if (opcao == 3) { // Sair
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
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.print("\033[H\033[2J");
		System.out.flush();
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
		Float result = sc.nextFloat();
		return result;
	}

	public static int int_input(String msg) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		print(msg);
		int result = sc.nextInt();
		return result;
	}

	// Linha de decoração
	public static void decor(String chr, int decor_size) {
		for (int i = 0; i < decor_size; i++) { // Imprime uma quantidade de strings igual ao valor decor_size
			print(chr);
		}
		println(""); // Quebra a linha
	} // Ex: sy.decor("-=-",9) >>> "-=--=--=-" (Total de 9 digitos)

	// Centralizador de texto
	public static void centralize(String msg, String chr, int decor_size) {
		// calcula a quantidade de espaços necessária para centralizar a
		int center = (decor_size * chr.length()) - msg.length(); 
		
		// Verifica se o valor do centro é impar, caso seja aumenta o valor uma vez
		if (center % 2 != 0) { 				
			center++;
		}
		// Imprime uma quantidade de espaços vazios igual ao valor do centro divido
		for (int i = 0; i < center / 2; i++) { 
			print(" ");
		}
		println(msg); // Quebra a linha
	} // Ex: sy.title("Teste","-=-",9)

	// Criador de títulos
	public static void title(String msg, String chr, int decor_size) {
		decor(chr, decor_size); // Cria um decorador
		centralize(msg, chr, decor_size); // Centraliza um texto
		decor(chr, decor_size); // Cria outro decorador
	}

	// Interagindo com menus
	public static void printMenu(String msg, String chr, int decor_size, String[] items) {
		title(msg, chr, decor_size);
		for (int i = 0; i < items.length; i++) {
			System.out.printf("%d - %s\n", i, items[i]);
		}
		decor(chr, decor_size);
	}

	public static int inputMenu(String msg, String chr, int decor_size, String[] items) {
		int result = -1; // Inicializa uma variável que representa um valor que vai armazenar o resultado
											// escolhido pelo usuário
		do {
			cls(); // Limpa tela
			printMenu(msg, chr, decor_size, items); // Printa um menu
			result = int_input("> "); // Solicita o input de um usuário
			// Cria algo parecido com uma Exception
			raiseError(
				(result > items.length || result < 0),
				"OPÇÃO INVÁLIDA",
				chr,
				decor_size
			);
		} while (result > items.length - 1 || result < 0); // Enquanto o input for maior que a quantidade de items ou menor
																												// do que 0 o loop vai continuar
		return result; // Retorna o resultado da função como um valor inteiro para ser utilizado em um
										// switch case ou qualquer outra coisa.
	}

	public static void raiseError(Boolean condition, String msg, String decor, int decor_size) {
		if (condition) {
			title(msg, decor, decor_size);
			ok();
		}
	}
	
	public static void printAllEstacionamentos(List<Estacionamento> list){
		for (int i = 0; i < list.size(); i++) {
			println(list.get(i).getNome());
		}
	}
}