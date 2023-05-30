package com.example.course;


public class StatisticsCourseFactory extends CourseFactory {
    public StatisticsCourseFactory() {
    }

    @Override
    public Course createCourse(String code, int numberOfCredits, String description) {
        return new StatisticsCourse(code, numberOfCredits, description);
    }

    @Override
    public CompositeCourse createCompositeCourse(String code, int numberOfCredits, String description) {
        return new CompositeCourse("S"+code, numberOfCredits, description);
    }
}
