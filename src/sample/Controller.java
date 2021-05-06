package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML public Label databaseConnection;
    public Label balance;
    public Button withdrawButton;
    public Button depositButton;
    public Button paymentButton;
    public Button logoutButton;
    Model loginModel = new Model();
    @FXML public Button loginButton;
    @FXML public PasswordField passwordField;
    @FXML public TextField usernameField;
    @FXML public Label loginMessage;
    @FXML public ImageView bankImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (loginModel.connected){
            databaseConnection.setText("Connected to database");
        } else {
            databaseConnection.setText("Not Connected to database");
        }
    }

    public void loginAttempt(ActionEvent event) throws Exception{
        try {
            if (loginModel.isLogin(usernameField.getText(), passwordField.getText())){
                loginMessage.setText("Username/Password Correct.");
            } else {
                loginMessage.setText("Username/Password Incorrect.");
            }
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void logout(ActionEvent event) {
    }

    public void makePayment(ActionEvent event) {
    }

    public void deposit(ActionEvent event) {
    }

    public void withdraw(ActionEvent event) {
    }
}
