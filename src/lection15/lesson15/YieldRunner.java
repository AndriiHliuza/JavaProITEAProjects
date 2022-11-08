package lection15.lesson15;

public class YieldRunner {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("Start of thread 1");
                Thread.yield();
                System.out.println("End of thread 1");
            }
        }.start();

        new Thread(() -> {
            System.out.println("Start of thread 2");
            System.out.println("End of thread 2");
        }).start();
    }
}
