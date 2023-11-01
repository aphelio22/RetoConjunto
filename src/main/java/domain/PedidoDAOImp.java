package domain;

import clase.Pedido;
import clase.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Implementación de la interfaz PedidoDAO que proporciona métodos para cargar pedidos
 * relacionados con un usuario desde una base de datos.
 */
public class PedidoDAOImp implements PedidoDAO {
    /**
     * Atributo con el que se establecerá la conexión a la base de datos.
     */
    private static Connection connection;
    /**
     *  Consulta SQL para cargar todos los pedidos relacionados con un usuario específico.
     */
    private final static String queryLoadAll = "select * from Pedido where usuario = ?";

    /**
     * Constructor para crear una instancia de PedidoDAOImp con una conexión de base de datos.
     *
     * @param conn La conexión de base de datos a utilizar.
     */
    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }

    /**
     * Carga todos los pedidos relacionados con un usuario específico desde la base de datos.
     *
     * @param id El ID del usuario para el cual se cargarán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos cargados.
     */
    @Override
    public ArrayList<Pedido> loadAll(Integer id) {
        //Se crea un ArryList de 'Pedido', 'salida' donde se cargarán cada uno de los pedidos.
        ArrayList<Pedido> salida = new ArrayList<>();
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Por cada resultado de la consulta se crea un objeto 'Pedido'.
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setCodigo_pedido(resultSet.getString("codigo_pedido"));

                //Formatea la fecha como cadena y la asigna al pedido.
                pedido.setFecha(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("fecha")));

                pedido.setUsuarioId(resultSet.getInt("usuario"));
                pedido.setTotal(resultSet.getInt("total"));

                //Carga los elementos (items) relacionados con el pedido.
                pedido.getItems().addAll(itemDAOImp.loadAll(pedido.getCodigo_pedido()));

                //Establece el pedido actual en la sesión.
                Sesion.setPedido(pedido);
                //Se carga cada pedido en salida.
                salida.add(pedido);
            }
        } catch (SQLException e) {
            // En caso de error al cargar los items se lanza una excepción.
            throw new RuntimeException(e);
        }
        return salida;
    }
}