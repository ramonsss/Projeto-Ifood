/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import classes_de_conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import telaAdmin.CadastrarLoja;
import telaAdmin.telaDoAdministrador;
import telaLojista.TelaDoLojista;
import telaUsuario.telaDoUsuario;

/**
 *
 * @author Ramon Souza
 */
public class Acoes extends javax.swing.JFrame {

    private int id;
    private String usuario;
    private String email;
    private String cep;
    private String senha;
    private boolean valorBooleano;

    public Acoes(int id) {

        this.id = id;

    }

    public Acoes(String email, String senha) {

        this.email = email;
        this.senha = senha;

    }

    public Acoes(String usuario, String email, String cep, String senha, boolean valorBooleano) {

        this.usuario = usuario;
        this.email = email;
        this.cep = cep;
        this.senha = senha;
        this.valorBooleano = valorBooleano;

    }

    public void cadastrar() {
        try {
            // Conecta ao banco de dados
            Connection con = Conexao.faz_conexao();

            // Verifica se o email já existe no banco de dados
            String sqlVerificaEmail = "SELECT email FROM dados_senhas WHERE email = ?";
            PreparedStatement stmtVerifica = con.prepareStatement(sqlVerificaEmail);
            stmtVerifica.setString(1, email);
            ResultSet rs = stmtVerifica.executeQuery();

            if (rs.next()) {
                // Email já cadastrado
                JOptionPane.showMessageDialog(null, "Este email já está cadastrado!");
                email = "";
            } else {
                // Insere o novo cadastro
                String sqlInserir = "INSERT INTO dados_senhas(usuario, senha, email, cep, isDonoVer) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmtInserir = con.prepareStatement(sqlInserir);

                stmtInserir.setString(1, usuario);
                stmtInserir.setString(2, senha);
                stmtInserir.setString(3, email);
                stmtInserir.setString(4, cep);
                stmtInserir.setBoolean(5, valorBooleano);

                stmtInserir.execute();

                JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso! Volte para o Login");

                // Limpa os campos
                usuario = "";
                senha = "";
                email = "";
                cep = "";

                stmtInserir.close();
            }

            // Fecha a conexão e o statement de verificação
            rs.close();
            stmtVerifica.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Alguma coisa não ocorreu como o previsto, tente mais tarde :( ");
        }
    }

    public void esqueceuSenha() {

        try {

            Connection con = Conexao.faz_conexao();

            // Verificar se o e-mail existe no banco de dados
            String sqlCheck = "SELECT * FROM dados_senhas WHERE email = ?";
            PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
            stmtCheck.setString(1, email);
            ResultSet rs = stmtCheck.executeQuery();

            if (rs.next()) {  // Se o e-mail for encontrado
                // E-mail encontrado, proceder com a atualização da senha
                String sqlUpdate = "UPDATE dados_senhas SET senha = ? WHERE email = ?";
                PreparedStatement stmtUpdate = con.prepareStatement(sqlUpdate);
                stmtUpdate.setString(1, senha);
                stmtUpdate.setString(2, email);

                stmtUpdate.executeUpdate();
                stmtUpdate.close();
                JOptionPane.showMessageDialog(null, "Sua senha foi redefinida com sucesso!");

                // Limpa os campos
                email = "";
                senha = "";
            } else {
                // E-mail não encontrado no banco de dados
                JOptionPane.showMessageDialog(null, "E-mail não encontrado. Verifique o e-mail e tente novamente.");
            }

            stmtCheck.close();
            con.close();

        } catch (SQLException el) {
            el.printStackTrace();
        }

    }


    private boolean verify = true;

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public void login() {

        try {

            Connection con = Conexao.faz_conexao();

            String sql = "select * from dados_senhas where email = ? and senha = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");

                // Verifica se o login é do admin
                String usuario = rs.getString("usuario");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                // Verifica se o login é do Lojista
                boolean verificaLojista = rs.getBoolean("isDonoVer");

                // AQUI EH A VERIFICAÇÃO, SE O LOGIN POSTO FOR O DO ADMIN EH PARA ABRIR MINHA CLASSE ADMIN
                if ("admin@admin.com".equals(email) && "admin123".equals(senha)) {

                    verify = false;

                    telaDoAdministrador adminFrame = new telaDoAdministrador();

                    adminFrame.setVerificacaoAdm(verify);

                    adminFrame.setVisible(true);
                    adminFrame.pack();
                    adminFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
                } // AQUI EH A VERIFICAÇÃO, SE O LOGIN POSTO FOR O DO LOJISTA EH PARA ABRIR MINHA CLASSE LOJISTA
                else if (verificaLojista) {

                    verify = true;

                    

                    TelaDoLojista lojistaFrame = new TelaDoLojista(verify, id);
                    
                    
                    lojistaFrame.setIdDoUsuario(id); 
                    
                    lojistaFrame.setVerificacao(verify);
                    

                    // SQL para pegar o nome do lojista pelo ID
                    String sqlNome = "SELECT usuario FROM dados_senhas WHERE id = ?";
                    PreparedStatement stmtNome = con.prepareStatement(sqlNome);

                    // Passa o ID do lojista para a consulta
                    stmtNome.setInt(1, id);  // Usa o usuarioId obtido anteriormente

                    ResultSet rsNome = stmtNome.executeQuery();

                    String nomeLojista = null;

                    // Verifica se o nome do lojista foi recuperado com sucesso
                    if (rsNome.next()) {
                        nomeLojista = rsNome.getString("usuario");  // Recupera o nome do lojista
                    }

                    stmtNome.close();  // Fecha a consulta

                    // Passando o nome do lojista para a tela
                    lojistaFrame.setLblMostrarNomeLojista(nomeLojista);  // Passando o nome para o JLabel da tela do lojista

                    // Exibe a tela do lojista
                    lojistaFrame.setVisible(true);
                    lojistaFrame.pack();
                    lojistaFrame.setLocationRelativeTo(null); // Para abrir sempre no centro da tela
                } // AQUI EH A VERIFICAÇÃO, SE O LOGIN POSTO FOR O DO USUARIO EH PARA ABRIR MINHA CLASSE USUARIO
                else {
                    telaDoUsuario usuarioFrame = new telaDoUsuario();
                    usuarioFrame.setVisible(true);
                    usuarioFrame.pack();
                    usuarioFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
                }

                

            } else {
                JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto");
            }

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
