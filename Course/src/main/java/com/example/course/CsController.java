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

public class CsController {
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
        CourseFactory cs = new ComputerScienceCourseFactory();

        //Creating math Courses
        Course I1100 = (ComputerScienceCourse) cs.createCourse("1100", 3, "Introduction to Informatics");
        Course I1101 = (ComputerScienceCourse) cs.createCourse("1101", 6, "Algorithm and Programming");
        Course I2201 = (ComputerScienceCourse) cs.createCourse("2201", 4, "Client-side WEB development");
        Course I2202 = (ComputerScienceCourse) cs.createCourse("2202", 4, "Computer organization");
        Course I2203 = (ComputerScienceCourse) cs.createCourse("2203", 4, "Operating System I");
        Course I2204 = (CompositeCourse) cs.createCompositeCourse("2204", 5, "Imperative programming");
        Course I2205 = (ComputerScienceCourse) cs.createCourse("2205", 3, "Graph theory");
        Course I2206 = (CompositeCourse) cs.createCompositeCourse("2206", 5, "Data structures");
        Course I2207 = (ComputerScienceCourse) cs.createCourse("2207", 4, "Computer architecture");
        Course I2208 = (ComputerScienceCourse) cs.createCourse("2208", 4, "Computer networks");
        Course I2209 = (ComputerScienceCourse) cs.createCourse("2209", 4, "Logical programming");
        Course I2210 = (ComputerScienceCourse) cs.createCourse("2210", 4, "Database I");
        Course I2211 = (CompositeCourse) cs.createCompositeCourse("2211", 5, "Object Oriented Programming");
        Course I2232 = (ComputerScienceCourse) cs.createCourse("2232", 3, "Functional programming");
        Course I2233 = (ComputerScienceCourse) cs.createCourse("2233", 3, "Computer graphics");

        ((CompositeCourse)I2204).addPrerequisite(I1101);
        ((CompositeCourse)I2206).addPrerequisite(I1101);
        ((CompositeCourse)I2206).addPrerequisite(I2204);
        ((CompositeCourse)I2211).addPrerequisite(I2204);
        ObservableList<Course> courses = FXCollections.observableArrayList(
                I1100, I1101, I2201, I2202, I2203, I2204, I2205, I2206, I2207, I2208, I2209, I2210, I2211, I2232, I2233
        );

        codeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("numberOfCredits"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));
        prerequisites.setCellValueFactory(new PropertyValueFactory<Course, List>("prerequisites"));
        courseTable.setItems(courses);
    }
}
