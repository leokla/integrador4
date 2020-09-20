/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import projeto.integrador.GUI.login.Login;
import projeto.integrador.conexao.Conexao;
import projeto.integrador.conexao.SGBDException;
import projeto.integrador.util.Progressbar;


public class ProjetoIntegrador4 {


    public static Conexao conexao;
    Login guiLogin;

    public ProjetoIntegrador4() {
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                 conexao= new Conexao();
                 conectar();
            }
        }).start();
        showGuiLogin();
       
        /**
         * Tratativa para não iniciar a tela com conexão null
         * 
         * TODO Colocar tratativa de tempo
         */
        do{ 
            Progressbar progressbar = new Progressbar();
            progressbar.createAndShowGUI((JFrame) guiLogin);
        }    
        while (conexao.getConexao() == null || conexao.getConexao().getConexao() == null);
        
        
    }

    private void showGuiLogin() {
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
            guiLogin = new Login(x, y);/* Cria a tela de login*/
            guiLogin.setVisible(true);/* Deixa visivel a tela de login*/
            UIManager.put("OptionPane.font", new Font("SansSerif", Font.BOLD, 14));

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public final void conectar() {
        try {
            conexao.conectar();
        } catch (SGBDException | ClassNotFoundException | SQLException ex) {
            // houve erro
            //System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this.guiLogin,
                    "Não foi possível estabelecer uma conexão com o banco de dados!"
                            + "\nO sistema será encerrado",
                    "Conexão com o Banco de Dados", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void desconectar() {
        try {
            // encerrar conexão
            conexao.desconectar();
            JOptionPane.showConfirmDialog(this.guiLogin,
                    "Conexão com o banco de dados foi encerrada com sucesso",
                    "Conexão com o SGBD", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this.guiLogin,
                    "Conexão com o banco de dados não foi encerrada com sucesso",
                    "Conexão com o SGBD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Conexao getConexao() {
        return conexao;
    }

    public static void setConexao(Conexao conexao) {
        ProjetoIntegrador4.conexao = conexao;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProjetoIntegrador4 pi4 = new ProjetoIntegrador4();
        //pi4.conectar();
        //

    }
    
}
