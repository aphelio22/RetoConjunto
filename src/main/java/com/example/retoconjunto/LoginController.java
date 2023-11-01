package com.example.retoconjunto;

import clase.Sesion;
import clase.Usuario;
import domain.DBConnection;
import domain.UsuarioDAOImp;
import exception.ContrasenhaIncorrecta;
import exception.UsuarioInexistente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase LoginController controla la lógica de la ventana de inicio de sesión.
 */
public class LoginController implements Initializable {
    /**
     * TextField donde el usuario introducirá su respectivo nombre
     * de usuario.
     */
    @FXML
    public TextField userField;
    /**
     * PasswordField en el que el usuario introducirá su respectiva contraseña.
     */
    @FXML
    private PasswordField passField;

    /**
     * Maneja el evento de inicio de sesión cuando se presiona el botón de inicio de sesión.
     *
     * @param actionEvent El evento de acción generado por el botón.
     */
    @FXML
    public void login(ActionEvent actionEvent) {
        String userEmail = userField.getText();
        String userPass = passField.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());
        try {
            Usuario usuario = usuarioDAOImp.loadUser(userEmail, userPass);
            Sesion.setUsuario(usuario);

            // Muestra un mensaje de confirmación en caso de un inicio de sesión exitoso.
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("¡Hola!");
            alert.setHeaderText("Inicio correcto");
            alert.setContentText("Bienvenido, " + usuario.getNombre() + ".");
            alert.showAndWait();

            // Carga la ventana de usuario después de un inicio de sesión exitoso.
            HelloApplication.loadFXMLUsuario("ventanaUsuario.fxml");

        } catch (UsuarioInexistente e) {
            // Muestra una alerta en caso de usuario inexistente.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Usuario Inexistente");
            alert.setContentText("No se ha encontrado al usuario.");
            alert.showAndWait();
            throw new RuntimeException(e);
        } catch (ContrasenhaIncorrecta e) {
            // Muestra una alerta en caso de contraseña incorrecta.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Contraseña incorrecta");
            alert.setContentText("La contraseña introducida no es correcta.");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Método de inicialización de la clase, se puede utilizar para realizar configuraciones iniciales si es necesario.
    }
}