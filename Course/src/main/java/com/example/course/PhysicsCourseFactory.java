package com.example.course;

public class PhysicsCourseFactory extends CourseFactory{
    public PhysicsCourseFactory() {
    }

    @Override
    public Course createCourse(String code, int numberOfCredits, String description) {
        return new PhysicsCourse(code, numberOfCredits, description);
    }
    @Override
    public CompositeCourse createCompositeCourse(String code, int numberOfCredits, String description) {
        return new CompositeCourse("P"+code, numberOfCredits, description);
    }
}
