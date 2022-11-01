package lection9.hometask9.second_part_hometask.task4;

public class GradeBookRunner {
    public static void main(String[] args) {

        Student john = new Student(2020, "John", "Smith",
                "2003.12.02", "john_smith@gmail.com", "Oxford",
                "Faculty of IT", "Information technologies");
        Student jack = new Student(2022, "Jack", "Miller",
                "2004.11.05", "superjack@gmail.com", "Massachusetts Institute of Technology",
                "Faculty of economics", "Economics");
        GradeBook johnGradeBook = new GradeBook(john);
        GradeBook jackGradeBook = new GradeBook(jack);

        System.out.println(john);
        System.out.println(johnGradeBook);
        johnGradeBook.createStudentGradeActivity("session", "Mr Tom Brown", "IT Basics");
        johnGradeBook.createStudentGradeActivity("session", "Mr Dale Miller", "Economics");
        johnGradeBook.createStudentGradeActivity("exam", "Mr Alex Davis", "Python Basics");
        System.out.println(johnGradeBook.getGradeBookInfo());

        System.out.println(jack);
        System.out.println(jackGradeBook);
        jackGradeBook.createStudentGradeActivity("exam", "Mr Dale Brown", "Science of law");
        jackGradeBook.createStudentGradeActivity("session", "Mr Alex Davis", "IT");
        jackGradeBook.createStudentGradeActivity("test", "Mr Tom Brown", "Philosophy");
        jackGradeBook.createStudentGradeActivity("exam", "Mr Alex Davis", "Economics Basics");
        System.out.println(jackGradeBook.getGradeBookInfo());

        System.out.println("Список викладачів, що приймали екзамени в John: " + johnGradeBook.getTutors());
        System.out.println("Список викладачів, що приймали екзамени в Jack: " + jackGradeBook.getTutors());
    }
}
