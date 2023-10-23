package exception;

import clase.Usuario;

public class UsuarioInexistente extends Exception {
    public UsuarioInexistente(String message){
        super(message);
    }
}
