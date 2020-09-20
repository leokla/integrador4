package projeto.integrador.DAO;

import projeto.integrador.ProjetoIntegrador4;
import projeto.integrador.conexao.Conexao;
import projeto.integrador.conexao.SGBDException;
import projeto.integrador.model.Post;
import projeto.integrador.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Object[][] getPostData(){
        
        
        String sql =  "select u.name, po.conteudo from post po\n" +
                    "inner join usuario u on u.id = po.user_id";
        try {
            ResultSet rs = this.getConexao().getBd().consulta(sql);
            ResultSetMetaData rsmd1 = rs.getMetaData();;
            
            int iRows = 0;
            while (rs.next()) {
                iRows++;
            }
            rs.beforeFirst();
            
            Object [][] result = new Object[iRows][rsmd1.getColumnCount()];
            
            int iRow = 0;
            while (rs.next()) {
                for (int nCol = 1; nCol <= rsmd1.getColumnCount(); ++nCol){
                    result[iRow][nCol - 1] = rs.getString(nCol);
                }
                iRow++;
            }
            
            return result;
        } catch (SQLException | SGBDException | ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
