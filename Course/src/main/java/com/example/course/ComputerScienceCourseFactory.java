package com.example.course;


public class ComputerScienceCourseFactory extends CourseFactory {
    public ComputerScienceCourseFactory() {
    }

    @Override
    public Course createCourse(String code, int numberOfCredits, String description) {
        return new ComputerScienceCourse(code, numberOfCredits, description);
    }

    @Override
    public CompositeCourse createCompositeCourse(String code, int numberOfCredits, String description) {
        return new CompositeCourse("I"+code, numberOfCredits, description);
    }
}