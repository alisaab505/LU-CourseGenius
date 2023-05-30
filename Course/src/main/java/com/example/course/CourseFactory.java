package com.example.course;


public abstract class CourseFactory {
    public abstract Course createCourse(String code, int numberOfCredits, String description);
    public abstract CompositeCourse createCompositeCourse(String code, int numberOfCredits, String description);
}