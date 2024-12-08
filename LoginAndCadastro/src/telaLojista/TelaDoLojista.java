/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaLojista;

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
import javax.swing.JTextField;
import loginandcadastro.Login;
import telaAdmin.CadastrarLoja;
import telaAdmin.ListarLojasCadastradas;
import telaAdmin.RemoverLojas;

/**
 *
 * @author Ramon Souza
 */
public class TelaDoLojista extends javax.swing.JFrame {

    private boolean verificacao;

    public boolean isVerificacao() {
        return verificacao;
    }

    public void setVerificacao(boolean verificacao) {
        this.verificacao = verificacao;
    }
    
    
    
    
    /**
     * Creates new form telaDoLojista
     */
    public TelaDoLojista() {
        initComponents();
        getGetIdDoUsuarioLogado();
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
        jLabel4 = new javax.swing.JLabel();
        lblMostrarNomeLojista = new javax.swing.JTextField();
        lblMostrarNomeLojista1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Lojista");
        setPreferredSize(new java.awt.Dimension(900, 500));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(voltar))
                .addGap(19, 19, 19))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(99, 99, 99)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 340, 500);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 500));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(234, 29, 44));
        jLabel4.setText("Seja Bem Vindo");

        lblMostrarNomeLojista.setEditable(false);
        lblMostrarNomeLojista.setBackground(new java.awt.Color(255, 255, 255));
        lblMostrarNomeLojista.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMostrarNomeLojista.setForeground(new java.awt.Color(234, 29, 44));
        lblMostrarNomeLojista.setBorder(null);

        lblMostrarNomeLojista1.setEditable(false);
        lblMostrarNomeLojista1.setBackground(new java.awt.Color(255, 255, 255));
        lblMostrarNomeLojista1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMostrarNomeLojista1.setForeground(new java.awt.Color(234, 29, 44));
        lblMostrarNomeLojista1.setText("!");
        lblMostrarNomeLojista1.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Ações")));

        jButton3.setBackground(new java.awt.Color(225, 81, 92));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cadastrar Lojas");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(225, 81, 92));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Listar Lojas Cadastradas");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(225, 81, 92));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remover Lojas Cadastradas");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMostrarNomeLojista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMostrarNomeLojista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblMostrarNomeLojista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMostrarNomeLojista1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(340, 0, 540, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int getIdDoUsuarioLogado;

    public int getGetIdDoUsuarioLogado() {
        return getIdDoUsuarioLogado;
    }

    public void setGetIdDoUsuarioLogado(int getIdDoUsuarioLogado) {
        this.getIdDoUsuarioLogado = getIdDoUsuarioLogado;
    }


    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        System.out.println("Este eh o valor da verificação quando entro na tela do Lojista:" + isVerificacao());
        
        
        CadastrarLoja cadastrarLojaFrame = new CadastrarLoja();
        cadastrarLojaFrame.setVisible(true);
        cadastrarLojaFrame.pack();
        cadastrarLojaFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        listarLojas();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        RemoverLojas RemoverLojas = new RemoverLojas();
        RemoverLojas.setVisible(true);
        RemoverLojas.pack();
        RemoverLojas.setLocationRelativeTo(null); // para abrir sempre no centro da tela
        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    
    
    
    public void listarLojas() {

        ListarLojasCadastradas listarLojasCadastradasFrame = new ListarLojasCadastradas();

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
        this.dispose();

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
            java.util.logging.Logger.getLogger(TelaDoLojista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDoLojista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDoLojista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDoLojista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDoLojista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lblMostrarNomeLojista;
    private javax.swing.JTextField lblMostrarNomeLojista1;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

    public JTextField getLblMostrarNomeLojista() {
        return lblMostrarNomeLojista;
    }

    public void setLblMostrarNomeLojista(String nomeLojista) {
        lblMostrarNomeLojista.setText(nomeLojista);  // Atualiza o texto do JLabel com o nome do lojista
    }

}