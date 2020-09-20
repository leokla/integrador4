/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.conexao;


/**
 *
 * @author Leonardo
 */
public class DaoStringConexaoPostgres implements DaoStringConexao {

    @Override
    public String getStringConexao(VoConexao vo) {
        // monta conexão
        String url = "jdbc:mysql://" + vo.getHost() +
                ":" + vo.getPorta() + "/" + vo.getBaseDados();

        //mostra conexao
        System.out.println(url);

        // retorna
        return url;
    }

    @Override
    public VoConexao getConfiguracaoDefault() {
        // cria objeto
        VoConexao vo = new VoConexao();

        // seta valores
        vo.setSgbd("PostgreSQL");
        vo.setHost("slinf30.ucs.br");
        vo.setPorta("5432");
        vo.setBaseDados("inf0211");
        vo.setUsuario("alunos");
        vo.setSenha("postgres");
        vo.setClassDriver("org.postgresql.Driver");

        // returns
        return vo;
    }

   /* @Override
    public VoConexao getConfiguracaoAlternativa() {
        // cria objeto
        VoConexao vo = new VoConexao();

        // seta valores
        vo.setSgbd("PostgreSQL");
        vo.setHost("localhost");
        vo.setPorta("5432");
        vo.setBaseDados("projetointegrador");
        vo.setUsuario("postgres");
        vo.setSenha("Teste405");
        vo.setClassDriver("org.postgresql.Driver");

        // returns
        return vo;
    }*/
    
     @Override
    public VoConexao getConfiguracaoAlternativa() {
        // cria objeto
        VoConexao vo = new VoConexao();

        //Seta valores
         vo.setSgbd("PostgreSQL");
         vo.setHost("windowsteste.cit5w3xssroz.us-east-1.rds.amazonaws.com");
         vo.setPorta("5432");
         vo.setBaseDados("postgres");
         vo.setUsuario("teste");
         vo.setSenha("SP17A50doc450");
         vo.setClassDriver("org.postgresql.Driver");


        // returns
        return vo;
    }

}