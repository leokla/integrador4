package projeto.integrador.DAO;

import projeto.integrador.ProjetoIntegrador4;
import projeto.integrador.conexao.Conexao;
import projeto.integrador.conexao.SGBDException;
import projeto.integrador.model.Post;
import projeto.integrador.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDAO {
    public boolean inserir(Post post){

        try {
            String sql;
                sql = "insert into post (iduser, conteudo)"
                        + " values (?, ?)";

                // obtem objeto
                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                // atribui valores
                ps.setInt(1, post.getUser().getId());
                ps.setString(2, post.getConteudo());

                // regrava no bd
                this.getConexao().getBd().executaSQL(ps);
        } catch (ClassNotFoundException | SQLException | SGBDException e) {
            // throw new CidadeException(e.getMessage());
        }

        // return, tudo certo ao salvar
        return true;
    }

    public Conexao getConexao() {
        return ProjetoIntegrador4.getConexao();
    }

}
