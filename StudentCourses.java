package program2;

import java.util.*;

public class StudentCourses {
    private Map<String, List<Course>> semesterCourses = new HashMap<>();

    public void addCourse(String semester, String courseName, int marks) {
        semesterCourses.putIfAbsent(semester, new ArrayList<>());
        semesterCourses.get(semester).add(new Course(courseName, marks));
    }

    public void displayCourses() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("\nSemester: " + semester);
            for (Course course : semesterCourses.get(semester)) {
                System.out.println("Course: " + course.name + ", Marks: " + course.marks);
            }
        }
    }

    private static class Course {
        String name;
        int marks;

        Course(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        StudentCourses sc = new StudentCourses();
        sc.addCourse("Semester 1", "Mathematics", 85);
        sc.addCourse("Semester 1", "Physics", 90);
        sc.addCourse("Semester 2", "Chemistry", 88);
        sc.displayCourses();
    }
}
 