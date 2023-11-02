package clase;

/**
 * La clase Item representa un elemento de un pedido que incluye información sobre el producto y la cantidad solicitada.
 */
public class Item {

    /**
     * Identificador único del ítem.
     */
    private Integer id;

    /**
     * Código del pedido al que pertenece el ítem.
     */
    private String codigo_pedido;

    /**
     * Cantidad del producto en el ítem.
     */
    private Integer cantidad;

    /**
     * Producto asociado al ítem.
     */
    private Producto producto;

    /**
     * Constructor para crear un nuevo objeto Item con todos los atributos especificados.
     *
     * @param id Identificador único del ítem.
     * @param codigo_pedido Código del pedido al que pertenece el ítem.
     * @param cantidad Cantidad del producto en el ítem.
     * @param producto Producto asociado al ítem.
     */
    public Item(Integer id, String codigo_pedido, Integer cantidad, Producto producto) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    /**
     * Constructor por defecto que crea un objeto Item vacío sin atributos inicializados.
     */
    public Item(){
    }

    /**
     * Obtiene el identificador único del ítem.
     *
     * @return El identificador único del ítem.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del ítem.
     *
     * @param id El identificador único del ítem.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el código del pedido al que pertenece el ítem.
     *
     * @return El código del pedido al que pertenece el ítem.
     */
    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    /**
     * Establece el código del pedido al que pertenece el ítem.
     *
     * @param codigo_pedido El código del pedido al que pertenece el ítem.
     */
    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    /**
     * Obtiene la cantidad del producto en el ítem.
     *
     * @return La cantidad del producto en el ítem.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto en el ítem.
     *
     * @param cantidad La cantidad del producto en el ítem.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el producto asociado al ítem.
     *
     * @return El producto asociado al ítem.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado al ítem.
     *
     * @param producto El producto asociado al ítem.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto Item.
     *
     * @return Una cadena que representa el objeto Item, incluyendo sus atributos.
     */
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", codigo_pedido='" + codigo_pedido + '\'' +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
