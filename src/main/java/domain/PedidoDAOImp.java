package domain;

import clase.Pedido;
import clase.Sesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PedidoDAOImp implements PedidoDAO{
    private static Connection connection;
    private final static String queryLoadAll = "select * from Pedido where usuario = ?";

    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }


    @Override
    public ArrayList<Pedido> loadAll(Integer id) {
        ArrayList<Pedido> salida = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setCodigo_pedido(resultSet.getString("codigo_pedido"));
                pedido.setFecha(String.valueOf(resultSet.getDate("fecha")));
                pedido.setUsuarioId(resultSet.getInt("usuario"));
                pedido.setTotal(resultSet.getInt("total"));
                pedido.getItems().addAll(itemDAOImp.loadAll(pedido.getCodigo_pedido()));
                Sesion.setPedido(pedido);
                salida.add(pedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(salida);
        return salida;
    }
}
