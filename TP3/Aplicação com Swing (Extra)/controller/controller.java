package controller;

import model.Usuario;
import view.view;

public class controller {
    private view View;
    private Usuario model;

    public controller(view View, Usuario model){
        this.View = View;
        this.model = model;
    }

    public String getViewNome(){
        return model.getNome();
    }
    
    public String getViewCPF(){
        return model.getCPF();
    }
    
    public String getViewEmail(){
        return model.getEmail();
    }
    
    public String getViewMatricula(){
        return model.getMatricula();
    }

    public String getViewSenha(){
        return model.getSenha();
    }

    public void setViewNome(String Nome){
        model.setNome(Nome);
    }
    
    public void setViewCPF(String CPF){
        model.setCPF(CPF);
    }
    
    public void setViewEmail(String Email){
        model.setEmail(Email);
    }
    
    public void setViewMatricula(String Matricula){
        model.setMatricula(Matricula);
    }

    public void setViewSenha(String Senha){
        model.setSenha(Senha);
    }

    public Object getViewPressed(){
        return View.getPressed();
    }

    public void setViewPressed(Object pressed){
        View.setPressed(pressed);
    }

    public Object getViewLoginBtn(){
        return View.getLoginBtn();
    }

    public void updateView(int page){
        for(int i = 0; i < View.getPages().size(); i++){
            if(i == page){
                View.getPages().get(page).setVisible(true);
            } else {
                View.getPages().get(i).setVisible(false);
            }
        }
    }
}
