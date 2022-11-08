package lection15.lesson15;

public class ExceptionThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        new ExceptThread().start();
        Thread.sleep(1000);

        System.out.println("End of main");
    }
}
