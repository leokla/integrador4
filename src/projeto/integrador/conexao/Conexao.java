/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto.integrador.conexao;

import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class Conexao {
    private DaoConectarBD conexao;
    private DaoConsultarBD bd;

    public Conexao() {
    }

    public void conectar() throws SGBDException, ClassNotFoundException, SQLException{
        // testa se existe conexao
        if (this.getConexao() == null) {
            // cria conexao
            this.setConexao(new DaoConectarBD());
            
            // cria objeto de consulta
            this.setBd(new DaoConsultarBD(this.getConexao()));

            // conectar
            this.getConexao().conectar();
        }
    }

    public void desconectar() throws SQLException{
        this.getConexao().desConectar();
    }

    public DaoConectarBD getConexao() {
        return conexao;
    }

    private void setConexao(DaoConectarBD conexao) {
        this.conexao = conexao;
    }

    public DaoConsultarBD getBd() {
        return bd;
    }

    private void setBd(DaoConsultarBD bd) {
        this.bd = bd;
    }
}
