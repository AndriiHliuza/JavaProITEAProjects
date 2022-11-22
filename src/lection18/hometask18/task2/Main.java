package lection18.hometask18.task2;

import lection18.hometask18.JavaClassChanger;

public class Main {
    public static void main(String[] args) {
        JavaClassChanger javaClassChanger = new JavaClassChanger("src/lection18/hometask18/Student.java");
        javaClassChanger.changeModifierInClassMembers("public", "private");
    }
}
