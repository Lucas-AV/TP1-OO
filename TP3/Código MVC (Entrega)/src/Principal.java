import model.Aluno;
import view.AlunoView;
import controller.AlunoController;

public class Principal {
    public static void main(String[] args) {
        //buscar o registro de um aluno no simulador de Banco de Dados
        Aluno model  = simuladorPersistenciaDeDados();

        //criando a view para exibir os dados do aluno
        AlunoView view = new AlunoView();

        //criando o controller para fazer a intermedio entre a model e a view
        AlunoController controller = new AlunoController(model, view);
        
        printMenu("1) Alterando o Nome para \"Andre Lanna\"");
        
        print("> Antes da Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view

        //fazendo update nas informacoes da model
        controller.setAlunoNomeCompleto("Andre Lanna");
        
        print("> Apos a Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view
        
        printMenu("2) Alterando o Email para \"andrelanna@unb.br\"");
        
        print("> Antes da Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view

        //fazendo update nas informacoes da model
        controller.setAlunoEmail("andrelanna@unb.br");
        
        print("> Apos a Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view
        
        printMenu("3) Alterando a Matricula para \"999999999\"");
        
        print("> Antes da Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view

        //fazendo update nas informacoes da model
        controller.setAlunoMatricula("999999999");
        
        print("> Apos a Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view
        
        printMenu("4) Alterando o Curso para \"Engenharia de Software\"");
        
        print("> Antes da Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view

        //fazendo update nas informacoes da model
        controller.setAlunoCurso("Engenharia de Software");
        
        print("> Apos a Alteracao:\n");
        controller.updateView(); // exibindo/recarregando a view
        
        printMenu("5) Comparacao Final:");
        
        //variaveis temporarias utilizadas para exibir o objeto antes das mudancas
        Aluno tempModel = simuladorPersistenciaDeDados();
        AlunoView tempView = new AlunoView();

        AlunoController tempController = new AlunoController(tempModel,
        tempView);
        
        print("> Antes de todas Alteracoes:\n");
        tempController.updateView(); // exibindo/recarregando a view antiga
        
        print("> Apos todas Alteracoes:\n");
        controller.updateView(); // exibindo/recarregando a view nova
        decor("-",67);
        
        print("Todo o codigo foi feito usando o MVC como pattern.\n\n");
        print("As alteracoes vistas na View sao feitas pelos Controllers na classe\nAluno, que esta presente no package Model.\n\n");
        print("Esse arquivo Principal carrega o main e tem como funcao emular um\nsistema de persistencia de dados e um usuario alterando os valores\nna view.\n"); 
        decor("-",67);
    }
    
    //valores ja estabelecidos que simulam persistencia de dados
    private static Aluno simuladorPersistenciaDeDados(){
        return new Aluno("Nicolas Barbosa Fernandes","Biologia","211043734","NicolasBarbosaFernandes@gmail.com");
    }
    
    private static void print(String msg){
        System.out.print(msg);
    }
    private static void decor(String decor, int decor_size){
        for(int i = 0; i < decor_size; i++){
            print(decor);
        }
        print("\n");
    }

    private static void printMenu(String frase){
        decor("-",54);
        print(frase+"\n");
        decor("-",54);
        print("\n");
    }
    
}
