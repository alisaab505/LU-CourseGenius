package com.example.course;


public class MathCourse extends Course{
    public MathCourse(String code, int numberOfCredits, String description) {
        super("M" + code, numberOfCredits, description);
    }
}
