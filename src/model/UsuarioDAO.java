package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    public static Usuario porNomeSenha(String nome, String senha) throws SQLException{
        if (nome == null || senha == null) {
            return null;
        } else {
            Statement statement = Conexao.conectar().createStatement();

            String sql = "SELECT * FROM usuario WHERE nome = '" + nome + "' AND senha = '" + senha + "'";

            statement.executeQuery(sql);

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            Usuario usuario = new Usuario();

            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setSenha(resultSet.getString("senha"));

            Conexao.fecharConexao();

            return usuario;
        }
    }
}
