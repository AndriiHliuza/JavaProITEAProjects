package lection6.lesson6;

public class App1 {
    private Room2 room2;

    public App1() {
        room2 = new Room2(5.1, 5.2, 5.2);
        System.out.println(room2);
    }

    public static void main(String[] args) {
        new App1();
    }
}
