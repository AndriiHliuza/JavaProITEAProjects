package lection15.lesson15;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("Start of the daemon thread");
                Thread.sleep(10_000);
            } else {
                System.out.println("Start of the usual thread");
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            if (!isDaemon()) {
                System.out.println("End of the usual thread");
            } else {
                System.out.println("End of the daemon thread");
            }
        }
    }
}
