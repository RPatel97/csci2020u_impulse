package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField usernameField;
    @FXML private TextField fullnameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;

    public void login(ActionEvent event) {
        String username = usernameField.getText();
        String fullnameText = fullnameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        System.out.println("login(), Username= " + username + " Full name =" + fullnameText + " Phone = " + phone
            + " E-mail = " + email);
    }
}