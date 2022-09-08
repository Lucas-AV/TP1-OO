package Exceptions;

@SuppressWarnings("serial")
public class ValorAcessoInvalidoException extends Exception {
  public ValorAcessoInvalidoException() {
    super("Este valor é inválido! Confira se não há nenhum número negativo e tente novamente");
  }
}