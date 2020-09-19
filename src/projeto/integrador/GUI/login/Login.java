
package projeto.integrador.GUI.login;

import projeto.integrador.CarregaIMG;
import projeto.integrador.animation.TAnimation;
import projeto.integrador.GUI.register.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


/**
 *
 * @author Rafael Dal Prá
 * Data: 25/04/2015
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     * @param x
     * @param y
     */
    public static String filial = "";
    public static String empresa = "";
    
    private JButton btConfig;
    public Login(int x, int y) {
        
        initComponents();
      
        CarregaIMG img = new CarregaIMG();
        Image ImgConfig = img.loadImage("image/config.png");
        Icon i = new ImageIcon(ImgConfig);

        btConfig = new JButton();
        btConfig.setBounds(410, 5, 40, 40);
        add(btConfig);
        btConfig.setIcon(i);
        btConfig.setBackground(new Color(147, 147, 147));
        btConfig.addActionListener((ActionEvent e) -> {

            
        });
        
        setLocation(x, y);/* Configura a localização da janela de login*/
        setTitle("SISTEMA COVID");/* Configura o titulo da janela de login*/
        getContentPane().setBackground(new Color(197, 197, 197));
        setResizable(false);/* Não redimencionavel*/
        
        jTTUser.requestFocus();

        /* Ouvinte de ação para o textfield do usuário que repassa o fóco para o textfield de senha*/
        jTTUser.addActionListener((ActionEvent e) -> {
            
            if(jTTUser.getText().equals(""))/* Se campo usuário vazio lança um erro*/
                JOptionPane.showMessageDialog(null, "CAMPO USUÁRIO VAZIO!", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            else/* Se não remete po fóco ao campo de senha*/
                jPFPass.requestFocus();

        });

        /* Ouvinte de ação para o textfield de senha que repassa o fóco para o botão de conectar*/
        jPFPass.addActionListener((ActionEvent e) -> {
            
            if(jLbPass.getText().equals(""))/* Se campo de senha vazio lança um erro*/
                JOptionPane.showMessageDialog(null, "CAMPO SENHA VAZIO!", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            else{/* Se não remete o fóco ao botão conectar*/
                
                jBCon.setEnabled(true);
                jBCon.doClick();
            }
        });

        jBCon.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),
                "none");
        jBExit.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),
                "none");
        jBCon.setEnabled(false);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbUser = new javax.swing.JLabel();
        jLbPass = new javax.swing.JLabel();
        jTTUser = new javax.swing.JTextField();
        jPFPass = new javax.swing.JPasswordField();
        jBExit = new javax.swing.JButton();
        jBCon = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(197, 197, 197));

        jLbUser.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLbUser.setText("Usuário:");

        jLbPass.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLbPass.setText("Senha:");

        jBExit.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jBExit.setText("Sair");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });
        jBExit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBExitKeyPressed(evt);
            }
        });

        jBCon.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jBCon.setText("Conectar");
        jBCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConActionPerformed(evt);
            }
        });
        jBCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBConKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton1.setText("Cadastrar-se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jBExit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jBCon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLbUser)
                            .addComponent(jLbPass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTTUser, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jPFPass)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPFPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbPass))
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExit)
                    .addComponent(jBCon))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        exit();
    }//GEN-LAST:event_jBExitActionPerformed

    private void jBConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConActionPerformed
       
        connect();
    }//GEN-LAST:event_jBConActionPerformed

    
    private void jBConKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBConKeyPressed

         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBCon.doClick();
        }
    }//GEN-LAST:event_jBConKeyPressed

    private void jBExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBExitKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBExit.doClick();
        }
    }//GEN-LAST:event_jBExitKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       register();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    
    /**
     * Método que encerra a aplicação
     */
    private void exit(){
        System.exit(0);
    }
    
    /**
     * Método que conecta a aplicação ao bando de dados
     */
    private void connect() {
//
//        CarregaIMG img = new CarregaIMG();
//        Image ImgConfig = img.loadImage("image/sistema1.png");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        int x = (int) dimension.getWidth();
        int y = (int) dimension.getHeight();

        Dimension di = new Dimension(1360, 760);
        
        int sizeX = (int) (x * 0.95);
        int sizeY = (int) (y * 0.90);
        
        TAnimation frame = new TAnimation();
        frame.setSize(sizeX, sizeY);
        frame.setMinimumSize(di);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        //frame.setIconImage(ImgConfig);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        setVisible(false);
        
    }
    private void register() {
//
//        CarregaIMG img = new CarregaIMG();
//        Image ImgConfig = img.loadImage("image/sistema1.png");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();/* Captura a dimensão da tela do computador*/
        int x = (int) ((dimension.getWidth() - 400) / 2);/* Define a largura da janela*/
        int y = (int) ((dimension.getHeight() - 300) / 2);/* Define a altura da janela*/

        Register register = new Register(x,y);

        register.setVisible(true);

        setVisible(false);

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCon;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLbPass;
    private javax.swing.JLabel jLbUser;
    private javax.swing.JPasswordField jPFPass;
    private javax.swing.JTextField jTTUser;
    // End of variables declaration//GEN-END:variables
}
