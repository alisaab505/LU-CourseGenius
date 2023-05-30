package com.example.course;


public abstract class Course {
    private String code;
    private int numberOfCredits;
    private String description;

    public Course(String code, int numberOfCredits, String description) {
        this.code = code;
        this.numberOfCredits = numberOfCredits;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return code;
    }
}
