package com.example.myfirstapp;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RegistrationButton;

    @FXML
    private Button SignInButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        SignInButton.setOnAction(actionEvent -> {
            DBConnection connection = new DBConnection();
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();


            if (!loginText.equals("") && !passwordText.equals("")) {
                try {
                    ResultSet result = connection.getUserDataFromDB(loginText, passwordText);
                    boolean x = result.next();
                    if(!x){
                        Shake loginAnim = new Shake(password_field);
                        loginAnim.playAnimation();
                        Shake passAnim = new Shake(login_field);
                        passAnim.playAnimation();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Shake loginAnim = new Shake(password_field);
                loginAnim.playAnimation();
                Shake passAnim = new Shake(login_field);
                passAnim.playAnimation();
                System.out.println("Login or Password is empty");
                return;
            }

            SignInButton.getScene().getWindow().hide();

            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Welcome to your page", ButtonType.OK);
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        RegistrationButton.setOnAction(actionEvent -> {
            RegistrationButton.getScene().getWindow().hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("signUp.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
