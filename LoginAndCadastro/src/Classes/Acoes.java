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

/**
 *
 * @author Ramon Souza
 */
public class Acoes {
    
    private int id;
    private String usuario;
    private String email;
    private String cep;
    private String senha;

    public Acoes(int id) {
        
        this.id = id;
        
    }

    public Acoes(String email, String senha) {
        
        this.email = email;
        this.senha = senha;
        
    }

    public Acoes(String usuario, String email, String cep, String senha) {
    
        this.usuario = usuario;
        this.email = email;
        this.cep = cep;
        this.senha = senha;
        
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

            if(rs.next()) {
                // Email já cadastrado
                JOptionPane.showMessageDialog(null, "Este email já está cadastrado!");
                email = "";
            } else {
                // Insere o novo cadastro
                String sqlInserir = "INSERT INTO dados_senhas(usuario, senha, email, cep) VALUES (?, ?, ?, ?)";
                PreparedStatement stmtInserir = con.prepareStatement(sqlInserir);
                
                stmtInserir.setString(1, usuario);
                stmtInserir.setString(2, senha);
                stmtInserir.setString(3, email);
                stmtInserir.setString(4, cep);

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

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Alguma coisa não ocorreu como o previsto, tente mais tarde :( ");
        }
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
