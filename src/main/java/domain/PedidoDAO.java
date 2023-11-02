package domain;

import clase.Pedido;

import java.util.ArrayList;

/**
 * La interfaz PedidoDAO define los métodos que deben implementarse para acceder a los datos de los pedidos en el sistema.
 */
public interface PedidoDAO {

    /**
     * Recupera todos los pedidos asociados a un usuario específico.
     *
     * @param id El identificador del usuario para el cual se desean cargar los pedidos.
     * @return Una lista de pedidos asociados al usuario especificado.
     */
    public ArrayList<Pedido> loadAll(Integer id);
}
