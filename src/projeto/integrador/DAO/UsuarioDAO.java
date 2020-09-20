package projeto.integrador.DAO;

import projeto.integrador.ProjetoIntegrador4;
import projeto.integrador.conexao.Conexao;
import projeto.integrador.conexao.SGBDException;
import projeto.integrador.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projeto.integrador.util.PasswordGenerator;

public class UsuarioDAO {
    public boolean inserir(Usuario user, JFrame frame){

        try {
            // testa se existe
            String sql;
            
            if (!this.existeUsuario(user.getNome())) {
//                sql = "insert into usuario (name, email, telefone, genero)"
//                        + " values (?, ?, ?, ?)";
                
                sql = "INSERT INTO public.usuario " +
                     "(name, pass, lastname, email, genero, telefone) ";
                //sql += "values (?, ?, ?, ? , ?, ?)";
                sql += "values (";
                sql += "'"+user.getNome()+"', ";
                sql += "'"+PasswordGenerator.getRandomPassword()+"', ";
                sql += "'"+" "+"', ";
                sql += "'"+user.getEmail()+"', ";
                sql += "'"+user.getGenero()+"', ";
                sql += "'"+user.getTelefone()+"' ";
                sql += ")";

                System.out.println(sql);
                // obtem objeto
                Statement insert = this.getConexao().getBd().getStatement(sql);
                insert.executeUpdate(sql);
                insert.close();
              
                JOptionPane.showMessageDialog(frame, "Sucesso. Sua senha foi enviada para o email: " + user.getEmail(), "Sucesso",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                //TODO tratar erro de usuario existente
            }
        } catch (ClassNotFoundException | SQLException | SGBDException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(frame, "Falha ao inserir usuário!", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
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
            String sql = "select * from usuario where name = " + user;

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
            String sql = "select * from usuario where name = " + user;

            // executar sql
            ResultSet rs = this.getConexao().getBd().consulta(sql);

            // testa resultado
            while (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("name"),
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

    public boolean autenticaUsuario(String user, String pass)  {
        try {
            // consultar o código
            String sql = "select * from usuario where name = '" + user + "' ";
            sql += "and pass = '" + pass + "'";

            System.out.println(sql);
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
}
