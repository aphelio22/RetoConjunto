package clase;

import java.util.Date;

/**
 * La clase Producto representa un artículo que puede ser solicitado en un pedido, con información sobre su nombre,
 * precio y cantidad disponible en el inventario.
 */
public class Producto {
    /**
     * Identificador único del producto.
     */
    private Integer id;
    /**
     * Nombre del producto
     */
    private String nombre;
    /**
     * Precio del producto.
     */
    private Double precio;
    /**
     * Cantidad disponible en el inventario
     */
    private Integer cantidad_disponible;

    /**
     * Constructor para crear un nuevo objeto Producto con todos los atributos especificados.
     *
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidad_disponible Cantidad disponible en el inventario.
     */
    public Producto(Integer id, String nombre, Double precio, Integer cantidad_disponible) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }

    /**
     * Constructor por defecto que crea un objeto Producto vacío sin atributos inicializados.
     */
    public Producto() {
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return El identificador único del producto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param id El identificador único del producto.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El precio del producto.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible en el inventario del producto.
     *
     * @return La cantidad disponible en el inventario del producto.
     */
    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    /**
     * Establece la cantidad disponible en el inventario del producto.
     *
     * @param cantidad_disponible La cantidad disponible en el inventario del producto.
     */
    public void setCantidad_disponible(Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto Producto, incluyendo su nombre y precio.
     *
     * @return Una cadena que representa el objeto Producto en el formato "nombre / precio€".
     */
    @Override
    public String toString() {
        return nombre + " / " + precio + "€";
    }
}
