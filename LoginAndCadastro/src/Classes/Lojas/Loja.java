/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Lojas;

import classes_de_conexao.Conexao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import telaAdmin.CadastrarLoja;
import telaAdmin.ListarLojasCadastradas;
import telaAdmin.RemoverLojas;

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
    public Loja() {
    }

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

            if (rs.next()) {
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

                if (confirma == 1) {
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

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Alguma coisa não ocorreu como o previsto, tente mais tarde :( ");
        }
    }

    public void listarLoja(ListarLojasCadastradas listarLojasCadastradasFrame) {

        try {

            Connection con = Conexao.faz_conexao();
//             
            String sql = "SELECT * FROM dados_lojas";

            PreparedStatement stmt = con.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = stmt.executeQuery();

            //lista para armazenar as lojas
            ArrayList<Loja> lojas = new ArrayList<>();
            int currentIndex = -1;

            if (rs.next()) {

                listarLojasCadastradasFrame.getTfIdLoja().setText(rs.getString("id"));
                listarLojasCadastradasFrame.getTfNomeLoja().setText(rs.getString("nome"));
                listarLojasCadastradasFrame.getTfCnpjLoja().setText(rs.getString("cnpj"));
                listarLojasCadastradasFrame.getTfLocalizacaoLoja().setText(rs.getString("localizacao"));

//              ****************************************para mostrar a imagem ******************************************************
                Blob blob = (Blob) rs.getBlob("imagem");
                byte[] img = blob.getBytes(1, (int) blob.length());
                BufferedImage imagem = null;
                try {
                    imagem = ImageIO.read(new ByteArrayInputStream(img));
                } catch (Exception e) {
                    System.out.println(e);
                }

                ImageIcon icone = new ImageIcon(imagem);
                Icon foto = new ImageIcon(icone.getImage().getScaledInstance(listarLojasCadastradasFrame.getLblFoto().getWidth(),
                        listarLojasCadastradasFrame.getLblFoto().getHeight(), Image.SCALE_SMOOTH));
                listarLojasCadastradasFrame.getLblFoto().setIcon(foto);
//              ********************************************************************************************************************

            }

            listarLojasCadastradasFrame.getListarLojaBtnProximo().addActionListener(e -> {

                try {

                    if (rs.next()) {
                        atualizarInterface(listarLojasCadastradasFrame, rs);
                    } else {
                        JOptionPane.showMessageDialog(null, "aqui é um aviso para mostrar que estou muito"
                                + " coringado nesta parte e implorando por sanidade"
                                + " mental, e que não tem mais lojas para aparecer.");
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            });

            listarLojasCadastradasFrame.getListarLojaBtnVoltar().addActionListener(e -> {

                try {

                    if (rs.previous()) {
                        atualizarInterface(listarLojasCadastradasFrame, rs);
                    } else {
                        JOptionPane.showMessageDialog(null, "aqui é um aviso para mostrar que estou muito"
                                + " coringado nesta parte e implorando por sanidade"
                                + " mental, e que não tem mais lojas para aparecer.");
                    }

                } catch (SQLException exyz) {
                    System.out.println(exyz);
                }

            });

        } catch (SQLException e) {

            e.printStackTrace();

        }

        listarLojasCadastradasFrame.setVisible(true);
        listarLojasCadastradasFrame.pack();
        listarLojasCadastradasFrame.setLocationRelativeTo(null); // Para abrir sempre no centro da tela
    }

    private void atualizarInterface(ListarLojasCadastradas listarLojasCadastradasFrame, ResultSet rs) {
        try {
            // Atualiza os campos com os dados do ResultSet
            listarLojasCadastradasFrame.getTfIdLoja().setText(rs.getString("id"));
            listarLojasCadastradasFrame.getTfNomeLoja().setText(rs.getString("nome"));
            listarLojasCadastradasFrame.getTfCnpjLoja().setText(rs.getString("cnpj"));
            listarLojasCadastradasFrame.getTfLocalizacaoLoja().setText(rs.getString("localizacao"));

            // Para mostrar a imagem
            Blob blob = (Blob) rs.getBlob("imagem");
            byte[] img = blob.getBytes(1, (int) blob.length());
            BufferedImage imagem = null;
            try {
                imagem = ImageIO.read(new ByteArrayInputStream(img));
            } catch (Exception ex) {
                System.out.println(ex);
            }

            ImageIcon icone = new ImageIcon(imagem);
            Icon foto = new ImageIcon(icone.getImage().getScaledInstance(
                    listarLojasCadastradasFrame.getLblFoto().getWidth(),
                    listarLojasCadastradasFrame.getLblFoto().getHeight(),
                    Image.SCALE_SMOOTH));
            listarLojasCadastradasFrame.getLblFoto().setIcon(foto);

        } catch (SQLException ex) {
            ex.printStackTrace();
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
