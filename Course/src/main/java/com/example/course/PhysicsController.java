package com.example.course;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class PhysicsController {
    @FXML
    private Button back;

    @FXML
    private TableColumn<Course, String> codeColumn;

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TableColumn<Course, Integer> creditsColumn;

    @FXML
    private TableColumn<Course, String> descriptionColumn;

    @FXML
    private TableColumn<Course, List> prerequisites;

    @FXML
    public void goBack(ActionEvent event) {
        try {
            courseTable.getScene().getWindow().hide();
            Stage login = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root);
            login.setScene(scene);
            login.show();
            login.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error signup : " + e);
        }
    }



    public void initialize() {
        CourseFactory phy = new PhysicsCourseFactory();

        //Creating math Courses
        Course p1100 = (PhysicsCourse) phy.createCourse("1100", 6, "Introduction to Mechanics");
        Course p1101 = (PhysicsCourse) phy.createCourse("1101", 6, "Introduction to Electricity");
        ObservableList<Course> courses = FXCollections.observableArrayList(
                p1100,p1101
        );

        codeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("numberOfCredits"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));
        prerequisites.setCellValueFactory(new PropertyValueFactory<Course, List>("prerequisites"));
        courseTable.setItems(courses);
    }
}
