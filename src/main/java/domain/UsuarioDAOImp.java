package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clase.Usuario;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

public class UsuarioDAOImp implements UsuarioDAO {

    private static Connection connection;
    private static String loadUser = "select * from Usuario where email = ?";

    public UsuarioDAOImp(Connection conn) {
        connection = conn;
    }

    @Override
    public Usuario loadUser(String email, String contrasenha) throws UsuarioInexistente {
        Usuario usuario = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(loadUser);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                usuario = new Usuario(email, contrasenha);
                usuario.setEmail(resultSet.getString("email"));
                usuario.setContrasenha(resultSet.getString("contrasenha"));
                if (!contrasenha.equals(usuario.getContrasenha())){
                    throw new ContrasenhaIncorrecta("Contraseña incorrecta");
                }
                usuario.setNombre(resultSet.getString("nombre"));
            } else {
                throw new UsuarioInexistente("El usuario no existe");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ContrasenhaIncorrecta e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
