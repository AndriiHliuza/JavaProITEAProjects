package lection14.hometask14.task_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private int groupID;
    private int courseId;
    private Map<String, Double> marks;

    public Student(String name, String surname, int groupID, int courseId, Map<String, Double> marks) {
        this.name = name + " " + surname;
        this.groupID = groupID;
        this.courseId = courseId;
        this.marks = marks;
    }

    public double getAverageMark() {
        double sumOfAllMarks = 0;
        for (double mark : marks.values()) {
            sumOfAllMarks += mark;
        }
        return sumOfAllMarks / marks.size();
    }

    public String getName() {
        return name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "groupID: " + groupID + "\n" +
                "courseId: " + courseId + "\n" +
                "marks: " + marks + "\n" +
                "averageMark: " + getAverageMark() + "\n";
    }

    public static void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
