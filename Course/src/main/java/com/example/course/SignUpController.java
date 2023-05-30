package com.example.course;


import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private RadioButton female;

    @FXML
    private PasswordField location;

    @FXML
    private RadioButton male;

    @FXML
    private PasswordField password;

    @FXML
    private Button signup;

    @FXML
    private TextField username;
    @FXML
    private ImageView process;
    @FXML
    private Button backLogIn;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        process.setVisible(false);
        username.setStyle("-fx-text-inner-color :#a0a2ab");
        password.setStyle("-fx-text-inner-color :#a0a2ab");
        location.setStyle("-fx-text-inner-color :#a0a2ab");

        handler = new DBHandler();
    }

    @FXML
    public void signupAction(ActionEvent event) {
        process.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e -> {
            System.out.println("SignUp Sucsesfuly ....");
        });
        pt.play();

        //save data in DB
        try {

            String insert = "Insert into Users (name,gender,address,password) values (?,?,?,?)";
            connection = handler.getConnection();
            pst = connection.prepareStatement(insert);
            pst.setString(1, username.getText());
            pst.setString(2, getGender());
            pst.setString(3, location.getText());
            pst.setString(4, password.getText());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void loginAction(ActionEvent event) throws Exception {
        try {
            signup.getScene().getWindow().hide();
            Stage login = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
            Scene scene = new Scene(root);
            login.setScene(scene);
            login.show();
            login.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error signup : " + e);
        }
    }
    public String getGender(){
        String gen = "";
        if(male.isSelected()){
            gen = "Male";
        }else if(female.isScaleShape()){
            gen = "Female";
        }
        return gen;
    }
}
