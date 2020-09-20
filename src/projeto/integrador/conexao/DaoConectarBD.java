/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.conexao;


import java.sql.*;


/**
 *
 * @author Leonardo
 */
public class DaoConectarBD {

    private VoConexao voConexao;
    private Connection conexao;

    private DaoConectarBD(VoConexao voConexao, Connection conexao) {
        this.voConexao = voConexao;
        this.conexao = conexao;
    }

    public DaoConectarBD() throws SGBDException, ClassNotFoundException, SQLException {
       this(null, null);
    }

    public Connection conectar() throws SGBDException, ClassNotFoundException, SQLException {
        // pegar configuração padrão
        this.voConexao = new DaoStringConexaoPostgres().getConfiguracaoAlternativa();

        // testa dados da conexão, se não existem gera exceção
        if ((this.getVoConexao() == null) || (this.getVoConexao().getBaseDados() == null) || (this.getVoConexao().getHost() == null) || (this.getVoConexao().getPorta() == null) || (this.getVoConexao().getSenha() == null) || (this.getVoConexao().getSgbd() == null) || (this.getVoConexao().getUsuario() == null)) {
            throw new SGBDException("Não foi possível conectar com o SGBD com as" +
                    " informações " + this.getVoConexao());
        }

        // realiza conexão e carrega driver
        DaoStringConexao conexaoConfig = new DaoStringConexaoPostgres();

        // pega configuração da conexao
        String url = conexaoConfig.getStringConexao(this.getVoConexao());

        // carrega o Driver
        Class.forName(this.getVoConexao().getClassDriver());

        // faz a conexao com o SGBD
        conexao = DriverManager.getConnection(url,
                this.getVoConexao().getUsuario(),
                this.getVoConexao().getSenha());
        conexao.setAutoCommit(false);

        // retorna conexao
        return conexao;
    }

    public void desConectar() throws SQLException {
        conexao.close();
    }

    public VoConexao getVoConexao() {
        return voConexao;
    }

    public void setVoConexao(VoConexao voConexao) {
        this.voConexao = voConexao;
    }

    public Connection getConexao() {
        return conexao;
    }
}
