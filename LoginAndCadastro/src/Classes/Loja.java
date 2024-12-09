/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import classes_de_conexao.Conexao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import telaAdmin.CadastrarLoja;

/**
 *
 * @author Ramon Souza
 */
public class Loja {
    private String nome;
    private String localizacao;
    private String cnpj;
    private int id_usuario;
    
    private FileInputStream fis;
    private int tamanho;

    // Construtor
    public Loja(String nome, String localizacao, String cnpj, FileInputStream fis, int tamanho, int id_usuario) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.cnpj = cnpj;
        this.fis = fis;
        this.tamanho = tamanho;
        this.id_usuario = id_usuario;
    }
    
    
    public void cadastrarLoja() {
        try {
            // Conecta ao banco de dados
            Connection con = Conexao.faz_conexao();
            
            // Verifica se o email já existe no banco de dados
            String sqlVerificaCnpj = "SELECT cnpj FROM dados_lojas WHERE cnpj = ?";
            PreparedStatement stmtVerifica = con.prepareStatement(sqlVerificaCnpj);
            stmtVerifica.setString(1, cnpj);
            ResultSet rs = stmtVerifica.executeQuery();

            if(rs.next()) {
                // Cnpj já cadastrado
                JOptionPane.showMessageDialog(null, "Este cnpj já está cadastrado!");
                cnpj = "";
            } else {
                // Insere o novo cadastro
                String sqlInserir = "INSERT INTO dados_lojas(nome, cnpj, localizacao, imagem, quantidadeProdutos, id_usuario) VALUES (?, ?, ?, ?, 1, ?)";
                PreparedStatement stmtInserir = con.prepareStatement(sqlInserir);
                
                stmtInserir.setString(1, nome);
                stmtInserir.setString(2, cnpj);
                stmtInserir.setString(3, localizacao);
                stmtInserir.setBlob(4, fis, tamanho);
                stmtInserir.setInt(5, id_usuario);
                
                int confirma = stmtInserir.executeUpdate();
                
                if(confirma == 1) {
                    JOptionPane.showMessageDialog(null, "Loja cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar a loja :(");
                }

                

                // Limpa os campos
                nome = "";
                localizacao = "";
                cnpj = "";
                

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
    

    // Getters
    public String getlocalizacao() {
        return localizacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    
    // Getter para 'fis'
    public FileInputStream getFis() {
        return fis;
    }

    // Setter para 'fis'
    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    // Getter para 'tamanho'
    public long getTamanho() {
        return tamanho;
    }

    // Setter para 'tamanho'
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
   
}
