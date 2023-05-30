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

public class StatisticsController {
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
        CourseFactory stat = new StatisticsCourseFactory();

        //Creating Stat Courses
        Course S1101 = (StatisticsCourse) stat.createCourse("1101", 3, "Introduction to Statistics");
        Course S2250 = (CompositeCourse) stat.createCompositeCourse("2250", 4, "Introduction to Probability");

        ((CompositeCourse)S2250).addPrerequisite(S1101);

        ObservableList<Course> coursesStat = FXCollections.observableArrayList(
                S1101,S2250
        );

        codeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("numberOfCredits"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));
        prerequisites.setCellValueFactory(new PropertyValueFactory<Course, List>("prerequisites"));
        courseTable.setItems(coursesStat);
    }
}
