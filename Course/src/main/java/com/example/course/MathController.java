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

public class MathController {
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
        CourseFactory math = new MathCourseFactory();

        //Creating math Courses
        Course M1100 = (MathCourse) math.createCourse("1100", 6, "Introduction to Algebra");
        Course M1101 = (MathCourse) math.createCourse("1101", 6, "Introduction to Analysis");
        Course M1102 = (CompositeCourse) math.createCompositeCourse("1101", 6, "Introduction to Analysis");
        Course M1103 = (CompositeCourse) math.createCompositeCourse("1101", 6, "Introduction to Analysis");
        Course M1104 = (CompositeCourse) math.createCompositeCourse("1101", 6, "Introduction to Analysis");
        Course M1105 = (CompositeCourse) math.createCompositeCourse("1101", 6, "Introduction to Analysis");
        Course M1106 = (CompositeCourse) math.createCompositeCourse("1101", 6, "Introduction to Analysis");
        Course M2250 = (CompositeCourse) math.createCompositeCourse("1101", 6, "Introduction to Analysis");
//        Course M1102 = (CompositeCourse) math.createCompositeCourse("1102", 2, "Introduction to Graph Theory");

        ((CompositeCourse)M1102).addPrerequisite(M1100);
        ((CompositeCourse)M1103).addPrerequisite(M1100);
        ((CompositeCourse)M1104).addPrerequisite(M1101);
        ((CompositeCourse)M1105).addPrerequisite(M1101);
        ((CompositeCourse)M1106).addPrerequisite(M1101);
        ((CompositeCourse)M2250).addPrerequisite(M1100);
        ObservableList<Course> courses = FXCollections.observableArrayList(
                M1100,M1101,M1102,M1103,M1104,M1105,M1106,M2250
        );

        codeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("numberOfCredits"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));
        prerequisites.setCellValueFactory(new PropertyValueFactory<Course, List>("prerequisites"));
        courseTable.setItems(courses);
    }
}
