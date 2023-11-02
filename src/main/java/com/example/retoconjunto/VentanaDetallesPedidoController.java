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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase VentanaDetallesPedidoController controla la lógica de la ventana de detalles del pedido.
 */
public class VentanaDetallesPedidoController implements Initializable {

    /**
     * TableColumn que representa a la columna 'id' de cada item.
     */
    @javafx.fxml.FXML
    private TableColumn<Item, String> cIdItem;

    /**
     * TableColumn que representa a la columna 'codigo_pedido' de cada item.
     */
    @javafx.fxml.FXML
    private TableColumn<Item, String> cCPedido;

    /**
     * TableColumn que representa a la columna 'cantidad' de cada item.
     */
    @javafx.fxml.FXML
    private TableColumn<Item, String> cCantidad;

    /**
     * TableColumn que representa a la columna donde se mostrarán los detalles
     * de cada producto que conforma cada item.
     */
    @javafx.fxml.FXML
    private TableColumn<Item, String> cProducto;

    /**
     * TableView que muestra todos los items del pedido con su información correspondiente.
     */
    @javafx.fxml.FXML
    private TableView tvItem;

    /**
     * Observable en el que se almacenará cada item con todos sus datos.
     */
    private ObservableList<Item> observableListItem;


    /**
     * Inicializa la clase y mappea las columnas de la tabla.
     *
     * @param url             La ubicación para inicializar.
     * @param resourceBundle  El recurso de recursos para inicializar.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Mappeo de columnas en la tabla.
        cIdItem.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        cCPedido.setCellValueFactory((fila) -> {
            String cPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(cPedido);
        });

        cCantidad.setCellValueFactory((fila) -> {
            String cCantidad = String.valueOf(fila.getValue().getCantidad());
            return new SimpleStringProperty(cCantidad);
        });

        cProducto.setCellValueFactory((fila) -> {
            String cProducto = String.valueOf(fila.getValue().getProducto());
            return new SimpleStringProperty(cProducto);
        });

        //Se crea el observable y se llena la tabla con cada item.
        observableListItem = FXCollections.observableArrayList();
        ItemDAOImp dao = new ItemDAOImp(DBConnection.getConnection());
        Sesion.setItems(dao.loadAll(Sesion.getPedido().getCodigo_pedido()));
        observableListItem.addAll(Sesion.getItems());
        tvItem.setItems(observableListItem);
    }

    /**
     * Método por el que al hacer click en el apartado 'Volver' del menu bar se vuelve a la
     * pantalla en la que el usuario puede ver sus pedidos realizados.
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @Deprecated
    public void volverAtrás(ActionEvent actionEvent) {
        // Maneja el evento de 'Volver' y carga la ventana de usuario.
        HelloApplication.loadFXMLUsuario("ventanaUsuario.fxml");
    }

    /**
     * Método por el que al hacer click en el apartado 'Acerca de' del menu bar se muestra
     * un mensaje que contiene información del creador de la aplicación.
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @Deprecated
    public void mostrarAcercaDe(ActionEvent actionEvent) {
        // Muestra información "Acerca de" en una ventana de diálogo.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de: ");
        alert.setHeaderText("Creado por: ");
        alert.setContentText("Jorge Alarcón Navarro, 2ºDAM");
        alert.showAndWait();
    }

    /**
     * Método por el que al hacer click en el apartado 'Log out' del menu bar se vuelve
     * a la pantalla de login.
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @Deprecated
    public void logOut(ActionEvent actionEvent) {
        //Quita de la sesión al usuario actual.
        Sesion.setUsuario(null);
        // Maneja el evento de cierre de sesión y carga la ventana de login.
        HelloApplication.loadFXMLLogin("login.fxml");
    }
}
