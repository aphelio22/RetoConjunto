package clase;

import java.util.ArrayList;

/**
 * La clase Sesion almacena información sobre la sesión actual del usuario, incluyendo el pedido actual, la posición
 * del pedido seleccionado en la tabla, el usuario, el listado de pedidos, los productos y los items.
 */
public class Sesion {
    /**
     * Pedido actual en la sesión.
     */
    private static Pedido pedidoActual = null;
    /**
     * Posición del pedido seleccionado en la tabla.
     */
    private static Integer pos = null;
    /**
     * Usuario actual en la sesión.
     */
    private static Usuario usuario;
    /**
     * Pedido en la sesión.
     */
    private static Pedido pedido;
    /**
     * Lista de pedidos en la sesión.
     */
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    /**
     * Lista de productos en la sesión.
     */
    private static ArrayList<Producto> productos = new ArrayList<>();
    /**
     * Lista de items en la sesión.
     */
    private static ArrayList<Item> items = new ArrayList<>();

    /**
     * Obtiene el pedido actual en la sesión.
     *
     * @return El pedido actual en la sesión.
     */
    public static Pedido getPedidoActual() {
        return pedidoActual;
    }

    /**
     * Establece el pedido actual en la sesión.
     *
     * @param pedidoActual El pedido actual en la sesión.
     */
    public static void setPedidoActual(Pedido pedidoActual) {
        Sesion.pedidoActual = pedidoActual;
    }

    /**
     * Obtiene la posición del pedido seleccionado en la tabla.
     *
     * @return La posición del pedido seleccionado en la tabla.
     */
    public static Integer getPos() {
        return pos;
    }

    /**
     * Establece la posición del pedido seleccionado en la tabla.
     *
     * @param pos La posición del pedido seleccionado en la tabla.
     */
    public static void setPos(Integer pos) {
        Sesion.pos = pos;
    }

    /**
     * Obtiene el pedido en la sesión.
     *
     * @return El pedido en la sesión.
     */
    public static Pedido getPedido() {
        return pedido;
    }

    /**
     * Establece el pedido en la sesión.
     *
     * @param pedido El pedido en la sesión.
     */
    public static void setPedido(Pedido pedido) {
        Sesion.pedido = pedido;
    }

    /**
     * Obtiene el usuario actual en la sesión.
     *
     * @return El usuario actual en la sesión.
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario actual en la sesión.
     *
     * @param usuario El usuario actual en la sesión.
     */
    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    /**
     * Obtiene la lista de pedidos en la sesión.
     *
     * @return La lista de pedidos en la sesión.
     */
    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece la lista de pedidos en la sesión.
     *
     * @param pedidos La lista de pedidos en la sesión.
     */
    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Sesion.pedidos = pedidos;
    }

    /**
     * Obtiene la lista de productos en la sesión.
     *
     * @return La lista de productos en la sesión.
     */
    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos en la sesión.
     *
     * @param productos La lista de productos en la sesión.
     */
    public static void setProductos(ArrayList<Producto> productos) {
        Sesion.productos = productos;
    }

    /**
     * Obtiene la lista de items en la sesión.
     *
     * @return La lista de items en la sesión.
     */
    public static ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Establece la lista de items en la sesión.
     *
     * @param items La lista de items en la sesión.
     */
    public static void setItems(ArrayList<Item> items) {
        Sesion.items = items;
    }
}
