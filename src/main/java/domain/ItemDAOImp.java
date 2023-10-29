package domain;

import clase.Item;
import clase.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImp implements ItemDAO{
    private static Connection connection;
    private final static String queryLoadAll = "select * from Item where codigo_pedido = ?";

    public ItemDAOImp(Connection conn) {
        connection = conn;
    }

    @Override
    public ArrayList<Item> loadAll(String codigo_Pedido) {
        ArrayList<Item> salida = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            preparedStatement.setString(1, codigo_Pedido);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setCodigo_pedido(resultSet.getString("codigo_pedido"));
                item.setCantidad(resultSet.getInt("cantidad"));
                Integer productId = resultSet.getInt("product_id");


                ProductoDAOImp productoDAOImp = new ProductoDAOImp(DBConnection.getConnection());
                Producto producto = productoDAOImp.loadProduct(productId);
                item.setProducto(producto);

                salida.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}
