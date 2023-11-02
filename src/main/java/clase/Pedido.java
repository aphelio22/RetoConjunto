package clase;

import java.util.ArrayList;

/**
 * La clase Pedido representa una solicitud de productos realizada por un usuario, que contiene información sobre
 * los productos solicitados, el usuario que realizó el pedido y otros detalles.
 */
public class Pedido {

    /**
     * Identificador único del pedido.
     */
    private Integer id;

    /**
     * Código único que identifica el pedido.
     */
    private String codigo_pedido;

    /**
     * Fecha en que se realizó el pedido.
     */
    private String fecha;

    /**
     * Identificador único del usuario que realizó el pedido.
     */
    private Integer usuarioId;

    /**
     * Total del pedido
     */
    private Integer total;

    /**
     * Lista de ítems que componen el pedido.
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Constructor para crear un nuevo objeto Pedido con todos los atributos especificados.
     *
     * @param id Identificador único del pedido.
     * @param codigo_pedido Código único que identifica el pedido.
     * @param fecha Fecha en que se realizó el pedido.
     * @param usuarioId Identificador único del usuario que realizó el pedido.
     * @param total Total del pedido.
     * @param items Lista de ítems que componen el pedido.
     */
    public Pedido(Integer id, String codigo_pedido, String fecha, Integer usuarioId, Integer total, ArrayList<Item> items) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.total = total;
        this.items = items;
    }

    /**
     * Constructor por defecto que crea un objeto Pedido vacío sin atributos inicializados.
     */
    public Pedido() {
    }

    /**
     * Obtiene la lista de ítems que componen el pedido.
     *
     * @return La lista de ítems que componen el pedido.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Establece la lista de ítems que componen el pedido.
     *
     * @param items La lista de ítems que componen el pedido.
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Obtiene el identificador único del pedido.
     *
     * @return El identificador único del pedido.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del pedido.
     *
     * @param id El identificador único del pedido.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el código único que identifica el pedido.
     *
     * @return El código único que identifica el pedido.
     */
    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    /**
     * Establece el código único que identifica el pedido.
     *
     * @param codigo_pedido El código único que identifica el pedido.
     */
    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    /**
     * Obtiene la fecha en que se realizó el pedido.
     *
     * @return La fecha en que se realizó el pedido.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el pedido.
     *
     * @param fecha La fecha en que se realizó el pedido.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el identificador único del usuario que realizó el pedido.
     *
     * @return El identificador único del usuario que realizó el pedido.
     */
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * Establece el identificador único del usuario que realizó el pedido.
     *
     * @param usuarioId El identificador único del usuario que realizó el pedido.
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Obtiene el total del pedido.
     *
     * @return El total del pedido.
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Establece el total del pedido.
     *
     * @param total El total del pedido.
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto Pedido.
     *
     * @return Una cadena que representa el objeto Pedido, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigo_pedido='" + codigo_pedido + '\'' +
                ", fecha='" + fecha + '\'' +
                ", usuarioId=" + usuarioId +
                ", total=" + total +
                '}';
    }
}
