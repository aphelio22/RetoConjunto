package com.example.retoconjunto;

import clase.Pedido;
import clase.Sesion;
import domain.DBConnection;
import domain.PedidoDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaUsuarioController implements Initializable {
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
    @javafx.fxml.FXML
    private MenuItem btnLogOut;
    @javafx.fxml.FXML
    private MenuItem btnAcercaDe;


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

        lbUsuario.setText("Bienvenido: " + Sesion.getUsuario().getNombre());

        observablePedidos = FXCollections.observableArrayList();
        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
        observablePedidos.addAll(Sesion.getPedidos());
        tvPedidos.setItems(observablePedidos);

    }

    @javafx.fxml.FXML
    public void mostrarItemsPedido(Event event) {
        seleccionarPedido(Sesion.getPedidoActual());
    }

    private void seleccionarPedido(Pedido p){
        Sesion.setPedidoActual(p);
        Sesion.setPos(tvPedidos.getSelectionModel().getSelectedIndex());
        HelloApplication.loadFXMLDetalles("ventanaDetallesPedido.fxml");

    }

    @javafx.fxml.FXML
    public void mostrarAcercaDe(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de: ");
        alert.setHeaderText("Creado por: ");
        alert.setContentText("Jorge Alarcón Navarro, 2ºDAM");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) {
        HelloApplication.loadFXMLLogin("login.fxml");
    }
}
