package lection15.lesson15;

public class SimpleThread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("End of SimpleThread");
    }
}
