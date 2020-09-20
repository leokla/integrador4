/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto.integrador.conexao;


/**
 *
 * @author Leonardo
 */
public interface DaoStringConexao {

    public String getStringConexao(VoConexao vo);
    public VoConexao getConfiguracaoDefault();
    public VoConexao getConfiguracaoAlternativa();
}
