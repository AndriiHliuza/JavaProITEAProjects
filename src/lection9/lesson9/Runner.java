package lection9.lesson9;

public class Runner {
    public static void main(String[] args) {
        TeacherLogic teacherLogic = new TeacherLogic();
        teacherLogic.excludeProcess(777, "Smith");
        teacherLogic.excludeProcess(6, "Serhii");
    }
}
