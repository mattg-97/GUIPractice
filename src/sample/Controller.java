package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
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
    public Button yesLogout;
    public Button dontLogout;
    public Button seeBalanceButton;
    Model loginModel = new Model();
    @FXML public Button loginButton;
    @FXML public PasswordField passwordField;
    @FXML public TextField usernameField;
    @FXML public Label loginMessage;
    @FXML public ImageView bankImage;
    public static int userid;
    public static double actualBalance;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //displayImage();
    }
    public void displayImage(){
        Image bankLogo = new Image(getClass().getResourceAsStream("Business-bank-account-e1534519443766.jpeg"));
        bankImage.setImage(bankLogo);
    }

    public void loginAttempt(ActionEvent event) throws Exception{
        try {
            if (loginModel.isLogin(usernameField.getText(), passwordField.getText())){
                userid = (loginModel.getUserid(usernameField.getText(), passwordField.getText()));
                actualBalance = (loginModel.returnBalance(loginModel.getUserid(usernameField.getText(), passwordField.getText())));
                loginMessage.setText("Username/Password Correct.");
                Parent root = FXMLLoader.load(getClass().getResource("OnlineBanking.fxml"));
                Stage window = (Stage) loginButton.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            } else {
                loginMessage.setText("Username/Password Incorrect.");
            }
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogoutConfirm.fxml"));
        Stage window = (Stage) logoutButton.getScene().getWindow();
        window.setScene(new Scene(root, 300, 200));
    }

    public void makePayment(ActionEvent event) {
    }

    public void deposit(ActionEvent event) {
    }

    public void withdraw(ActionEvent event) {
    }


    public void confirmLogout(ActionEvent event) {
        System.exit(1);
    }

    public void returnToOLB(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OnlineBanking.fxml"));
        Stage window = (Stage) dontLogout.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    public void displayBalance(ActionEvent event) {
        balance.setText("£" + actualBalance);
    }
}
