/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaAdmin;

import Classes.Loja;
import classes_de_conexao.Conexao;
import com.mysql.cj.jdbc.Blob;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Ramon Souza
 */
public class CadastrarLoja extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarLoja
     */
    public CadastrarLoja() {
        initComponents();
    }

    // instanciar o objeto para o fluxo de bytes
    private FileInputStream fis;
    
    //variavel global para armazenar tamanho da imagem (bytes)
    private int tamanho;    
    
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
        Right = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNomeDaLoja = new javax.swing.JTextField();
        tfCnpj = new javax.swing.JTextField();
        tfLocalizacao = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnCarregar = new javax.swing.JButton();
        btnCadastrarLoja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));
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
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltar)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 340, 500);

        Right.setBackground(new java.awt.Color(244, 244, 244));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(234, 29, 44));
        jLabel4.setText("Cadastrar Lojas");

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nome da Loja");

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("CNPJ");

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Localização");

        tfNomeDaLoja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNomeDaLoja.setForeground(new java.awt.Color(102, 102, 102));
        tfNomeDaLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeDaLojaActionPerformed(evt);
            }
        });

        tfCnpj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCnpj.setForeground(new java.awt.Color(102, 102, 102));
        tfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCnpjActionPerformed(evt);
            }
        });

        tfLocalizacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfLocalizacao.setForeground(new java.awt.Color(102, 102, 102));
        tfLocalizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLocalizacaoActionPerformed(evt);
            }
        });

        lblFoto.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ramon Souza\\Downloads\\camera.png")); // NOI18N
        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnCarregar.setForeground(new java.awt.Color(51, 102, 255));
        btnCarregar.setText("Carregar foto");
        btnCarregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarActionPerformed(evt);
            }
        });

        btnCadastrarLoja.setBackground(new java.awt.Color(51, 153, 0));
        btnCadastrarLoja.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarLoja.setText("Cadastrar Loja");
        btnCadastrarLoja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarLojaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel4))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(tfNomeDaLoja)
                                    .addComponent(tfCnpj)
                                    .addComponent(tfLocalizacao, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addContainerGap(65, Short.MAX_VALUE)
                                .addComponent(btnCadastrarLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(112, 112, 112)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCarregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnCarregar))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(tfNomeDaLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(tfLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCadastrarLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel1.add(Right);
        Right.setBounds(310, 0, 730, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeDaLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeDaLojaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeDaLojaActionPerformed

    private void tfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCnpjActionPerformed

    private void tfLocalizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLocalizacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLocalizacaoActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        telaDoAdministrador adminFrame = new telaDoAdministrador();
        adminFrame.setVisible(true);
        adminFrame.pack();
        adminFrame.setLocationRelativeTo(null); // para abrir sempre no centro da tela
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
        // TODO add your handling code here:
        
        carregarFoto();
        
    }//GEN-LAST:event_btnCarregarActionPerformed

    private void btnCadastrarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarLojaActionPerformed
        // TODO add your handling code here:
         if(tfNomeDaLoja.getText().equals("") || tfCnpj.getText().equals("") || tfLocalizacao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos :)");
        } else {
             
             Loja loja = new Loja(tfNomeDaLoja.getText(), tfLocalizacao.getText(), tfCnpj.getText(), fis, tamanho);
             loja.cadastrarLoja();
             tfNomeDaLoja.setText("");
             tfLocalizacao.setText("");
             tfCnpj.setText("");
             
             lblFoto.setIcon(new ImageIcon(CadastrarLoja.class.getResource("/icon/camera.png")));
             
        }
    }//GEN-LAST:event_btnCadastrarLojaActionPerformed

    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(CadastrarLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarLoja().setVisible(true);
            }
        });
    }
    
    private void carregarFoto() {
        
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("AINNN SELECIONA A FOTINHANN");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int resultado = jfc.showOpenDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION) {
            // para armazenar o arquivo na variavel tamanho
            try {
                fis = new FileInputStream(jfc.getSelectedFile());
                tamanho = (int) jfc.getSelectedFile().length();
                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(foto));
                lblFoto.updateUI();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton btnCadastrarLoja;
    private javax.swing.JButton btnCarregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField tfCnpj;
    private javax.swing.JTextField tfLocalizacao;
    private javax.swing.JTextField tfNomeDaLoja;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables



public JTextField getTfNomeDaLoja() {
        return tfNomeDaLoja;
    }

    public void setTfNomeDaLoja(JTextField tfNomeDaLoja) {
        this.tfNomeDaLoja = tfNomeDaLoja;
    }

    // Getter e Setter para tfLocalizacao
    public JTextField getTfLocalizacao() {
        return tfLocalizacao;
    }

    public void setTfLocalizacao(JTextField tfLocalizacao) {
        this.tfLocalizacao = tfLocalizacao;
    }

    // Getter e Setter para tfCnpj
    public JTextField getTfCnpj() {
        return tfCnpj;
    }

    public void setTfCnpj(JTextField tfCnpj) {
        this.tfCnpj = tfCnpj;
    }

    // Getter e Setter para fis (InputStream)
    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    // Getter e Setter para tamanho (long)
    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }


}
