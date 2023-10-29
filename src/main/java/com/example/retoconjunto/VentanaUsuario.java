package com.example.retoconjunto;

import clase.Pedido;
import clase.Sesion;
import clase.Usuario;
import domain.DBConnection;
import domain.PedidoDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class VentanaUsuario implements Initializable {
    @javafx.fxml.FXML
    private MenuItem itemLogOut;
    @javafx.fxml.FXML
    private Label lbUsuario;
    @javafx.fxml.FXML
    private TableView tvPedidos;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cCPedido;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cFecha;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cUsuario;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cTotal;
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cIdPedido;
    private ObservableList<Pedido> observablePedidos;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cIdPedido.setCellValueFactory( (fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        cFecha.setCellValueFactory( (fila) -> {
            String fecha = fila.getValue().getFecha();
            return new SimpleStringProperty(fecha);
        });

        cCPedido.setCellValueFactory( (fila) -> {
            String codigoPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(codigoPedido);
        });

        cUsuario.setCellValueFactory( (fila) -> {
            String usuarioId = String.valueOf(fila.getValue().getUsuarioId());
            return new SimpleStringProperty(usuarioId);
        });

        cTotal.setCellValueFactory( (fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });


        observablePedidos = FXCollections.observableArrayList();
        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
        observablePedidos.addAll(Sesion.getPedidos());
        tvPedidos.setItems(observablePedidos);
       
    }
}
