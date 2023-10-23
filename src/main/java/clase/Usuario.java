package clase;

import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

import java.security.PublicKey;
import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String nombre;
    private String contrasenha;
    private String email;
    private ArrayList<Pedido> pedido;

    public Usuario(Integer id, String nombre, String contrasenha, String email) {
        this.pedido = null;
        this.id = id;
        this.nombre = nombre;
        this.contrasenha = contrasenha;
        this.email = email;
    }

    public Usuario(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta {
        this.pedido = new ArrayList<Pedido>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
