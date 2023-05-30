package com.example.course;


import java.util.ArrayList;
import java.util.List;

public class CompositeCourse extends Course {
    private List<Course> subCourses = new ArrayList<>();
    private List<Course> prerequisites = new ArrayList<>();

    private int totalCredits = 0;
    private String totalDescription = "";

    public CompositeCourse(String code, int numberOfCredits, String description) {
        super(code, numberOfCredits, description);
    }

    public void addSubCourse(Course course) {
        subCourses.add(course);
        totalCredits += course.getNumberOfCredits();
        totalDescription += course.getDescription() + "\n";
    }

    public void removeSubCourse(Course course) {
        subCourses.remove(course);
        totalCredits -= course.getNumberOfCredits();
        totalDescription = totalDescription.replace(course.getDescription() + "\n", "");
    }

    public List<Course> getSubCourses() {
        return subCourses;
    }

    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }

    public void removePrerequisite(Course prerequisite) {
        prerequisites.remove(prerequisite);
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public String getTotalDescription() {
        StringBuilder descriptionBuilder = new StringBuilder(super.getDescription());
        descriptionBuilder.append("\nSub-courses:\n");
        descriptionBuilder.append(totalDescription);
        descriptionBuilder.append("Prerequisites:\n");
        for (Course prerequisite : prerequisites) {
            descriptionBuilder.append("- ");
            descriptionBuilder.append(prerequisite.getDescription());
            descriptionBuilder.append("\n");
        }
        return descriptionBuilder.toString();
    }


}
