package domain;

import clase.Usuario;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz UsuarioDAO que proporciona métodos para cargar usuarios
 * desde una base de datos.
 */
public class UsuarioDAOImp implements UsuarioDAO {
    /**
     * Atributo con el que se establecerá la conexión a la base de datos.
     */
    private static Connection connection;
    /**
     *  Consulta SQL para cargar el usuario relacionados con un email específico.
     */
    private static String loadUser = "select * from Usuario where email = ?";

    /**
     * Constructor para crear una instancia de UsuarioDAOImp con una conexión de base de datos.
     *
     * @param conn La conexión de base de datos a utilizar.
     */
    public UsuarioDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga un usuario desde la base de datos utilizando su dirección de correo electrónico y contraseña.
     *
     * @param email       La dirección de correo electrónico del usuario.
     * @param contrasenha La contraseña del usuario.
     * @return Un objeto Usuario que representa el usuario cargado si las credenciales son correctas.
     * @throws UsuarioInexistente      Si el usuario no existe en la base de datos.
     * @throws ContrasenhaIncorrecta   Si la contraseña proporcionada no coincide con la almacenada en la base de datos.
     */
    @Override
    public Usuario loadUser(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta {
        //Se crea una variable de tipo 'Usuario'.
        Usuario usuario;
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(loadUser);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Cuando se obtiene el resultado de la consulta se crea un objeto 'Usuario'.
            if (resultSet.next()) {
                usuario = new Usuario(email, contrasenha);
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setContrasenha(resultSet.getString("contrasenha"));

                //Se comprueba si la contraseña proporcionada coincide con la almacenada en la base de datos.
                if (!contrasenha.equals(usuario.getContrasenha())) {
                    throw new ContrasenhaIncorrecta("Contraseña incorrecta");
                }
                //En caso de que el usuario no exista se lanza otra excepción.
            } else {
                throw new UsuarioInexistente("El usuario no existe");
            }
        } catch (SQLException e) {
            //En caso de error al cargar el usuario se lanza una excepción.
            throw new RuntimeException(e);
        }
        System.out.println(usuario);
        return usuario;
    }
}
