package com.example.retoconjunto;

import clase.Usuario;
import domain.DBConnection;
import domain.UsuarioDAOImp;
import exception.UsuarioInexistente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Holita");
            alert.setHeaderText("Bienvenido " + usuario.getNombre());
            alert.setContentText("Inicio correcto");
            alert.showAndWait();
        } catch (UsuarioInexistente e) {
            throw new RuntimeException(e);
        }
    }
}
