package Exceptions;

@SuppressWarnings("serial")
public class ObjetoNaoEncontradoException extends Exception {
  public ObjetoNaoEncontradoException() {
    super("Objeto não encontrado!");
  }
}