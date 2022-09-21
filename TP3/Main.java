import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Usuario.Usuario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI implements ActionListener {
    Usuario user;

    // First Page
    JFrame first_page;
    JPanel buttons_row, text_row;
    JLabel email_label, senha_label, invalid_login;
    JTextField email, senha;
    JButton login, signIn;
    JPanel emailP, senhaP;

    // Register Page
    JFrame register_page;
    JPanel register_buttons_row, register_text_row;
    JLabel register_nome_label, register_email_label, register_senha_label, register_matricula_label, register_cpf_label;
    JTextField register_nome, register_email, register_senha, register_matricula, register_cpf;
    JButton cancel, complete;
    JLabel error;
    JPanel register_nomeP, register_cpfP, register_matriculaP, register_senhaP, register_emailP;

    // Profile Page
    JFrame profile_page;
    JPanel page_buttons_row;
    JLabel profile_name, profile_email, profile_senha, profile_matricula, profile_cpf;
    JButton back, close;
    JPanel profile_buttons_row;

    public void setUser(Usuario user){
        this.user = user;
    }
    public Usuario getUser(){
        return this.user;
    }

    // GUI constructor
    public GUI(){
        // Tela principal
        first_page = new JFrame();
        first_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        first_page.setSize(500,500);
        first_page.setLayout(new GridLayout(6,2));

        // Botões
        buttons_row = new JPanel();
        signIn = new JButton("Registrar");
        signIn.addActionListener(this);
        
        login = new JButton("Logar");
        login.addActionListener(this);

        buttons_row.add(signIn);
        buttons_row.add(login);

        // Inputs
        emailP = new JPanel();
        email = new JTextField();
        email_label = new JLabel("Email: ");
        email.setColumns(10);
        emailP.add(email);

        senhaP = new JPanel();
        senha = new JTextField();
        senha_label = new JLabel("Senha: ");
        senha.setColumns(10);
        senhaP.add(senha);

        // Estrutura
        first_page.add(email_label);
        first_page.add(emailP);
        first_page.add(senha_label);
        first_page.add(senhaP);
        first_page.add(buttons_row);
        invalid_login = new JLabel("");
        first_page.add(invalid_login);
        first_page.setTitle("LOGIN || CADASTRO UNB");
        first_page.pack();
        first_page.setVisible(true);


        // Tela de registro
        register_page = new JFrame();
        register_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register_page.setSize(500,500);
        register_page.setLayout(new GridLayout(6,1));

        // Botões
        register_buttons_row = new JPanel();
        cancel = new JButton("Cancelar");
        cancel.addActionListener(this);
        
        complete = new JButton("Finalizar");
        complete.addActionListener(this);

        error = new JLabel("");
        register_buttons_row.add(cancel);
        register_buttons_row.add(complete);
        register_buttons_row.add(error);

        // Inputs
        register_nomeP = new JPanel();
        register_nome = new JTextField();
        register_nome_label = new JLabel("Nome completo: ");
        register_nome.setColumns(10);
        register_nomeP.add(register_nome);

        register_cpfP = new JPanel();
        register_cpf = new JTextField();
        register_cpf_label = new JLabel("CPF: ");
        register_cpf.setColumns(10);
        register_cpfP.add(register_cpf);

        register_matriculaP = new JPanel();
        register_matricula = new JTextField();
        register_matricula_label = new JLabel("Matrícula: ");
        register_matricula.setColumns(10);
        register_matriculaP.add(register_matricula);

        register_emailP = new JPanel();
        register_email = new JTextField();
        register_email_label = new JLabel("Email: ");
        register_email.setColumns(10);
        register_emailP.add(register_email);

        register_senhaP = new JPanel();
        register_senha = new JTextField();
        register_senha_label = new JLabel("Senha: ");
        register_senha.setColumns(10);
        register_senhaP.add(register_senha);

        register_page.add(register_nome_label);
        register_page.add(register_nomeP);
        
        register_page.add(register_matricula_label);
        register_page.add(register_matriculaP);
        
        register_page.add(register_cpf_label);
        register_page.add(register_cpfP);

        register_page.add(register_email_label);
        register_page.add(register_emailP);
        
        register_page.add(register_senha_label);
        register_page.add(register_senhaP);
        
        register_page.add(register_buttons_row);

        register_page.setTitle("REGISTRO DE USUÁRIO");
        register_page.pack();
        register_page.setVisible(false);

        // Tela de perfil
        profile_page = new JFrame();
        profile_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profile_page.setSize(500,500);
        profile_page.setLayout(new GridLayout(5,1));

        profile_name = new JLabel();
        profile_matricula = new JLabel();
        profile_cpf = new JLabel();
        profile_email = new JLabel();
        profile_senha = new JLabel();


        // Botões
        profile_buttons_row = new JPanel();
        back = new JButton("Voltar");
        back.addActionListener(this);
        close = new JButton("Fechar");
        close.addActionListener(this);
        profile_buttons_row.add(back);
        profile_buttons_row.add(close);

        profile_page.add(profile_name);
        profile_page.add(profile_matricula);
        profile_page.add(profile_cpf);
        profile_page.add(profile_email);
        profile_page.add(profile_senha);
        profile_page.add(profile_buttons_row);

        profile_page.setTitle("PERFIL DO USUÁRIO");
        profile_page.setVisible(false);
    }

    public void updatePage(JFrame pageA, JFrame pageB){
        // Não visível
        pageA.setVisible(false);
        // Visível
        pageB.setVisible(true);
    }

    // Receptor de ações
    public void actionPerformed(ActionEvent e){
        // Registrar na página principal
        if(e.getSource() == signIn){
            // Limpeza dos campos
            email.setText("");
            senha.setText("");
            invalid_login.setText("");
            // Atualização da página
            updatePage(first_page,register_page);
        } 
        // Logar na página principal
        else if(e.getSource() == login){
            // Verifica se o usuário foi cadastrado
            if(user == null){
                invalid_login.setText("NÃO EXISTE USUÁRIO CADASTRADO");
            } 
            // Verifica se a senha de input está igual a senha cadastrada
            else if(!user.getEmail().equals(email.getText()) || !user.getSenha().equals(senha.getText())){
                invalid_login.setText("Login inválido!");
            } 
            // Limpeza dos campos
            else {
                email.setText("");
                senha.setText("");
                invalid_login.setText("");
            }
        }
        // Cancelar na página de registro
        else if(e.getSource() == cancel){
            // Reset dos campos de texto
            register_cpf.setText("");
            register_email.setText("");
            register_matricula.setText("");
            register_senha.setText("");
            register_nome.setText("");

            // Atualização da página
            updatePage(register_page,first_page);
        }
        // Finalizar na pagina de registro
        else if(e.getSource() == complete){
            // Verifica a existência de campos vazios
            if(
                !register_email.getText().isEmpty() &&
                !register_senha.getText().isEmpty() &&
                !register_cpf.getText().isEmpty() &&
                !register_nome.getText().isEmpty() &&
                !register_matricula.getText().isEmpty()
            ){
                // Reset dos campos
                profile_name.setText("");
                profile_matricula.setText("");
                profile_cpf.setText("");
                profile_email.setText("");
                profile_senha.setText("");
                error.setText("");

                // Adição de usuário
                setUser(new Usuario());
                user.setEmail(register_email.getText());
                user.setSenha(register_senha.getText());
                user.setMatricula(register_matricula.getText());
                user.setNome(register_nome.getText());
                user.setCPF(register_cpf.getText());
                
                // Visualização dos dados
                profile_name.setText("Nome completo: "+user.getNome());
                profile_matricula.setText("Matricula: "+user.getMatricula());
                profile_cpf.setText("CPF: "+user.getCPF());
                profile_email.setText("Email: "+user.getEmail());
                profile_senha.setText("Senha: "+user.getSenha());
                profile_page.pack();

                // Atualização da página
                updatePage(register_page,profile_page);
            } else {
                error.setText("Preencha os campos vazios!");
            }
        }
        // Voltar na página de perfil
        else if(e.getSource() == back){
            // Reset dos campos
            email.setText("");
            senha.setText("");
            // Atualização da página
            updatePage(profile_page,first_page);
        }
        // Fechar na página de perfil
        else if(e.getSource() == close){
            System.exit(0);
        }
    }
}

public class Main {
    public static void main(String[] args){
        new GUI();
    } 
}