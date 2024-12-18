/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaAdmin;

import classes_de_conexao.Conexao;

import Classes.Lojas.Loja;
import classes_de_conexao.Conexao;
import loginandcadastro.Login;
import loginandcadastro.LoginAndCadastro;
import classes_de_conexao.Conexao;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import telaLojista.TelaDoLojista;

/**
 *
 * @author Ramon Souza
 */
public class ListarLojasCadastradas extends javax.swing.JFrame {

    private boolean verifica;

    public boolean isVerifica() {
        return verifica;
    }

    public void setVerifica(boolean verifica) {
        this.verifica = verifica;
    }

    /**
     * Creates new form ListarLojasCadastradas
     */
    public ListarLojasCadastradas() {
        initComponents();
        
    }

    public ListarLojasCadastradas(boolean verificacao) {
        initComponents();
        this.verifica = verificacao;
        System.out.println("Esse eh a verificacao do listar Lojas: " + verifica);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfLocalizacaoLoja = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNomeLoja = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfIdLoja = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCnpjLoja = new javax.swing.JTextField();
        listarLojaBtnProximo = new javax.swing.JButton();
        listarLojaBtnVoltar = new javax.swing.JButton();
        btnCadastrarProduto = new javax.swing.JButton();
        btnListarProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar Lojas Cadastradas");
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        Left.setBackground(new java.awt.Color(234, 29, 44));
        Left.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramon Souza\\Documents\\NetBeansProjects\\LoginAndCadastro\\src\\Icon\\logo250x250-removebg-preview.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("copyright © RSFOOD Todos os direitos reservados");

        voltar.setForeground(new java.awt.Color(234, 29, 44));
        voltar.setText("Voltar");
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltar))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 340, 620);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(560, 600));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 500));

        lblFoto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramon Souza\\Downloads\\camera.png")); // NOI18N
        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setText("Nome da Loja:");

        tfLocalizacaoLoja.setEditable(false);

        jLabel5.setText("Localização da Loja:");

        tfNomeLoja.setEditable(false);

        jLabel6.setText("id da Loja:");

        tfIdLoja.setEditable(false);

        jLabel7.setText("CNPJ da Loja:");

        tfCnpjLoja.setEditable(false);

        listarLojaBtnProximo.setText("❯");
        listarLojaBtnProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listarLojaBtnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarLojaBtnProximoActionPerformed(evt);
            }
        });

        listarLojaBtnVoltar.setText("❮");
        listarLojaBtnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCadastrarProduto.setBackground(new java.awt.Color(51, 153, 0));
        btnCadastrarProduto.setText("Cadastrar Produtos");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });

        btnListarProduto.setBackground(new java.awt.Color(51, 153, 255));
        btnListarProduto.setText("Listar Produtos");
        btnListarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listarLojaBtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnListarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(listarLojaBtnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(tfIdLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCnpjLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfLocalizacaoLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tfNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCnpjLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLocalizacaoLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listarLojaBtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listarLojaBtnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );

        jPanel4.add(jPanel3);

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(340, 0, 560, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        
        

        if (verifica == false) {
            telaDoAdministrador adminFrame = new telaDoAdministrador();
            adminFrame.setVisible(true);
            adminFrame.pack();
            adminFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
            this.dispose();

            System.out.println("eh adm");

        } else if (verifica == true) {

            System.out.println("Eh lojista");

            Login lojistaFrame = new Login();
            lojistaFrame.setVisible(true);
            lojistaFrame.pack();
            lojistaFrame.setLocationRelativeTo(null); // Para abrir sempre no centro da tela
            this.dispose();
        }
    }//GEN-LAST:event_voltarActionPerformed

    private void listarLojaBtnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarLojaBtnProximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listarLojaBtnProximoActionPerformed

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        // TODO add your handling code here:

        CadastrarProduto cadastrarProdutoFrame = new CadastrarProduto(verifica);
        
        cadastrarProdutoFrame.setVerificar(verifica);

        cadastrarProdutoFrame.setIdDaLoja(Integer.parseInt(tfIdLoja.getText()));

        cadastrarProdutoFrame.setVisible(true);
        cadastrarProdutoFrame.pack();
        cadastrarProdutoFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
        this.dispose();


    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnListarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProdutoActionPerformed
        // TODO add your handling code here:
        ListarProdutosCadastrados listarProdutoFrame = new ListarProdutosCadastrados(verifica);
        
        listarProdutoFrame.setVerify(verifica);
        
        CadastrarProduto cadastrarProduto = new CadastrarProduto();
        
        

        System.out.println(tfIdLoja.getText());

        try {

            Connection con = Conexao.faz_conexao();

            String sql = "SELECT * FROM dados_produtos WHERE id_loja = ?";

            PreparedStatement stmt = con.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            stmt.setInt(1, Integer.parseInt(tfIdLoja.getText()));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                listarProdutoFrame.getTfIdProduto().setText(rs.getString("id_produto"));
                listarProdutoFrame.getTfNomeProduto().setText(rs.getString("nome_produto"));
                listarProdutoFrame.getTfPrecoDoProduto().setText(rs.getString("preco"));
                listarProdutoFrame.getTfDescricao().setText(rs.getString("descricao_produto"));
                listarProdutoFrame.getTfTempoDePreparo().setText(rs.getString("tempo_preparo"));

//              ****************************************para mostrar a imagem ******************************************************
                Blob blob = (Blob) rs.getBlob("imagem");
                byte[] img = blob.getBytes(1, (int) blob.length());
                BufferedImage imagem = null;
                try {
                    imagem = ImageIO.read(new ByteArrayInputStream(img));
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo");
                }

                ImageIcon icone = new ImageIcon(imagem);
                Icon foto = new ImageIcon(icone.getImage().getScaledInstance(listarProdutoFrame.getLblFoto3().getWidth(),
                        listarProdutoFrame.getLblFoto3().getHeight(), Image.SCALE_SMOOTH));
                listarProdutoFrame.getLblFoto3().setIcon(foto);
//              ********************************************************************************************************************
            }

            listarProdutoFrame.getListarProdutoBtnProximo().addActionListener(e -> {

                try {

                    if (rs.next()) {
                        atualizarInterface(listarProdutoFrame, rs);
                    } else {
                        JOptionPane.showMessageDialog(null, "aqui é um aviso para mostrar que estou muito"
                                + " coringado nesta parte e implorando por sanidade"
                                + " mental, e que não tem mais lojas para aparecer.");
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            });

            listarProdutoFrame.getListarProdutoBtnAnterior().addActionListener(e -> {

                try {

                    if (rs.previous()) {
                        atualizarInterface(listarProdutoFrame, rs);
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
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo");
        }

        listarProdutoFrame.setVisible(true);
        listarProdutoFrame.pack();
        listarProdutoFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
        this.dispose();
    }//GEN-LAST:event_btnListarProdutoActionPerformed

    private void atualizarInterface(ListarProdutosCadastrados listarProdutoFrame, ResultSet rs) {
        try {
            // Atualiza os campos com os dados do ResultSet
            listarProdutoFrame.getTfIdProduto().setText(rs.getString("id_produto"));
            listarProdutoFrame.getTfNomeProduto().setText(rs.getString("nome_produto"));
            listarProdutoFrame.getTfPrecoDoProduto().setText(rs.getString("preco"));
            listarProdutoFrame.getTfDescricao().setText(rs.getString("descricao_produto"));
            listarProdutoFrame.getTfTempoDePreparo().setText(rs.getString("tempo_preparo"));

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
                    listarProdutoFrame.getLblFoto3().getWidth(),
                    listarProdutoFrame.getLblFoto3().getHeight(),
                    Image.SCALE_SMOOTH));
            listarProdutoFrame.getLblFoto3().setIcon(foto);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarLojasCadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarLojasCadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarLojasCadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarLojasCadastradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarLojasCadastradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnListarProduto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JButton listarLojaBtnProximo;
    private javax.swing.JButton listarLojaBtnVoltar;
    private javax.swing.JTextField tfCnpjLoja;
    private javax.swing.JTextField tfIdLoja;
    private javax.swing.JTextField tfLocalizacaoLoja;
    private javax.swing.JTextField tfNomeLoja;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

    // Getter e Setter para tfCnpjLoja
    public javax.swing.JTextField getTfCnpjLoja() {
        return tfCnpjLoja;
    }

    public void setTfCnpjLoja(javax.swing.JTextField tfCnpjLoja) {
        this.tfCnpjLoja = tfCnpjLoja;
    }

    // Getter e Setter para tfIdLoja
    public javax.swing.JTextField getTfIdLoja() {
        return tfIdLoja;
    }

    public void setTfIdLoja(javax.swing.JTextField tfIdLoja) {
        this.tfIdLoja = tfIdLoja;
    }

    // Getter e Setter para tfLocalizacaoLoja
    public javax.swing.JTextField getTfLocalizacaoLoja() {
        return tfLocalizacaoLoja;
    }

    public void setTfLocalizacaoLoja(javax.swing.JTextField tfLocalizacaoLoja) {
        this.tfLocalizacaoLoja = tfLocalizacaoLoja;
    }

    // Getter e Setter para tfNomeLoja
    public javax.swing.JTextField getTfNomeLoja() {
        return tfNomeLoja;
    }

    public void setTfNomeLoja(javax.swing.JTextField tfNomeLoja) {
        this.tfNomeLoja = tfNomeLoja;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JButton getListarLojaBtnProximo() {
        return listarLojaBtnProximo;
    }

    public void setListarLojaBtnProximo(JButton listarLojaBtnProximo) {
        this.listarLojaBtnProximo = listarLojaBtnProximo;
    }

    public JButton getListarLojaBtnVoltar() {
        return listarLojaBtnVoltar;
    }

    public void setListarLojaBtnVoltar(JButton listarLojaBtnVoltar) {
        this.listarLojaBtnVoltar = listarLojaBtnVoltar;
    }

}
