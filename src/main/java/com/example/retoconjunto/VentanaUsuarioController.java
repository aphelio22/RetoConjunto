package com.example.retoconjunto;

import clase.Pedido;
import clase.Sesion;
import domain.DBConnection;
import domain.PedidoDAOImp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase VentanaUsuarioController controla la lógica de la ventana de usuario.
 */
public class VentanaUsuarioController implements Initializable {

    /**
     * Label que completa al mensaje de 'Bienvenido...' en la pantalla de los
     * pedidos del usuario.
     */
    @javafx.fxml.FXML
    private Label lbUsuario;

    /**
     * TableColumn que representa a la columna 'id' de cada pedido.
     */
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cIdPedido;

    /**
     * TableColumn que representa a la columna 'codigo_pedido' de cada pedido.
     */
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cCPedido;

    /**
     * TableColumn que representa a la columna 'fecha' de cada pedido.
     */
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cFecha;

    /**
     * TableColumn que representa a la columna 'usuario' de cada pedido.
     */
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cUsuario;

    /**
     * TableColumn que representa a la columna 'total' de cada pedido.
     */
    @javafx.fxml.FXML
    private TableColumn<Pedido, String> cTotal;

    /**
     * TableView que muestra todos los pedidos del usuario con su información correspondiente.
     */
    @javafx.fxml.FXML
    private TableView<Pedido> tvPedidos;

    /**
     * Observable en el que se almacenará cada pedido con todos sus datos.
     */
    private ObservableList<Pedido> observablePedidos;

    /**
     * Inicializa la clase y mappea las columnas de la tabla.
     *
     * @param url             La ubicación para inicializar.
     * @param resourceBundle  El recurso de recursos para inicializar.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Mappeo de las columnas de la tabla.
        cIdPedido.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        cFecha.setCellValueFactory((fila) -> {
            String fecha = fila.getValue().getFecha();
            return new SimpleStringProperty(fecha);
        });

        cCPedido.setCellValueFactory((fila) -> {
            String codigoPedido = fila.getValue().getCodigo_pedido();
            return new SimpleStringProperty(codigoPedido);
        });

        cUsuario.setCellValueFactory((fila) -> {
            String usuarioId = String.valueOf(fila.getValue().getUsuarioId());
            return new SimpleStringProperty(usuarioId);
        });

        cTotal.setCellValueFactory((fila) -> {
            String total = String.valueOf(fila.getValue().getTotal());
            return new SimpleStringProperty(total);
        });

        //Texto de bienvenida de la ventada en la que se muestran los pedidos de cada usuario.
        lbUsuario.setText("Bienvenid@: " + Sesion.getUsuario().getNombre());

        //Se crea el observable y se llena la tabla con cada pedido.
        observablePedidos = FXCollections.observableArrayList();
        PedidoDAOImp dao = new PedidoDAOImp(DBConnection.getConnection());
        Sesion.setPedidos(dao.loadAll(Sesion.getUsuario().getId()));
        observablePedidos.addAll(Sesion.getPedidos());
        tvPedidos.setItems(observablePedidos);

        //Al seleccionar un pedido en la tabla se llamará al método 'seleccionarPedido()'.
        tvPedidos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            seleccionarPedido(tvPedidos.getSelectionModel().getSelectedItem());
        });
    }

    /**
     * Maneja la selección de un pedido en la tabla y carga la ventana de detalles del pedido.
     *
     * @param p El pedido seleccionado.
     */
    private void seleccionarPedido(Pedido p) {
        Sesion.setPedido(p);
        Sesion.setPos(tvPedidos.getSelectionModel().getSelectedIndex());
        HelloApplication.loadFXMLDetalles("ventanaDetallesPedido.fxml");
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
        // Maneja el evento de cierre de sesión y carga la ventana de inicio de sesión.
        HelloApplication.loadFXMLLogin("login.fxml");
    }
}
