package com.example.myfirstapp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField countrySignUpField;

    @FXML
    private TextField login_field2;

    @FXML
    private PasswordField password_field;

    @FXML
    private RadioButton signUpCheckBoxFemale;

    @FXML
    private RadioButton signUpCheckBoxMale;

    @FXML
    private TextField signUpNameField;

    @FXML
    private TextField surnameSignUpField;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(actionEvent -> {

            try {
                newUser();
            }catch (Exception e){
            e.printStackTrace();
            }
        });
    }
    private void newUser() throws SQLException, ClassNotFoundException {

        String name = signUpNameField.getText();
        String surname = surnameSignUpField.getText();
        String login = login_field2.getText();
        String password = password_field.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected()){
            gender = "Male";
        }else {
            gender = "Female";
        }
        String location = countrySignUpField.getText();
        User user = new User(name ,surname, login, password, gender, location);
        DBConnection connection = new DBConnection();
        connection.addUsersDataToDB(user);
    }

}

