package projeto.integrador.DAO;

import projeto.integrador.ProjetoIntegrador4;
import projeto.integrador.conexao.Conexao;
import projeto.integrador.conexao.SGBDException;
import projeto.integrador.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public boolean inserir(Usuario user){

        try {
            // testa se existe
            String sql;
            if (!this.existeUsuario(user.getNome())) {
                sql = "insert into usuario (nome, email, telefone, genero)"
                        + " values (?, ?, ?, ?)";

                // obtem objeto
                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                // atribui valores
                ps.setString(1, user.getNome());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getTelefone());
                ps.setString(4, user.getGenero());

                // regrava no bd
                this.getConexao().getBd().executaSQL(ps);
            } else {
                //TODO tratar erro de usuario existente
            }
        } catch (ClassNotFoundException | SQLException | SGBDException e) {
           // throw new CidadeException(e.getMessage());
        }

        // return, tudo certo ao salvar
        return true;
    }
    public Conexao getConexao() {
        return ProjetoIntegrador4.getConexao();
    }
    public boolean existeUsuario(String user)  {
        try {
            // consultar o código
            String sql = "select * from usuario where nome = " + user;

            // executar sql
            ResultSet rs = this.getConexao().getBd().consulta(sql);

            // testa resultado
            while (rs.next()) {
                return true;
            }

        } catch (ClassNotFoundException | SQLException | SGBDException e) {
            //TODO tratar erro
        }

        // return, não existe o código
        return false;
    }
    public Usuario getByName(String user)  {
        try {
            // consultar o código
            String sql = "select * from usuario where nome = " + user;

            // executar sql
            ResultSet rs = this.getConexao().getBd().consulta(sql);

            // testa resultado
            while (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("genero"));
            }

        } catch (ClassNotFoundException | SQLException | SGBDException e) {
            //TODO tratar erro
        }

        // return, não existe o código
        return null;
    }

}
