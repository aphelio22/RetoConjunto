package domain;

import clase.Item;
import clase.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación de la interfaz ItemDAO que proporciona métodos para cargar elementos (items)
 * relacionados con sus respectivos pedidos desde una base de datos.
 */
public class ItemDAOImp implements ItemDAO {

    /**
     * Atributo con el que se establecerá la conexión a la base de datos.
     */
    private static Connection connection;

    /**
     *  Consulta SQL para cargar todos los elementos (items) relacionados con un pedido específico.
     */
    private final static String queryLoadAll = "select * from Item where codigo_pedido = ?";

    /**
     * Constructor de la clase ItemDAOImp.
     * @param conn Conexión de base de datos que se utilizará para las operaciones.
     */
    public ItemDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga todos los elementos (items) relacionados con un pedido específico desde la base de datos.
     * @param codigo_Pedido Código del pedido para el cual se cargarán los elementos.
     * @return Lista de elementos (items) relacionados con el pedido.
     * @throws RuntimeException Si ocurre un error durante la carga de elementos.
     */
    @Override
    public ArrayList<Item> loadAll(String codigo_Pedido) {
        //Se crea un ArryList de 'Item', 'salida', donde se cargarán cada uno de los items.
        ArrayList<Item> salida = new ArrayList<>();
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setString(1, codigo_Pedido);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Por cada resultado de la consulta se crea un objeto 'Item'.
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setCodigo_pedido(resultSet.getString("codigo_pedido"));
                item.setCantidad(resultSet.getInt("cantidad"));
                Integer productId = resultSet.getInt("product_id");

                //Se carga la información de cada producto relacionado con cada item.
                ProductoDAOImp productoDAOImp = new ProductoDAOImp(DBConnection.getConnection());
                Producto producto = productoDAOImp.loadProduct(productId);
                item.setProducto(producto);

                //Se carga cada item en salida.
                salida.add(item);
            }
        } catch (SQLException e) {
            // En caso de error al cargar los items se lanza una excepción.
            throw new RuntimeException(e);
        }
        return salida;
    }
}







