package lection14.hometask14.task_9;

import lection14.hometask14.task_9.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRunner {
    public static void main(String[] args) {
        Map<String, Double> johnMarks = new HashMap<>();
        johnMarks.put("Biology", 5.0);
        johnMarks.put("Economics", 8.0);
        johnMarks.put("Programming", 12.0);
        johnMarks.put("Physics", 7.0);
        johnMarks.put("Java Basics", 11.0);
        Student john = new Student("John", "Smith", 4, 1, johnMarks);

        Map<String, Double> bobMarks = new HashMap<>();
        bobMarks.put("Chemistry", 1.0);
        bobMarks.put("Economics", 9.0);
        bobMarks.put("Python Pro", 10.0);
        bobMarks.put("Mathematics", 10.0);
        bobMarks.put("Java Advanced", 12.0);
        Student bob = new Student("Bob", "Johnson", 2, 3, bobMarks);

        Map<String, Double> kateMarks = new HashMap<>();
        kateMarks.put("Biology", 1.0);
        kateMarks.put("Economics", 2.0);
        kateMarks.put("Programming", 1.0);
        kateMarks.put("Physics", 4.0);
        kateMarks.put("Java Basics", 5.0);
        Student kate = new Student("Kate", "Williams", 1, 1, kateMarks);

        Map<String, Double> robertMarks = new HashMap<>();
        robertMarks.put("Chemistry", 4.0);
        robertMarks.put("Economics", 2.0);
        robertMarks.put("Python Pro", 1.0);
        robertMarks.put("Mathematics", 2.0);
        robertMarks.put("Java Advanced", 3.0);
        Student robert = new Student("Robert", "Johnson", 1, 3, robertMarks);

        List<Student> students = new ArrayList<>(List.of(john, bob, kate, robert));

        System.out.println("------Students before remove------");
        Student.showStudents(students);
        removeStudent(students);
        System.out.println("\n------Students after remove------");
        Student.showStudents(students);

        System.out.println("\n------Students with courseId = 4------");
        printStudents(students, 4);
        System.out.println("\n------Students with courseId = 2------");
        printStudents(students, 2);
    }

    public static void removeStudent(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageMark() < 3) {
                System.out.println("Student " + students.get(i).getName() + " was removed");
                students.remove(i);
                i--;
            } else {
                students.get(i).setCourseId(students.get(i).getCourseId() + 1);
                System.out.println(students.get(i).getName() + "'s groupId was changed to: " + students.get(i).getCourseId());
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourseId() == course) {
                System.out.println(student);
            }
        }
    }
}
