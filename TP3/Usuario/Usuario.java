package Usuario;
public class Usuario {
    String CPF, Email, Nome, Senha, Matricula;

    // GetSet()
    public String getCPF(){
        return this.CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    
    public String getEmail(){
        return this.Email;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getNome(){
        return this.Nome;
    }
    public void setNome(String Nome){
        this.Nome = Nome;
    }

    public String getSenha(){
        return this.Senha;
    }
    public void setSenha(String Senha){
        this.Senha = Senha;
    }

    public String getMatricula(){
        return this.Matricula;
    }
    public void setMatricula(String Matricula){
        this.Matricula = Matricula;
    }
}
