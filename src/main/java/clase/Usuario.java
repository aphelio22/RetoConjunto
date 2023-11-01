package clase;

import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;

import java.util.ArrayList;

/**
 * La clase Usuario representa a un usuario en el sistema. Almacena información como el ID, nombre, contraseña, email
 * y una lista de pedidos relacionados con el mismo.
 */
public class Usuario {
    /**
     * ID del usuario.
     */
    private Integer id;
    /**
     * Nombre del usuario.
     */
    private String nombre;
    /**
     * Contraseña del usuario.
     */
    private String contrasenha;
    /**
     * Dirección de correo electrónico del usuario.
     */
    private String email;
    /**
     * Lista de pedidos asociados al usuario.
     */
    private ArrayList<Pedido> pedido;

    /**
     * Constructor de la clase Usuario que inicializa los atributos ID, nombre, contraseña y email del usuario.
     *
     * @param id          El ID del usuario.
     * @param nombre      El nombre del usuario.
     * @param contrasenha La contraseña del usuario.
     * @param email       La dirección de correo electrónico del usuario.
     */
    public Usuario(Integer id, String nombre, String contrasenha, String email) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenha = contrasenha;
        this.email = email;
    }

    /**
     * Constructor de la clase Usuario que recibe el email y la contraseña. Se utiliza en la autenticación de usuarios.
     * Inicializa una lista vacía de pedidos.
     *
     * @param email       La dirección de correo electrónico del usuario.
     * @param contrasenha La contraseña del usuario.
     * @throws UsuarioInexistente     Excepción lanzada cuando el usuario no existe.
     * @throws ContrasenhaIncorrecta Excepción lanzada cuando la contraseña es incorrecta.
     */
    public Usuario(String email, String contrasenha) throws UsuarioInexistente, ContrasenhaIncorrecta {
        this.pedido = new ArrayList<Pedido>();
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El ID del usuario.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenha La contraseña del usuario.
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    /**
     * Obtiene la dirección de correo electrónico del usuario.
     *
     * @return La dirección de correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la dirección de correo electrónico del usuario.
     *
     * @param email La dirección de correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve una representación en cadena de la instancia de Usuario.
     *
     * @return Una cadena que representa la instancia de Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasenha='" + contrasenha + '\'' +
                ", email='" + email + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}
