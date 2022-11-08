package lection15.lesson15;

public class ExceptThread extends Thread {
    @Override
    public void run() {
        boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }
        System.out.println("End of ExceptThread");
    }
}
