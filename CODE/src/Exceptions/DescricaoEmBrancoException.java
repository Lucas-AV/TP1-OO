package Exceptions;

@SuppressWarnings("serial")
public class DescricaoEmBrancoException extends Exception {
  public DescricaoEmBrancoException() {
    super("Um ou mais campos estão em branco!!!");
  }
}