package lection9.lesson9;

public class TeacherLogic {
    public void excludeProcess(int rectorId, String studentName) {
        AbstractTeacher teacher = TeacherCreator.createTeacher(rectorId);
        System.out.println("Student: " + studentName + " was excluded: " + teacher.excludeStudent(studentName));
    }
}
