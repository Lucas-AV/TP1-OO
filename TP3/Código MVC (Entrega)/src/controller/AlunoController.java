package controller;

import model.Aluno;
import view.AlunoView;

public class AlunoController {
    private Aluno model;
    private AlunoView view;
    
    public AlunoController(Aluno model, AlunoView view){
          this.model = model;
          this.view = view;
    }
    
    public String getAlunoNomeCompleto(){
        return model.getNomeCompleto();
    }
    
    public void setAlunoNomeCompleto(String nomeCompleto){
        model.setNomeCompleto(nomeCompleto);
    }
    
    public String getAlunoCurso(){
        return model.getCurso();
    }
    
    public void setAlunoCurso(String curso){
       model.setCurso(curso);
    }
    
    public String getAlunoMatricula(){
        return model.getMatricula();
    }
    
    public void setAlunoMatricula(String matricula){
       model.setMatricula(matricula);
    }
    
    public String getAlunoEmail(){
        return model.getEmail();
    }
    
    public void setAlunoEmail(String email){
       model.setEmail(email);
    }
    
    public void updateView(){
        view.printAlunoDetalhes(model.getMatricula(),
                                model.getNomeCompleto(),
                                model.getEmail(),
                                model.getCurso());
    }

}
