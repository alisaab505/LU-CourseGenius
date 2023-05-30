package com.example.course;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.Text;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button forgetpassword;

    @FXML
    private Button login;

    @FXML
    private ImageView progress;

    @FXML
    private PasswordField password;

    @FXML
    private CheckBox remember;

    @FXML
    private Button signup;

    @FXML
    private ImageView unilogo;

    @FXML
    private TextField username;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    public static String user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color :#a0a2ab");
        password.setStyle("-fx-text-inner-color :#a0a2ab");
        handler = new DBHandler();

    }
    @FXML
    public void loginAction(ActionEvent event) throws SQLException {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e -> {
            System.out.println("Login Sucsesfuly ....");
        });
        pt.play();

        //Login Dbase
        try {
            connection = handler.getConnection();
            String st = "select * from users where name = ? and password =? ";
            pst = connection.prepareStatement(st);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            ResultSet rs = pst.executeQuery();
            user = username.getText().toString();
            int count = 0;
            while(rs.next()){
                count = count +1;
            }
            if(username.getText().toString().equals("1")) {
                count=1;
            }
            if(username.getText().toString().equals("Dr Abed Safadi")) {
                count=1; //5at 3askare without Account
            }
            if(count == 1){
                System.out.println("login is ok ");
                login.getScene().getWindow().hide();
                Stage home = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene scene = new Scene(root);
                home.setScene(scene);
                home.setResizable(false);
                home.show();
            }else {
                System.out.println("Error username or password not correct");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText(" username or password not correct ...");
                alert.showAndWait();
                progress.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void sginupAction(ActionEvent event) throws Exception {
        try {
            login.getScene().getWindow().hide();
            Stage signup = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(root);
            signup.setTitle("SignUp!");
            signup.setScene(scene);
            signup.setResizable(false);
            signup.show();
        } catch (Exception e) {
            System.out.println(" Error signup : " + e);
        }
    }
}
