package view;

public class AlunoView {
    public void printAlunoDetalhes(String matricula, String nomeCompleto, String email, String curso){
          print("\tMatricula: " + matricula + "\n");
          print("\tNome Completo: " + nomeCompleto + "\n");
          print("\tEmail: " + email + "\n");
          print("\tCurso: " + curso + "\n\n");
    }
    private static void print(String msg){
        System.out.print(msg);
    }
}
