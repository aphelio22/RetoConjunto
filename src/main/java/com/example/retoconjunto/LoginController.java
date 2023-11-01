package com.example.retoconjunto;

import clase.Sesion;
import clase.Usuario;
import domain.DBConnection;
import domain.UsuarioDAOImp;
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

public class LoginController implements Initializable {
    @FXML
    public TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button btnLogin;

    @FXML
    public void login(ActionEvent actionEvent) {
        String userEmail = userField.getText();
        String userPass = passField.getText();
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(DBConnection.getConnection());
        try {
            Usuario usuario = usuarioDAOImp.loadUser(userEmail, userPass);
            Sesion.setUsuario(usuario);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Holita");
            alert.setHeaderText("Bienvenido " + usuario.getNombre());
            alert.setContentText("Inicio correcto");
            alert.showAndWait();
            HelloApplication.loadFXMLUsuario("ventanaUsuario.fxml");
        } catch (UsuarioInexistente e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
