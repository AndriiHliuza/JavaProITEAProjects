package lection4.lesson4;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello");
        Class.forName(Main.class.getName());
        System.out.println("By");
    }

    public static class C {
        static int i = value();

        static int value() {
            System.out.println("helo");
            return 1;
        }
    }
}
