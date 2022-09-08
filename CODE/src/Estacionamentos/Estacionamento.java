package Estacionamentos;

import Acessos.Acesso;
import Eventos.Evento;
import Exceptions.ObjetoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

  private String nome;

  private int capacidade,
  numeroAcessos;

  private List < Acesso > acessos = new ArrayList < Acesso > ();
  private List < Evento > eventos = new ArrayList < Evento > ();

  private float valorDiariaDiurna,
  porcDiariaNoturna,
  valorMensalista;

  private float valorFracaoQuinze,
  porcHoraCheia;

  public void cadastrarEvento(String nomeEvento, String dataHoraEventoInicio, String dataHoraEventoFim,
    float valorEvento) {
    Evento novo_evento = new Evento(nomeEvento, dataHoraEventoInicio, dataHoraEventoFim, valorEvento);
    adicionarEvento(novo_evento);
  }

  public void apagarEventoPeloNome(String nome) throws ObjetoNaoEncontradoException {
    for (int i = 0; i < eventos.size(); i++) {
      if (eventos.get(i).getNomeEvento().equals(nome)) {
        eventos.remove(i);
        break;
      } else if (i == eventos.size() - 1) {
        throw new ObjetoNaoEncontradoException();
      }
    }
  }

  public void adicionarAcesso(Acesso acesso) {
    acessos.add(acesso);
    this.numeroAcessos = acessos.size();
  }

  public void adicionarEvento(Evento evento) {
    eventos.add(evento);
    this.numeroAcessos = acessos.size();
  }

  public void excluirAcessoPelaPlaca(String placa) throws ObjetoNaoEncontradoException {
    for (int i = 0; i < acessos.size(); i++) {
      if (acessos.get(i).getPlaca().equals(placa)) {
        acessos.remove(i);
        break;
      } else if (i == acessos.size() - 1) {
        throw new ObjetoNaoEncontradoException();
      }
    }
  }

  public void exibirAcessoPelaPlaca(String placa) throws ObjetoNaoEncontradoException {
    for (int i = 0; i < acessos.size(); i++) {
      if (acessos.get(i).getPlaca().equals(placa)) {
        acessos.get(i).listAllAtributtes();
        break;
      } else if (i == acessos.size() - 1) {
        throw new ObjetoNaoEncontradoException();
      }
    }
  }

  public Acesso retornarAcesso(String placa) throws ObjetoNaoEncontradoException {

    int index = 0;
    for (int i = 0; i < acessos.size(); i++) {
      if (acessos.get(i).getPlaca().equals(placa)) {
        index = i;
        break;
      } else if (i == acessos.size() - 1) {
        throw new ObjetoNaoEncontradoException();
      }
    }

    return acessos.get(index);
  }

  public Evento retornarEvento(String nomeEvento) throws ObjetoNaoEncontradoException {

    int index = 0;
    for (int i = 0; i < eventos.size(); i++) {
      if (eventos.get(i).getNomeEvento().equals(nomeEvento)) {
        index = i;
        break;
      } else if (i == eventos.size() - 1) {
        throw new ObjetoNaoEncontradoException();
      }
    }

    return eventos.get(index);
  }

  public void listarAllEventos() throws ObjetoNaoEncontradoException {
    if (eventos.size() == 0) {
      throw new ObjetoNaoEncontradoException();
    } else {
      for (int i = 0; i < eventos.size(); i++) {
        System.out.println(eventos.get(i).getNomeEvento());
      }
    }
  }

  public void listarAllAcessos() throws ObjetoNaoEncontradoException {
    if (eventos.size() == 0) {
      throw new ObjetoNaoEncontradoException();
    } else {
      for (int i = 0; i < acessos.size(); i++) {
        System.out.println(acessos.get(i).getPlaca());
      }
    }
  }

  public void listarAllAcessosEvento() throws ObjetoNaoEncontradoException {
    if (acessos.size() == 0) {
      throw new ObjetoNaoEncontradoException();
    } else {
      for (int i = 0; i < acessos.size(); i++) {
        System.out.println(acessos.get(i).getPlaca());
      }
    }
  }

  public void listarAllAtributtes() {
    System.out.printf("Nome: %s\n", nome);
    System.out.printf("Capacidade: %s\n", capacidade);
    System.out.printf("Valor da Diaria Diurna: %.2f\n", valorDiariaDiurna);
    System.out.printf("Porcentagem Diaria Noturna: %.2f%%\n", porcDiariaNoturna);
    System.out.printf("Valor da Fracao Quinze: %.2f\n", valorFracaoQuinze);
    System.out.printf("Porcentagem Hora Cheia: %.2f%%\n", porcHoraCheia);
    System.out.printf("Valor Mensalista: %.2f\n", valorMensalista);
  }

  public Estacionamento(String nome, int capacidade, float valorDiariaDiurna, float porcDiariaNoturna,
    float valorFracaoQuinze, float porcHoraCheia, float valorMensalista) {
    this.nome = nome;
    this.capacidade = capacidade;
    this.valorDiariaDiurna = valorDiariaDiurna;
    this.porcDiariaNoturna = porcDiariaNoturna;
    this.valorFracaoQuinze = valorFracaoQuinze;
    this.porcHoraCheia = porcHoraCheia;
    this.valorMensalista = valorMensalista;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public int getNumeroAcessos() {
    return numeroAcessos;
  }

  public void setNumeroAcessos(int numeroAcessos) {
    this.numeroAcessos = numeroAcessos;
  }

  public float getValorDiariaDiurna() {
    return valorDiariaDiurna;
  }

  public void setValorDiariaDiurna(float valorDiariaDiurna) {
    this.valorDiariaDiurna = valorDiariaDiurna;
  }

  public float getPorcDiariaNoturna() {
    return porcDiariaNoturna;
  }

  public void setPorcDiariaNoturna(float porcDiariaNoturna) {
    this.porcDiariaNoturna = porcDiariaNoturna;
  }

  public float getValorFracaoQuinze() {
    return valorFracaoQuinze;
  }

  public void setValorFracaoQuinze(float valorFracaoQuinze) {
    this.valorFracaoQuinze = valorFracaoQuinze;
  }

  public float getPorcHoraCheia() {
    return porcHoraCheia;
  }

  public void setPorcHoraCheia(float porcHoraCheia) {
    this.porcHoraCheia = porcHoraCheia;
  }

  public float getValorMensalista() {
    return valorMensalista;
  }

  public void setValorMensalista(float valorMensalista) {
    this.valorMensalista = valorMensalista;
  }

}