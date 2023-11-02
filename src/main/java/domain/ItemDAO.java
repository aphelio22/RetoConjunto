package domain;

import clase.Item;

import java.util.ArrayList;

/**
 * La interfaz ItemDAO define los métodos que deben implementarse para acceder a los datos de los elementos (Item) en el sistema.
 */
public interface ItemDAO {

    /**
     * Recupera todos los elementos (Items) relacionados con un pedido específico.
     *
     * @param codigoPedido El código del pedido para el cual se desean cargar los elementos.
     * @return Una lista de elementos relacionados con el pedido dado.
     */
    public ArrayList<Item> loadAll(String codigoPedido);
}
