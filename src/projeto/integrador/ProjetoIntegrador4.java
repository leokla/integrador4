/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import projeto.integrador.GUI.login.Login;

/**
 *
 * @author Rafael
 */
public class ProjetoIntegrador4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            /* Define o estilo d elayout para Nimbus*/
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();/* Captura a dimensão da tela do computador*/
            int x = (int) ((dimension.getWidth() - 400) / 2);/* Define a largura da janela*/
            int y = (int) ((dimension.getHeight() - 300) / 2);/* Define a altura da janela*/
            Login login = new Login(x, y);/* Cria a tela de login*/
            login.setVisible(true);/* Deixa visivel a tela de login*/
            javax.swing.UIManager.put("OptionPane.font", new Font("SansSerif", Font.BOLD, 14));
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
