/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.GUI.panel.panelmenuprinc;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import projeto.integrador.CarregaIMG;
import static projeto.integrador.animation.TAnimation.jSlidingPanel1;
import projeto.integrador.util.JSlidingPanel;
import projeto.integrador.util.URoundButton;




/**
 *
 * @author Rafael dal Prá
 * Data: 25/04/2015
 */
public class JpMenuPrinc extends javax.swing.JPanel {

   
    
    public JpMenuPrinc() {
        
        initComponents();
        
        /* Objeto que carrega as imagens da tela*/
        CarregaIMG charge = new CarregaIMG();
        
        Image ImgBorder = charge.loadImage("image/lateral.png");
        Icon iCantos = new ImageIcon(ImgBorder);
        
        Image imgMenu = charge.loadImage("image/fundocovid.png");
        Icon iMenu = new ImageIcon(imgMenu);

        Image imgIntra = charge.loadImage("image/siringa.png");
        Icon iIntraLog = new ImageIcon(imgIntra);
        
        Image imgConfig = charge.loadImage("image/icon_config.png");
        Icon iConfig = new ImageIcon(imgConfig);
        
        Image imgExit = charge.loadImage("image/exit.png");
        Icon iExit = new ImageIcon(imgExit);

        
        URoundButton btIntra =  new URoundButton();
        btIntra.setIcon(iIntraLog);
        btIntra.setBounds(1105, 307, 170, 170);
        btIntra.addActionListener((ActionEvent event) -> {

            jSlidingPanel1.setDirectionMove(JSlidingPanel.MOVE_LEFT);
            jSlidingPanel1.next(1);
            
        });
        
        
        URoundButton rbModuloExit = new URoundButton();
        rbModuloExit.setIcon(iExit);
        rbModuloExit.setBounds(311, 672, 130, 130);
        rbModuloExit.addActionListener((ActionEvent e) ->{
            
            exit();
        });
        
        URoundButton rbModuloHelp = new URoundButton();
        
        rbModuloHelp.setBounds(394, 498, 81, 81);
        rbModuloHelp.addActionListener((ActionEvent e) ->{

        });
        
        URoundButton rbConfig = new URoundButton();
        rbConfig.setBounds(457, 90, 81, 81);
        rbConfig.setIcon(iConfig);
        rbConfig.addActionListener((ActionEvent event) -> {

        });
        
        URoundButton rbMapa = new URoundButton();
        rbMapa.setBounds(457, 90, 81, 81);
        
        rbMapa.addActionListener((ActionEvent event) -> {

        });
        
        
        jLMenuCenter.setBackground(new Color(197, 197, 197));
        jLMenuCenter.add(btIntra);
        jLMenuCenter.add(rbModuloExit);
        
        jLBEast.setIcon(iCantos);
        jLBWest.setIcon(iCantos);
        
        jLMenuCenter.setIcon(iMenu);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLBWest = new javax.swing.JLabel();
        jLBEast = new javax.swing.JLabel();
        jLMenuCenter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(197, 197, 197));
        setMaximumSize(new java.awt.Dimension(2560, 1080));
        setPreferredSize(new java.awt.Dimension(1981, 1050));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLBWest, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLMenuCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 1601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLBEast, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLBEast, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                        .addComponent(jLBWest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLMenuCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void exit(){
        
        JFrame topFrame1 = (JFrame) SwingUtilities.getWindowAncestor(JpMenuPrinc.this);
        
        int i = JOptionPane.showConfirmDialog(topFrame1, "Deseja realmente sair do sistema?","ATENÇÃO", JOptionPane.OK_CANCEL_OPTION);
        
        if(i == JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLBEast;
    private javax.swing.JLabel jLBWest;
    private javax.swing.JLabel jLMenuCenter;
    // End of variables declaration//GEN-END:variables
}
