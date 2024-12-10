/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Classes.Usuario.Cliente;
import Classes.Usuario.DonoLoja;
import Classes.Usuario.Usuario;
import classes_de_conexao.Conexao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import telaAdmin.CadastrarLoja;
import telaAdmin.ListarLojasCadastradas;
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

    public Acoes() {
    }

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

                // Cria um objeto Cliente ou DonoLoja e adiciona ao ArrayList
                Usuario novoUsuario;
                if (valorBooleano) {
                    novoUsuario = new DonoLoja(usuario, senha, email, cep, valorBooleano);
                } else {
                    novoUsuario = new Cliente(usuario, senha, email, cep, valorBooleano);
                }
                Usuario.adicionarUsuarioAoArray(novoUsuario);

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
                
                
                Usuario usuarioLogado = null;
                

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

                    usuarioLogado = new DonoLoja(usuario, senha, email, rs.getString("cep"), verificaLojista);
                    
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

                    // Passando o nome do lojista para a tela
                    lojistaFrame.setLblMostrarNomeLojista(nomeLojista);  // Passando o nome para o JLabel da tela do lojista

                    // Exibe a tela do lojista
                    lojistaFrame.setVisible(true);
                    lojistaFrame.pack();
                    lojistaFrame.setLocationRelativeTo(null); // Para abrir sempre no centro da tela
                } // AQUI EH A VERIFICAÇÃO, SE O LOGIN POSTO FOR O DO USUARIO EH PARA ABRIR MINHA CLASSE USUARIO
                else {
                    
                    
                    usuarioLogado = new Cliente(usuario, senha, email, rs.getString("cep"), verificaLojista);
                    
                    telaDoUsuario usuarioFrame = new telaDoUsuario();

                    listarLojas(usuarioFrame);

                    usuarioFrame.setVisible(true);
                    usuarioFrame.pack();
                    usuarioFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto");
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void listarLojas(telaDoUsuario usuarioFrame) {

        try {

            Connection con = Conexao.faz_conexao();
//             
            String sql = "SELECT id, nome, localizacao, imagem FROM dados_lojas";

            PreparedStatement stmt = con.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuarioFrame.getTfIdLoja().setText(rs.getString("id"));
                usuarioFrame.getTfNomeLoja().setText(rs.getString("nome"));
                usuarioFrame.getTfLocalizacaoLoja().setText(rs.getString("localizacao"));

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
                Icon foto = new ImageIcon(icone.getImage().getScaledInstance(usuarioFrame.getLblFoto().getWidth(),
                        usuarioFrame.getLblFoto().getHeight(), Image.SCALE_SMOOTH));
                usuarioFrame.getLblFoto().setIcon(foto);
//              ********************************************************************************************************************

            }

            usuarioFrame.getListarLojaBtnProximo().addActionListener(e -> {

                try {

                    if (rs.next()) {
                        atualizarInterface(usuarioFrame, rs);
                    } else {
                        JOptionPane.showMessageDialog(null, "aqui é um aviso para mostrar que estou muito"
                                + " coringado nesta parte e implorando por sanidade"
                                + " mental, e que não tem mais lojas para aparecer.");
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            });

            usuarioFrame.getListarLojaBtnVoltar().addActionListener(e -> {

                try {

                    if (rs.previous()) {
                        atualizarInterface(usuarioFrame, rs);
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

        usuarioFrame.setVisible(true);
        usuarioFrame.pack();
        usuarioFrame.setLocationRelativeTo(null); // Para abrir sempre no centro da tela
        this.dispose();

    }

    private void atualizarInterface(telaDoUsuario usuarioFrame, ResultSet rs) {
        try {
            // Atualiza os campos com os dados do ResultSet
            usuarioFrame.getTfIdLoja().setText(rs.getString("id"));
            usuarioFrame.getTfNomeLoja().setText(rs.getString("nome"));
            usuarioFrame.getTfLocalizacaoLoja().setText(rs.getString("localizacao"));

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
                    usuarioFrame.getLblFoto().getWidth(),
                    usuarioFrame.getLblFoto().getHeight(),
                    Image.SCALE_SMOOTH));
            usuarioFrame.getLblFoto().setIcon(foto);

        } catch (SQLException ex) {
            ex.printStackTrace();
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
