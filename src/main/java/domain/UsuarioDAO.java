package domain;

import clase.Usuario;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

/**
 * Interfaz que define las operaciones para acceder a objetos de tipo Usuario en la base de datos.
 */
public interface UsuarioDAO {

    /**
     * Recupera un usuario de la base de datos en función de su dirección de correo electrónico y contraseña.
     * Sirve para iniciar sesión.
     *
     * @param email      La dirección de correo electrónico del usuario.
     * @param contrasenha La contraseña del usuario.
     * @return El usuario encontrado en la base de datos.
     * @throws UsuarioInexistente    Si no se encuentra un usuario con la dirección de correo electrónico proporcionada.
     * @throws ContrasenhaIncorrecta Si la contraseña proporcionada no coincide con la del usuario encontrado.
     */
    public Usuario loadUser(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta;
}
