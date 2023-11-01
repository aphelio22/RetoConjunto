package domain;

import clase.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz ProductoDAO que proporciona métodos para cargar productos
 * desde una base de datos.
 */
public class ProductoDAOImp implements ProductoDAO {
    /**
     * Atributo con el que se establecerá la conexión a la base de datos.
     */
    private static Connection connection;
    /**
     *  Consulta SQL para cargar el producto relacionado con un item específico.
     */
    private final static String queryLoad = "select * from Producto where id = ?";

    /**
     * Constructor para crear una instancia de ProductoDAOImp con una conexión de base de datos.
     *
     * @param conn La conexión de base de datos a utilizar.
     */
    public ProductoDAOImp(Connection conn) {
        connection = conn;
    }

    /**
     * Carga un producto específico desde la base de datos utilizando su ID.
     *
     * @param id El ID del producto que se va a cargar.
     * @return Un objeto Producto que representa el producto cargado o null si no se encontró.
     */
    @Override
    public Producto loadProduct(Integer id) {
        //Se crea una avariable de tipo 'Producto' que se inicializa a null.
        Producto producto = null;
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoad);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Cuando se obtiene el resultado de la consulta se crea un objeto 'Producto'.
            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCantidad_disponible(resultSet.getInt("cantidad_disponible"));
            }
        } catch (SQLException e) {
            // En caso de error al cargar los productos se lanza una excepción.
            throw new RuntimeException(e);
        }

        return producto;
    }
}
