package com.example.course;

public class MathCourseFactory extends CourseFactory {
    public MathCourseFactory() {
    }

    @Override
    public Course createCourse(String code, int numberOfCredits, String description) {
        return new MathCourse(code, numberOfCredits, description);
    }

    @Override
    public CompositeCourse createCompositeCourse(String code, int numberOfCredits, String description) {
        return new CompositeCourse("M"+code, numberOfCredits, description);
    }
}