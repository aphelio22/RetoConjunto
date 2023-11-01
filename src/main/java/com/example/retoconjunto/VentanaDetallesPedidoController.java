package com.example.retoconjunto;

import clase.Item;
import clase.Sesion;
import domain.DBConnection;
import domain.ItemDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaDetallesPedidoController implements Initializable {
    @javafx.fxml.FXML
    private TableColumn<Item, String> cIdItem;
    @javafx.fxml.FXML
    private TableColumn<Item, String> cCPedido;
    @javafx.fxml.FXML
    private TableColumn<Item, String> cCantidad;
    @javafx.fxml.FXML
    private TableColumn<Item, String> cProducto;
    private ObservableList<Item> observableListItem;
    @javafx.fxml.FXML
    private TableView tvPedido;
    @javafx.fxml.FXML
    private MenuItem menuVolver;
    @javafx.fxml.FXML
    private MenuItem menuAcercaDe;
    @javafx.fxml.FXML
    private MenuItem btnLogOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cIdItem.setCellValueFactory( (fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        cCPedido.setCellValueFactory( (fila) -> {
            String cPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(cPedido);
        });

        cCantidad.setCellValueFactory( (fila) -> {
            String cCantidad = String.valueOf(fila.getValue().getCantidad());
            return new SimpleStringProperty(cCantidad);
        });

        cProducto.setCellValueFactory( (fila) -> {
            String cProducto = String.valueOf(fila.getValue().getProducto());
            return new SimpleStringProperty(cProducto);
        });

        observableListItem = FXCollections.observableArrayList();
        ItemDAOImp dao = new ItemDAOImp(DBConnection.getConnection());
        Sesion.setItems(dao.loadAll(Sesion.getPedido().getCodigo_pedido()));
        observableListItem.addAll(Sesion.getItems());
        System.out.println(observableListItem);
        tvPedido.setItems(observableListItem);
    }

    @javafx.fxml.FXML
    public void volverAtrás(ActionEvent actionEvent) {
        HelloApplication.loadFXMLUsuario("ventanaUsuario.fxml");
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
