package clase;

import java.util.ArrayList;

public class Sesion {
    private static Usuario usuario;
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Sesion.pedidos = pedidos;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Sesion.productos = productos;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        Sesion.items = items;
    }
}