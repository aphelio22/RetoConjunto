package com.example.retoconjunto;

import clase.Item;
import clase.Sesion;
import domain.DBConnection;
import domain.ItemDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaDetallesPedido implements Initializable {
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
}
