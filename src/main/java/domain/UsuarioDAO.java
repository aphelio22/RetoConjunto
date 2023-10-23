package domain;

import clase.Usuario;
import exception.UsuarioInexistente;

public interface UsuarioDAO {
    public Usuario loadUser(String email, String contrasenha) throws UsuarioInexistente;

}
