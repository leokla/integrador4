package projeto.integrador.DAO;

import projeto.integrador.ProjetoIntegrador4;
import projeto.integrador.conexao.Conexao;
import projeto.integrador.conexao.SGBDException;
import projeto.integrador.model.Post;
import projeto.integrador.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PostDAO {
    public boolean inserir(Post post){

        try {
            String sql;
            
                sql = "INSERT INTO public.post (conteudo, user_id) ";
                sql += "VALUES (";
                sql += "'"+post.getConteudo()+"', ";
             
                sql += post.getUser().getId();
                sql += ")";
                        
                System.out.println(sql);
                // obtem objeto
                Statement insert = this.getConexao().getBd().getStatement(sql);
                insert.executeUpdate(sql);
                insert.close();
//           
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
