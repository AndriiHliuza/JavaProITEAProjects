package lection15.lesson15;

public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        var threadName = getName();
        System.out.println("Start of the thread " + threadName);
        var timeout = switch (threadName) {
            case "First" -> 5_000L;
            case "Second" -> 1_000L;
            default -> 0L;
        };
        try {
            Thread.sleep(timeout);
            System.out.println("End of the thread " + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
